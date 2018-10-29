package com.example.admin.akash.FAQ;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.admin.akash.R;

public class FAQ extends AppCompatActivity {
    TextView answer1,answer2,answer3;
    ImageButton plus1, minus1,plus2, minus2,plus3, minus3;;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        answer1 = (TextView) findViewById(R.id.answer1);
        plus1 = (ImageButton) findViewById(R.id.plus1);
        minus1 = (ImageButton) findViewById(R.id.minus1);

        answer2 = (TextView) findViewById(R.id.answer2);
        plus2 = (ImageButton) findViewById(R.id.plus2);
        minus2 = (ImageButton) findViewById(R.id.minus2);

        answer3 = (TextView) findViewById(R.id.answer3);
        plus3 = (ImageButton) findViewById(R.id.plus3);
        minus3 = (ImageButton) findViewById(R.id.minus3);


    }

    public void provideAnswer(View view) {
        Log.v("provideAnswer","inside provide answer");
        if(view.getId() == R.id.questionLayout1){
           if( answer1.getVisibility() == View.GONE ){
               answer1.setVisibility(View.VISIBLE);
               minus1.setVisibility(View.VISIBLE);
               plus1.setVisibility(View.GONE);

               answer2.setVisibility(View.GONE);
               minus2.setVisibility(View.GONE);
               plus2.setVisibility(View.VISIBLE);
               answer3.setVisibility(View.GONE);
               minus3.setVisibility(View.GONE);
               plus3.setVisibility(View.VISIBLE);


           }else{
               answer1.setVisibility(View.GONE);
               minus1.setVisibility(View.GONE);
               plus1.setVisibility(View.VISIBLE);

               answer2.setVisibility(View.GONE);
               minus2.setVisibility(View.GONE);
               plus2.setVisibility(View.VISIBLE);
               answer3.setVisibility(View.GONE);
               minus3.setVisibility(View.GONE);
               plus3.setVisibility(View.VISIBLE);

           }
        }
        if(view.getId() == R.id.questionLayout2){
            if( answer2.getVisibility() == View.GONE ){
                answer2.setVisibility(View.VISIBLE);
                minus2.setVisibility(View.VISIBLE);
                plus2.setVisibility(View.GONE);

                answer1.setVisibility(View.GONE);
                minus1.setVisibility(View.GONE);
                plus1.setVisibility(View.VISIBLE);
                answer3.setVisibility(View.GONE);
                minus3.setVisibility(View.GONE);
                plus3.setVisibility(View.VISIBLE);


            }else{
                answer2.setVisibility(View.GONE);
                minus2.setVisibility(View.GONE);
                plus2.setVisibility(View.VISIBLE);

                answer1.setVisibility(View.GONE);
                minus1.setVisibility(View.GONE);
                plus1.setVisibility(View.VISIBLE);
                answer3.setVisibility(View.GONE);
                minus3.setVisibility(View.GONE);
                plus3.setVisibility(View.VISIBLE);

            }
        }
        if(view.getId() == R.id.questionLayout3){
            if( answer3.getVisibility() == View.GONE ){
                answer3.setVisibility(View.VISIBLE);
                minus3.setVisibility(View.VISIBLE);
                plus3.setVisibility(View.GONE);

                answer1.setVisibility(View.GONE);
                minus1.setVisibility(View.GONE);
                plus1.setVisibility(View.VISIBLE);
                answer2.setVisibility(View.GONE);
                minus2.setVisibility(View.GONE);
                plus2.setVisibility(View.VISIBLE);


            }else{
                answer3.setVisibility(View.GONE);
                minus3.setVisibility(View.GONE);
                plus3.setVisibility(View.VISIBLE);

                answer1.setVisibility(View.GONE);
                minus1.setVisibility(View.GONE);
                plus1.setVisibility(View.VISIBLE);
                answer2.setVisibility(View.GONE);
                minus2.setVisibility(View.GONE);
                plus2.setVisibility(View.VISIBLE);

            }
        }

    }
}
