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

public class RegistrarCliente extends AppCompatActivity {

    private SQLiteDatabase BasseDeDatos;
    private AdminSQLiteOpenHelper BBDD;
    private TextInputEditText nombreC,apellidoC,correoC;
    private boolean registrado;
    private Button registrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_cliente);
        BBDD = new AdminSQLiteOpenHelper(this,"BBDDCliente",null,1);
        registrar = findViewById(R.id.Registrar);

        registrado = false;
        nombreC =  findViewById(R.id.input_nombre);
        apellidoC = findViewById(R.id.input_apellido);
        correoC = findViewById(R.id.input_correo);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegistrarMetodo(view);
            }
        });

    }
    public void RegistrarMetodo(View view){
        BasseDeDatos = BBDD.getWritableDatabase();
        String nombre = nombreC.getText().toString();
        String apellido = apellidoC.getText().toString();
        String correo = correoC.getText().toString();

        if(!nombre.isEmpty()&!apellido.isEmpty()&!registrado){
            ContentValues registro = new ContentValues();
            registro.put("nombreCliente",nombre);
            registro.put("apellido",apellido);
            registro.put("correo",correo);

            BasseDeDatos.insert("BBDDCliente",null,registro);

            BasseDeDatos.close();

            nombreC.setText("");
            apellidoC.setText("");
            correoC.setText("");
            registrado = true;
        }else{
            if(nombre.isEmpty()){
                Toast.makeText(this,"Debes rellenar el nombre",Toast.LENGTH_SHORT).show();
            }
            if(apellido.isEmpty()){
                Toast.makeText(this,"Debes rellenar el apellido",Toast.LENGTH_SHORT).show();
            }
            if(registrado){
                Toast.makeText(this, "Ya te has registrado", Toast.LENGTH_SHORT).show();
            }
        }
        Toast.makeText(this, "Registrado", Toast.LENGTH_SHORT).show();
        Intent intent1 = new Intent(RegistrarCliente.this, Clientes.class);
        startActivity(intent1);
    }
}
