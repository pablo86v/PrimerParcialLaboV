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

    EditText evNombre ;
    EditText evCantidad;
    EditText evPrecio;
    Bundle b;
    ProductoModel p;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        //back btn
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        b = i.getExtras();
        p  = (ProductoModel) b.getSerializable("ProductoModel");

        evNombre = (EditText)super.findViewById(R.id.evNombre);
        evCantidad = (EditText)super.findViewById(R.id.evCantidad);
        evPrecio = (EditText)super.findViewById(R.id.evPrecio);

        evNombre.setText(p.getNombreProducto());
        evCantidad.setText(String.valueOf(p.getCantidad()));
        evPrecio.setText(String.valueOf(p.getPrecioUnidad()));

        Button btnEditar = (Button)super.findViewById(R.id.btnEditar);
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.setNombreProducto(evNombre.getText().toString());
                p.setCantidad(Integer.valueOf(evCantidad.getText().toString()));
                p.setPrecioUnidad(Integer.valueOf(evPrecio.getText().toString()));

                Intent returnIntent = new Intent();
                returnIntent.putExtra("position",b.getInt("position"));
                returnIntent.putExtra("ProductoModel", p);

                setResult(DetailActivity.RESULT_OK,returnIntent);
                finish();
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
