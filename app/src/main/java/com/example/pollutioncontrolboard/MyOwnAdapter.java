package com.example.pollutioncontrolboard;

import android.content.Context;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;

//import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyOwnAdapter extends RecyclerView.Adapter<MyOwnAdapter.MyOwnHolder> {
    String data1[],data2[];
    int img[];
    Context ctx;
    public MyOwnAdapter(Context ct,String[] s1,String[] s2,int i1[])
    {
        ctx=ct;
        data1=s1;
        data2=s2;
        img=i1;
    }

    @Override
    public MyOwnHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater myInflator=LayoutInflater.from(ctx);
        View myownView=  myInflator.inflate(R.layout.my_row,parent,false);
        return new MyOwnHolder(myownView);
    }

    @Override
    public void onBindViewHolder( MyOwnHolder holder, int position) {
        holder.t1.setText(data1[position]);
        holder.t2.setText(data2[position]);

        holder.myImage.setImageResource(img[position]);

    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyOwnHolder extends RecyclerView.ViewHolder
    {
        TextView t1,t2;
        ImageView myImage;
        public MyOwnHolder(View itemView) {
            super(itemView);
            t1=(TextView)itemView.findViewById(R.id.textView2);
            t2=(TextView)itemView.findViewById(R.id.textView3);
            myImage=(ImageView)itemView.findViewById(R.id.imageView);
        }
    }
}
