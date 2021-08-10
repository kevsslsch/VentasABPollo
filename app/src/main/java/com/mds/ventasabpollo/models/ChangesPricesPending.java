package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class ChangesPricesPending {
    private int cambio;
    private String nombre_cliente;
    private String nombre_articulo;
    private double cantidad;
    private double precio_original;
    private double precio_pactado;
    private String fecha;
    private String observaciones;

    public ChangesPricesPending() {
    }

    public ChangesPricesPending(int cambio, String nombre_cliente, String nombre_articulo, double cantidad, double precio_original, double precio_pactado, String fecha, String observaciones) {
        this.cambio = cambio;
        this.nombre_cliente = nombre_cliente;
        this.nombre_articulo = nombre_articulo;
        this.cantidad = cantidad;
        this.precio_original = precio_original;
        this.precio_pactado = precio_pactado;
        this.fecha = fecha;
        this.observaciones = observaciones;
    }

    public int getCambio() {
        return cambio;
    }

    public void setCambio(int cambio) {
        this.cambio = cambio;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getNombre_articulo() {
        return nombre_articulo;
    }

    public void setNombre_articulo(String nombre_articulo) {
        this.nombre_articulo = nombre_articulo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_original() {
        return precio_original;
    }

    public void setPrecio_original(double precio_original) {
        this.precio_original = precio_original;
    }

    public double getPrecio_pactado() {
        return precio_pactado;
    }

    public void setPrecio_pactado(double precio_pactado) {
        this.precio_pactado = precio_pactado;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
