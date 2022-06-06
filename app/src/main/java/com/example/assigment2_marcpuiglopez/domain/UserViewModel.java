package com.example.assigment2_marcpuiglopez.domain;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.assigment2_marcpuiglopez.room.DatabaseController;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private DatabaseController repository;
    private LiveData<List<User>> allUsers;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new DatabaseController(application);
        allUsers = repository.fetchAll();
    }

    //la he puesto public
    public LiveData<List<User>> getAllUsers() {
        return allUsers;
    }

    public int getGamesPlayed() {
        return repository.g;
    }

    public void insert(User user) {
        repository.setUser(user);
    }
}

