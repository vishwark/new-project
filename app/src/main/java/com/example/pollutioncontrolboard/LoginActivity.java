package com.example.pollutioncontrolboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pollutioncontrolboard.data.AppRepositry;
import com.example.pollutioncontrolboard.data.model.User;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity  extends AppCompatActivity {

    EditText etUserName,etPassword;
    Button btnLogin,btnRegister;
    String username,password;

    AppRepositry appRepositry;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUserName=findViewById(R.id.username);
        etPassword=findViewById(R.id.password);
        btnLogin=findViewById(R.id.login);
        btnRegister = findViewById(R.id.btnRegister);
        appRepositry = new AppRepositry(getApplicationContext());
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                username=etUserName.getText().toString();
                password=etPassword.getText().toString();
                validate();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
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
           User user = appRepositry.getUserData(username,password);
           if(user!=null){
               Intent intent = new Intent(this,City.class);
               startActivity(intent);
           }else{
               Toast.makeText(this,"Invalid username or password. Please try again ",Toast.LENGTH_LONG).show();
           }
       }
    }

//    public void getUsers(View view)
//    {
//        List users = appRepositry.getAllUsers();
//        for(int i=0;i<users.size();i++)
//        {
//            Toast.makeText(this, (String) users.get(i),Toast.LENGTH_SHORT).show();
//        }
//    }

    public void admin(View view)
    {
        Intent intent = new Intent(this,Admin.class);
        startActivity(intent);
    }
}
