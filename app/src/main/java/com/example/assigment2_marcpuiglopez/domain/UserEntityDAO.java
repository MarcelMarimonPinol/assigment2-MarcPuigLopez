package com.example.assigment2_marcpuiglopez.domain;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface UserEntityDAO {

    @Query("SELECT nickname, sum(score) AS score , (SELECT count(*) FROM userentity group by nickname) AS gameId FROM userentity GROUP BY nickname ORDER BY score DESC")
    LiveData<List<UserEntity>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE) //Aqui enlloc de replace hi havia ignroe
    void insertUser(UserEntity element);

    @Query("SELECT * from userentity where nickname = (:name)")
    LiveData<List<UserEntity>> getGamesByNickname(String name);

}
