package com.example.pollutioncontrolboard.data;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pollutioncontrolboard.data.dao.UserDao;
import com.example.pollutioncontrolboard.data.model.City;
import com.example.pollutioncontrolboard.data.model.Health;
import com.example.pollutioncontrolboard.data.model.Pollution;
import com.example.pollutioncontrolboard.data.model.Program;
import com.example.pollutioncontrolboard.data.model.User;

@Database(entities = {User.class, City.class, Health.class, Pollution.class, Program.class},version = 1)

public abstract class AppDatabase extends RoomDatabase
{
    public static AppDatabase INSTANCE;
    public abstract UserDao userDao();

    // added on friday
    public static AppDatabase getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "user-database").allowMainThreadQueries().build();
              /* allow queries on the main thread.
                        Don't do this on a real app! See PersistenceBasicSample for an example.*/

        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}