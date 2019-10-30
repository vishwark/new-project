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

    @ColumnInfo(name="city")
    private String city;


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

    public String getDew() {
        return dew;
    }

    public void setDew(String dew) {
        this.dew = dew;
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

    public long getPm10() {
        return pm10;
    }

    public void setPm10(long pm10) {
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

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }
}


@Entity
class City {

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


@Entity
class Program {

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

@Entity
class Health {

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