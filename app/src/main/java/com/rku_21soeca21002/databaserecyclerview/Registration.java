package com.rku_21soeca21002.databaserecyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registration extends AppCompatActivity {

    EditText edtUsername, edtPassword;
    DBHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        dbHelper = new DBHelper(getApplicationContext());
    }

    //Register Button onclick
    public void register(View view) {
        validateForm();
    }

    private void validateForm() {
        String valUsername = edtUsername.getText().toString().trim();
        String valPassword = edtPassword.getText().toString();

        if(valUsername.equals("") || valPassword.equals(""))
        {
            Toast.makeText(this, "Username or Password must not be emopty", Toast.LENGTH_SHORT).show();
            return;
        }

        if(valPassword.length()<3)
        {
            Toast.makeText(this, "Password must be greater than 3", Toast.LENGTH_SHORT).show();
            return;
        }

        ContentValues values = new ContentValues();
        values.put(MyUtil.COL_USERNAME,valUsername);
        values.put(MyUtil.COL_PASSWORD,valPassword);

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.insert(MyUtil.TBL_NAME,null,values);
        Toast.makeText(this, "Record Added", Toast.LENGTH_SHORT).show();
        startActivity(new Intent(Registration.this,Dashboard.class));
        finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        Toast.makeText(this, "Back Button Pressed", Toast.LENGTH_SHORT).show();
    }
}