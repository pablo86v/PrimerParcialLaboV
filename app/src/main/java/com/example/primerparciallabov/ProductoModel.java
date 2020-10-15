package com.example.primerparciallabov;

import java.util.Objects;

public class ProductoModel {
    private int cantidad;
    private int precioUnidad;
    private String nombreProducto;


    public ProductoModel() {
    }

    public ProductoModel(int cantidad, int precioUnidad, String nombreProducto) {
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(int precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductoModel that = (ProductoModel) o;
        return cantidad == that.cantidad &&
                precioUnidad == that.precioUnidad &&
                Objects.equals(nombreProducto, that.nombreProducto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantidad, precioUnidad, nombreProducto);
    }

    @Override
    public String toString() {
        return "ProductoModel{" +
                "cantidad=" + cantidad +
                ", precioUnidad=" + precioUnidad +
                ", nombreProducto='" + nombreProducto + '\'' +
                '}';
    }
}
