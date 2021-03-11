package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class VisitsMovements extends RealmObject {

    private int ruta;
    private int visita;
    private int clave_articulo;
    private int piezas_devolucion;
    private int piezas_cambio;
    private int piezas_apartado;
    private String fecha_apartado;
    private boolean enviada;
    private int user_id;

    public VisitsMovements() {
    }

    public VisitsMovements(
            int ruta,
            int visita,
            int clave_articulo,
            int piezas_devolucion,
            int piezas_cambio,
            int piezas_apartado,
            String fecha_apartado,
            boolean enviada,
            int user_id) {

        this.ruta = ruta;
        this.visita = visita;
        this.clave_articulo = clave_articulo;
        this.piezas_devolucion = piezas_devolucion;
        this.piezas_cambio = piezas_cambio;
        this.piezas_apartado = piezas_apartado;
        this.fecha_apartado = fecha_apartado;
        this.enviada = enviada;
        this.user_id = user_id;
    }

    public int getRuta() {
        return ruta;
    }

    public void setRuta(int ruta) {
        this.ruta = ruta;
    }

    public int getVisita() {
        return visita;
    }

    public void setVisita(int visita) {
        this.visita = visita;
    }

    public int getClave_articulo() {
        return clave_articulo;
    }

    public void setClave_articulo(int clave_articulo) {
        this.clave_articulo = clave_articulo;
    }

    public int getPiezas_devolucion() {
        return piezas_devolucion;
    }

    public void setPiezas_devolucion(int piezas_devolucion) {
        this.piezas_devolucion = piezas_devolucion;
    }

    public int getPiezas_cambio() {
        return piezas_cambio;
    }

    public void setPiezas_cambio(int piezas_cambio) {
        this.piezas_cambio = piezas_cambio;
    }

    public int getPiezas_apartado() {
        return piezas_apartado;
    }

    public void setPiezas_apartado(int piezas_apartado) {
        this.piezas_apartado = piezas_apartado;
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

    public String getFecha_apartado() {
        return fecha_apartado;
    }

    public void setFecha_apartado(String fecha_apartado) {
        this.fecha_apartado = fecha_apartado;
    }
}
