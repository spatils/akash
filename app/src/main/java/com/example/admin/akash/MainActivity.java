package com.example.admin.akash;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.example.admin.akash.DisplayAccessory.DisplayAccessory;
import com.example.admin.akash.common.Product;
import com.example.admin.akash.common.ProductGroup;
import com.example.admin.akash.common.ProductHandler;
import com.example.admin.akash.util.googledrive.HttpHandler;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import java.util.Timer;
import java.util.TimerTask;
import me.relex.circleindicator.CircleIndicator;



public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private  ViewPager mPager;
    private static int currentPage = 0;
    private static final Integer[] XMEN= {R.drawable.ic_menu_camera,R.drawable.ic_menu_send,R.drawable.ic_menu_manage,R.drawable.ic_menu_share,R.drawable.ic_menu_manage};
    private ArrayList<Integer> XMENArray = new ArrayList<Integer>();
    String spreadsheetId = "11sra5UPTT9r_rLsK1H5ltWW9I567-HxxqcZ7lq9S-_Q";
    String scriptURL = "https://script.google.com/macros/s/AKfycbxOLElujQcy1-ZUer1KgEvK16gkTLUqYftApjNCM_IRTL3HSuDk/exec?id=SHEETID&sheet=Sheet1";
    String JSONURL = scriptURL.replace("SHEETID",spreadsheetId);
    ProductHandler ph = ProductHandler.getInstance();
    String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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


        init();
        if (checkInternetConenction() )  new ReadGoogleWorkSheet().execute();
        ProductHandler ph=  ProductHandler.getInstance();
        Log.v(TAG,"____Size of ph "+ph.getProductGroupList().size());
        Log.v(TAG,"____Size of ph "+ph.getProductList().size());
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            final Context context = this;
            Intent intent = new Intent(context, DisplayAccessory.class);
            intent.putExtra("ACCESSORY","Garment Accessories");
            startActivity(intent);

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {


        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void selectDrawerItem(MenuItem menuItem) {



    }
    private boolean checkInternetConenction() {
        // get Connectivity Manager object to check connection
        ConnectivityManager connec;
        connec = (ConnectivityManager) getSystemService(getApplicationContext().CONNECTIVITY_SERVICE);

        // Check for network connections
        if (connec.getNetworkInfo(0).getState() ==
                android.net.NetworkInfo.State.CONNECTED ||
                connec.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() ==
                        android.net.NetworkInfo.State.CONNECTING ||
                connec.getNetworkInfo(1).getState() == android.net.NetworkInfo.State.CONNECTED) {
            Toast.makeText(this, " Connected ", Toast.LENGTH_LONG).show();
            return true;
        } else if (
                connec.getNetworkInfo(0).getState() ==
                        android.net.NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() ==
                                android.net.NetworkInfo.State.DISCONNECTED) {
            Toast.makeText(this, " Not Connected ", Toast.LENGTH_LONG).show();
            return false;
        }
        return false;
    }
    public class ReadGoogleWorkSheet  extends AsyncTask<Void, Void, Void> {


        private String TAG ="ReadGoogleWorkSheet";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this,"Json Data is                     downloading",Toast.LENGTH_LONG).show();

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
                    Log.v(TAG,"Adding Product Groyp"+productGroup.getCatagoryName() + productGroup.getProductGroupName()+ productGroup.getStartId()+productGroup.getEndId());


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
            super.onPostExecute(result);

        }
    }





}
