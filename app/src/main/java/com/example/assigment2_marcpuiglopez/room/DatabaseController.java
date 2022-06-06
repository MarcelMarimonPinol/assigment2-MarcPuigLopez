package com.example.assigment2_marcpuiglopez.room;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;

import com.example.assigment2_marcpuiglopez.domain.UserEntity;
import com.example.assigment2_marcpuiglopez.domain.UserEntityDAO;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DatabaseController {
    private UserEntityDAO userDAO;

    public DatabaseController(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        userDAO = db.userDAO();
    }

    public LiveData<List<UserEntity>> fetchAll() {
        return userDAO.getAll();
    }

    public void setUser(String nickname, int score) {
        UserEntity userEntity = new UserEntity();
        userEntity.nickname = nickname;
        userEntity.score = score;
        new insertAsyncTask(userDAO).execute(userEntity);
    }

    public LiveData<List<UserEntity>> getGamesByNickname(@NonNull final String nickname) {
        return userDAO.getGamesByNickname(nickname);
    }

    private static class insertAsyncTask {
        private UserEntityDAO asyncDao;
        private Executor executor = Executors.newSingleThreadExecutor();

        insertAsyncTask(UserEntityDAO dao) {
            asyncDao = dao;
        }

        public void execute(UserEntity userEntity) {
            this.doInBackground(userEntity);
        }

        private void doInBackground(final UserEntity userEntity) {
            this.executor.execute(() -> asyncDao.insertUser(userEntity));
        }
    }
}
