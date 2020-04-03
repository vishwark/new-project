package com.example.pollutioncontrolboard;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
public class CausesActivity  extends AppCompatActivity
{
//    public String aq;
//    public  String ci;
//    TextView t1=findViewById(R.id.textView1);
//    TextView t2=findViewById(R.id.textView2);
//    TextView t3=findViewById(R.id.textView3);
//    TextView t4=findViewById(R.id.textView4);
//    TextView t5=findViewById(R.id.textView5);

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
        setContentView(R.layout.causes);




    }

//   PollutionViewActivity p=new PollutionViewActivity();
//   PollutionViewActivity.Getpollution gt =p.new Getpollution();
//
//     aq=gt.getCity();
//
//    ContentValues values =new ContentValues();
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        super.onCreate(savedInstanceState);
//        //setTheme(R.style.AppTheme_Dark);
//        setContentView(R.layout.causes);
//       // setContentView(R.layout.activity_main);
//        e1=findViewById(R.id.et1);
//        e2=findViewById(R.id.et2);
//    }
//
//    public void doSaveContent(View view) {
//        values.put("emp_name",e1.getText().toString());
//        values.put("profile",e2.getText().toString());
//        Uri uri= getContentResolver().insert(MyContentProvider.CONTENT_URI,values);
//        Toast.makeText(this,uri.toString(),Toast.LENGTH_LONG).show();
//    }
//
//    public void doLoadContent(View view) {
//        Cursor cr= getContentResolver().query(MyContentProvider.CONTENT_URI,null,null,null,"_id");
//        StringBuilder stringBuilder =new StringBuilder();
//
//        while(cr.moveToNext())
//        {
//            int id=cr.getInt(0);
//            String s1 =cr.getString(1);
//            String s2= cr.getString(2);
//            stringBuilder.append(id+"     "+s1+"     "+s2+"\n");
//
//        }
//        Toast.makeText(this,stringBuilder.toString(),Toast.LENGTH_LONG).show();
//    }
}
