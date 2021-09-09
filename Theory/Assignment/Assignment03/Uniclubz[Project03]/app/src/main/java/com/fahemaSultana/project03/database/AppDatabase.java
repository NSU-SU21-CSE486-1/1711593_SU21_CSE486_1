package com.fahemaSultana.project03.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.fahemaSultana.project03.profile.DataModel.UserEntity;

@Database(entities = {UserEntity.class}, version = 1, exportSchema = false)
@TypeConverters({UniversitiesConverters.class, PhoneNumbersConverters.class})
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract UserDao userDao();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "AppDatabase.db")
                    .build();
        }
        return instance;

    }
}
