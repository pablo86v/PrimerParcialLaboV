package com.example.primerparciallabov;

import android.content.Intent;
import android.os.ProxyFileDescriptorCallback;
import android.util.Log;
import android.view.View;

import java.io.Serializable;

public class ProductoListener implements View.OnClickListener {

    private MainActivity mainActivity;
    private ProductoViewHolder productoViewHolder;

    public ProductoListener(ProductoViewHolder productoViewHolder, MainActivity mainActivity){
        this.mainActivity = mainActivity;
        this.productoViewHolder = productoViewHolder;
    }

    public ProductoListener() {
    }

    @Override
    public void onClick(View view) {
            ProductoModel p = this.productoViewHolder.producto;
            Intent i = new Intent(this.mainActivity, DetailActivity.class);
            i.putExtra("position", this.productoViewHolder.position);
            i.putExtra("ProductoModel", p);

            mainActivity.startActivityForResult(i,1);
    }
}

