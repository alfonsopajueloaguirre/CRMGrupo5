package com.example.crmgrupo5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrarNegocio extends AppCompatActivity {

    private SQLiteDatabase BasseDeDatos;
    private AdminSQLiteOpenHelper BBDD;
    private EditText nombreE,ingresosE,IDE;
    private boolean registrado;
    private Button registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_negocio);
        BBDD = new AdminSQLiteOpenHelper(this,"BBDD",null,1);
        registrar = findViewById(R.id.registrar);

        registrado = false;
        nombreE =  findViewById(R.id.NombreEmpresa);
        ingresosE = findViewById(R.id.Ingresos);
        IDE = findViewById(R.id.NIDFiscal);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarMetodo(view);
            }
        });

    }
    public void RegistrarMetodo(View view){
        BasseDeDatos = BBDD.getWritableDatabase();
        String nombreEmpresa = nombreE.getText().toString();
        String ingresos = ingresosE.getText().toString();
        String id = IDE.getText().toString();

        if(!id.isEmpty()& !registrado){
            ContentValues registro = new ContentValues();
            registro.put("nombreEmpresa",nombreEmpresa);
            registro.put("ingresos",ingresos);
            registro.put("IdFiscal",id);

            BasseDeDatos.insert("BBDDNegocio",null,registro);

            BasseDeDatos.close();

            nombreE.setText("");
            ingresosE.setText("");
            IDE.setText("");
            registrado = true;
        }else{
            if(id.isEmpty()){
                Toast.makeText(this,"Debes rellenar el número de identificación fiscal",Toast.LENGTH_SHORT).show();
            }
            if(registrado){
                Toast.makeText(this, "Ya te has registrado", Toast.LENGTH_SHORT).show();
            }
        }
    }
}