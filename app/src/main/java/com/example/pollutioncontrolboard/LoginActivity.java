package com.example.pollutioncontrolboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity  extends AppCompatActivity {
    public LoginActivity()
    {
    }
    EditText etUserName,etPassword;
    Button btnLogin;
    String username,password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserName=findViewById(R.id.username);
        etPassword=findViewById(R.id.password);
        btnLogin=findViewById(R.id.login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Button clo");
                username=etUserName.getText().toString();
                password=etPassword.getText().toString();
                validate();
            }
        });

    }

    public void validate()
    {
       if(username.isEmpty() || password.isEmpty())
       {
           Toast.makeText(this,"enter the username and password",Toast.LENGTH_LONG).show();
       }
       else
       {
           if(username.equals("vishwa") && password.equals("1234")){
               Toast.makeText(this,"welcome successful login",Toast.LENGTH_LONG).show();


           }
           else
           {
               Toast.makeText(this,"unsuccessful login",Toast.LENGTH_LONG).show();
               Intent intent = new Intent(this, MainActivity.class);
               startActivity(intent);
           }

       }
    }
}
