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


            if (fila1.moveToNext()) {
                j2 = fila1.getString(0);
                p2 = fila1.getString(1);

            }
            if (fila1.moveToNext()) {
                j3 = fila1.getString(0);
                p3 = fila1.getString(1);

            }
            if (fila1.moveToNext()) {
                j4 = fila1.getString(0);
                p4 = fila1.getString(1);

            }
            if (fila1.moveToNext()) {
                j5 = fila1.getString(0);
                p5 = fila1.getString(1);

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

        if(j1==null){
            textoNumero1.setVisibility(View.GONE);
        }
        if(j2==null){
            textoNumero2.setVisibility(View.GONE);
        }
        if(j3==null){
            textoNumero3.setVisibility(View.GONE);
        }
        if(j4==null){
            textoNumero4.setVisibility(View.GONE);
        }
        if(j5==null){
            textoNumero5.setVisibility(View.GONE);
        }

        visibilidad(j1,p1,textoNegocio2,textoIngreso2);
        visibilidad(j2,p2,textoNegocio2,textoIngreso2);
        visibilidad(j3,p3,textoNegocio3,textoIngreso3);
        visibilidad(j4,p4,textoNegocio4,textoIngreso4);
        visibilidad(j5,p5,textoNegocio5,textoIngreso5);

        BaseDeDatos.close();

    }
    public void goGraficos(View view){
        Intent intent3 = new Intent(Negocios.this,Graficos.class);
        startActivity(intent3);
    }
    public void visibilidad(String i, String j, TextView txt, TextView txt2){
        if(i!=null){
            txt.setText(i);
            txt2.setText(j);
        }else{
            txt.setVisibility(View.GONE);
        }
    }

}
