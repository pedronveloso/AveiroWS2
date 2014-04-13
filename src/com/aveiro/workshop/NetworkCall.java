package com.aveiro.workshop;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NetworkCall {


    public static String httpGet(String url){
        try{
            URL urlObj = new URL(url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlObj.openConnection();
            httpURLConnection.connect();

            InputStream is = httpURLConnection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is,"UTF-8"));

            String response = "", data;
            while ((data = reader.readLine())!= null){
                response += data+"\n";
            }
            return response;

        } catch (Exception e){
            return null;
        }
    }
}
