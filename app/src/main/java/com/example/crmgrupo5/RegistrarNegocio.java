package com.example.crmgrupo5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class RegistrarNegocio extends AppCompatActivity {

    private SQLiteDatabase BasseDeDatos;
    private AdminSQLiteOpenHelper BBDD;
    private TextInputEditText nombreE;
    private EditText ingresosE;
    private boolean registrado;
    private Button registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_negocio);
        BBDD = new AdminSQLiteOpenHelper(this,"BBDD",null,1);
        registrar = findViewById(R.id.registrar);

        registrado = false;
        nombreE =  findViewById(R.id.input_empresa);
        ingresosE = findViewById(R.id.editText_ingresos);


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


        if(!nombreEmpresa.isEmpty()& !registrado){
            ContentValues registro = new ContentValues();
            registro.put("nombreEmpresa",nombreEmpresa);
            registro.put("ingresos",ingresos);


            BasseDeDatos.insert("BBDDNegocio",null,registro);

            BasseDeDatos.close();

            nombreE.setText("");
            ingresosE.setText("");

            registrado = true;
        }else{
            if(nombreEmpresa.isEmpty()){
                Toast.makeText(this,"Debes rellenar el número de identificación fiscal",Toast.LENGTH_SHORT).show();
            }
            if(registrado){
                Toast.makeText(this, "Ya te has registrado", Toast.LENGTH_SHORT).show();
            }
        }
        Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(RegistrarNegocio.this, Negocios.class);
        startActivity(intent1);
    }
}