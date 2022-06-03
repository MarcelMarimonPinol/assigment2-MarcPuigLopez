package com.example.assigment2_marcpuiglopez.domain;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.android.gms.games.Player;

public class Game implements Parcelable {

    private Player player;
    private int intents;
    private int score;

    public Game(User user, int intents, int score) {
        this.player = player;
        this.intents = intents;
        this.score = score;
    }

    protected Game(Parcel in) {
        player = in.readParcelable(Player.class.getClassLoader());
        intents = in.readInt();
        score = in.readInt();
    }

    public static final Creator<Game> CREATOR = new Creator<Game>() {
        @Override
        public Game createFromParcel(Parcel in) {
            return new Game(in);
        }

        @Override
        public Game[] newArray(int size) {
            return new Game[size];
        }
    };

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getIntents() {
        return intents;
    }

    public void setIntents(int intents) {
        this.intents = intents;
    }

    public int getScore(int letters) {
        return ((letters-intents)/letters)*10;
    }

    public void missedGuess() {
        this.score = 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeParcelable(player, flags);
        parcel.writeInt(intents);
        parcel.writeInt(score);
    }

}
