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

public class RegistrarReunion extends AppCompatActivity {

    private SQLiteDatabase BasseDeDatos;
    private AdminSQLiteOpenHelper BBDD;
    private TextInputEditText nombreCR,mes;
    private EditText dia;
    private boolean registrado;
    private Button registrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_reunion);
        BBDD = new AdminSQLiteOpenHelper(this,"BBDDReuniones",null,1);
        registrar = findViewById(R.id.registrar);

        registrado = false;
        nombreCR =  findViewById(R.id.input_reunion);
        mes = findViewById(R.id.input_mes);
        dia = findViewById(R.id.editText_Dia);


    }
    public void RegistrarMetodo(View view){
        BasseDeDatos = BBDD.getWritableDatabase();
        String nombreClienteReunion = nombreCR.getText().toString();
        String mesR = mes.getText().toString();
        String diaR = dia.getText().toString();

        if(nombreClienteReunion!=null & !registrado){
            ContentValues registro = new ContentValues();

            registro.put("nombreCliente",nombreClienteReunion);
            registro.put("mes",mesR);
            registro.put("dia",diaR);

            BasseDeDatos.insert("BBDDReuniones",null,registro);

            BasseDeDatos.close();

            nombreCR.setText("");
            mes.setText("");
            dia.setText("");

            registrado = true;
            Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();
            Intent intent1 = new Intent(RegistrarReunion.this, Reuniones.class);
            startActivity(intent1);
        }else{
            if(nombreClienteReunion.isEmpty()){
                Toast.makeText(this,"Debes rellenar el nombre del cliente",Toast.LENGTH_SHORT).show();
            }
            if(registrado){
                Toast.makeText(this, "Ya te has registrado", Toast.LENGTH_SHORT).show();
            }
        }
    }
}