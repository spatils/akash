package com.example.admin.akash.services;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.admin.akash.R;

public class Services extends AppCompatActivity {
    TextView serviceDetails1,serviceDetails2,serviceDetails3,serviceDetails4,serviceDetails5,serviceDetails6;
    ImageButton plus1, minus1,plus2, minus2,plus3,   minus3, plus4, minus4,plus5, minus5,plus6,   minus6;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        serviceDetails1 = (TextView) findViewById(R.id.serviceDetails1);

        plus1 = (ImageButton) findViewById(R.id.plus1);
        minus1 = (ImageButton) findViewById(R.id.minus1);

        serviceDetails2 = (TextView) findViewById(R.id.serviceDetails2);
        plus2 = (ImageButton) findViewById(R.id.plus2);
        minus2 = (ImageButton) findViewById(R.id.minus2);

        serviceDetails3 = (TextView) findViewById(R.id.serviceDetails3);
        plus3 = (ImageButton) findViewById(R.id.plus3);
        minus3 = (ImageButton) findViewById(R.id.minus3);


        serviceDetails4 = (TextView) findViewById(R.id.serviceDetails4);
        plus4 = (ImageButton) findViewById(R.id.plus4);
        minus4 = (ImageButton) findViewById(R.id.minus4);

        serviceDetails5 = (TextView) findViewById(R.id.serviceDetails5);
        serviceDetails5.setText(Html.fromHtml(getString(R.string.serviceDetails5),0));
        plus5 = (ImageButton) findViewById(R.id.plus5);
        minus5 = (ImageButton) findViewById(R.id.minus5);

        serviceDetails6 = (TextView) findViewById(R.id.serviceDetails6);
        serviceDetails6.setText(Html.fromHtml(getString(R.string.serviceDetails6),0));
        plus6 = (ImageButton) findViewById(R.id.plus6);
        minus6 = (ImageButton) findViewById(R.id.minus6);
    }
    public void provideAnswer(View view) {
        Log.v("provideAnswer","inside provide answer");
        if(view.getId() == R.id.serviceLayout1){
            if( serviceDetails1.getVisibility() == View.GONE ){
                serviceDetails1.setVisibility(View.VISIBLE);
                minus1.setVisibility(View.VISIBLE);
                plus1.setVisibility(View.GONE);

                serviceDetails2.setVisibility(View.GONE);
                minus2.setVisibility(View.GONE);
                plus2.setVisibility(View.VISIBLE);
                serviceDetails3.setVisibility(View.GONE);
                minus3.setVisibility(View.GONE);
                plus3.setVisibility(View.VISIBLE);

                serviceDetails4.setVisibility(View.GONE);
                minus4.setVisibility(View.GONE);
                plus4.setVisibility(View.VISIBLE);

                serviceDetails5.setVisibility(View.GONE);
                minus5.setVisibility(View.GONE);
                plus5.setVisibility(View.VISIBLE);


                serviceDetails6.setVisibility(View.GONE);
                minus6.setVisibility(View.GONE);
                plus6.setVisibility(View.VISIBLE);


            }else{
                serviceDetails1.setVisibility(View.GONE);
                minus1.setVisibility(View.GONE);
                plus1.setVisibility(View.VISIBLE);

                serviceDetails2.setVisibility(View.GONE);
                minus2.setVisibility(View.GONE);
                plus2.setVisibility(View.VISIBLE);
                serviceDetails3.setVisibility(View.GONE);
                minus3.setVisibility(View.GONE);
                plus3.setVisibility(View.VISIBLE);

                serviceDetails4.setVisibility(View.GONE);
                minus4.setVisibility(View.GONE);
                plus4.setVisibility(View.VISIBLE);

                serviceDetails5.setVisibility(View.GONE);
                minus5.setVisibility(View.GONE);
                plus5.setVisibility(View.VISIBLE);


                serviceDetails6.setVisibility(View.GONE);
                minus6.setVisibility(View.GONE);
                plus6.setVisibility(View.VISIBLE);

            }
        }
        if(view.getId() == R.id.serviceLayout2){
            if( serviceDetails2.getVisibility() == View.GONE ){
                serviceDetails2.setVisibility(View.VISIBLE);
                minus2.setVisibility(View.VISIBLE);
                plus2.setVisibility(View.GONE);

                serviceDetails1.setVisibility(View.GONE);
                minus1.setVisibility(View.GONE);
                plus1.setVisibility(View.VISIBLE);
                serviceDetails3.setVisibility(View.GONE);
                minus3.setVisibility(View.GONE);
                plus3.setVisibility(View.VISIBLE);

                serviceDetails4.setVisibility(View.GONE);
                minus4.setVisibility(View.GONE);
                plus4.setVisibility(View.VISIBLE);

                serviceDetails5.setVisibility(View.GONE);
                minus5.setVisibility(View.GONE);
                plus5.setVisibility(View.VISIBLE);


                serviceDetails6.setVisibility(View.GONE);
                minus6.setVisibility(View.GONE);
                plus6.setVisibility(View.VISIBLE);


            }else{
                serviceDetails2.setVisibility(View.GONE);
                minus2.setVisibility(View.GONE);
                plus2.setVisibility(View.VISIBLE);

                serviceDetails1.setVisibility(View.GONE);
                minus1.setVisibility(View.GONE);
                plus1.setVisibility(View.VISIBLE);
                serviceDetails3.setVisibility(View.GONE);
                minus3.setVisibility(View.GONE);
                plus3.setVisibility(View.VISIBLE);

                serviceDetails4.setVisibility(View.GONE);
                minus4.setVisibility(View.GONE);
                plus4.setVisibility(View.VISIBLE);

                serviceDetails5.setVisibility(View.GONE);
                minus5.setVisibility(View.GONE);
                plus5.setVisibility(View.VISIBLE);


                serviceDetails6.setVisibility(View.GONE);
                minus6.setVisibility(View.GONE);
                plus6.setVisibility(View.VISIBLE);
            }
        }
        if(view.getId() == R.id.serviceLayout3){
            if( serviceDetails3.getVisibility() == View.GONE ){
                serviceDetails3.setVisibility(View.VISIBLE);
                minus3.setVisibility(View.VISIBLE);
                plus3.setVisibility(View.GONE);

                serviceDetails1.setVisibility(View.GONE);
                minus1.setVisibility(View.GONE);
                plus1.setVisibility(View.VISIBLE);
                serviceDetails2.setVisibility(View.GONE);
                minus2.setVisibility(View.GONE);
                plus2.setVisibility(View.VISIBLE);

                serviceDetails4.setVisibility(View.GONE);
                minus4.setVisibility(View.GONE);
                plus4.setVisibility(View.VISIBLE);

                serviceDetails5.setVisibility(View.GONE);
                minus5.setVisibility(View.GONE);
                plus5.setVisibility(View.VISIBLE);


                serviceDetails6.setVisibility(View.GONE);
                minus6.setVisibility(View.GONE);
                plus6.setVisibility(View.VISIBLE);


            }else{
                serviceDetails3.setVisibility(View.GONE);
                minus3.setVisibility(View.GONE);
                plus3.setVisibility(View.VISIBLE);

                serviceDetails1.setVisibility(View.GONE);
                minus1.setVisibility(View.GONE);
                plus1.setVisibility(View.VISIBLE);
                serviceDetails2.setVisibility(View.GONE);
                minus2.setVisibility(View.GONE);
                plus2.setVisibility(View.VISIBLE);

                serviceDetails4.setVisibility(View.GONE);
                minus4.setVisibility(View.GONE);
                plus4.setVisibility(View.VISIBLE);

                serviceDetails5.setVisibility(View.GONE);
                minus5.setVisibility(View.GONE);
                plus5.setVisibility(View.VISIBLE);


                serviceDetails6.setVisibility(View.GONE);
                minus6.setVisibility(View.GONE);
                plus6.setVisibility(View.VISIBLE);

            }
        }
        if(view.getId() == R.id.serviceLayout4){
            if( serviceDetails4.getVisibility() == View.GONE ){
                serviceDetails4.setVisibility(View.VISIBLE);
                minus4.setVisibility(View.VISIBLE);
                plus4.setVisibility(View.GONE);

                serviceDetails1.setVisibility(View.GONE);
                minus1.setVisibility(View.GONE);
                plus1.setVisibility(View.VISIBLE);
                serviceDetails2.setVisibility(View.GONE);
                minus2.setVisibility(View.GONE);
                plus2.setVisibility(View.VISIBLE);

                serviceDetails6.setVisibility(View.GONE);
                minus6.setVisibility(View.GONE);
                plus6.setVisibility(View.VISIBLE);

                serviceDetails5.setVisibility(View.GONE);
                minus5.setVisibility(View.GONE);
                plus5.setVisibility(View.VISIBLE);
                serviceDetails3.setVisibility(View.GONE);
                minus3.setVisibility(View.GONE);
                plus3.setVisibility(View.VISIBLE);


            }else{
                serviceDetails4.setVisibility(View.GONE);
                minus4.setVisibility(View.GONE);
                plus4.setVisibility(View.VISIBLE);

                serviceDetails1.setVisibility(View.GONE);
                minus1.setVisibility(View.GONE);
                plus1.setVisibility(View.VISIBLE);
                serviceDetails2.setVisibility(View.GONE);
                minus2.setVisibility(View.GONE);
                plus2.setVisibility(View.VISIBLE);

                serviceDetails6.setVisibility(View.GONE);
                minus6.setVisibility(View.GONE);
                plus6.setVisibility(View.VISIBLE);

                serviceDetails5.setVisibility(View.GONE);
                minus5.setVisibility(View.GONE);
                plus5.setVisibility(View.VISIBLE);
                serviceDetails3.setVisibility(View.GONE);
                minus3.setVisibility(View.GONE);
                plus3.setVisibility(View.VISIBLE);

            }
        }
        if(view.getId() == R.id.serviceLayout5){
            if( serviceDetails5.getVisibility() == View.GONE ){
                serviceDetails5.setVisibility(View.VISIBLE);
                minus5.setVisibility(View.VISIBLE);
                plus5.setVisibility(View.GONE);

                serviceDetails1.setVisibility(View.GONE);
                minus1.setVisibility(View.GONE);
                plus1.setVisibility(View.VISIBLE);
                serviceDetails2.setVisibility(View.GONE);
                minus2.setVisibility(View.GONE);
                plus2.setVisibility(View.VISIBLE);

                serviceDetails6.setVisibility(View.GONE);
                minus6.setVisibility(View.GONE);
                plus6.setVisibility(View.VISIBLE);

                serviceDetails4.setVisibility(View.GONE);
                minus4.setVisibility(View.GONE);
                plus4.setVisibility(View.VISIBLE);
                serviceDetails3.setVisibility(View.GONE);
                minus3.setVisibility(View.GONE);
                plus3.setVisibility(View.VISIBLE);


            }else{
                serviceDetails5.setVisibility(View.GONE);
                minus5.setVisibility(View.GONE);
                plus5.setVisibility(View.VISIBLE);

                serviceDetails1.setVisibility(View.GONE);
                minus1.setVisibility(View.GONE);
                plus1.setVisibility(View.VISIBLE);
                serviceDetails2.setVisibility(View.GONE);
                minus2.setVisibility(View.GONE);
                plus2.setVisibility(View.VISIBLE);

                serviceDetails6.setVisibility(View.GONE);
                minus6.setVisibility(View.GONE);
                plus6.setVisibility(View.VISIBLE);

                serviceDetails4.setVisibility(View.GONE);
                minus4.setVisibility(View.GONE);
                plus4.setVisibility(View.VISIBLE);

                serviceDetails3.setVisibility(View.GONE);
                minus3.setVisibility(View.GONE);
                plus3.setVisibility(View.VISIBLE);


            }
        }
        if(view.getId() == R.id.serviceLayout6){
            if( serviceDetails6.getVisibility() == View.GONE ){
                serviceDetails6.setVisibility(View.VISIBLE);
                minus6.setVisibility(View.VISIBLE);
                plus6.setVisibility(View.GONE);

                serviceDetails1.setVisibility(View.GONE);
                minus1.setVisibility(View.GONE);
                plus1.setVisibility(View.VISIBLE);
                serviceDetails2.setVisibility(View.GONE);
                minus2.setVisibility(View.GONE);
                plus2.setVisibility(View.VISIBLE);

                serviceDetails4.setVisibility(View.GONE);
                minus4.setVisibility(View.GONE);
                plus4.setVisibility(View.VISIBLE);

                serviceDetails5.setVisibility(View.GONE);
                minus5.setVisibility(View.GONE);
                plus5.setVisibility(View.VISIBLE);

                serviceDetails3.setVisibility(View.GONE);
                minus3.setVisibility(View.GONE);
                plus3.setVisibility(View.VISIBLE);



            }else{
                serviceDetails6.setVisibility(View.GONE);
                minus6.setVisibility(View.GONE);
                plus6.setVisibility(View.VISIBLE);

                serviceDetails1.setVisibility(View.GONE);
                minus1.setVisibility(View.GONE);
                plus1.setVisibility(View.VISIBLE);
                serviceDetails2.setVisibility(View.GONE);
                minus2.setVisibility(View.GONE);
                plus2.setVisibility(View.VISIBLE);

                serviceDetails4.setVisibility(View.GONE);
                minus4.setVisibility(View.GONE);
                plus4.setVisibility(View.VISIBLE);

                serviceDetails5.setVisibility(View.GONE);
                minus5.setVisibility(View.GONE);
                plus5.setVisibility(View.VISIBLE);

                serviceDetails3.setVisibility(View.GONE);
                minus3.setVisibility(View.GONE);
                plus3.setVisibility(View.VISIBLE);


            }
        }

    }

}
