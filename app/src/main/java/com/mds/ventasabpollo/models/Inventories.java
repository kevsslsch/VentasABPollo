package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class Inventories extends RealmObject {

    private int ruta;
    private int clave_articulo;
    private String nombre_articulo;
    private int cantidad_inicial;
    //private int cantidad;
    private int user_id;

    public Inventories() {
    }

    public Inventories(
            int ruta,
            int clave_articulo,
            String nombre_articulo,
            int cantidad_inicial,
            //int cantidad,
            int user_id) {

        this.ruta = ruta;
        this.clave_articulo = clave_articulo;
        this.nombre_articulo = nombre_articulo;
        this.cantidad_inicial = cantidad_inicial;
        //this.cantidad = cantidad;
        this.user_id = user_id;
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

    public String getNombre_articulo() {
        return nombre_articulo;
    }

    public void setNombre_articulo(String nombre_articulo) {
        this.nombre_articulo = nombre_articulo;
    }

    public int getCantidad_inicial() {
        return cantidad_inicial;
    }

    public void setCantidad_inicial(int cantidad_inicial) {
        this.cantidad_inicial = cantidad_inicial;
    }

    /*public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }*/

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
