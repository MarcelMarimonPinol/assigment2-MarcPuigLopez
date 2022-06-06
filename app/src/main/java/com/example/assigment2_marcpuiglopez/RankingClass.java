package com.example.assigment2_marcpuiglopez;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assigment2_marcpuiglopez.domain.User;
import com.example.assigment2_marcpuiglopez.domain.RankingAdapter;
import com.example.assigment2_marcpuiglopez.domain.UserViewModel;

public class RankingClass extends AppCompatActivity implements UserClick{

    private RecyclerView ranking;

    private RankingAdapter rankingAdapter;
    UserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking_class);

        ranking = findViewById(R.id.ranking);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        ranking.setLayoutManager(layoutManager);

        ranking.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        viewModel = new ViewModelProvider(this).get(UserViewModel.class);
        viewModel.getAllUsers().observe(this, users -> rankingAdapter.setUsers(users));

        rankingAdapter = new RankingAdapter(this, this);
        ranking.setAdapter(rankingAdapter);
    }

    @Override
    public void onUserClicked(User user) {
        Intent i = new Intent(this, HistoryClass.class);
        i.putExtra(getString(R.string.user_hint) , user);
        startActivity(i);
    }

}