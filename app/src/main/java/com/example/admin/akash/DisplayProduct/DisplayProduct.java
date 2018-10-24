package com.example.admin.akash.DisplayProduct;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.akash.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.view.SimpleDraweeView;

public class DisplayProduct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_display_product);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        String productName = getIntent().getStringExtra("PRODUCTNAME" );
        String imageURL = getIntent().getStringExtra("IMAGEEURL"  );
        String productDescription = getIntent().getStringExtra("PRODUCTDESCRIPTION" );

        TextView textViewProductName = (TextView) findViewById(R.id.productName);
        TextView textViewProductDescription = (TextView) findViewById(R.id.productDescription);
        Uri uri = Uri.parse(imageURL);
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.productImage);
        draweeView.getHierarchy().setProgressBarImage(new ProgressBarDrawable());
        draweeView.setImageURI(uri);
        textViewProductName.setText (productName);
        textViewProductDescription.setText(productDescription);

    }

}
