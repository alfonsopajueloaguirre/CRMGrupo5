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

public class Reuniones extends AppCompatActivity {

    private SQLiteDatabase BaseDeDatos;
    private AdminSQLiteOpenHelper BBDD;
    private String tipoBBDD = "BBDDReuniones";
    private TextView textoReunion1,textoReunion2,textoReunion3,textoReunion4,textoReunion5;
    private TextView textoMes1,textoMes2,textoMes3,textoMes4,textoMes5;
    private TextView textoDia1,textoDia2,textoDia3,textoDia4,textoDia5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        BBDD = new AdminSQLiteOpenHelper(this, "BBDDReuniones", null, 1);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reuniones);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textoReunion1 = findViewById(R.id.textView_cliente1);
        textoReunion2 = findViewById(R.id.textView_cliente2);
        textoReunion3 = findViewById(R.id.textView_cliente3);
        textoReunion4 = findViewById(R.id.textView_cliente4);
        textoReunion5 = findViewById(R.id.textView_cliente5);

        textoMes1 = findViewById(R.id.textView_mes1);
        textoMes2 = findViewById(R.id.textView_mes2);
        textoMes3 = findViewById(R.id.textView_mes3);
        textoMes4 = findViewById(R.id.textView_mes4);
        textoMes5 = findViewById(R.id.textView_mes5);

        textoDia1 = findViewById(R.id.textView_dia1);
        textoDia2 = findViewById(R.id.textView_dia2);
        textoDia3 = findViewById(R.id.textView_dia3);
        textoDia4 = findViewById(R.id.textView_dia4);
        textoDia5 = findViewById(R.id.textView_dia5);

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
        String columnas[] = new String[]{"nombreReunion","mes","dia"};
        String j1="",j2="",j3="",j4="",j5="",p1="",p2="",p3="",p4="",p5="",c1="",c2="",c3="",c4="",c5="";
        String empty = "";

        Cursor fila1 = BaseDeDatos.rawQuery("select * from "+tipoBBDD+"  order by nombreReunion ASC",null);

        if(fila1.moveToFirst()) {
            j1 = fila1.getString(0);
            p1 = fila1.getString(1);
            c1 = fila1.getString(2);

            if (fila1.moveToNext()) {
                j2 = fila1.getString(0);
                p2 = fila1.getString(1);
                c2 = fila1.getString(2);
            }
            if (fila1.moveToNext()) {
                j3 = fila1.getString(0);
                p3 = fila1.getString(1);
                c3 = fila1.getString(2);
            }
            if (fila1.moveToNext()) {
                j4 = fila1.getString(0);
                p4 = fila1.getString(1);
                c4 = fila1.getString(2);
            }
            if (fila1.moveToNext()) {
                j5 = fila1.getString(0);
                p5 = fila1.getString(1);
                c5 = fila1.getString(2);
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

        textoReunion1.setText(j1);
        textoReunion2.setText(j2);
        textoReunion3.setText(j3);
        textoReunion4.setText(j4);
        textoReunion5.setText(j5);

        textoMes1.setText(p1);
        textoMes2.setText(p2);
        textoMes3.setText(p3);
        textoMes4.setText(p4);
        textoMes5.setText(p5);

        textoDia1.setText(c1);
        textoDia2.setText(c2);
        textoDia3.setText(c3);
        textoDia4.setText(c4);
        textoDia5.setText(c5);

        BaseDeDatos.close();

    }

    public void restablecerReuniones(View view){
        BaseDeDatos = BBDD.getWritableDatabase();

        BaseDeDatos.execSQL("DELETE FROM "+tipoBBDD);
        Toast.makeText(this, "Reuniones restablecidas", Toast.LENGTH_SHORT).show();
        BaseDeDatos.close();

        textoReunion1.setVisibility(View.INVISIBLE);
        textoDia1.setVisibility(View.INVISIBLE);
        textoMes1.setVisibility(View.INVISIBLE);

        textoReunion2.setVisibility(View.INVISIBLE);
        textoDia2.setVisibility(View.INVISIBLE);
        textoMes2.setVisibility(View.INVISIBLE);

        textoReunion3.setVisibility(View.INVISIBLE);
        textoDia3.setVisibility(View.INVISIBLE);
        textoMes3.setVisibility(View.INVISIBLE);

        textoReunion3.setVisibility(View.INVISIBLE);
        textoDia3.setVisibility(View.INVISIBLE);
        textoMes3.setVisibility(View.INVISIBLE);

        textoReunion3.setVisibility(View.INVISIBLE);
        textoDia3.setVisibility(View.INVISIBLE);
        textoMes3.setVisibility(View.INVISIBLE);

        mostrarReuniones();
    }

}
