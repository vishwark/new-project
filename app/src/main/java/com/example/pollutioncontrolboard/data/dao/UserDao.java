package com.example.pollutioncontrolboard.data.dao;

import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pollutioncontrolboard.data.model.User;

import java.util.List;


@Dao
public interface UserDao {

    @Insert
    public void insertAll(User... users);
    @Delete
    void delete(User user);

    @Query("select count(*) from user")
    int countUsers();
    @Query("select * from user")
    List<User> getUsers();





}
