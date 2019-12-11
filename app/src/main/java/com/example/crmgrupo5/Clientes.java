package com.example.crmgrupo5;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

import java.io.ByteArrayInputStream;

public class Clientes extends AppCompatActivity {

    private SQLiteDatabase BaseDeDatos;
    private AdminSQLiteOpenHelper BBDD;
    private String tipoBBDD = "BBDDCliente";
    private TextView textoContacto1,textoContacto2,textoContacto3,textoContacto4,textoContacto5,textoContacto6;
    private TextView textoNombre1;
    private TextView textoApellido1;
    private TextView textoCorreo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BBDD = new AdminSQLiteOpenHelper(this, "BBDDCliente", null, 1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactos);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textoContacto1 = findViewById(R.id.textView_contacto1);
        textoContacto2 = findViewById(R.id.textView_contacto2);
        textoContacto3 = findViewById(R.id.textView_contacto3);
        textoContacto4 = findViewById(R.id.textView_contacto4);
        textoContacto5 = findViewById(R.id.textView_contacto5);
        textoContacto6 = findViewById(R.id.textView_contacto5);

        textoNombre1 = findViewById(R.id.textView_nombre1);

        //textoApellido1 = findViewById(R.id.te)

        textoCorreo1 = findViewById(R.id.textView_correo1);



        mostrarClientes();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Clientes.this, RegistrarCliente.class);
                startActivity(intent);

            }
        });
    }

    public void mostrarClientes(){
        BaseDeDatos = BBDD.getWritableDatabase();
        String columnas[] = new String[]{"nombre","apellido","correo"};
        String j1="",j2="",j3="",j4="",j5="",j6="",p1="",p2="",p3="",p4="",p5="",p6="", c1,c2,c3,c4,c5,c6;
        String empty ="";

        Cursor fila1 = BaseDeDatos.rawQuery("select * from "+tipoBBDD+"  order by nombreCliente DESC",null);

        if(fila1.moveToFirst()) {
            j1 = fila1.getString(0);
            p1 = fila1.getString(1);
            c1 = fila1.getString(2);
            textoContacto1.setVisibility(View.VISIBLE);

            if (fila1.moveToNext()) {
                j2 = fila1.getString(0);
                p2 = fila1.getString(1);
                c2 = fila1.getString(2);
                textoContacto2.setVisibility(View.VISIBLE);
            }
            if (fila1.moveToNext()) {
                j3 = fila1.getString(0);
                p3 = fila1.getString(1);
                c3 = fila1.getString(2);
                textoContacto3.setVisibility(View.VISIBLE);
            }
            if (fila1.moveToNext()) {
                j4 = fila1.getString(0);
                p4 = fila1.getString(1);
                c4 = fila1.getString(2);
                textoContacto4.setVisibility(View.VISIBLE);
            }
            if (fila1.moveToNext()) {
                j5 = fila1.getString(0);
                p5 = fila1.getString(1);
                c5 = fila1.getString(2);
                textoContacto5.setVisibility(View.VISIBLE);
            }
            if (fila1.moveToNext()) {
                j6 = fila1.getString(0);
                p6 = fila1.getString(1);
                c6 = fila1.getString(2);
                textoContacto6.setVisibility(View.VISIBLE);
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

        textoNombre1.setText(j1);
        /*textoRanking2.setText(j2);
        textoRanking3.setText(j3);
        textoRanking4.setText(j4);
        textoRanking5.setText(j5);
        textoRanking6.setText(j6);*/

        textoCorreo1.setText(p1);
        /*mostrarPunt2.setText(p2);
        mostrarPunt3.setText(p3);
        mostrarPunt4.setText(p4);
        mostrarPunt5.setText(p5);
        mostrarPunt6.setText(p6);*/

        BaseDeDatos.close();

    }

}
