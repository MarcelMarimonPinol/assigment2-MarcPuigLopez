package com.example.assigment2_marcpuiglopez.domain;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserDAO {

    //@Query("SELECT name, sum(score) AS score , " +
    //        "count((SELECT count(name) FROM todo group by name)) AS games FROM todo GROUP BY name ORDER BY score DESC")

    @Query("SELECT * FROM user")
    LiveData<List<User>> getAll();

    @Query("SELECT * from user where nickname = (:nickname)")
    int getGamesPlayed(String nickname);

    //OnConflictStrategy s'ulitza en cas de que la PK ja existeix.
    //No es necesari.
    @Insert(onConflict = OnConflictStrategy.IGNORE) //Aqui enlloc de replace hi havia ignroe
    void insertUser(User element);


}
