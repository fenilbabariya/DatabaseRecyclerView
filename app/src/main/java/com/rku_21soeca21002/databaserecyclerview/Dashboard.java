package com.rku_21soeca21002.databaserecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<UserPOJO> users;
    UserAdapter adapter;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        recyclerView = findViewById(R.id.recyclerView);
        dbHelper = new DBHelper(getApplicationContext());

        users = fetchUsersFromDatabase();
        adapter = new UserAdapter(getApplicationContext(),users);

        RecyclerView.LayoutManager mlayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

    }

    private ArrayList<UserPOJO> fetchUsersFromDatabase() {
        ArrayList<UserPOJO> user = new ArrayList<UserPOJO>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(MyUtil.TBL_NAME,null,null,null,null,null,null);
        if(cursor.getCount()>0)
        {
            cursor.moveToFirst();
            do {
                String username = cursor.getString(1);
                String password = cursor.getString(2);
                user.add(new UserPOJO(username,password));
            }while (cursor.moveToNext());
        }
        return user;
    }

    public void addNewRocord(View view) {
        startActivity(new Intent(Dashboard.this,Registration.class));
    }
}