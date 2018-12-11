package com.example.admin.akash.DisplayAccessory;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.admin.akash.R;

import java.util.ArrayList;

public class AccessoryAdaptor extends ArrayAdapter<String>   {
    private final Context context;
    private final ArrayList<String> values;
    public AccessoryAdaptor(Context context, ArrayList<String> values )  {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.table_accessory_listview, parent, false);
        Button textViewEven = (Button) rowView.findViewById(R.id.evenAccessory);
        textViewEven.setText(values.get(position));
        if (position % 2 == 0) {
            textViewEven.setBackgroundColor(Color.parseColor("#e0024b0b"));
        } else
            textViewEven.setBackgroundColor(Color.parseColor("#e62f0a"));

        textViewEven.setOnClickListener(  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View parentRow = (View) v.getParent();
                ListView listView = (ListView) parentRow.getParent();
                final int position = listView.getPositionForView(parentRow);
                listView.performItemClick(v,position,0);


            }
        });
        return rowView;
    }
}
