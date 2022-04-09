package com.example.app_13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import  android.widget.TextView;
import  android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtImporte;
    private TextView tvImporte,tvImpuesto,tvTotal;
    private Button btnCalcular,btnLimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtImporte=(EditText)findViewById(R.id.edtImporte);
        tvImporte=(TextView)findViewById(R.id.tvImporte);
        tvImpuesto=(TextView)findViewById(R.id.tvImpuesto);
        tvTotal=(TextView)findViewById(R.id.tvTotal);
        btnCalcular=(Button)findViewById(R.id.btnCalcular);
        btnLimpiar=(Button)findViewById((R.id.btnLimpiar));
        btnCalcular.setOnClickListener(this);
        btnLimpiar.setOnClickListener(this);
    }

    public void onClick(View v) {
        if (v==btnCalcular){
            double impor=Double.parseDouble(edtImporte.getText().toString());
            Procesar(impor);
        }
        if (v==btnLimpiar){
            limpiar();
        }
    }

    public void Procesar(double importe){
        double impuesto,total;
        impuesto=importe * 0.18;
        total=importe +impuesto;
        //Reporte
        tvImporte.setText("Importe  : "+importe);
        tvImpuesto.setText("Impuesto : "+impuesto);
        tvTotal.setText(("El total es : ")+total);
    }

    public  void limpiar(){
        edtImporte.setText("");
        tvImporte.setText("");
        tvImpuesto.setText("");
        tvTotal.setText("");
    }

}