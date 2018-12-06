package com.example.admin.akash.DisplayProduct;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

//import com.facebook.samples.zoomable.ZoomableDraweeView;
import android.widget.TextView;

import com.example.admin.akash.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.samples.zoomable.ZoomableDraweeView;

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

        textViewProductName.setText (productName);
        textViewProductDescription.setText(productDescription);

        ZoomableDraweeView view = (ZoomableDraweeView) findViewById(R.id.zoomable);

        DraweeController ctrl = Fresco.newDraweeControllerBuilder().setUri(
                uri).setTapToRetryEnabled(true).build();
        GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder(getResources())
                .setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER)
                .setProgressBarImage(new ProgressBarDrawable())
                .build();

        view.setController(ctrl);
        view.setHierarchy(hierarchy);



    }

}
