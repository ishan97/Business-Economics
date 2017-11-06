package com.ishan.gupta.understandingbusinessandeconomics;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class insider extends AppCompatActivity {
    private AdView mAdView;

    TextView head, desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insider);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-1274943404400438~3908234704");

        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("2CAE164B0624BB7C1C85F0E0F2CE37A5")
                .build();
        mAdView.loadAd(adRequest);

        Bundle b=this.getIntent().getExtras();
        String[] list=b.getStringArray("heading");
        String[] description=b.getStringArray("description");
        int position=b.getInt("position");
        String name=b.getString("name");

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

        head=(TextView) findViewById(R.id.heading);
        desc=(TextView)findViewById(R.id.description);

        head.setText(list[position]);
        desc.setText(description[position]);




    }
}
