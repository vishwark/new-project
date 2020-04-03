package com.example.pollutioncontrolboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pollutioncontrolboard.data.model.User;

public class Admin extends AppCompatActivity {
    EditText etUserName,etPassword;
    Button btnLogin;
    String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        etUserName=findViewById(R.id.a);
        etPassword=findViewById(R.id.p);
        btnLogin=findViewById(R.id.b);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username=etUserName.getText().toString();
                password=etPassword.getText().toString();
                validate();
            }
        });
    }
    public void validate()
    {
        if(username.isEmpty() && password.isEmpty())
        {
            Toast.makeText(this,"Enter the username and password",Toast.LENGTH_LONG).show();
        } else if(username.isEmpty())
        {
            Toast.makeText(this,"Enter the user name",Toast.LENGTH_LONG).show();
        } else if(password.isEmpty()){
            Toast.makeText(this,"Enter the user name",Toast.LENGTH_LONG).show();
        }else{

            if(!(username=="vishwa" && password == "1234")){
                Intent intent = new Intent(Admin.this,Add.class);
                startActivity(intent);
            }else{
                Toast.makeText(this,"Invalid username or password. Please try again ",Toast.LENGTH_LONG).show();
            }
        }
    }
}
