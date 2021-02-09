package com.mds.ventasabpollo.models;


import io.realm.RealmObject;

public class VisitsClasifications extends RealmObject {

    private int clasificacion;
    private String nombre_clasificacion;

    public VisitsClasifications() {
    }

    public VisitsClasifications(
            int clasificacion,
            String nombre_clasificacion){

        this.clasificacion = clasificacion;
        this.nombre_clasificacion = nombre_clasificacion;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getNombre_clasificacion() {
        return nombre_clasificacion;
    }

    public void setNombre_clasificacion(String nombre_clasificacion) {
        this.nombre_clasificacion = nombre_clasificacion;
    }
}

