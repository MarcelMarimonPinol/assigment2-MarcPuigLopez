package com.example.assigment2_marcpuiglopez.domain;

import android.os.Parcel;
import android.os.Parcelable;

    public class Player implements Parcelable {

        private String nickname;

        public Player(String nickname) {
            this.nickname = nickname;
        }

        protected Player(Parcel in) {
            nickname = in.readString();
        }

        public static final Creator<Player> CREATOR = new Creator<Player>() {
            @Override
            public Player createFromParcel(Parcel in) {
                return new Player(in);
            }

            @Override
            public Player[] newArray(int size) {
                return new Player[size];
            }
        };

        public String getNickname() {
            return nickname;
        }

        @Override
        public String toString() {
            return "Word{" +
                    "nickname='" + nickname + '\'' +
                    '}';
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(nickname);
        }



}
