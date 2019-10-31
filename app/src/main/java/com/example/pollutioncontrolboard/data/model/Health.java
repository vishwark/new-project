package com.example.pollutioncontrolboard.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Health {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "cid")
    private int cid;

    @ColumnInfo(name = "city_name")
    private String city_name;

    @ColumnInfo(name = "pid")
    private String pid;

    @ColumnInfo(name = "aqi")
    private int aqi ;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCity_name() {
        return city_name;
    }

    public void setCity_name(String city_name) {
        this.city_name = city_name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }



    // @ColumnInfo(name = "status")
    // private int aqi ;


}