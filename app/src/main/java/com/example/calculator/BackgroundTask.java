package com.example.calculator;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

class BackgroundTask extends AsyncTask<String,Void,String> {

    AlertDialog dialog;
    Context context;
    public BackgroundTask(Context context)
    {
        this.context = context;
    }

//    @Override
//    protected void onPreExecute() {
////        dialog = new AlertDialog.Builder(context).create();
////        dialog.setTitle("Login Status");
//    }
//    @Override
//    protected void onPostExecute(String s) {
////        dialog.setMessage(s);
////        dialog.show();
//        if(s.contains(""))
//        {
//            Intent intent_name = new Intent();
//            intent_name.setClass(context.getApplicationContext(),MainActivity.class);
//            context.startActivity(intent_name);
//        }
//
//    }


    @Override
    protected String doInBackground(String... params) {
        String result = "";
        String num1 = params[0];
        String num2 = params[1];
        String op = params[2];
        String res = params[3];


        String connstr = "http://ec2-54-162-211-127.compute-1.amazonaws.com/SamplePage.php";
        try {
            URL url = new URL(connstr);
            HttpURLConnection http = (HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);

            OutputStream ops = http.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(ops,"UTF-8"));
            String data = URLEncoder.encode("num1","UTF-8")+"="+URLEncoder.encode(num1,"UTF-8")+"&&"
                    +URLEncoder.encode("num2","UTF-8")+"="+URLEncoder.encode(num2,"UTF-8")+"&&"
                    +URLEncoder.encode("op","UTF-8")+"="+URLEncoder.encode(op,"UTF-8")+"&&"
                    +URLEncoder.encode("result","UTF-8")+"="+URLEncoder.encode(res,"UTF-8");
            writer.write(data);
            writer.flush();
            writer.close();
            ops.close();

            InputStream ips = http.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(ips,"UTF-8"));
            String line ="";
            while ((line = reader.readLine()) != null)
            {
                result += line + "\n";
            }
            reader.close();
            ips.close();
            http.disconnect();
            return result;

        } catch (MalformedURLException e) {
            result = e.getMessage();
        } catch (IOException e) {
            result = e.getMessage();
        }


        return result;
    }
}
