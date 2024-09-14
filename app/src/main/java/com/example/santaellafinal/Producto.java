package com.example.santaellafinal;

public class Producto {


    private int imagen;
    private String titulo;
    private String descripcion;
    private double precio;
    private int cantidad;

    public Producto(int imagen, String titulo, String descripcion, double precio) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.cantidad = 0;
    }

    // Getters para los atributos
    public int getImagen() { return imagen; }
    public String getTitulo() { return titulo; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio() { return precio; }
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
