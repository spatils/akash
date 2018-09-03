package com.example.admin.akash.DisplayProduct;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.akash.R;

public class DisplayProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_product);
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

        String productName = getIntent().getStringExtra("PRODUCTNAME" );
        String imageURL = getIntent().getStringExtra("IMAGEEURL"  );
        String productDescription = getIntent().getStringExtra("PRODUCTDESCRIPTION" );

        TextView textViewProductName = (TextView) findViewById(R.id.productName);
        TextView textViewProductDescription = (TextView) findViewById(R.id.productDescription);
        ImageView imageView = (ImageView)findViewById(R.id.productImage);
        int id = getResources().getIdentifier("drawable/" +imageURL , null, getPackageName());
        System.out.println("id "+id+" drawable/");
        imageView.setImageResource(id);
        textViewProductName.setText (productName);
        textViewProductDescription.setText(productDescription);

    }

}
