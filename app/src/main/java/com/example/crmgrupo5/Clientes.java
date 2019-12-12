package com.example.crmgrupo5;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class Clientes extends AppCompatActivity {

    private SQLiteDatabase BaseDeDatos;
    private AdminSQLiteOpenHelper BBDD;
    private String tipoBBDD = "BBDDCliente";
    private TextView textoContacto1,textoContacto2,textoContacto3,textoContacto4,textoContacto5,textoContacto6;
    private TextView textoNombre1,textoNombre2,textoNombre3,textoNombre4,textoNombre5,textoNombre6;
    private TextView textoApellido1,textoApellido2,textoApellido3,textoApellido4,textoApellido5,textoApellido6;
    private TextView textoCorreo1,textoCorreo2,textoCorreo3,textoCorreo4,textoCorreo5,textoCorreo6;

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
        textoContacto6 = findViewById(R.id.textView_contacto6);

        textoNombre1 = findViewById(R.id.textView_nombre1);
        textoNombre2 = findViewById(R.id.textView_nombre2);
        textoNombre3 = findViewById(R.id.textView_nombre3);
        textoNombre4 = findViewById(R.id.textView_nombre4);
        textoNombre5 = findViewById(R.id.textView_nombre5);
        textoNombre6 = findViewById(R.id.textView_nombre6);

        textoApellido1 = findViewById(R.id.textView_apellido1);
        textoApellido2 = findViewById(R.id.textView_apellido2);
        textoApellido3 = findViewById(R.id.textView_apellido3);
        textoApellido4 = findViewById(R.id.textView_apellido4);
        textoApellido5 = findViewById(R.id.textView_apellido5);
        textoApellido6 = findViewById(R.id.textView_apellido6);

        textoCorreo1 = findViewById(R.id.textView_correo1);
        textoCorreo2 = findViewById(R.id.textView_correo2);
        textoCorreo3 = findViewById(R.id.textView_correo3);
        textoCorreo4 = findViewById(R.id.textView_correo4);
        textoCorreo5 = findViewById(R.id.textView_correo5);
        textoCorreo6 = findViewById(R.id.textView_correo6);

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
        String j1="",j2="",j3="",j4="",j5="",j6="",p1="",p2="",p3="",p4="",p5="",p6="",c1="",c2="",c3="",c4="",c5="",c6="";
        String empty ="";

        Cursor fila1 = BaseDeDatos.rawQuery("select * from "+tipoBBDD+"  order by nombreCliente ASC",null);

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
                textoNombre6.setVisibility(View.VISIBLE);
                textoApellido6.setVisibility(View.VISIBLE);
                textoCorreo6.setVisibility(View.VISIBLE);
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
        textoCorreo6.setText(c6);

        BaseDeDatos.close();

    }

    public void restablecerContactos(View view){
        BaseDeDatos = BBDD.getWritableDatabase();

        BaseDeDatos.execSQL("DELETE FROM "+tipoBBDD);
        Toast.makeText(this, "Contactos restablecidas", Toast.LENGTH_SHORT).show();
        BaseDeDatos.close();

        textoContacto1.setVisibility(View.INVISIBLE);
        textoNombre1.setVisibility(View.INVISIBLE);
        textoApellido1.setVisibility(View.INVISIBLE);
        textoCorreo1.setVisibility(View.INVISIBLE);

        textoContacto2.setVisibility(View.INVISIBLE);
        textoNombre2.setVisibility(View.INVISIBLE);
        textoApellido2.setVisibility(View.INVISIBLE);
        textoCorreo2.setVisibility(View.INVISIBLE);

        textoContacto3.setVisibility(View.INVISIBLE);
        textoNombre3.setVisibility(View.INVISIBLE);
        textoApellido3.setVisibility(View.INVISIBLE);
        textoCorreo3.setVisibility(View.INVISIBLE);

        textoContacto4.setVisibility(View.INVISIBLE);
        textoNombre4.setVisibility(View.INVISIBLE);
        textoApellido4.setVisibility(View.INVISIBLE);
        textoCorreo4.setVisibility(View.INVISIBLE);

        textoContacto5.setVisibility(View.INVISIBLE);
        textoNombre5.setVisibility(View.INVISIBLE);
        textoApellido5.setVisibility(View.INVISIBLE);
        textoCorreo5.setVisibility(View.INVISIBLE);

        textoContacto6.setVisibility(View.INVISIBLE);
        textoNombre6.setVisibility(View.INVISIBLE);
        textoApellido6.setVisibility(View.INVISIBLE);
        textoCorreo6.setVisibility(View.INVISIBLE);

        mostrarClientes();
    }

}