package com.example.labpractico.ejercicio2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.labpractico.R;

public class NumeroMayor extends AppCompatActivity implements View.OnClickListener {
    EditText edt1, edt2, edt3;
    Button btnOperar, btnNuevo;
    TextView rst1, rst2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numero_mayor);
        setTitle("Mayor de tres numeros");

        edt1 = findViewById(R.id.edtNum1);
        edt2 = findViewById(R.id.edtNum2);
        edt3 = findViewById(R.id.edtNum3);
        btnOperar = findViewById(R.id.btnOperar);
        btnNuevo = findViewById(R.id.btnNuevo);
        rst1 = findViewById(R.id.rstMayor);
        rst2 = findViewById(R.id.rstMedia);

        btnOperar.setOnClickListener(this);
        btnNuevo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Operaciones ops = new Operaciones();


        switch (view.getId()){
            case R.id.btnOperar:
                if (edt1.getText().toString().length() == 0){
                    edt1.setError("Llene este campo");
                } else if (edt2.getText().toString().length() == 0){
                    edt2.setError("Llene este campo");
                } else if (edt3.getText().toString().length() == 0){
                    edt3.setError("Llene este campo");
                } else {
                    double a = Double.parseDouble(edt1.getText().toString());
                    double b = Double.parseDouble(edt2.getText().toString());
                    double c = Double.parseDouble(edt3.getText().toString());

                    ops.setNum1(a);
                    ops.setNum2(b);
                    ops.setNum3(c);

                    rst1.setText(ops.numeroMayor(a, b, c));;
                    rst2.setText(String.format("%.2f", ops.media(a, b, c)));
                }
                break;

            case R.id.btnNuevo:
                rst1.setText("");
                rst2.setText("");
                edt1.setText("");
                edt2.setText("");
                edt3.setText("");

            default:
                break;
        }
    }
}