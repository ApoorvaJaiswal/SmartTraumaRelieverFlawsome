package com.example.jaisa.smarttraumareliever_flawsome;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class TestActivity extends AppCompatActivity {
    private Button clickButton;
    private EditText valueText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        clickButton = findViewById(R.id.yelo);
        valueText = findViewById(R.id.yelo1);

        clickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncFetch asyncFetch = new AsyncFetch();
                asyncFetch.execute(new String[]{valueText.getText().toString()});
            }
        });
    }

    private class AsyncFetch extends AsyncTask {

        ProgressDialog pdLoading = new ProgressDialog(TestActivity.this);
        private char ch;
        private String res;

        @Override
        protected void onPreExecute(){
            super.onPreExecute();
            pdLoading.setMessage("\tLoading...");
            pdLoading.setCancelable(false);
            pdLoading.show();
        }

        @Override
        protected Object doInBackground(Object[] params) {
            //Toast.makeText(getActivity(), tabNum+"", Toast.LENGTH_SHORT).show();
            String value = (String)params[0];
            //aa="hiiiiHello";

            try{
                String link = "http://websiteyo.pythonanywhere.com/";
                String data="";
                try {
                    data = URLEncoder.encode("ind", "UTF-8")+"="+URLEncoder.encode(value,"UTF-8")+"&"+URLEncoder.encode("work", "UTF-8")+"="+URLEncoder.encode("retrieve","UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                //String data = "status=registered";

                URL url = new URL(link);
                HttpURLConnection conn = (HttpURLConnection)url.openConnection();
                conn.setRequestMethod("POST");

                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                wr.write(data);
                wr.flush();

                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String sb = "";
                String line = null;
                // Read Server Response

                int c = 1;
                //String name="", address="", phone="", comments="";
                while((line = rd.readLine()) != null) {
                    //sb.append(line);
                    sb = sb+line;
                    //break;
                }
                //aa=sb+"    "+sb.length();
                res=sb;
                return sb;

            } catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(Object result){
            pdLoading.hide();
            Toast.makeText(TestActivity.this, ""+res, Toast.LENGTH_SHORT).show();
        }

    }
}
