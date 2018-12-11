package com.example.admin.akash.aboutus;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
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


        LinearLayout sendEmail = (LinearLayout) findViewById(R.id.sendemail);
        sendEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendIntent = new Intent(Intent.ACTION_VIEW);
                /***
                sendIntent.setType("plain/text");
                sendIntent.setData(Uri.parse("prashant@akash-industries.com"));
                sendIntent.setClassName("com.google.android.gm", "com.google.android.gm.ComposeActivityGmail");
                sendIntent.putExtra(Intent.EXTRA_EMAIL, new String[] { "demoemail@gmail.com" });
                sendIntent.putExtra(Intent.EXTRA_SUBJECT, "Enquiry");
                sendIntent.putExtra(Intent.EXTRA_TEXT, "Hi , this message is generated using android app. I want to ask a question related to ..");
                 **/
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:prashant@akash-industries.com"));
                startActivity(emailIntent);

            }
        });
    }

}
