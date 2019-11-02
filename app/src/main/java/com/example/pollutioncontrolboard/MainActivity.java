package com.example.pollutioncontrolboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pollutioncontrolboard.data.model.AppRepositry;
import com.example.pollutioncontrolboard.data.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private String TAG = MainActivity.class.getSimpleName();
    ArrayList<HashMap<String, String>> pollutionList;
    private ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppRepositry appRepositry = new AppRepositry(getApplicationContext());
        System.out.println("Inside main activity");
        User user = new User();
        //user.setUid(1);
        user.setCity("Bengaluru");
        user.setEmail("2xyz@gmail.com");
        user.setUsername("abc");
        user.setPassword("123456789");
        user.setPhone(9874452145L);
        appRepositry.insertUser(user);
        System.out.println("Successfully inserted new user");
        List<User> users = appRepositry.getAllUsers();
        String email = "";
        for(User usr : users){
            System.out.println("Email : "+usr.getEmail());
            email = usr.getEmail();

            //json parsing
            pollutionList = new ArrayList<>();
            lv = (ListView) findViewById(R.id.list);
            new Getpollution().execute();

        }

       // TextView txtEmail = findViewById(R.id.txtEmail);
        //txtEmail.setText(email);
    }

    private class Getpollution extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this,"Json Data is downloading",Toast.LENGTH_LONG).show();

        }

        @Override
        protected Void doInBackground(Void... arg0) {HttpHandler sh = new HttpHandler();
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
                                    JSONObject w1 = p.getJSONObject("wg");
                                    String w=w1.getString("v");
                    Log.e(TAG, "Response from url: " +w);
//                                    JSONObject w2 = p.getJSONObject("w");
//                                    String wg=w2.getString("v");






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
                       // p_data.put("t", t);
                        p_data.put("w", "w :"+w);
                       // p_data.put("wg",wg);


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
            ListAdapter adapter = new SimpleAdapter(MainActivity.this, pollutionList,
                    R.layout.list_item, new String[]{ "co","no2","o3","pm10","pm25","so2","w"},
                    new int[]{R.id.co, R.id.no2,R.id.o3,R.id.pm10,R.id.pm25,R.id.so2,R.id.w});
            lv.setAdapter(adapter);
            Toast.makeText(getApplicationContext(),
                    "data fetching complete",
                    Toast.LENGTH_LONG).show();
        }
    }

}
