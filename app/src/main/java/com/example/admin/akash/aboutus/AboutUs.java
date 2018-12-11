package com.example.admin.akash.aboutus;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

import com.example.admin.akash.R;

public class AboutUs extends AppCompatActivity {
    TextView aboutustext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        aboutustext = (TextView) findViewById(R.id.aboutustext);
        aboutustext.setText(Html.fromHtml(getString(R.string.aboutusstring),0));

    }

}
