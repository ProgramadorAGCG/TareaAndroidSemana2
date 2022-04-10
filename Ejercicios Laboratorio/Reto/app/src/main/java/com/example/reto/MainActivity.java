package com.example.reto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText importe;
    private Button calcular, limpiar;
    private TextView txtImporte, txtImpuesto, txtTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtImporte = (TextView) findViewById(R.id.ImporteView);
        txtImpuesto = (TextView) findViewById(R.id.ImpuestoView);
        txtTotal = (TextView) findViewById(R.id.TotalView);
        calcular = (Button) findViewById(R.id.Calcular);
        limpiar = (Button) findViewById(R.id.Limpiar);
        importe = (EditText) findViewById(R.id.Importe);

        btnCalcular();
        limpiar();
    }

    private void btnCalcular(){
        calcular.setOnClickListener((View v)->{
            Double valor = Double.parseDouble(importe.getText().toString());
            Double impuesto = valor * 0.18;
            Double total = valor + impuesto;
            txtImporte.setText(txtImporte.getText().toString() + valor);
            txtImpuesto.setText(txtImpuesto.getText().toString() + impuesto);
            txtTotal.setText(txtTotal.getText().toString() + total);
        });
    }

    private void limpiar(){
        limpiar.setOnClickListener((View v)->{
            txtImporte.setText("");
            txtImpuesto.setText("");
            txtTotal.setText("");
            importe.setText("");
        });
    }


}