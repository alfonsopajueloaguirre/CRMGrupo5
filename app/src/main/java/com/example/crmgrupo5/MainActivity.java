package com.example.crmgrupo5;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase BaseDeDatos;
    private AdminSQLiteOpenHelper BBDD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BBDD = new AdminSQLiteOpenHelper(this, "CRM-Clientes", null, 1);
    }
}
