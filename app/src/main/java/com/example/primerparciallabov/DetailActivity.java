package com.example.primerparciallabov;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    ProductoModel producto = new ProductoModel();
    EditText evNombre ;
    EditText evCantidad;
    EditText evPrecio;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        //back btn
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        Bundle b = i.getExtras();

        /*
        producto.setCantidad(b.getInt("cantidad"));
        producto.setPrecioUnidad(b.getInt("precioUnidad"));
        producto.setNombreProducto(b.getString("nombreProducto"));
        */


        evNombre = (EditText)super.findViewById(R.id.evNombre);
        evNombre.setText(producto.getNombreProducto());

        evCantidad = (EditText)super.findViewById(R.id.evCantidad);
        evCantidad.setText(String.valueOf(producto.getCantidad()));

        evPrecio = (EditText)super.findViewById(R.id.evPrecio);
        evPrecio.setText(String.valueOf(producto.getPrecioUnidad()));

        Button btnEditar = (Button)super.findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              /*  producto.setNombreProducto(evNombre.getText());
                producto.setCantidad(Integer.valueOf(evCantidad.getText());
                producto.setNombreProducto(Integer.valueOf(evPrecio.getText());
                
               */
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if(menuItem.getItemId() == android.R.id.home){
            Intent mainActivity = new Intent(this, MainActivity.class);
            mainActivity.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(mainActivity);
        }
        return (super.onOptionsItemSelected(menuItem));
    }

}
