package com.example.crmgrupo5;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class Graficos extends AppCompatActivity {

    private ImageView grafico1,grafico2,grafico3;
    private TextView textGanancias, textCostes;
    private Spinner spinner;
    double random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficos);

        spinner = findViewById(R.id.spinner_operaciones);
        textGanancias = findViewById(R.id.numGanancias);
        textCostes = findViewById(R.id.numCostes);

        String[] opciones = {"Televisión", "Radio", "Redes Sociales", "Anuncios web"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opciones);

        spinner.setAdapter(adapter);

        grafico1 = findViewById(R.id.grafico1);
        grafico2 = findViewById(R.id.grafico2);
        grafico3 = findViewById(R.id.grafico3);

        grafico1.setVisibility(View.GONE);
        grafico2.setVisibility(View.GONE);
        grafico3.setVisibility(View.GONE);
        random = Math.floor(Math.random()*4+1);
        if(random ==1){
            grafico1.setVisibility(View.VISIBLE);
        }
        if(random == 2){
            grafico1.setVisibility(View.VISIBLE);
        }
        if(random == 3){
            grafico3.setVisibility(View.VISIBLE);
        }
    }

    public void calcularPresupuesto(View view){
        String seleccion = spinner.getSelectedItem().toString();
        if (seleccion.equals("Televisión")) {
            textCostes.setText("10.000 €");
            textGanancias.setText("20.000 €");
            textGanancias.setVisibility(View.VISIBLE);
            textCostes.setVisibility(View.VISIBLE);
            // codigo set cuadrado a rojo ID (integer) IDColor (integer)
        }
        if (seleccion.equals("Radio")) {
            textCostes.setText("2.000 €");
            textGanancias.setText("4.000 €");
            textGanancias.setVisibility(View.VISIBLE);
            textCostes.setVisibility(View.VISIBLE);
            // codigo set cuadrado a rojo ID (integer) IDColor (integer)
        }
        if (seleccion.equals("Redes Sociales")) {
            textCostes.setText("1.000 €");
            textGanancias.setText("2.000 €");
            textGanancias.setVisibility(View.VISIBLE);
            textCostes.setVisibility(View.VISIBLE);
            // codigo set cuadrado a rojo ID (integer) IDColor (integer)
        }
        if (seleccion.equals("Anuncios web")) {
            textCostes.setText("5.000 €");
            textGanancias.setText("10.000 €");
            textGanancias.setVisibility(View.VISIBLE);
            textCostes.setVisibility(View.VISIBLE);
            // codigo set cuadrado a rojo ID (integer) IDColor (integer)
        }
    }

}