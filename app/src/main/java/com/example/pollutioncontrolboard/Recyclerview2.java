package com.example.pollutioncontrolboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;

public class Recyclerview2 extends AppCompatActivity {
    RecyclerView r1;
    String s1[],s2[];
    MyOwnAdapter ad;
    int imageResource[]={R.drawable.air_pollution,R.drawable.air_pollution,R.drawable.air_pollution,R.drawable.air_pollution,R.drawable.air_pollution,R.drawable.air_pollution,R.drawable.air_pollution};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        r1=(RecyclerView) findViewById(R.id.recyclerView);

        s1=getResources().getStringArray(R.array.gases);
        s2=getResources().getStringArray(R.array.health);
        ad=new MyOwnAdapter(this,s1,s2,imageResource);
        r1.setAdapter(ad);
        // r1.setLayoutManager(new LinearLayoutManager(this));

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL);
        r1.setLayoutManager(staggeredGridLayoutManager);

    }
}

//public class Recyclerview extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_recyclerview);
//    }
//}
