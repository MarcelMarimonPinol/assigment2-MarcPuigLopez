package com.example.assigment2_marcpuiglopez.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class UserEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "gameId")
    public int gameId;

    @NonNull
    @ColumnInfo(name = "nickname")
    public String nickname;

    @ColumnInfo(name = "score")
    public int score;

}
