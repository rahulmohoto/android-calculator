package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class history extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history2);

        listView=findViewById(R.id.listView);
        getJson();
    }

    private void getJson() {
        GetJSON getJSON = new GetJSON();
        getJSON.execute();
    }

    private class GetJSON extends AsyncTask<Void,Void,String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Toast.makeText(getApplicationContext(), s, Toast.LENGTH_SHORT).show();
            try {
                loadIntoListView(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL("http://ec2-54-162-211-127.compute-1.amazonaws.com/getData.php");
                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                StringBuilder sb = new StringBuilder();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String json;
                while ((json = bufferedReader.readLine()) != null) {
                    sb.append(json + "\n");
                }
                return sb.toString();
            } catch (Exception e) {
                return null;
            }
        }
        }

    private void loadIntoListView(String json) throws JSONException {
        JSONArray jsonArray = new JSONArray(json);
        String[] data = new String[jsonArray.length()];
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            String s = obj.getString("num1")+" "+obj.getString("op")+" "+obj.getString("num2")+" "+"= "+obj.getString("result");
            data[i] = s;
            //Log.e("show content: ", "data[i]");
            //Toast.makeText(getApplicationContext(), data[i], Toast.LENGTH_SHORT).show();
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(history.this,android.R.layout.simple_list_item_1,data);
        listView.setAdapter(arrayAdapter);
    }
    }

