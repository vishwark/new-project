package com.example.pollutioncontrolboard;

import android.os.AsyncTask;
import android.os.Bundle;

import com.example.pollutioncontrolboard.data.AppRepositry;
import com.example.pollutioncontrolboard.data.model.Pollution;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class City extends AppCompatActivity  implements AdapterView.OnItemSelectedListener {

    private String TAG = City.class.getSimpleName();
    ArrayList<HashMap<String, String>> pollutionList;
    AppRepositry appRepositry;

    private ListView lv;



    Spinner spinner;
    String selectedCity;
    List<String> cities = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        appRepositry = new AppRepositry(getApplicationContext());
        setContentView(R.layout.activity_city);
        spinner = findViewById(R.id.spinner);
        Button button = findViewById(R.id.button);
        String city = "agra,ahmedabad,amaravathi,ambala,amrithsar,ankleshwar,asansol,aurangabad,banglore,bathinda,brajrajnagar,bulandshahr,chandrapur,chennai,coimbatore,delhi,durgapur,dwarka,eloor,faridabad,fatehabad,gandhinagar,gaya,ghaziabad,greater nioda,gurugram,haldia,hapur,hisar,howrah,hubballi,hyderabad,jorapokhar,kalaburagi,kanpur,karnal,khanna,kota,kurukshetra,lucknow,maihar,manali,mandideep,mumbai,muzaffarpur,nashik,navi mumbai,noida,panipat,pantna,patiyala,pithampur,pune,ratlam,rupnagar,satna,siluguri,singrauli,sirsa,solapur,talcher,thiruvananthapuram,tirupati,udaipur,ujjain,visakhapatnam";

        cities = Arrays.asList(city.split("\\s*,\\s*"));
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,cities);
        System.out.println(cities);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        //json thing
        selectedCity=String.valueOf(spinner.getSelectedItem());
        pollutionList = new ArrayList<>();
        lv = (ListView) findViewById(R.id.list);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Selected city is :"+selectedCity,Toast.LENGTH_LONG).show();
                new Getpollution().execute();
            }
        });


    }
    private class Getpollution extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(City.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(Void... arg0)
        {
            HttpHandler sh = new HttpHandler();
            // Making a request to url and getting response
            String url = "https://api.waqi.info/feed/bangalore/?token=e77965fe2ea9d2510af203f0d38aa4eefcfd4a29";
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    JSONObject data = jsonObj.getJSONObject("data");

                    Log.e(TAG, "Response from url: " + data);

                    String aqi = data.getString("aqi");
                    Log.e(TAG, "Response from url: " + aqi);

                    JSONObject p = data.getJSONObject("iaqi");

                    JSONObject c = p.getJSONObject("co");
                    Log.e(TAG, "Response from url: " + c);
                    String co=c.getString("v");
                    Log.e(TAG, "Response from url: " +co);

                    JSONObject n = p.getJSONObject("no2");
                    String no2=n.getString("v");
                    Log.e(TAG, "Response from url: " +no2);
                    JSONObject o = p.getJSONObject("o3");
                    String o3=o.getString("v");
                    Log.e(TAG, "Response from url: " +o3);
                    JSONObject p1 = p.getJSONObject("pm10");
                    String pm10=p1.getString("v");
                    Log.e(TAG, "Response from url: " +pm10);
                    JSONObject p2 = p.getJSONObject("pm25");
                    String pm25=p2.getString("v");
                    Log.e(TAG, "Response from url: " +pm25);
                    JSONObject s = p.getJSONObject("so2");
                    String so2=s.getString("v");
                    Log.e(TAG, "Response from url: " +so2);
                    JSONObject t1 = p.getJSONObject("t");
                    String t=t1.getString("v");
                    Log.e(TAG, "Response from url: " +t);
//                                    JSONObject w1 = p.getJSONObject("w");
//                                    String w=w1.getString("v");
//                    Log.e(TAG, "Response from url: " +w);
////                                   JSONObject w2 = p.getJSONObject("w");
////                                  String wg=w2.getString("v");

                    List<Pollution> pollutionDataList = new ArrayList<Pollution>();
                    Pollution pollution=new Pollution();
                    pollution.setAqi("aqi");
                    pollution.setCo("co");
                    pollution.setNo2("no2");
                    pollution.setPm10("pm10");
                    pollution.setPm25("pm25");
                    pollution.setO3("o3");
                    pollutionDataList.add(pollution);
                    appRepositry.insertpollutiondata(pollutionDataList);


                    System.out.println(pollutionDataList.size());

                    // tmp hash map for single contact
                    HashMap<String, String> p_data = new HashMap<>();

                    // adding each child node to HashMap key => value
                    p_data.put("aqi", aqi);
                    p_data.put("co", "co :"+co);
                    //p_data.put("dew", dew);
                    p_data.put("no2", "no2 :"+no2);
                    p_data.put("o3", "o3 :"+o3);
                    p_data.put("pm10","pm10 :"+pm10);
                    p_data.put("pm25","pm25 :"+pm25);
                    p_data.put("so2","so2 :"+so2);
                    //  p_data.put("t", t);
//                        p_data.put("w", "w :"+w);
//                       // p_data.put("wg",wg);


                    // adding contact to contact list
                    pollutionList.add(p_data);

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
            ListAdapter adapter = new SimpleAdapter(City.this, pollutionList,
                    R.layout.list_item, new String[]{ "co","no2","o3","pm10","pm25","so2"},
                    new int[]{R.id.co, R.id.no2,R.id.o3,R.id.pm10,R.id.pm25,R.id.so2});
            lv.setAdapter(adapter);
            Toast.makeText(getApplicationContext(),
                    "data fetching complete",
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedCity = cities.get(position);
        //System.out.println(position);
        Toast.makeText(getApplicationContext(),cities.get(position) , Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}
