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
            String url = "https://api.waqi.info/feed/beijing/?token=e77965fe2ea9d2510af203f0d38aa4eefcfd4a29";
            String jsonStr = sh.makeServiceCall(url);

            Log.e(TAG, "Response from url: " + jsonStr);
            if (jsonStr != null) {
                try {
                    JSONObject jsonObj = new JSONObject(jsonStr);
                    JSONObject data = jsonObj.getJSONObject("data");


                        String aqi = data.getString("aqi");

                        JSONObject p = data.getJSONObject("iaqi");


                                    String co2=p.getString("co2");
                                    String dew=p.getString("dew");
                                    String no2=p.getString("no2");
                                    String o3=p.getString("o3");
                                    String pm10=p.getString("pm10");
                                    String pm25=p.getString("pm25");
                                    String so2=p.getString("so2");
                                    String t=p.getString("t");
                                    String w=p.getString("w");
                                    String wg=p.getString("wg");






                        // tmp hash map for single contact
                        HashMap<String, String> p_data = new HashMap<>();

                        // adding each child node to HashMap key => value
                        p_data.put("aqi", aqi);
                        p_data.put("co2", co2);
                        p_data.put("dew", dew);
                        p_data.put("no2", no2);
                        p_data.put("o3", o3);
                        p_data.put("pm10",pm10);
                        p_data.put("pm25",pm25);
                        p_data.put("so2",so2);
                        p_data.put("t", t);
                        p_data.put("w", w);
                        p_data.put("wg",wg);


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
                    R.layout.list_item, new String[]{ "email","mobile"},
                    new int[]{R.id.email, R.id.mobile});
            lv.setAdapter(adapter);
        }
    }

}
