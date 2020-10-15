package com.example.primerparciallabov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private ProductoAdapter productoAdapter;
    public List<ProductoModel> productos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Lista de productos
        this.productos = new ArrayList<ProductoModel>();
        loadTestList(this.productos);

        // Obtengo el Recycler y le configuro un layoutmanager (hay varios tipos)
        RecyclerView rv = (RecyclerView)findViewById(R.id.recycler);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        rv.setLayoutManager(lm);

        // Vinculo mi adapater con mi RecyclerView
        productoAdapter = new ProductoAdapter(this.productos, this);
        rv.setAdapter(productoAdapter);
    }

    private void loadTestList(List<ProductoModel> productos){
        if(Locale.getDefault().toString().equals("es_ES")) {
            productos.add(new ProductoModel(17, 530, "Arroz"));
            productos.add(new ProductoModel(16, 554, "Fideos"));
            productos.add(new ProductoModel(51, 455, "Manteca"));
            productos.add(new ProductoModel(15, 545, "Aceite"));
            productos.add(new ProductoModel(31, 545, "Gaseosa"));
        }else {
            productos.add(new ProductoModel(17, 530, "Rice"));
            productos.add(new ProductoModel(16, 554, "Noodles"));
            productos.add(new ProductoModel(51, 455, "Butter"));
            productos.add(new ProductoModel(15, 545, "Oil"));
            productos.add(new ProductoModel(31, 545, "Soda"));
        }
    }
}