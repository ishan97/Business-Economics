package com.ishan.gupta.understandingbusinessandeconomics;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ishan on 20/08/16.
 */
public class CustomAdapter extends BaseAdapter {

    String[] list;
    Context context;
    LayoutInflater inflater;

    public CustomAdapter(Context context1 , String[] list1) {
        list=list1;
        context=context1;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tv;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.list_view_row, null);
        holder.tv=(TextView) rowView.findViewById(R.id.list);
        holder.tv.setText(list[position]);
        return rowView;
    }

}


