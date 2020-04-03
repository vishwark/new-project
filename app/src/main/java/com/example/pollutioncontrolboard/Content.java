package com.example.pollutioncontrolboard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Content extends AppCompatActivity {

    EditText e1,e2;
    ContentValues values =new ContentValues();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        e1=findViewById(R.id.et1);
        e2=findViewById(R.id.et2);
    }

    public void doSaveContent(View view) {
        values.put("emp_name",e1.getText().toString());
        values.put("profile",e2.getText().toString());
        Uri uri= getContentResolver().insert(MyContentProvider.CONTENT_URI,values);
        Toast.makeText(this,uri.toString(),Toast.LENGTH_LONG).show();
    }

    public void doLoadContent(View view) {
        Cursor cr= getContentResolver().query(MyContentProvider.CONTENT_URI,null,null,null,"_id");
        StringBuilder stringBuilder =new StringBuilder();

        while(cr.moveToNext())
        {
            int id=cr.getInt(0);
            String s1 =cr.getString(1);
            String s2= cr.getString(2);
            stringBuilder.append(id+"     "+s1+"     "+s2+"\n");

        }
        Toast.makeText(this,stringBuilder.toString(),Toast.LENGTH_LONG).show();
    }
}
