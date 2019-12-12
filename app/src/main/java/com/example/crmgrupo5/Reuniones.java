package com.example.crmgrupo5;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

public class Reuniones extends AppCompatActivity {
    private SQLiteDatabase BaseDeDatos;
    private AdminSQLiteOpenHelper BBDD;
    private String tipoBBDD = "BBDDReuniones";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BBDD = new AdminSQLiteOpenHelper(this, "BBDDReuniones", null, 1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reuniones);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mostrarReuniones();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Reuniones.this,RegistrarReunion.class);
                startActivity(intent);
            }
        });
    }
    public void mostrarReuniones(){
        BaseDeDatos = BBDD.getWritableDatabase();
        String columnas[] = new String[]{"reunion","mes","dia"};
        String j1="",j2="",j3="",j4="",j5="",j6="",p1="",p2="",p3="",p4="",p5="",p6="",c1="",c2="",c3="",c4="",c5="",c6="";
        String empty ="";

        Cursor fila1 = BaseDeDatos.rawQuery("select * from "+tipoBBDD+"  order by nombreCliente ASC",null);

        if(fila1.moveToFirst()) {
            j1 = fila1.getString(0);
            p1 = fila1.getString(1);
            c1 = fila1.getString(2);
            //textoContacto1.setVisibility(View.VISIBLE);

            if (fila1.moveToNext()) {
                j2 = fila1.getString(0);
                p2 = fila1.getString(1);
                c2 = fila1.getString(2);
                //textoContacto2.setVisibility(View.VISIBLE);
            }
            if (fila1.moveToNext()) {
                j3 = fila1.getString(0);
                p3 = fila1.getString(1);
                c3 = fila1.getString(2);
                //textoContacto3.setVisibility(View.VISIBLE);
            }
            if (fila1.moveToNext()) {
                j4 = fila1.getString(0);
                p4 = fila1.getString(1);
                c4 = fila1.getString(2);
                //textoContacto4.setVisibility(View.VISIBLE);
            }
            if (fila1.moveToNext()) {
                j5 = fila1.getString(0);
                p5 = fila1.getString(1);
                c5 = fila1.getString(2);
                //textoContacto5.setVisibility(View.VISIBLE);
            }
            if (fila1.moveToNext()) {
                j6 = fila1.getString(0);
                p6 = fila1.getString(1);
                c6 = fila1.getString(2);
                //textoContacto6.setVisibility(View.VISIBLE);
                //extoNombre6.setVisibility(View.VISIBLE);
                //textoApellido6.setVisibility(View.VISIBLE);
                //textoCorreo6.setVisibility(View.VISIBLE);
            }


        }else {

            j1="";
            j2="";
            j3="";
            j4="";
            j5="";
            j6="";
            p1="";
            p2="";
            p3="";
            p4="";
            p5="";
            p6="";
        }

        /*textoNombre1.setText(j1);
        textoNombre2.setText(j2);
        textoNombre3.setText(j3);
        textoNombre4.setText(j4);
        textoNombre5.setText(j5);
        textoNombre6.setText(j6);

        textoApellido1.setText(p1);
        textoApellido2.setText(p2);
        textoApellido3.setText(p3);
        textoApellido4.setText(p4);
        textoApellido5.setText(p5);
        textoApellido6.setText(p6);

        textoCorreo1.setText(c1);
        textoCorreo2.setText(c2);
        textoCorreo3.setText(c3);
        textoCorreo4.setText(c4);
        textoCorreo5.setText(c5);
        textoCorreo6.setText(c6);*/

        BaseDeDatos.close();

    }

}
