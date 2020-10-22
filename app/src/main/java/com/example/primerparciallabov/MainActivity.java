package com.example.primerparciallabov;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1) {
            if(resultCode == DetailActivity.RESULT_OK){
                ProductoModel p ;
                Bundle b = data.getExtras();
                p  = (ProductoModel) b.getSerializable("ProductoModel");
                updateList(b.getInt("position"),p);
            }
        }
    }//onActivityResult

   public void updateList(int position, ProductoModel producto){
       this.productos.set(position, producto);
       this.productoAdapter.notifyDataSetChanged();
   }

    private void loadTestList(List<ProductoModel> productos){
        productos.add(new ProductoModel(17, 530, getString(R.string.p1)));
        productos.add(new ProductoModel(17, 530, getString(R.string.p2)));
        productos.add(new ProductoModel(17, 530, getString(R.string.p3)));
        productos.add(new ProductoModel(17, 530, getString(R.string.p4)));
        productos.add(new ProductoModel(17, 530, getString(R.string.p5)));
        productos.add(new ProductoModel(17, 530, getString(R.string.p6)));
        productos.add(new ProductoModel(17, 530, getString(R.string.p7)));
        productos.add(new ProductoModel(17, 530, getString(R.string.p8)));
        productos.add(new ProductoModel(17, 530, getString(R.string.p9)));
        productos.add(new ProductoModel(17, 530, getString(R.string.p10)));
        productos.add(new ProductoModel(17, 530, getString(R.string.p11)));
        productos.add(new ProductoModel(17, 530, getString(R.string.p12)));
    }
}