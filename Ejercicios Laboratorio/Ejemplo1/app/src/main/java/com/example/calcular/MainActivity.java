package com.example.calcular;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText numero1, numero2;
    private TextView resultado;
    private Button btnsuma, btnresta, btnmulti, btndivision, btnlimpiar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numero1 = (EditText) findViewById(R.id.numero1);
        numero2 = (EditText) findViewById(R.id.numero2);
        resultado = (TextView) findViewById(R.id.resultado);
        btnsuma = (Button) findViewById(R.id.btnSuma);
        btnresta = (Button) findViewById(R.id.btnResta);
        btnmulti = (Button) findViewById(R.id.btnMulti);
        btndivision = (Button) findViewById(R.id.btnDivision);
        btnlimpiar=(Button) findViewById(R.id.btnlimpiar);

        eventosClick();
        limpiar();
    }

    private void eventosClick(){
        btnsuma.setOnClickListener((View v)->{
            Double respuesta;
            Double valor1 = Double.parseDouble(this.numero1.getText().toString());
            Double valor2 = Double.parseDouble(this.numero2.getText().toString());
            respuesta = (valor1 + valor2);
            this.resultado.setText(respuesta.toString());
        });

        btnresta.setOnClickListener((View v)->{
            Double respuesta;
            Double valor1 = Double.parseDouble(this.numero1.getText().toString());
            Double valor2 = Double.parseDouble(this.numero2.getText().toString());
            respuesta = (valor1 - valor2);
            this.resultado.setText(respuesta.toString());
        });

        btnmulti.setOnClickListener((View v)->{
            Double respuesta;
            Double valor1 = Double.parseDouble(this.numero1.getText().toString());
            Double valor2 = Double.parseDouble(this.numero2.getText().toString());
            respuesta = (valor1 * valor2);
            this.resultado.setText(respuesta.toString());
        });

        btndivision.setOnClickListener((View v)->{
            Double respuesta;
            Double valor1 = Double.parseDouble(this.numero1.getText().toString());
            Double valor2 = Double.parseDouble(this.numero2.getText().toString());
            if(valor2 == 0){
                Toast.makeText(this,"El denominador es 0, la división no puede ejecutarse", Toast.LENGTH_SHORT).show();
            }else{
                respuesta = (valor1 / valor2);
                this.resultado.setText(respuesta.toString());
            }
        });
    }

    private void limpiar(){
        btnlimpiar.setOnClickListener((View v)->{
            numero1.setText("");
            numero2.setText("");
            resultado.setText("");
        });
    }

}