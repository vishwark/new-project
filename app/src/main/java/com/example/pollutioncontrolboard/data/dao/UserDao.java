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
    @Delete
    void delete(User user);
    @Query("select * from Health")
    List<Health> getHealth();
    @Query("select count(*) from User")
    int countUsers();
    @Query("select * from User")
    List<User> getUsers();

    @Query("select aqi from Pollution")
    String getaqi();

    @Query("select * from Pollution")
    List<Pollution> getPollution();






}
