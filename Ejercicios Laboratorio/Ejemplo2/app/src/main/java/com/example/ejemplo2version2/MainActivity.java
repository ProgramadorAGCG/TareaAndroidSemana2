package com.example.ejemplo2version2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btnAceptar);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        EditText edtusu,edtpwd;
        edtusu = (EditText) findViewById(R.id.edtUsuario);
        edtpwd = (EditText) findViewById(R.id.edtPassword);
        if(edtusu.getText().toString().equals("ucs") &&
                edtpwd.getText().toString().equals("123")){
            Toast.makeText(this,"¡BIENVENIDO!",Toast.LENGTH_LONG).show();
            Intent intent = new Intent (v.getContext(), MainActivity2.class);
            startActivity(intent);
            finish();
        }else{
            Toast.makeText(this,"DENEGADO",Toast.LENGTH_LONG).show();
        }
    }

}