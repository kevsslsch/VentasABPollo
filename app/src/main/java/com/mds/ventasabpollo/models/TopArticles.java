package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class TopArticles extends RealmObject {

    private int clave_articulo;
    private int clicks;
    private boolean es_top;
    private String fecha_registro;
    private int user_id;

    public TopArticles() {
    }

    public TopArticles(
            int clave_articulo,
            int clicks,
            boolean es_top,
            String fecha_registro,
            int user_id) {

        this.clave_articulo = clave_articulo;
        this.clicks = clicks;
        this.es_top = es_top;
        this.fecha_registro = fecha_registro;
        this.user_id = user_id;
    }

    public int getClave_articulo() {
        return clave_articulo;
    }

    public void setClave_articulo(int clave_articulo) {
        this.clave_articulo = clave_articulo;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public boolean isEs_top() {
        return es_top;
    }

    public void setEs_top(boolean es_top) {
        this.es_top = es_top;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
