package com.example.assigment2_marcpuiglopez.domain;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assigment2_marcpuiglopez.R;
import com.example.assigment2_marcpuiglopez.UserClick;

import java.util.Collections;
import java.util.List;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.ViewHolder> {
    private List<UserEntity> data = Collections.emptyList();
    private static UserClick clickListener;

    public RankingAdapter(final Context context, final UserClick clickUserItemListener) {
        this.clickListener = clickUserItemListener;
    }

    public void setUsers(List<UserEntity> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.ranking_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        UserEntity userEntity = data.get(position);

        holder.itemView.setOnClickListener(v ->
                clickListener.onUserClicked(new User(
                        userEntity.gameId,
                        userEntity.nickname,
                        userEntity.score
        )));

        holder.nickname.setText(userEntity.nickname);
        holder.score.setText(String.valueOf(userEntity.score));
        holder.gamesPlayed.setText(String.valueOf(userEntity.gameId));
    }

    @Override
    public int getItemCount() {
        if (data == null) return 0;
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nickname;
        public TextView score;
        public TextView gamesPlayed;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nickname = itemView.findViewById(R.id.nickname);
            score = itemView.findViewById(R.id.score);
            gamesPlayed = itemView.findViewById(R.id.gamesPlayed);
        }
    }
}
