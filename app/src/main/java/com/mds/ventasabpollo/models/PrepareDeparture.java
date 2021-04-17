package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class PrepareDeparture extends RealmObject {

    private int clave_articulo;
    private double cantidad;

    public PrepareDeparture() {
    }

    public PrepareDeparture(
            int clave_articulo,
            double cantidad) {

        this.clave_articulo = clave_articulo;
        this.cantidad = cantidad;
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
}
