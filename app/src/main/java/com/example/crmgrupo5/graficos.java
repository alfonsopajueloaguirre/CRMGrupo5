package com.example.crmgrupo5;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class graficos extends AppCompatActivity {

    private ImageView grafico1,grafico2,grafico3;
    double random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graficos);
        grafico1 = findViewById(R.id.grafico1);
        grafico2 = findViewById(R.id.grafico2);
        grafico3 = findViewById(R.id.grafico1);

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
}