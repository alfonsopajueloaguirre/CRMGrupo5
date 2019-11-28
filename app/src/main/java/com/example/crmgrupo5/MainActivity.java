package com.example.crmgrupo5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SQLiteDatabase BaseDeDatos;
    private AdminSQLiteOpenHelper BBDD;
    private boolean registrado;
    String nombreCliente;
    private EditText ETnombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BBDD = new AdminSQLiteOpenHelper(this, "CRM-Clientes", null, 1);
        registrado = false;
        //nombre = (EditText)findViewById(R.id.nombreCliente);
    }
    public void Registrar(View view){
        //abrir la base de datos modo escritura y lectura
        BaseDeDatos = BBDD.getWritableDatabase();

        if (!nombreCliente.isEmpty() & !registrado){
            //permite almacenar las columnas del registro en pares clave-valor
            ContentValues registro = new ContentValues();
            //Añade los pares
            registro.put("nombre", nombreCliente);
            //registro.put("puntuacion",);

            BaseDeDatos.insert("CRM", null, registro);
            BaseDeDatos.close();

            ETnombre.setText("");
            registrado=true;

        }else{
            //if (ETnombre.isEmpty()) {
                Toast.makeText(this, "Debes rellenar el nombre", Toast.LENGTH_SHORT).show();
            }
            if (registrado){
                Toast.makeText(this, "Ya te has registrado", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void restablecerEstadiaticas (View view){
        BaseDeDatos = BBDD.getWritableDatabase();
        BaseDeDatos.execSQL("DELETE FROM CRM ");
        Toast.makeText(this, "Estadisticas restablecidas", Toast.LENGTH_SHORT).show();
        BaseDeDatos.close();
    }
}
