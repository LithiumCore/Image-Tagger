package com.t3intern.anli0001.androidpaydemo;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by anli0001 on 6/24/2016.
 *
 * HTTP request side class; sends the JSON token to the server.
 */
public class HTTPRequester extends AsyncTask<String, Void, String> {
    HttpClient client;
    String urlString;
    String TAG = "HTTPRequester";
    StringBuilder sb = new StringBuilder();
    Context context;
    public static final String CONNECTION_FAILURE = "There was a problem connecting. Make sure you are connected to the internet.";

    public HTTPRequester(Context context){
        this.context = context.getApplicationContext();
        client = new DefaultHttpClient();
        urlString = "http://10.11.17.59/t3/androidPayTokenDecryptor/token"; //Decryption RESTful service URL
        //urlString = "http://posttestserver.com/post.php";
        //urlString = "http://httpbin.org/post";
    }

    @Override
    protected String doInBackground(String... token) {
        return postTokenNew(token[0]);
    }
    // onPostExecute displays the results of the AsyncTask.
    @Override
    protected void onPostExecute(String result) {
        Log.i(TAG, "Post executed");
        Intent intent = new Intent(context, OrderCompleteActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("ConfirmationNumber", result);
        context.startActivity(intent);
    }

    public String postTokenNew(String token){
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setRequestMethod("POST");
            conn.setUseCaches(false);
            conn.setRequestProperty("content-type", "application/json; charset=utf-8");
            conn.setRequestProperty("X-SpeechCycle-SmartCare-CustomerID", "AlphaMedia");
            conn.setRequestProperty("X-SpeechCycle-SmartCare-ApplicationID", "Mobile");
            conn.setRequestProperty("X-SpeechCycle-SmartCare-SessionID", "706035D4-3FD0-4CFD-AD40-0A951DA09838");
            conn.connect();

            OutputStreamWriter out = new OutputStreamWriter(conn.getOutputStream());
            out.write(token);
            out.close();

            int HttpResult = conn.getResponseCode();
            if(HttpResult == HttpURLConnection.HTTP_OK){
                BufferedReader br = new BufferedReader(new InputStreamReader(
                        conn.getInputStream(),"utf-8"));
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                System.out.println(""+sb.toString());
            }
            else{
                System.out.println(conn.getResponseMessage());
            }
        }
        catch(IOException e) {
            Log.e(TAG, "IOException occurred");
            e.printStackTrace();
        }
        //return Integer.toString(HttpResult);
        return "" + sb.toString();
    }
}
