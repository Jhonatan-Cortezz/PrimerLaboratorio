package com.example.labpractico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.LinearLayoutCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.labpractico.ejercicio1.Salario;
import com.example.labpractico.ejercicio2.NumeroMayor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayoutCompat btn1, btn2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Laboratorio semana 4");

        btn1 = (LinearLayoutCompat) findViewById(R.id.btn1);
        btn2 =(LinearLayoutCompat) findViewById(R.id.btn2);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn1:
                Intent intre = new Intent(this, Salario.class);
                startActivity(intre);
                break;

            case R.id.btn2:
                Intent intent = new Intent(this, NumeroMayor.class);
                startActivity(intent);
                break;
        }

    }
}