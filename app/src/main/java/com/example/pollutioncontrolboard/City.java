package com.example.pollutioncontrolboard;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import com.example.pollutioncontrolboard.data.AppRepositry;
import com.example.pollutioncontrolboard.data.model.AqiHelperModel;
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



    Spinner spinner;
    String selectedCity;
    List<String> cities = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(R.style.AppTheme_Dark);
        appRepositry = new AppRepositry(getApplicationContext());
        setContentView(R.layout.content_city);
        spinner = findViewById(R.id.spinner_search);
        Button button = findViewById(R.id.button);
        String city = "agra,ahmedabad,amaravathi,ambala,amrithsar,ankleshwar,asansol,aurangabad,banglore,bathinda,brajrajnagar,bulandshahr,chandrapur,chennai,coimbatore,delhi,durgapur,dwarka,eloor,faridabad,fatehabad,gandhinagar,gaya,ghaziabad,greater nioda,gurugram,haldia,hapur,hisar,howrah,hubballi,hyderabad,jorapokhar,kalaburagi,kanpur,karnal,khanna,kota,kurukshetra,lucknow,maihar,manali,mandideep,mumbai,muzaffarpur,nashik,navi mumbai,noida,panipat,pantna,patiyala,pithampur,pune,ratlam,rupnagar,satna,siluguri,singrauli,sirsa,solapur,talcher,thiruvananthapuram,tirupati,udaipur,ujjain,visakhapatnam";

        cities = Arrays.asList(city.split("\\s*,\\s*"));
        ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,cities);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Selected city is :"+selectedCity,Toast.LENGTH_LONG).show();
                Intent intent = new Intent(City.this,PollutionViewActivity.class);
                intent.putExtra("city",selectedCity);
                startActivity(intent);
            }
        });


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectedCity = parent.getItemAtPosition(position).toString();
        Toast.makeText(getApplicationContext(),selectedCity, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent)
    {

    }
}
