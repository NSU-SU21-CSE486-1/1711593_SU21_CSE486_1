package com.fahemaSultana.project03.database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.fahemaSultana.project03.profile.DataModel.UserEntity;

import java.util.List;

@Dao
public interface UserDao {

    @Insert(onConflict = REPLACE)
    void insert(UserEntity user);

    @Insert
    void insertAll(UserEntity... users);

    @Delete
    void delete(UserEntity user);

    @Query("SELECT * FROM user_list_table")
    List<UserEntity> getAll();

    @Query("SELECT * FROM user_list_table")
    LiveData<List<UserEntity>> getAllLiveData();
}
