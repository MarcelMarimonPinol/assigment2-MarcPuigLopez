package com.example.assigment2_marcpuiglopez.domain;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    @PrimaryKey (autoGenerate = true)
    @NonNull
    public int gamesPlayed;

    @ColumnInfo(name = "nickname")
    @NonNull
    public String nickname;

    @ColumnInfo(name = "score")
    @NonNull
    public int score;


    public User(String nickname) {
        this.nickname = nickname;
        this.score = 0;
        this.gamesPlayed = 0;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gamesPlayed = gamesPlayed;
    }
}
