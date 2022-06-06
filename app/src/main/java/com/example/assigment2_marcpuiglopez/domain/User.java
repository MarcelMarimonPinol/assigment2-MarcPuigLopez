package com.example.assigment2_marcpuiglopez.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {

    public int gameId;
    public String nickname;
    public int score;

    public User(String nickname) {
        this.gameId = 0;
        this.nickname = nickname;
        this.score = 0;
    }

    public User(int gameId, String nickname, int score) {
        this.gameId = gameId;
        this.nickname = nickname;
        this.score = score;
    }

    protected User(Parcel in) {
        gameId = in.readInt();
        nickname = in.readString();
        gameId = in.readInt();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public int getGamesPlayed() {
        return gameId;
    }

    public void setGamesPlayed(int gamesPlayed) {
        this.gameId = gamesPlayed;
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
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(gameId);
        parcel.writeString(nickname);
        parcel.writeInt(score);
    }
}