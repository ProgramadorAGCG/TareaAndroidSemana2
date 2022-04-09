package com.example.app_12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import  android.widget.EditText;
import  android.widget.Button;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private EditText edtUsuario,edtContraseña;
    private Button btnAceptar,btnCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsuario=(EditText)findViewById(R.id.edtUsuario);
        edtContraseña=(EditText)findViewById(R.id.edtContraseña);
        btnAceptar=(Button)findViewById(R.id.btnAceptar);
        btnCancelar=(Button)findViewById(R.id.btnCancelar);

        eventClick();
    }

    private void eventClick(){
        btnAceptar.setOnClickListener((View v)->{
            if(this.edtUsuario.getText().toString().equals("utp") &&
                    this.edtContraseña.getText().toString().equals("123")){
                Intent intent = new Intent (v.getContext(), MainActivity2.class);
                startActivity(intent);
                finish();
            }else{
                Toast.makeText(this, "Error al iniciar sesión", Toast.LENGTH_SHORT).show();
            }
        });
    }
}