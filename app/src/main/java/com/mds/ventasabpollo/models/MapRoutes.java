package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class MapRoutes extends RealmObject {

    private int lista;
    private int cliente;
    private String nombre_cliente;
    private String nombre_comercial;
    private double latitud;
    private double longitud;
    private int orden;
    private int user_id;

    public MapRoutes() {
    }

    public MapRoutes(
            int lista,
            int cliente,
            String nombre,
            String comercial,
            double latitud,
            double longitud,
            int orden,
            int user_id) {

        this.lista = lista;
        this.cliente = cliente;
        this.nombre_cliente = nombre;
        this.nombre_comercial = comercial;
        this.latitud = latitud;
        this.longitud = longitud;
        this.orden = orden;
        this.user_id = user_id;
    }

    public int getLista() {
        return lista;
    }

    public void setLista(int lista) {
        this.lista = lista;
    }
    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
