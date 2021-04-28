package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class RechargeInventories extends RealmObject {

    private int ruta;
    private int salida;
    private int recarga;
    private int clave_articulo;
    private double cantidad;
    private String fecha;

    public RechargeInventories() {
    }

    public RechargeInventories(
            int ruta,
            int salida,
            int recarga,
            int clave_articulo,
            double cantidad,
            String fecha) {

        this.ruta = ruta;
        this.salida = salida;
        this.recarga = recarga;
        this.clave_articulo = clave_articulo;
        this.cantidad = cantidad;
        this.fecha = fecha;
    }

    public int getSalida() {
        return salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
    }

    public int getRecarga() {
        return recarga;
    }

    public void setRecarga(int recarga) {
        this.recarga = recarga;
    }

    public int getRuta() {
        return ruta;
    }

    public void setRuta(int ruta) {
        this.ruta = ruta;
    }

    public int getClave_articulo() {
        return clave_articulo;
    }

    public void setClave_articulo(int clave_articulo) {
        this.clave_articulo = clave_articulo;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
