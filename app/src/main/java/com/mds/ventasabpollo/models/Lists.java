package com.mds.ventasabpollo.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Lists extends RealmObject {
    private int lista;
    private String nombre_lista;
    private String nombre_ruta;
    private String comentarios;
    private int dia_semana;
    private int user_id;

    public Lists() {
    }

    public Lists(
            int lista,
            String nombre_lista,
            String nombre_ruta,
            String comentarios,
            int dia_semana,
            int user_id) {

        this.lista = lista;
        this.nombre_lista = nombre_lista;
        this.nombre_ruta = nombre_ruta;
        this.comentarios = comentarios;
        this.dia_semana = dia_semana;
        this.user_id = user_id;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
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

    public String getNombre_ruta() {
        return nombre_ruta;
    }

    public void setNombre_ruta(String nombre_ruta) {
        this.nombre_ruta = nombre_ruta;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getDia_semana() {
        return dia_semana;
    }

    public void setDia_semana(int dia_semana) {
        this.dia_semana = dia_semana;
    }
}
