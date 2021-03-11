package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class Cities extends RealmObject {
    private int     position;
    private int     ciudad;
    private String nombre_ciudad;

    public Cities() {
    }

    public Cities(
            int position,
            int ciudad,
            String nombre_ciudad) {

        this.position = position;
        this.ciudad = ciudad;
        this.nombre_ciudad = nombre_ciudad;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getCiudad() {
        return ciudad;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre_ciudad() {
        return nombre_ciudad;
    }

    public void setNombre_ciudad(String nombre_ciudad) {
        this.nombre_ciudad = nombre_ciudad;
    }
}
