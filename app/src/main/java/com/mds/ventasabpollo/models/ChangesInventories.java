package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class ChangesInventories extends RealmObject {

    private int ruta;
    private int clave_articulo;
    private double cantidad_anterior;
    private double cantidad_nueva;
    private String fecha;
    private boolean enviado;
    private int user_id;

    public ChangesInventories() {
    }

    public ChangesInventories(
            int ruta,
            int clave_articulo,
            double cantidad_anterior,
            double cantidad_nueva,
            String fecha,
            int user_id) {

        this.ruta = ruta;
        this.clave_articulo = clave_articulo;
        this.cantidad_anterior = cantidad_anterior;
        this.cantidad_nueva = cantidad_nueva;
        this.fecha = fecha;
        this.user_id = user_id;
    }

    public int getRuta() {
        return ruta;
    }

    public void setRuta(int ruta) {
        this.ruta = ruta;
    }

    public double getClave_articulo() {
        return clave_articulo;
    }

    public void setClave_articulo(int clave_articulo) {
        this.clave_articulo = clave_articulo;
    }

    public double getCantidad_anterior() {
        return cantidad_anterior;
    }

    public void setCantidad_anterior(int cantidad_anterior) {
        this.cantidad_anterior = cantidad_anterior;
    }

    public double getCantidad_nueva() {
        return cantidad_nueva;
    }

    public void setCantidad_nueva(double cantidad_nueva) {
        this.cantidad_nueva = cantidad_nueva;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
