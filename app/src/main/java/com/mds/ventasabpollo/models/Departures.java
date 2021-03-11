package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class Departures extends RealmObject {

    private int salida;
    private String vendedor;
    private String registrado_por;
    private String autorizado_por;
    private String fecha_registro;
    private int lista;
    private String nombre_lista;
    private String estado_actual;

    public Departures() {
    }

    public Departures(
            int salida,
            String vendedor,
            String registrado_por,
            String autorizado_por,
            String fecha_registro,
            int lista,
            String nombre_lista,
            String estado_actual) {

        this.salida = salida;
        this.vendedor = vendedor;
        this.registrado_por = registrado_por;
        this.autorizado_por = autorizado_por;
        this.fecha_registro = fecha_registro;
        this.lista = lista;
        this.nombre_lista = nombre_lista;
        this.estado_actual = estado_actual;
    }

    public int getSalida() {
        return salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getRegistrado_por() {
        return registrado_por;
    }

    public void setRegistrado_por(String registrado_por) {
        this.registrado_por = registrado_por;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getLista() {
        return lista;
    }

    public void setLista(int lista) {
        this.lista = lista;
    }

    public String getNombre_lista() {
        return nombre_lista;
    }

    public void setNombre_lista(String nombre_lista) {
        this.nombre_lista = nombre_lista;
    }

    public String getEstado_actual() {
        return estado_actual;
    }

    public void setEstado_actual(String estado_actual) {
        this.estado_actual = estado_actual;
    }

    public String getAutorizado_por() {
        return autorizado_por;
    }

    public void setAutorizado_por(String autorizado_por) {
        this.autorizado_por = autorizado_por;
    }
}
