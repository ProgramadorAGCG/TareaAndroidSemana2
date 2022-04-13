package com.example.glovokvb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtPrecio, edtTasaAnual, edtTiempo;
    TextView tvTasaMensual, tvCuota;
    CheckBox chkDecimal;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPrecio=(EditText) findViewById(R.id.edtPrecio);
        edtTasaAnual=(EditText) findViewById(R.id.edtTasa);
        edtTiempo=(EditText) findViewById(R.id.edtTiempo);
        tvTasaMensual=(TextView) findViewById(R.id.tvTasaMensual);
        tvCuota=(TextView) findViewById(R.id.tvCuota);
        chkDecimal=(CheckBox) findViewById(R.id.chkDecimal);
        btnCalcular=(Button) findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==btnCalcular){
            NumberFormat nf=NumberFormat.getNumberInstance();
            double ta,tm,cuota,precio;
            int tiempo;
            ta=Double.parseDouble(edtTasaAnual.getText().toString());
            precio=Double.parseDouble(edtPrecio.getText().toString());
            tiempo=Integer.parseInt(edtTiempo.getText().toString());
            tm=Math.pow(1+(ta/100),1.0/12)-1;

            cuota=precio*((tm*Math.pow(1+tm,tiempo))/(Math.pow(1+tm,tiempo)-
                    1));
            nf.setMaximumFractionDigits(2);
            tvTasaMensual.setText("Tasa Mensual : "+nf.format(tm*100));
            if(chkDecimal.isChecked())
                tvCuota.setText("Cuota Mensual : S/. "+nf.format(cuota));
            else
                tvCuota.setText("Cuota Mensual : S/. "+Math.round(cuota));
        }
    }
}
//String.format("%.5g%n", 0.912385);
