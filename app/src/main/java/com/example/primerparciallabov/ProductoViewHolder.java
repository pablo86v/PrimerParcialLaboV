package com.example.primerparciallabov;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductoViewHolder extends RecyclerView.ViewHolder {
    public TextView tvNombreProducto;
    public TextView tvCantidad;
    public TextView tvPrecioUnidad;
    private MainActivity mainActivity;
    public ProductoModel producto;


    public ProductoViewHolder(@NonNull View itemView, MainActivity mainActivity) {
        super(itemView);

        this.mainActivity = mainActivity;

        tvNombreProducto = itemView.findViewById(R.id.tvNombreProducto);
        tvCantidad = itemView.findViewById(R.id.tvCantidad);
        tvPrecioUnidad = itemView.findViewById(R.id.tvPrecioUnidad);

        itemView.findViewById(R.id.itemCard).setOnClickListener(new ProductoListener(this, this.mainActivity));

    }
}