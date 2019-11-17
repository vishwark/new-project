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


public class RegisterActivity extends AppCompatActivity {


    private EditText etUserName,etEmail,etPassword;
    private Button btnSubmit;
    private String userName,email,password;

    AppRepositry appRepositry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setTheme(R.style.AppTheme_Dark);
        setContentView(R.layout.register_layout);
        etUserName = findViewById(R.id.etUserName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSubmit = findViewById(R.id.btnSubmit);
        appRepositry = new AppRepositry(getApplicationContext());
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userName = etUserName.getText().toString();
                email = etEmail.getText().toString();
                password = etPassword.getText().toString();

                User user = new User();
                user.setUsername(userName);
                user.setEmail(email);
                user.setPassword(password);

                boolean hasEmptyFields = false;
                String message = "";

                if(userName.isEmpty()){
                    hasEmptyFields = true;
                    message = "Enter the user Name";
                }
                if(email.isEmpty()){
                    hasEmptyFields = true;
                    if(!message.isEmpty()){
                        message = message+" , Enter the email";
                    }else{
                        message = message+"Enter the email";
                    }
                }
                if(password.isEmpty()){
                    hasEmptyFields = true;
                    if(!message.isEmpty()){
                        message = message+" , Enter the password";
                    }else{
                        message = message+"Enter the password";
                    }
                }
                if(hasEmptyFields){
                    Toast.makeText(RegisterActivity.this,message,Toast.LENGTH_LONG).show();
                }else{
                    registerUser(user);
                }
            }
        });
    }

    private void registerUser(User user){
        appRepositry.insertUser(user);
        Toast.makeText(RegisterActivity.this,"Successfully registered.",Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }



}
