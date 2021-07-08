package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class Articles extends RealmObject {

    private int     clave_articulo;
    private int     familia;
    private int     sublinea;
    private String articulo;
    private String nombre_articulo;
    private String nombre_unidad;
    private String descripcion_extendida;
    private String ubicacion_URL;
    private boolean temporal_flag;
    private int     user_id;

    public Articles() {
    }

    public Articles(int clave_articulo, int familia, int sublinea, String articulo, String nombre_articulo, String nombre_unidad, String descripcion_extendida, String ubicacion_URL) {
        this.clave_articulo = clave_articulo;
        this.familia = familia;
        this.sublinea = sublinea;
        this.articulo = articulo;
        this.nombre_articulo = nombre_articulo;
        this.nombre_unidad = nombre_unidad;
        this.descripcion_extendida = descripcion_extendida;
        this.ubicacion_URL = ubicacion_URL;
        this.temporal_flag = false;
    }

    public Articles(
            int    clave_articulo,
            int    familia,
            int    sublinea,
            String articulo,
            String nombre_articulo,
            String nombre_unidad,
            String descripcion_extendida,
            String ubicacion_URL,
            boolean temporal_flag,
            int user_id
            ){

        this.clave_articulo = clave_articulo;
        this.familia = familia;
        this.sublinea = sublinea;
        this.articulo = articulo;
        this.nombre_articulo = nombre_articulo;
        this.nombre_unidad = nombre_unidad;
        this.descripcion_extendida = descripcion_extendida;
        this.ubicacion_URL = ubicacion_URL;
        this.temporal_flag = temporal_flag;
        this.user_id = user_id;

    }

    public int getClave_articulo() {
        return clave_articulo;
    }

    public void setClave_articulo(int clave_articulo) {
        this.clave_articulo = clave_articulo;
    }

    public int getFamilia() {
        return familia;
    }

    public void setFamilia(int familia) {
        this.familia = familia;
    }

    public int getSublinea() {
        return sublinea;
    }

    public void setSublinea(int sublinea) {
        this.sublinea = sublinea;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public String getNombre_articulo() {
        return nombre_articulo;
    }

    public void setNombre_articulo(String nombre_articulo) {
        this.nombre_articulo = nombre_articulo;
    }

    public String getNombre_unidad() {
        return nombre_unidad;
    }

    public void setNombre_unidad(String nombre_unidad) {
        this.nombre_unidad = nombre_unidad;
    }

    public String getDescripcion_extendida() {
        return descripcion_extendida;
    }

    public void setDescripcion_extendida(String descripcion_extendida) {
        this.descripcion_extendida = descripcion_extendida;
    }

    public String getUbicacion_URL() {
        return ubicacion_URL;
    }

    public void setUbicacion_URL(String ubicacion_URL) {
        this.ubicacion_URL = ubicacion_URL;
    }

    public boolean isTemporal_flag() {
        return temporal_flag;
    }

    public void setTemporal_flag(boolean temporal_flag) {
        this.temporal_flag = temporal_flag;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
