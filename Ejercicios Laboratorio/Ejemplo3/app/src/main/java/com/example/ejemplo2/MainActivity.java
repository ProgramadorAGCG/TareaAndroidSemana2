package com.example.ejemplo2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mostrarMensajeBienvenida();
    }

    private void mostrarMensajeBienvenida(){
        LayoutInflater imagenDialogo = LayoutInflater.from(MainActivity.this);
        final View vistaImagen = imagenDialogo.inflate(R.layout.imagenbienvenida, null);
        AlertDialog.Builder mensajeBienvenida = new AlertDialog.Builder(this);
        mensajeBienvenida.setTitle("Importante");
        mensajeBienvenida.setMessage("¿Acepta la ejecución de este programa en modo prueba?");
        mensajeBienvenida.setCancelable(false);

        mensajeBienvenida.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                clickAceptar();
            }
        });

        mensajeBienvenida.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                clickCancelar();
            }
        });

        mensajeBienvenida.setView(vistaImagen);
        mensajeBienvenida.show();
    }

    private void clickAceptar(){
        Toast.makeText(this,"Bienvenido a probar el programa.", Toast.LENGTH_SHORT).show();
    }

    private void clickCancelar(){
        finish();
    }
}