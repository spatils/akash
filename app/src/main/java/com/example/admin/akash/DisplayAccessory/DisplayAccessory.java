package com.example.admin.akash.DisplayAccessory;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.admin.akash.DisplayProductGroup.DisplayProductGroup;
import com.example.admin.akash.R;
import com.example.admin.akash.common.AccessoryList;

public class DisplayAccessory extends AppCompatActivity {
    String accessoryName ="GARMENT" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_accessory);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        accessoryName =  getIntent().getStringExtra("ACCESSORY");
        ListView listViewAccessory = (ListView)  (ListView) findViewById(R.id.accessorylistView);
        AccessoryAdaptor accessoryAdaptor = null;
        if (accessoryName.equals("GARMENT")) {
            accessoryAdaptor = new AccessoryAdaptor(DisplayAccessory.this, AccessoryList.getInstance().getGarmentList());
        }
        else {

            accessoryAdaptor = new AccessoryAdaptor(DisplayAccessory.this, AccessoryList.getInstance().getShoeList());
        }
        listViewAccessory.setAdapter(accessoryAdaptor);
        listViewAccessory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(DisplayAccessory.this,
                        DisplayProductGroup.class);
                System.out.println(" Position "+position+" view "+view);
                myIntent.putExtra("ACCESSORY",accessoryName);
                Button clickedButton = (Button ) view ;
                System.out.println(" Text value from Button "+clickedButton.getText());
                myIntent.putExtra("PRODUCTGROUP",clickedButton.getText());
                               startActivity(myIntent);

            }
        });

    }

}
