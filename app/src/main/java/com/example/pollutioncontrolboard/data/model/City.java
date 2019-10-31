package com.example.pollutioncontrolboard.data.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class City {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="cid")
    private int cid;

    @ColumnInfo(name="city_name")
    private String city_name;

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

    @ColumnInfo(name="pid")
    private String pid;



}

