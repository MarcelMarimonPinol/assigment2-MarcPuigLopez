package com.example.assigment2_marcpuiglopez.domain;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.assigment2_marcpuiglopez.room.DatabaseController;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private DatabaseController repository;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new DatabaseController(application);
    }

    public LiveData<List<UserEntity>> getAllUsers() {
        return repository.fetchAll();
    }

    public LiveData<List<UserEntity>> getGamesByNickname(@NonNull final String nickname) {
        return repository.getGamesByNickname(nickname);
    }

    public void insert(String nickname, int score) {
        repository.setUser(nickname, score);
    }

}

