package com.example.ejemplo4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.switchmaterial.SwitchMaterial;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    String[] items = {"1 Pollo a la brasa", "1/2 Pollo a la brasa", "1/4 Pollo a la brasa", "Porción de Anticucho", "Pechuga de Pollo"};
    AutoCompleteTextView spnProductos;
    TextInputEditText txtCantidad, txtPrecio, txtTotal, txtDescuento, txtTotalPagar;
    SwitchMaterial swchDelivery;
    ExtendedFloatingActionButton btnCalcular;
    double precio;
    int delivery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnProductos = findViewById(R.id.spnProductos);
        ArrayAdapter adapterItems = new ArrayAdapter<String>(this, R.layout.list_item, items);
        spnProductos.setAdapter(adapterItems);
        spnProductos.setOnItemClickListener(this);

        txtCantidad = findViewById(R.id.txtCantidad);
        swchDelivery = findViewById(R.id.swchDelivery);
        txtPrecio = findViewById(R.id.txtPrecio);
        txtTotal = findViewById(R.id.txtTotal);
        txtDescuento = findViewById(R.id.txtDescuento);
        txtTotalPagar = findViewById(R.id.txtTotalPagar);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == btnCalcular) {
            int cantidad;
            double total, descuento, totalPagar;

            cantidad = Integer.parseInt(txtCantidad.getText().toString());
            total = precio * cantidad;

            // Delivery
            if (swchDelivery.isChecked())
                delivery = 10;
            else
                delivery = 0;

            // Descuento
            if (total > 60)
                descuento = 5;
            else
                descuento = 0;

            totalPagar = (total + delivery) - descuento;
            txtTotal.setText("S/ "+total);
            txtDescuento.setText("S/ "+descuento);
            txtTotalPagar.setText("S/ "+totalPagar);
        }
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        if (i == 0)
            precio = 65.50;
        else if (i == 1)
            precio = 34.50;
        else if (i == 2)
            precio = 18.50;
        else if (i == 3)
            precio = 17.50;
        else if (i == 4)
            precio = 21.50;
        else
            precio = 0;

        txtPrecio.setText("S/ " + precio);
    }
}