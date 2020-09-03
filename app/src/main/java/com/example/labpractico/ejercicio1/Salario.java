package com.example.labpractico.ejercicio1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.labpractico.R;

public class Salario extends AppCompatActivity implements View.OnClickListener {
    EditText edtNombre, edtSalarioMensual, edtQtyMinutos;
    CheckBox chkTarde;
    Button btnCalcular, btnNuevo;
    TextView txtNombre, txtDecuento, txtRenta, txtSueldo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salario);
        setTitle("Calculo de salario");

        edtNombre = findViewById(R.id.edtNombre);
        edtSalarioMensual = findViewById(R.id.edtSueldo);
        edtQtyMinutos = findViewById(R.id.edtQytMinutos);
        chkTarde = findViewById(R.id.rdTarde);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnNuevo = findViewById(R.id.btnNuevo);
        txtNombre = findViewById(R.id.txtNombre);
        txtDecuento = findViewById(R.id.txtDescuento);
        txtRenta = findViewById(R.id.txtRenta);
        txtSueldo = findViewById(R.id.txtSalario);

        chkTarde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (chkTarde.isChecked() == true){
                    edtQtyMinutos.setVisibility(view.VISIBLE);
                } else if (chkTarde.isChecked() == false){
                    edtQtyMinutos.setVisibility(view.GONE);
                }
            }
        });



        btnCalcular.setOnClickListener(this);
        btnNuevo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        CalcularSalario cal = new CalcularSalario();
        String n = edtNombre.getText().toString();
        String s = edtSalarioMensual.getText().toString();
        String m = edtQtyMinutos.getText().toString();

        switch (view.getId()){
            case R.id.btnCalcular:

                if (n.length() != 0 && s.length() != 0 && m.length() != 0){
                    cal.setNomre(n);
                    cal.setSueldo(Double.parseDouble(s));
                    cal.setQtyMinutos(Integer.parseInt(m));

                    String descuento = String.format("%.2f", cal.decuentoPorLlegarTarde());
                    String retencion = String.format("%.2f", cal.calcularRetencion());
                    String salario = String.format("%.2f", cal.salarioFinal());

                    txtNombre.setText("Nombre delTrabajador: " + cal.getNomre());
                    txtDecuento.setText("Descuento por llegadas tarde: " + descuento);
                    txtRenta.setText("Renta 10%: " + retencion);
                    txtSueldo.setText("Sueldo Final: " + salario);
                }else if (n.length() == 0){
                    edtNombre.setError("Complete este campo");
                } else if (s.length() == 0){
                    edtSalarioMensual.setError("Complete este campo");
                } else if (m.length() == 0 && chkTarde.isChecked() == true){
                    edtQtyMinutos.setError("Complete este campo");
                } else if (n.length() != 0 && s.length() != 0 && m.length() == 0){
                    cal.setNomre(n);
                    cal.setSueldo(Double.parseDouble(s));
                    cal.setQtyMinutos(0);

                    String descuento = String.format("%.2f", cal.decuentoPorLlegarTarde());
                    String retencion = String.format("%.2f", cal.calcularRetencion());
                    String salario = String.format("%.2f", cal.salarioFinal());

                    txtNombre.setText("Nombre del Trabajador: " + cal.getNomre());
                    txtDecuento.setText("Descuento por llegadas tarde: " + descuento);
                    txtRenta.setText("Renta 10%: " + retencion);
                    txtSueldo.setText("Sueldo Final: " + salario);


                }
                break;

            case R.id.btnNuevo:
                edtNombre.setText("");
                edtQtyMinutos.setText("");
                edtSalarioMensual.setText("");
                txtSueldo.setText("");
                txtRenta.setText("");
                txtDecuento.setText("");
                txtNombre.setText("");
                break;
        }
    }
}