package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class DetailsDepartures extends RealmObject {

    private int salida;
    private int clave_articulo;
    private String nombre_articulo;
    private int cantidad;

    public DetailsDepartures() {
    }

    public DetailsDepartures(
            int salida,
            int clave_articulo,
            String nombre_articulo,
            int cantidad) {

        this.salida = salida;
        this.clave_articulo = clave_articulo;
        this.nombre_articulo = nombre_articulo;
        this.cantidad = cantidad;
    }

    public int getSalida() {
        return salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
    }

    public int getClave_articulo() {
        return clave_articulo;
    }

    public void setClave_articulo(int clave_articulo) {
        this.clave_articulo = clave_articulo;
    }

    public String getNombre_articulo() {
        return nombre_articulo;
    }

    public void setNombre_articulo(String nombre_articulo) {
        this.nombre_articulo = nombre_articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
