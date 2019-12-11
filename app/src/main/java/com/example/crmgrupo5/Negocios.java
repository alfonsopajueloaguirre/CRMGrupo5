package com.example.crmgrupo5;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Negocios extends AppCompatActivity {

    private SQLiteDatabase BaseDeDatos;
    private AdminSQLiteOpenHelper BBDD;
    private String tipoBBDD = "BBDDNegocio";
    private TextView textoNegocio1,textoNegocio2,textoNegocio3,textoNegocio4,textoNegocio5;
    private TextView textoIngreso1,textoIngreso2,textoIngreso3,textoIngreso4,textoIngreso5;
    private TextView textoNumero1,textoNumero2,textoNumero3,textoNumero4,textoNumero5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BBDD = new AdminSQLiteOpenHelper(this, "BBDDNegocio", null, 1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_negocios);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        textoNegocio1 = findViewById(R.id.textView_negocio1);
        textoNegocio2 = findViewById(R.id.textView_negocio2);
        textoNegocio3 = findViewById(R.id.textView_negocio3);
        textoNegocio4 = findViewById(R.id.textView_negocio4);
        textoNegocio5 = findViewById(R.id.textView_negocio5);

        textoIngreso1 = findViewById(R.id.textView_ingresos1);
        textoIngreso2 = findViewById(R.id.textView_ingresos2);
        textoIngreso3 = findViewById(R.id.textView_ingresos3);
        textoIngreso4 = findViewById(R.id.textView_ingresos4);
        textoIngreso5 = findViewById(R.id.textView_ingresos5);

        textoNumero1 = findViewById(R.id.textView_number1);
        textoNumero2 = findViewById(R.id.textView_number2);
        textoNumero3 = findViewById(R.id.textView_number3);
        textoNumero4 = findViewById(R.id.textView_number4);
        textoNumero5 = findViewById(R.id.textView_number5);

        mostrarNegocios();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Negocios.this,RegistrarNegocio.class);
                startActivity(intent);
            }
        });
    }
    public void mostrarNegocios(){
        BaseDeDatos = BBDD.getWritableDatabase();
        String columnas[] = new String[]{"nombreEmpresa","ingresos"};
        String j1="",j2="",j3="",j4="",j5="",p1="",p2="",p3="",p4="",p5="",c1="",c2="",c3="",c4="",c5="";
        String empty ="";

        Cursor fila1 = BaseDeDatos.rawQuery("select * from "+tipoBBDD+"  order by nombreEmpresa ASC",null);

        if(fila1.moveToFirst()) {
            j1 = fila1.getString(0);
            p1 = fila1.getString(1);
            textoNumero1.setVisibility(View.VISIBLE);

            if (fila1.moveToNext()) {
                j2 = fila1.getString(0);
                p2 = fila1.getString(1);
                textoNumero2.setVisibility(View.VISIBLE);
            }
            if (fila1.moveToNext()) {
                j3 = fila1.getString(0);
                p3 = fila1.getString(1);
                textoNumero3.setVisibility(View.VISIBLE);
            }
            if (fila1.moveToNext()) {
                j4 = fila1.getString(0);
                p4 = fila1.getString(1);
                textoNumero4.setVisibility(View.VISIBLE);
            }
            if (fila1.moveToNext()) {
                j5 = fila1.getString(0);
                p5 = fila1.getString(1);
                textoNumero5.setVisibility(View.VISIBLE);
            }
        }else {

            j1="";
            j2="";
            j3="";
            j4="";
            j5="";
            p1="";
            p2="";
            p3="";
            p4="";
            p5="";
        }

        textoNegocio1.setText(j1);
        textoNegocio2.setText(j2);
        textoNegocio3.setText(j3);
        textoNegocio4.setText(j4);
        textoNegocio5.setText(j5);

        textoIngreso1.setText(p1);
        textoIngreso2.setText(p2);
        textoIngreso3.setText(p3);
        textoIngreso4.setText(p4);
        textoIngreso5.setText(p5);

        BaseDeDatos.close();

    }
    public void goGraficos(View view){
        Intent intent3 = new Intent(Negocios.this,Graficos.class);
        startActivity(intent3);
    }

}
