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
import android.widget.Toast;

public class Negocios extends AppCompatActivity {

    private SQLiteDatabase BaseDeDatos;
    private AdminSQLiteOpenHelper BBDD;
    private String tipoBBDD = "BBDDNegocio";
    private TextView textoNegocio1,textoNegocio2,textoNegocio3,textoNegocio4,textoNegocio5;
    private TextView textoIngreso1,textoIngreso2,textoIngreso3,textoIngreso4,textoIngreso5;
    private TextView textoNumero1,textoNumero2,textoNumero3,textoNumero4,textoNumero5;
    private Button buttonMark1,buttonMark2,buttonMark3,buttonMark4,buttonMark5;

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

        buttonMark1 = findViewById(R.id.button_grafico1);
        buttonMark2 = findViewById(R.id.button_grafico2);
        buttonMark3 = findViewById(R.id.button_grafico3);
        buttonMark4 = findViewById(R.id.button_grafico4);
        buttonMark5 = findViewById(R.id.button_grafico5);

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
        String j1="",j2="",j3="",j4="",j5="",p1="",p2="",p3="",p4="",p5="";
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

            j1=empty;
            j2=empty;
            j3=empty;
            j4=empty;
            j5=empty;
            p1=empty;
            p2=empty;
            p3=empty;
            p4=empty;
            p5=empty;
        }

        if(j1==empty){
            textoNumero1.setVisibility(View.GONE);
            buttonMark1.setVisibility(View.GONE);
        }
        if(j2==empty){
            textoNumero2.setVisibility(View.GONE);
            buttonMark2.setVisibility(View.GONE);
        }
        if(j3==empty){
            textoNumero3.setVisibility(View.GONE);
            buttonMark3.setVisibility(View.GONE);
        }
        if(j4==empty){
            textoNumero4.setVisibility(View.GONE);
            buttonMark4.setVisibility(View.GONE);
        }
        if(j5==empty){
            textoNumero5.setVisibility(View.GONE);
            buttonMark5.setVisibility(View.GONE);
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

    public void restablecerNegocios(View view){
        BaseDeDatos = BBDD.getWritableDatabase();

        BaseDeDatos.execSQL("DELETE FROM "+tipoBBDD);
        Toast.makeText(this, "Negocios restablecidos", Toast.LENGTH_SHORT).show();
        BaseDeDatos.close();

        textoNegocio1.setVisibility(View.INVISIBLE);
        textoIngreso1.setVisibility(View.INVISIBLE);
        textoNumero1.setVisibility(View.INVISIBLE);
        buttonMark1.setVisibility(View.INVISIBLE);

        textoNegocio2.setVisibility(View.INVISIBLE);
        textoIngreso2.setVisibility(View.INVISIBLE);
        textoNumero2.setVisibility(View.INVISIBLE);
        buttonMark2.setVisibility(View.INVISIBLE);

        textoNegocio3.setVisibility(View.INVISIBLE);
        textoIngreso3.setVisibility(View.INVISIBLE);
        textoNumero3.setVisibility(View.INVISIBLE);
        buttonMark3.setVisibility(View.INVISIBLE);

        textoNegocio4.setVisibility(View.INVISIBLE);
        textoIngreso4.setVisibility(View.INVISIBLE);
        textoNumero4.setVisibility(View.INVISIBLE);
        buttonMark4.setVisibility(View.INVISIBLE);

        textoNegocio5.setVisibility(View.INVISIBLE);
        textoIngreso5.setVisibility(View.INVISIBLE);
        textoNumero5.setVisibility(View.INVISIBLE);
        buttonMark5.setVisibility(View.INVISIBLE);

        mostrarNegocios();
    }

}
