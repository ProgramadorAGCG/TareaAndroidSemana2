package com.example.app_11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Toast;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton = (Button) findViewById( R.id.btn1 );
        boton.setOnClickListener(this);
    }

    public void onClick(View v) {
        Toast toast = Toast.makeText(this, "Primer Ejemplo Objeto Toast", Toast.LENGTH_SHORT);
        toast.show();
    }

}