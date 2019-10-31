package com.example.pollutioncontrolboard.data.model;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Program {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "pid")
    private int pid;

    @ColumnInfo(name = "p_name")
    private String p_name;

    @ColumnInfo(name = "aqi")
    private String aqi;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }
}
