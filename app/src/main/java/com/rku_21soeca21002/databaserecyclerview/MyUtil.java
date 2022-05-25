package com.rku_21soeca21002.databaserecyclerview;

public class MyUtil {
    public static final String DB_NAME = "rku";
    public static final String TBL_NAME = "student";

    public static final String COL_ID = "id";
    public static final String COL_USERNAME = "username";
    public static final String COL_PASSWORD = "password";

    public static final String CREATE_QUERY = "CREATE TABLE IF NOT EXISTS " + TBL_NAME + "(" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_USERNAME + " TEXT, " + COL_PASSWORD + " TEXT)";
}
