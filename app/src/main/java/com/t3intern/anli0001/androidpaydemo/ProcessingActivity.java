package com.t3intern.anli0001.androidpaydemo;

/**
 * Created by anli0001 on 7/19/2016.
 */
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Toast;


public class ProcessingActivity extends Activity {
    private String tokenJSON;
    private Intent mActivityLaunchIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_processing);
        mActivityLaunchIntent = this.getIntent();
        tokenJSON = mActivityLaunchIntent.getStringExtra("FullWallet");
        //time = (EditText) findViewById(R.id.et_time);
        //button = (Button) findViewById(R.id.btn_do_it);
        //finalResult = (TextView) findViewById(R.id.tv_result);
        if(networkCheck(this)) {
                new HTTPRequester(this.getBaseContext()).execute(tokenJSON);
        }
        else{
            Toast.makeText(this, "Failed to send data, check connection", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, VendorScreen.class);
            startActivity(intent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.activity_main, menu);
        return false;
    }

    public boolean networkCheck(Context context){
        ConnectivityManager connMgr = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected()) {
            return true;
        } else {
            return false;
        }
    }
}