package com.example.crmgrupo5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity {
    private Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        enter = findViewById(R.id.Enter);

    }
    public void Enter (View view){
        Intent enterIntent = new Intent(Inicio.this, MainActivity.class);
        startActivity(enterIntent);
    }
}
