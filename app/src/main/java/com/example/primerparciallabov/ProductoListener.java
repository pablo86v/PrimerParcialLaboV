package com.example.primerparciallabov;

import android.content.Intent;
import android.os.ProxyFileDescriptorCallback;
import android.util.Log;
import android.view.View;

public class ProductoListener implements View.OnClickListener {

    private MainActivity mainActivity;
    private ProductoViewHolder productoViewHolder;

    public ProductoListener(ProductoViewHolder productoViewHolder, MainActivity mainActivity){
        this.mainActivity = mainActivity;
        this.productoViewHolder = productoViewHolder;
    }

    @Override
    public void onClick(View view) {

        ProductoModel p = this.productoViewHolder.producto;

        Intent i = new Intent(this.mainActivity, DetailActivity.class);
        i.putExtra("position", this.productoViewHolder.position);
        i.putExtra("cantidad", p.getCantidad());
        i.putExtra("precioUnidad", p.getPrecioUnidad());
        i.putExtra("nombreProducto", p.getNombreProducto());


        this.mainActivity.startActivity(i);
    }
}

