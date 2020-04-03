package com.example.pollutioncontrolboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void adduser(View view) {
        Intent intent = new Intent(Add.this,RegisterActivity.class);
        startActivity(intent);
    }
}
