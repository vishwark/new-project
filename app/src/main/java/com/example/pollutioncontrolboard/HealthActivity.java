package com.example.pollutioncontrolboard;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HealthActivity extends AppCompatActivity
{
//    TextView t1=findViewById(R.id.t1);
//    TextView t2=findViewById(R.id.t2);
//    TextView t3=findViewById(R.id.t3);
//    TextView t5=findViewById(R.id.t4);
//    TextView t4=findViewById(R.id.t5);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(R.style.AppTheme_Dark);
//        t1.setMovementMethod(new ScrollingMovementMethod());
//        t2.setMovementMethod(new ScrollingMovementMethod());
//        t3.setMovementMethod(new ScrollingMovementMethod());
//        t5.setMovementMethod(new ScrollingMovementMethod());
//
//        t4.setMovementMethod(new ScrollingMovementMethod());
        setContentView(R.layout.glossary);

    }
}