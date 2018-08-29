package com.example.admin.akash.DisplayAccessory;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.admin.akash.DisplayImageList.DisplayImages;
import com.example.admin.akash.MainActivity;
import com.example.admin.akash.R;

public class AccessoryAdaptor extends ArrayAdapter<String>   {
    private final Context context;
    private final String[] values;
    public AccessoryAdaptor(Context context, String[] values) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.accessory_listview, parent, false);
        Button textViewEven = (Button) rowView.findViewById(R.id.evenAccessory);
        textViewEven.setText(values[position]);
        textViewEven.setOnClickListener(  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View parentRow = (View) v.getParent();
                ListView listView = (ListView) parentRow.getParent();
                final int position = listView.getPositionForView(parentRow);
                listView.performItemClick(v,position,0);
                System.out.println("Button clicked");
            }
        });
        return rowView;
    }
}
