package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class ChangesPrices extends RealmObject {
    private int cambio;
    private int visita;
    private int autorizacion;
    private int cliente;
    private int clave_articulo;
    private double cantidad;
    private double precio_original;
    private double precio_pactado;

    public ChangesPrices() {
    }

    public ChangesPrices(int cambio, int visita, int cliente, int clave_articulo, double cantidad, double precio_original, double precio_pactado) {
        this.cambio = cambio;
        this.visita = visita;
        this.autorizacion = 0;
        this.cliente = cliente;
        this.clave_articulo = clave_articulo;
        this.cantidad = cantidad;
        this.precio_original = precio_original;
        this.precio_pactado = precio_pactado;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public int getCambio() {
        return cambio;
    }

    public void setCambio(int cambio) {
        this.cambio = cambio;
    }

    public int getVisita() {
        return visita;
    }

    public void setVisita(int visita) {
        this.visita = visita;
    }

    public int getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(int autorizacion) {
        this.autorizacion = autorizacion;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getClave_articulo() {
        return clave_articulo;
    }

    public void setClave_articulo(int clave_articulo) {
        this.clave_articulo = clave_articulo;
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
}
