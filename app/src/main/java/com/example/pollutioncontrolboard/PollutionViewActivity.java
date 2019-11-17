package com.example.pollutioncontrolboard;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pollutioncontrolboard.adapters.PollutantsAdapter;
import com.example.pollutioncontrolboard.data.model.AqiHelperModel;
import com.example.pollutioncontrolboard.data.model.Pollutant;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PollutionViewActivity  extends AppCompatActivity {

    private TextView aqiTextView, temperatureTextView, locationTextView, pressureTextView, humidityTextView, windTextView, attributionTextView;
    private RecyclerView pollutantsRecyclerView;
    AqiHelperModel aqiHelperModel;

    private PollutantsAdapter pollutantsAdapter;
    private List<Pollutant> pollutantsList = new ArrayList<>();

    private String TAG = PollutionViewActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.AppTheme_Dark);
        setContentView(R.layout.pollution_aqi_layout);
        //Intent intent = getIntent();
        String selectedCity = getIntent().getStringExtra("city");
        init();
        new Getpollution().execute(selectedCity);
        /*if (aqiHelperModel.getPressure() != null)
            pressureTextView.setText(getString(R.string.pressure_unit, iaqi.getPressure().getV()));
        if (aqiHelperModel.getHumidity() != null)
            humidityTextView.setText(getString(R.string.humidity_unit, iaqi.getHumidity().getV()));
        if (aqiHelperModel.getWind() != null)
            windTextView.setText(getString(R.string.wind_unit, iaqi.getWind().getV()));*/

    }

    private void init() {
        aqiTextView = findViewById(R.id.aqi_text_view);
        temperatureTextView = findViewById(R.id.temperature_text_view);
        locationTextView = findViewById(R.id.location_text_view);
        pressureTextView = findViewById(R.id.pressure_text_view);
        humidityTextView = findViewById(R.id.humidity_text_view);
        windTextView = findViewById(R.id.wind_text_view);
        attributionTextView = findViewById(R.id.attribution_text_view);
        setupRecyclerView();
    }

    private void setupRecyclerView() {
        pollutantsRecyclerView = findViewById(R.id.pollutants_recycler_view);
        pollutantsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        pollutantsRecyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(pollutantsRecyclerView.getContext(),
                DividerItemDecoration.VERTICAL);
        pollutantsRecyclerView.addItemDecoration(dividerItemDecoration);
    }

    private void setAqiScaleGroup() {
        int aqi = Integer.valueOf(aqiHelperModel.getAqi());
        TextView aqiScaleText;
        if (aqi >= 0 && aqi <= 50) aqiScaleText = findViewById(R.id.scaleGood);
        else if (aqi >= 51 && aqi <= 100) aqiScaleText = findViewById(R.id.scaleModerate);
        else if (aqi >= 101 && aqi <= 150)
            aqiScaleText = findViewById(R.id.scaleUnhealthySensitive);
        else if (aqi >= 151 && aqi <= 200) aqiScaleText = findViewById(R.id.scaleUnhealthy);
        else if (aqi >= 201 && aqi <= 300) aqiScaleText = findViewById(R.id.scaleVeryUnhealthy);
        else if (aqi >= 301) aqiScaleText = findViewById(R.id.scaleHazardous);
        else aqiScaleText = findViewById(R.id.scaleGood);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            aqiScaleText.setForeground(getDrawable(R.drawable.selected_aqi_foreground));
        }
    }

    private void addPollutantsToList(AqiHelperModel iaqi) {
        pollutantsList.clear();
        if (iaqi.getCo() != null)
            pollutantsList.add(new Pollutant("Carbon Monoxide - AQI", iaqi.getCo()));
        if (iaqi.getNo2() != null)
            pollutantsList.add(new Pollutant("Nitrous Dioxide - AQI", iaqi.getNo2()));
        if (iaqi.getO3() != null)
            pollutantsList.add(new Pollutant("Ozone - AQI", iaqi.getO3()));
        if (iaqi.getPm25() != null)
            pollutantsList.add(new Pollutant("PM 2.5 - AQI", iaqi.getPm25()));
        if (iaqi.getPm10() != null)
            pollutantsList.add(new Pollutant("PM 10 - AQI", iaqi.getPm10()));
        if (iaqi.getSo2() != null)
            pollutantsList.add(new Pollutant("Sulfur Dioxide - AQI", iaqi.getSo2()));
        pollutantsAdapter = new PollutantsAdapter(pollutantsList);
        pollutantsRecyclerView.setAdapter(pollutantsAdapter);
    }

    private class Getpollution extends AsyncTask<String, Void, Void> {
        AqiHelperModel aqiHelper = new AqiHelperModel();

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            //Toast.makeText(City.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(String... arg0)
        {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "https://api.waqi.info/feed/"+arg0[0]+"/?token=e77965fe2ea9d2510af203f0d38aa4eefcfd4a29";
            System.out.println("URL is  : "+url);
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    String status = "";
                    String aqi = "";
                    String co ="";
                    String dew ="";
                    String no2 = "";
                    String o3 = "";
                    String pm10 = "";
                    String pm25 = "";
                    String so2 = "";
                    String temperature = "";
                    String w = "";
                    String wg = "";
                    String city = "";

                    if (jsonObj.has("status")) {
                        status = jsonObj.optString("status");
                    }

                    if (jsonObj.has("data")) {
                        JSONObject data = jsonObj.getJSONObject("data");
                        aqi = data.getString("aqi");

                        if(data.has("city")){
                            JSONObject jsonObjct = data.getJSONObject("city");
                            city = jsonObjct.getString("name");
                        }

                        if (data.has("iaqi")) {
                            JSONObject iqui = data.getJSONObject("iaqi");
                            if(iqui.has("co")){
                                JSONObject jsonObjct = iqui.getJSONObject("co");
                                co = jsonObjct.getString("v");
                            }

                            if(iqui.has("no2")){
                                JSONObject jsonObjct = iqui.getJSONObject("no2");
                                no2 = jsonObjct.getString("v");
                            }

                            if(iqui.has("o3")){
                                JSONObject jsonObjct = iqui.getJSONObject("o3");
                                o3 = jsonObjct.getString("v");
                            }
                            if(iqui.has("pm10")){
                                JSONObject jsonObjct = iqui.getJSONObject("pm10");
                                pm10 = jsonObjct.getString("v");
                            }
                            if(iqui.has("pm25")){
                                JSONObject jsonObjct = iqui.getJSONObject("pm25");
                                pm25 = jsonObjct.getString("v");
                            }

                            if(iqui.has("so2")){
                                JSONObject jsonObjct = iqui.getJSONObject("so2");
                                so2 = jsonObjct.getString("v");
                            }
                            if(iqui.has("t")){
                                JSONObject jsonObjct = iqui.getJSONObject("t");
                                temperature = jsonObjct.getString("v");
                            }
                            if(iqui.has("w")){
                                JSONObject jsonObjct = iqui.getJSONObject("w");
                                w = jsonObjct.getString("v");
                            }
                            if(iqui.has("wg")){
                                JSONObject jsonObjct = iqui.getJSONObject("wg");
                                wg = jsonObjct.getString("v");
                            }

                        }
                    }
                    aqiHelper.setCity(city);
                    aqiHelper.setStatus(status);
                    aqiHelper.setAqi(aqi);
                    aqiHelper.setCo(co);
                    aqiHelper.setNo2(no2);
                    aqiHelper.setDew(dew);
                    aqiHelper.setO3(o3);
                    aqiHelper.setPm10(pm10);
                    aqiHelper.setPm25(pm25);
                    aqiHelper.setSo2(so2);
                    aqiHelper.setTemperature(temperature);
                    aqiHelper.setW(w);
                    aqiHelper.setWg(wg);

                    aqiHelperModel = aqiHelper;
                } catch (final JSONException e) {
                    Log.e(TAG, "Json parsing error: " + e.getMessage());
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getApplicationContext(),
                                    "Json parsing error: " + e.getMessage(),
                                    Toast.LENGTH_LONG).show();
                        }
                    });

                }

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG).show();
                    }
                });
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            aqiTextView.setText(aqiHelper.getAqi());
            if (aqiHelper.getTemperature() != null && !aqiHelper.getTemperature().isEmpty())
                temperatureTextView.setText(getString(R.string.temperature_unit_celsius, Float.valueOf(aqiHelper.getTemperature())));

            locationTextView.setText(aqiHelper.getCity());
            setAqiScaleGroup();
            addPollutantsToList(aqiHelper);
            pollutantsAdapter.notifyDataSetChanged();


        }
    }

}
