package com.ishan.gupta.understandingbusinessandeconomics;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class furthur extends AppCompatActivity {
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_furthur);

        Bundle b=this.getIntent().getExtras();
        final String[] list=b.getStringArray("terms");
        final String[] description=b.getStringArray("description");
        final String name=b.getString("name");

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        myToolbar.setTitle(name);
        myToolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        myToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-1274943404400438~3908234704");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("2CAE164B0624BB7C1C85F0E0F2CE37A5")
                .build();
        mAdView.loadAd(adRequest);

        ListView listView = (ListView) findViewById(R.id.termsList);
        listView.setFocusable(false);
        listView.setAdapter(new CustomAdapter(this, list));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle b=new Bundle();
                b.putStringArray("heading", list);
                b.putStringArray("description", description);
                b.putInt("position",position);
                b.putString("name",name);
                Intent intent=new Intent(furthur.this, insider.class);
                intent.putExtras(b);
                startActivity(intent);
            }
        });

    }
}
