package com.example.assigment2_marcpuiglopez.domain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assigment2_marcpuiglopez.R;

import java.util.Collections;
import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private List<UserEntity> data = Collections.emptyList();
    private final Context context;

    public HistoryAdapter(final Context context) {
        this.context = context;
    }

    public void setGames(List<UserEntity> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserEntity userEntity = data.get(position);
        holder.gameId.setText(String.valueOf(userEntity.gameId));
        holder.nickname.setText(userEntity.nickname);
        holder.score.setText(String.valueOf(userEntity.score));
    }

    @Override
    public int getItemCount() {
        if (data == null) return 0;
        return data.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nickname;
        public TextView score;
        public TextView gameId;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nickname = itemView.findViewById(R.id.nickname);
            score = itemView.findViewById(R.id.score);
            gameId = itemView.findViewById(R.id.gameId);
        }
    }
}
