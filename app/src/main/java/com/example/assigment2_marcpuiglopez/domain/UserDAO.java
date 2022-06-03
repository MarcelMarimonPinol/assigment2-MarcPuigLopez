package com.example.assigment2_marcpuiglopez.domain;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {
    @Query("SELECT * FROM user")
    LiveData<List<User>> getAll();

    //OnConflictStrategy s'ulitza en cas de que la PK ja existeix.
    //No es necesari.
    @Insert(onConflict = OnConflictStrategy.IGNORE) //Aqui enlloc de replace hi havia ignroe
    void insertUser(User element);
}
