package com.example.pollutioncontrolboard.data.model;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name="user_name")
    private String username;

    @ColumnInfo(name="password")
    private String password;

    @ColumnInfo(name="email")
    private String email;

    @ColumnInfo(name="city")
    private String city;

    @ColumnInfo(name="phone")
    private long phone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }
}


@Entity
class Pollution {

    @PrimaryKey(autoGenerate = true)
    private int uid;

    @ColumnInfo(name="aqi")
    private String aqi;

    @ColumnInfo(name="co")
    private String co;

    @ColumnInfo(name="dew")
    private String dew;

    @ColumnInfo(name="no2")
    private String no2;

    @ColumnInfo(name="o3")
    private String o3;

    @ColumnInfo(name="pm10")
    private long pm10;

    @ColumnInfo(name="pm25")
    private String pm25;

    @ColumnInfo(name="so2")
    private String so2;

    @ColumnInfo(name="t")
    private String t;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    public void setCo(String co) {
        this.co = co;
    }

    public void setDew(String dew) {
        this.dew = dew;
    }

    public void setNo2(String no2) {
        this.no2 = no2;
    }

    public void setO3(String o3) {
        this.o3 = o3;
    }

    public void setPm10(long pm10) {
        this.pm10 = pm10;
    }

    public void setPm25(String pm25) {
        this.pm25 = pm25;
    }

    public void setSo2(String so2) {
        this.so2 = so2;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getAqi() {
        return aqi;
    }

    public String getCo() {
        return co;
    }

    public String getDew() {
        return dew;
    }

    public String getNo2() {
        return no2;
    }

    public String getO3() {
        return o3;
    }

    public long getPm10() {
        return pm10;
    }

    public String getPm25() {
        return pm25;
    }

    public String getSo2() {
        return so2;
    }

    public String getT() {
        return t;
    }




}
