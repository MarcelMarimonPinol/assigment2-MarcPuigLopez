package com.example.assigment2_marcpuiglopez;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assigment2_marcpuiglopez.domain.User;
import com.example.assigment2_marcpuiglopez.domain.UserAdapter;
import com.example.assigment2_marcpuiglopez.domain.UserViewModel;

import java.util.ArrayList;
import java.util.List;

public class RankingClass extends AppCompatActivity {

    private RecyclerView ranking;

    private ArrayList<User> dataSet;
    private UserAdapter userAdapter;
    UserViewModel viewModel;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking_class);

        user = getIntent().getParcelableExtra("game");

        ranking = findViewById(R.id.ranking);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        ranking.setLayoutManager(layoutManager);

        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        viewModel.getAllUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> todos) {
                userAdapter.setUsers(todos);
            }
        });

        userAdapter = new UserAdapter();
        ranking.setAdapter(userAdapter);
    }
}