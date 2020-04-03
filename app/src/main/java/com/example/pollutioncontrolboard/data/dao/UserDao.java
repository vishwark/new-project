package com.example.pollutioncontrolboard.data.dao;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pollutioncontrolboard.data.model.Health;
import com.example.pollutioncontrolboard.data.model.Pollution;
import com.example.pollutioncontrolboard.data.model.User;

import java.util.List;


@Dao
public interface UserDao {

    @Insert
    public void insertAll(User... users);

//    @Query("INSERT INTO user (email,username,passwrod) values :email , :username,:password")
//    public void insertUser(String username,String password,String email);

    @Insert
    public void insertPollution(Pollution... pollution);


    @Delete
    void delete(User user);

    @Query("select * from Health where city_name=:city_nam")
    List<Health> getHealth(String city_nam);

    @Query("select count(*) from User")
    int countUsers();
    @Query("select * from User")
    List<User> getUsers();

    @Query("select aqi from Pollution")
    String getaqi();

    @Query("select * from Pollution")
    List<Pollution> getPollution();

    @Query("select * from Health")
    List<Health> getHealth();

    @Query("select * from user where user_name = :username and password = :password")
    User getUserData(String username,String password);

}