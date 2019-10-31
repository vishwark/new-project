package com.example.pollutioncontrolboard.data.model;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import com.example.pollutioncontrolboard.data.AppDatabase;
import com.example.pollutioncontrolboard.data.dao.UserDao;

import java.util.List;

public class AppRepositry {
    AppDatabase appDatabase;

    public AppRepositry(Context context) {
        appDatabase = appDatabase.getAppDatabase(context);
    }

    public void insertUser(final User user) {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                appDatabase.userDao().insertAll(user);
                return null;
            }
        }.execute();

    }

    public List<Health> insertUser(final Health health) {

        return appDatabase.userDao().getHealth();

    }

    public List<User> getAllUsers(){
        return appDatabase.userDao().getUsers();
    }

}
