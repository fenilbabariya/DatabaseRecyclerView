package com.rku_21soeca21002.databaserecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    Context context;
    ArrayList<UserPOJO> users;

    public UserAdapter(Context context, ArrayList<UserPOJO> users) {
        this.context = context;
        this.users = users;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.useritem,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        UserPOJO user = users.get(position);
        holder.txtUsername.setText(user.getUsername());
        holder.txtPassword .setText(user.getPassword());
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder{
        TextView txtUsername, txtPassword;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            txtUsername = itemView.findViewById(R.id.txtUsername);
            txtPassword = itemView.findViewById(R.id.txtPassword);
        }

    }

}
