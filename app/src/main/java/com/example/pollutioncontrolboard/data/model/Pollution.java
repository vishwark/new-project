package com.example.pollutioncontrolboard.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Pollution {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name="city")
    private String city;


    @ColumnInfo(name="aqi")
    private String aqi;

    @ColumnInfo(name="co")
    private String co;



    @ColumnInfo(name="no2")
    private String no2;

    @ColumnInfo(name="o3")
    private String o3;

    @ColumnInfo(name="pm10")
    private String pm10;

    @ColumnInfo(name="pm25")
    private String pm25;

    @ColumnInfo(name="so2")
    private String so2;



    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public String getCo() {
        return co;
    }

    public void setCo(String co) {
        this.co = co;
    }


    public String getNo2() {
        return no2;
    }

    public void setNo2(String no2) {
        this.no2 = no2;
    }

    public String getO3() {
        return o3;
    }

    public void setO3(String o3) {
        this.o3 = o3;
    }

    public String getPm10() {
        return pm10;
    }

    public void setPm10(String pm10) {
        this.pm10 = pm10;
    }

    public String getPm25() {
        return pm25;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public String getSo2() {
        return so2;
    }

    public void setSo2(String so2) {
        this.so2 = so2;
    }


}