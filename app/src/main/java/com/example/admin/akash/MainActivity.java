package com.example.admin.akash;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.example.admin.akash.DisplayAccessory.DisplayAccessory;
import com.example.admin.akash.FAQ.FAQ;
import com.example.admin.akash.aboutus.AboutUs;
import com.example.admin.akash.common.Product;
import com.example.admin.akash.common.ProductGroup;
import com.example.admin.akash.common.ProductHandler;
import com.example.admin.akash.services.Services;
import com.example.admin.akash.util.googledrive.HttpHandler;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import java.util.Timer;
import java.util.TimerTask;
import me.relex.circleindicator.CircleIndicator;



public class MainActivity extends AppCompatActivity
         {
    private  ViewPager mPager;

    private static int currentPage = 0;
    private static final Integer[] XMEN= {R.drawable.slider11,R.drawable.slider2,R.drawable.slider3};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();
    String spreadsheetId = "11sra5UPTT9r_rLsK1H5ltWW9I567-HxxqcZ7lq9S-_Q";
    String scriptURL = "https://script.google.com/macros/s/AKfycbxOLElujQcy1-ZUer1KgEvK16gkTLUqYftApjNCM_IRTL3HSuDk/exec?id=SHEETID&sheet=Sheet1";
    String JSONURL = scriptURL.replace("SHEETID",spreadsheetId);
    ProductHandler ph = ProductHandler.getInstance();
    String TAG = "MainActivity";
    public ProgressBar progressBar ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);


        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        CardView  garmentAccessory = (CardView) findViewById(R.id.bankcardId);
        garmentAccessory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this,
                        DisplayAccessory.class);
                myIntent.putExtra("ACCESSORY","Garment Accessories");
                startActivity(myIntent);
                // TODO Do not call action unless Asyn Task is complete
            }
        });
        CardView  shoeAccessory = (CardView) findViewById(R.id.bankcardId1);
        shoeAccessory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this,
                        DisplayAccessory.class);
                myIntent.putExtra("ACCESSORY","Shoes Accessories");
                startActivity(myIntent);
                // TODO Do not call action unless Asyn Task is complete
            }
        });
        CardView  callNow = (CardView) findViewById(R.id.callnow);
        callNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:+919930646648"));
                startActivity(intent);

            }
        });
        CardView  sendSMS = (CardView) findViewById(R.id.sendsms);
        sendSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Uri sms_uri = Uri.parse("smsto:+919930646648");
                Intent sms_intent = new Intent(Intent.ACTION_SENDTO, sms_uri);
                sms_intent.putExtra("sms_body", "Contacting Via Your Mobile App.We need more information! Type Here - \"");
                startActivity(sms_intent);

            }
        });

        CardView  faq = (CardView) findViewById(R.id.faq);
        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this,
                        FAQ.class);
                startActivity(myIntent);

            }
        });

        CardView  services = (CardView) findViewById(R.id.services);
        services.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this,
                        Services.class);
                startActivity(myIntent);

            }
        });
        CardView  aboutUs = (CardView) findViewById(R.id.aboutus);
        aboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent myIntent = new Intent(MainActivity.this,
                        AboutUs.class);
                startActivity(myIntent);

            }
        });




        init();
        if(!checkInternetConenction()) Snackbar.make(findViewById(R.id.drawer_layout), "Please connect to the internet", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
        if (checkInternetConenction() && !isProductListAlreadyDownloaded())  new ReadGoogleWorkSheet().execute();

    }
    private void init() {
        for(int i=0;i<XMEN.length;i++)
            XMENArray.add(XMEN[i]);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter(MainActivity.this,XMENArray));
        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(mPager);

        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == XMEN.length) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2500, 2500);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    public void selectDrawerItem(MenuItem menuItem) {



    }
    private boolean isProductListAlreadyDownloaded(){
        if (ph.getProductList() == null || ph.getProductList().size() ==0 )
         return false;
        else return true ;
    }
    private boolean checkInternetConenction() {
        // get Connectivity Manager object to check connection
        ConnectivityManager cm =
                (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnected();
        return isConnected;
    }
    public class ReadGoogleWorkSheet  extends AsyncTask<Void, Void, Void> {


        private String TAG ="ReadGoogleWorkSheet";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Toast.makeText(MainActivity.this,"Json Data is                     downloading",Toast.LENGTH_LONG).show();
            showProgressBar();
        }

        @Override
        protected Void doInBackground(Void... arg0) {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response

            String jsonStr = sh.makeServiceCall(JSONURL);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);

                    // Getting JSON Array node
                    JSONArray contacts = jsonObj.getJSONArray("Sheet1");
                    String previousCatagory = new String("");
                    String previousProductGroup = new String("");
                    int productStartPosition = 0 ;


                    // looping through All Products
                    for (int i = 0; i < contacts.length(); i++) {
                        JSONObject c = contacts.getJSONObject(i);
                        Product product = new Product();
                        product.setCatagory(  c.getString("Category_Name"));
                        product.setProductDescription(  c.getString("Description"));
                        product.setProductImageURL(  c.getString("Image_Name"));
                        product.setProductName(  c.getString("Product_name"));
                        product.setProductGroupName(  c.getString("Group_Name"));
                        ph.addProduct(product);
                        if( i != 0) {
                            if ( !previousCatagory.equals(product.getCatagory()) || !previousProductGroup.equals(product.getProductGroupName())) {
                                ProductGroup productGroup = new ProductGroup();
                                productGroup.setStartId(productStartPosition);
                                productGroup.setEndId(i - 1);
                                productGroup.setCatagoryName(previousCatagory);
                                productGroup.setProductGroupName(previousProductGroup);
                                ph.addProductGroup(productGroup);
                                Log.v(TAG,"Adding Product Group"+productGroup.getCatagoryName() + productGroup.getProductGroupName()+ productGroup.getStartId()+productGroup.getEndId());
                                productStartPosition = i;
                                previousCatagory = product.getCatagory();
                                previousProductGroup = product.getProductGroupName();
                              }
                        }else{
                            previousCatagory = product.getCatagory();
                            previousProductGroup = product.getProductGroupName();
                        }


                    }
                    //Adding last product group
                    ProductGroup productGroup = new ProductGroup();
                    productGroup.setStartId(productStartPosition);
                    productGroup.setEndId(contacts.length()-1);
                    productGroup.setCatagoryName(previousCatagory);
                    productGroup.setProductGroupName(previousProductGroup);
                    ph.addProductGroup(productGroup);
                    Log.v(TAG,"Adding Product Group"+productGroup.getCatagoryName() + productGroup.getProductGroupName()+ productGroup.getStartId()+productGroup.getEndId());


                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());


                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");

            }
            return null;

        }
        @Override
        protected void onPostExecute(Void result) {
            progressBar.setVisibility(View.INVISIBLE);
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
        }
    }

    private void showProgressBar(){
        progressBar.setVisibility(View.VISIBLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);

    }



}
