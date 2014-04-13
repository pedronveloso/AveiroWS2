package com.aveiro.workshop;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends Activity {


public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.main);

    TextView tvAux = (TextView) findViewById(R.id.tv_current_temp);

    tvAux.setText("20º");

    tvAux = (TextView) findViewById(R.id.tv_max_temp);

    tvAux.setText("24º");

    new DownloadWeatherInfo().execute();
}

     private class DownloadWeatherInfo extends AsyncTask<Void,Void,String>{

         @Override
         protected String doInBackground(Void... params) {
             return NetworkCall.httpGet("http://api.openweathermap.org/data/2.5/forecast/daily?q=Aveiro&units=metric&cnt=7&lang=pt&APPID=f68b13ab43f8d29d4ba7979c2c09695d");
         }

 @Override
 protected void onPostExecute(String response) {
     Log.d("AVEIRO","Resposta web: "+response);

     try{
         JSONObject jsonObject = new JSONObject(response);
         JSONArray jsonArray = jsonObject.getJSONArray("list");
         jsonObject = jsonArray.getJSONObject(0);
         jsonObject = jsonObject.getJSONObject("temp");
         Double averageTemp = jsonObject.getDouble("day");
         Double minTemp = jsonObject.getDouble("min");

         TextView tvAux = (TextView) findViewById(R.id.tv_current_temp);

         tvAux.setText(averageTemp+"º");

         tvAux = (TextView) findViewById(R.id.tv_min_temp);

          tvAux.setText(minTemp+"º");

         Intent intent = new Intent(MainActivity.this,SecondActivity.class);
         startActivity(intent);

     } catch (JSONException e){
         Log.e("AVEIRO","Erro de process.: "+e.getMessage());
     }
 }
     }

}