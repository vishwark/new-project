package com.example.pollutioncontrolboard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pollutioncontrolboard.data.model.AppRepositry;
import com.example.pollutioncontrolboard.data.model.User;

import java.util.List;

public class MainActivity extends AppCompatActivity {

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
        }

        TextView txtEmail = findViewById(R.id.txtEmail);
        txtEmail.setText(email);
    }
}
