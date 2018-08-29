package com.example.admin.akash.DisplayImageList;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.admin.akash.R;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

public class DisplayImages extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_display_images);
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
        //Uri uri = Uri.parse("https://drive.google.com/open?id=1ktY8tPT0_TBTme_ezWsmNs94hfmum4Bk");
        Uri uri = Uri.parse("https://raw.githubusercontent.com/facebook/fresco/master/docs/static/logo.png");
        SimpleDraweeView draweeView = (SimpleDraweeView) findViewById(R.id.sdvImage1);
        draweeView.setImageURI(uri);
    }

}
