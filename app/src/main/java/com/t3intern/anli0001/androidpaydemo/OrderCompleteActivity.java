package com.t3intern.anli0001.androidpaydemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.wallet.FullWallet;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by anli0001 on 6/20/2016.
 */
public class OrderCompleteActivity extends Activity {
    FullWallet mFullWallet;
    private TextView orderConfirmation;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);
        try{
            JSONObject confJSON = new JSONObject(getIntent().getStringExtra("ConfirmationNumber"));
            orderConfirmation = (TextView) findViewById(R.id.order_confirmation);
            orderConfirmation.setText(String.format(getString(R.string.order_confirmation_message), confJSON.get("confirmationNumber")));
            //TextView demoText = (TextView) findViewById(R.id.demo_text);
            //demoText.setText(confJSON.toString());
        }
        catch(JSONException e){
            e.printStackTrace();
        }
        mFullWallet = getIntent().getParcelableExtra(Constants.EXTRA_FULL_WALLET);
    }

    public void resetTransaction(View v){
        Intent intent = new Intent(OrderCompleteActivity.this, VendorScreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        OrderCompleteActivity.this.startActivity(intent);
    }
}
