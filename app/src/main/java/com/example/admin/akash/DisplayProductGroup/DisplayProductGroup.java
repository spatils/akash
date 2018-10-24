package com.example.admin.akash.DisplayProductGroup;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.admin.akash.R;
import com.example.admin.akash.DisplayProduct.DisplayProduct;
import com.example.admin.akash.common.ProductHandler;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;


public class DisplayProductGroup extends AppCompatActivity {
    String accessoryName = null;
    String productGroupName = null;
    String TAG  = "DisplayProductGroup";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        ProductHandler ph=  ProductHandler.getInstance();
        Log.v(TAG,"____Size of ph "+ph.getProductGroupList().size());
        Log.v(TAG,"____Size of ph "+ph.getProductList().size());
        accessoryName =  getIntent().getStringExtra("ACCESSORY");
        productGroupName =  getIntent().getStringExtra("PRODUCTGROUP");
        setContentView(R.layout.activity_display_productgroup);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        GridView gridView = (GridView) findViewById(R.id.grid_products);

        DisplayProductGroupAdaptor displayImageAdaptor = new DisplayProductGroupAdaptor(this,ph.getProductListByProductGrooup(accessoryName,productGroupName) );
        gridView.setAdapter(displayImageAdaptor);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(DisplayProductGroup.this,
                        DisplayProduct.class);
                ProductHandler ph=  ProductHandler.getInstance();

                String productName = ph.getProductListByProductGrooup(accessoryName,productGroupName).get(position).getProductName();
                String productDescription = ph.getProductListByProductGrooup(accessoryName,productGroupName).get(position).getProductDescription();
                String imageURL = ph.getProductListByProductGrooup(accessoryName,productGroupName).get(position).getProductImageURL();
                myIntent.putExtra("PRODUCTNAME",productName);
                myIntent.putExtra("IMAGEEURL",imageURL );
                myIntent.putExtra("PRODUCTDESCRIPTION",productDescription);
                startActivity(myIntent);
            }
        });
    }

}
