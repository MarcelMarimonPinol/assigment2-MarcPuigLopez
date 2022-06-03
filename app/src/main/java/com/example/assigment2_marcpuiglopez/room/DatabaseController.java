package com.example.assigment2_marcpuiglopez.room;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.assigment2_marcpuiglopez.domain.User;
import com.example.assigment2_marcpuiglopez.domain.UserDAO;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DatabaseController {
    private UserDAO userDAO;
    private LiveData<List<User>> allUsers;

    public DatabaseController(Application application) {
        AppDatabase db = AppDatabase.getDatabase(application);
        userDAO = db.userDAO();
        allUsers = userDAO.getAll();
    }

    public LiveData<List<User>> fetchAll() {
        return allUsers;
    }

    public void setUser(User user) {
        new insertAsyncTask(userDAO).execute(user);
    }

    /*private static class insertAsyncTask extends AsyncTask<Todo, Void, Void> {
        private TodoDao asyncDao;

        insertAsyncTask(TodoDao dao) {
            asyncDao = dao;
        }

        @Override
        protected Void doInBackground(Todo... todos) {
            asyncDao.insertTodo(todos[0]);
            return null;
        }
    }*/

    private static class insertAsyncTask {
        private UserDAO asyncDao;
        private Executor executor = Executors.newSingleThreadExecutor();

        insertAsyncTask(UserDAO dao) {
            asyncDao = dao;
        }

        public void execute(User user) {
            this.doInBackground(user);
        }

        private void doInBackground(final User user) {
            this.executor.execute(new Runnable() {
                @Override
                public void run() {
                    asyncDao.insertUser(user);
                }
            });
        }
    }
}
