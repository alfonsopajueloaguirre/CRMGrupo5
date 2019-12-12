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

    private SQLiteDatabase BaseDeDatosReuniones;
    private AdminSQLiteOpenHelper BBDD;
    private TextInputEditText nombre,mes;
    private EditText dia;
    private boolean registrado;
    private Button registrarReunion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_reunion);
        BBDD = new AdminSQLiteOpenHelper(this,"BBDDReuniones",null,1);
        registrarReunion = findViewById(R.id.registrar_reunion);

        registrado = false;
        nombre = findViewById(R.id.input_reunion);
        mes = findViewById(R.id.input_mes);
        dia = findViewById(R.id.editText_dia);

        registrarReunion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarReunion(view);
            }
        });
    }

    public void RegistrarReunion(View view){
        BaseDeDatosReuniones = BBDD.getWritableDatabase();
        String nombreCliente = nombre.getText().toString();
        String mesR = mes.getText().toString();
        String diaR = dia.getText().toString();

        if(!mesR.isEmpty() & !registrado){
            ContentValues registro = new ContentValues();

            registro.put("nombreReunion",nombreCliente);
            registro.put("mes",mesR);
            registro.put("dia",diaR);

            BaseDeDatosReuniones.insert("BBDDReuniones",null,registro);

            BaseDeDatosReuniones.close();

            nombre.setText("");
            mes.setText("");
            dia.setText("");

            registrado = true;

        }else{
            if(mesR.isEmpty()){
                Toast.makeText(this,"Debes rellenar el nombre",Toast.LENGTH_SHORT).show();
            }
            if(diaR.isEmpty()){
                Toast.makeText(this,"Debes rellenar el apellido",Toast.LENGTH_SHORT).show();
            }
            if(registrado){
                Toast.makeText(this, "Ya te has registrado", Toast.LENGTH_SHORT).show();
            }
        }
        Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(RegistrarReunion.this, Reuniones.class);
        startActivity(intent1);

    }
}