package com.example.crmgrupo5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper {



    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase baseDatos) {
        baseDatos.execSQL("create table BBDDCliente (nombreCliente varchar(20) primary key, apellido varchar(30) primary key,correo varchar(30))");
        baseDatos.execSQL("create table BBDDNegocio (nombreEmpresa varchar(20) primary key, ingresos float,IdFiscal int)");
        baseDatos.execSQL("create table BBDDReuniones (dia int primary key, mes int,nombreCliente varchar(20),recordatorio int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
