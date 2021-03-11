package com.mds.ventasabpollo.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Routes extends RealmObject {
    @PrimaryKey
    private int ruta;
    private int salida;
    private int autorizador_inicio;
    private int autorizado_fin;
    private String nombre_autorizador_inicio;
    private String fecha_inicio;
    private String fecha_fin;
    private boolean enviada;
    private int user_id;

    public Routes() {
    }

    public Routes(
            int ruta,
            int salida,
            int autorizador_inicio,
            int autorizado_fin,
            String nombre_autorizador_inicio,
            String fecha_inicio,
            String fecha_fin,
            boolean enviada,
            int user_id) {

        this.ruta = ruta;
        this.salida = salida;
        this.autorizador_inicio = autorizador_inicio;
        this.autorizado_fin = autorizado_fin;
        this.nombre_autorizador_inicio = nombre_autorizador_inicio;
        this.fecha_inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.enviada = enviada;
        this.user_id = user_id;
    }


    public int getRuta() {
        return ruta;
    }

    public void setRuta(int ruta) {
        this.ruta = ruta;
    }

    public int getSalida() {
        return salida;
    }

    public void setSalida(int salida) {
        this.salida = salida;
    }

    public int getAutorizador_inicio() {
        return autorizador_inicio;
    }

    public void setAutorizador_inicio(int autorizador_inicio) {
        this.autorizador_inicio = autorizador_inicio;
    }

    public int getAutorizado_fin() {
        return autorizado_fin;
    }

    public void setAutorizado_fin(int autorizado_fin) {
        this.autorizado_fin = autorizado_fin;
    }

    public String getNombre_autorizador_inicio() {
        return nombre_autorizador_inicio;
    }

    public void setNombre_autorizador_inicio(String nombre_autorizador_inicio) {
        this.nombre_autorizador_inicio = nombre_autorizador_inicio;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(String fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public boolean isEnviada() {
        return enviada;
    }

    public void setEnviada(boolean enviada) {
        this.enviada = enviada;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }


}
