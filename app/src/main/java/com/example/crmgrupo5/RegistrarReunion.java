package com.example.crmgrupo5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarReunion extends AppCompatActivity {

    private SQLiteDatabase BasseDeDatos;
    private AdminSQLiteOpenHelper BBDD;
    private EditText nombreCR,fecha;
    private boolean registrado;
    private Button registrar,si,no;
    private int recordatorio;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_reunion);
        BBDD = new AdminSQLiteOpenHelper(this,"BBDD",null,1);
        registrar = findViewById(R.id.registrar);
        si = findViewById(R.id.si);
        no = findViewById(R.id.no);

        registrado = false;
        nombreCR =  findViewById(R.id.input_reunion);
        fecha = findViewById(R.id.editText_Dia);

        si.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordatorio = 1;
                si.setVisibility(View.GONE);
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recordatorio = 0;
                no.setVisibility(View.GONE);
            }
        });
        if(recordatorio==1){
            no.setVisibility(View.GONE);
        }
        if(recordatorio==0){
            si.setVisibility(View.GONE);
        }
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarMetodo(view);
            }
        });

    }
    public void RegistrarMetodo(View view){
        BasseDeDatos = BBDD.getWritableDatabase();
        String nombreClienteReunion = nombreCR.getText().toString();
        String diaR = fecha.getText().toString();

        if(fecha!=null & !registrado){
            ContentValues registro = new ContentValues();

            registro.put("nombreCliente",nombreClienteReunion);
            registro.put("fecha",diaR);
            registro.put("recordatorio",recordatorio);

            BasseDeDatos.insert("BBDDNegocio",null,registro);

            BasseDeDatos.close();

            nombreCR.setText("");
            fecha.setText("");
            registrado = true;
            recordatorio = -1;
        }else{
            if(fecha==null){
                Toast.makeText(this,"Debes rellenar el nombre del cliente",Toast.LENGTH_SHORT).show();
            }
            if(registrado){
                Toast.makeText(this, "Ya te has registrado", Toast.LENGTH_SHORT).show();
            }
        }
    }
}