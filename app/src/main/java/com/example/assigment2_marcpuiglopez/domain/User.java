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

    public User() {
        this.nickname = "";
        this.score = 0;
    }

    public User(String nickname) {
        this.nickname = nickname;
        this.score = 0;
    }

    public User(String nickname, int score) {
        this.nickname = nickname;
        this.score = score;
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

    @Override
    public String toString() {
        return "User{" +
                "gamesPlayed=" + gamesPlayed +
                ", nickname='" + nickname + '\'' +
                ", score=" + score +
                '}';
    }
}
