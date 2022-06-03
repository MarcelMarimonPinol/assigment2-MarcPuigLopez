package com.example.assigment2_marcpuiglopez.domain;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assigment2_marcpuiglopez.R;

import java.util.Collections;
import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.ViewHolder> {
    private List<User> data = Collections.emptyList();

    public UserAdapter() {
    }

    public void setUsers(List<User> data) {
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
        User currentUser = data.get(position);
        Log.v("TEST", "holder: " + holder);
        Log.v("TEST", "user: " + currentUser);
        holder.nickname.setText(currentUser.getNickname() + "1");
        holder.score.setText(String.valueOf(currentUser.getScore()));
    }

    @Override
    public int getItemCount() {
        if (data == null) return 0;
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nickname;
        public TextView score;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nickname = itemView.findViewById(R.id.nickname);
            score = itemView.findViewById(R.id.score);
        }

        @Override
        public String toString() {
            return "ViewHolder{" +
                    "nickname=" + nickname +
                    ", score=" + score +
                    '}';
        }
    }
}
