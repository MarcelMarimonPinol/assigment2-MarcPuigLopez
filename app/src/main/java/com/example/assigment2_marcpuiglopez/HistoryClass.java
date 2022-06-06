package com.example.assigment2_marcpuiglopez;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assigment2_marcpuiglopez.domain.HistoryAdapter;
import com.example.assigment2_marcpuiglopez.domain.User;
import com.example.assigment2_marcpuiglopez.domain.UserViewModel;

public class HistoryClass extends AppCompatActivity {

    User user;
    private RecyclerView history;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.history_class);

        user = getIntent().getParcelableExtra(getString(R.string.user_hint));

        history = findViewById(R.id.history);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        history.setLayoutManager(layoutManager);

        history.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        HistoryAdapter historyAdapter = new HistoryAdapter(this);
        history.setAdapter(historyAdapter);

        UserViewModel viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        viewModel.getGamesByNickname(user.nickname).observe(this, historyAdapter::setGames);

    }
}