package com.mds.ventasabpollo.models;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class VisitsClients extends RealmObject {

    @PrimaryKey
    private int     id;
    private int     ruta;
    private int     cliente;
    private int     lista;
    private int     clasificacion_visita;
    private int     position_clasificacion_visita;
    private String fecha_visita_inicio;
    private String fecha_visita_fin;
    private String fecha_enviada;
    private double  lat_visita_inicio;
    private double  long_visita_inicio;
    private double  lat_visita_fin;
    private double  long_visita_fin;
    private boolean enviada;
    private boolean es_credito;
    private boolean es_remision;
    private boolean visitada;
    private boolean finalizado_forzado;
    private boolean estado_ventas;
    private int     id_db;
    private int     factura;
    private int     user_id;

    public VisitsClients() {
    }

    public VisitsClients(
            int     id,
            int     ruta,
            int     cliente,
            int     lista,
            int     clasificacion_visita,
            int     position_clasificacion_visita,
            String fecha_visita_inicio,
            double  lat_visita_inicio,
            double  long_visita_inicio,
            double  lat_visita_fin,
            double  long_visita_fin,
            boolean visitada,
            boolean estado_ventas,
            int     user_id) {

        this.id = id;
        this.ruta = ruta;
        this.cliente = cliente;
        this.lista = lista;
        this.clasificacion_visita = clasificacion_visita;
        this.position_clasificacion_visita = position_clasificacion_visita;
        this.visitada = visitada;
        this.es_credito = false;
        this.es_remision = true;
        this.estado_ventas = estado_ventas;
        this.fecha_visita_inicio = fecha_visita_inicio;
        this.fecha_visita_fin = fecha_visita_fin;
        this.lat_visita_inicio = lat_visita_inicio;
        this.long_visita_inicio = long_visita_inicio;
        this.lat_visita_fin = lat_visita_fin;
        this.long_visita_fin = long_visita_fin;
        this.id_db = id_db;
        this.user_id = user_id;
    }

    public int getFactura() {
        return factura;
    }

    public void setFactura(int factura) {
        this.factura = factura;
    }

    public boolean isEs_remision() {
        return es_remision;
    }

    public void setEs_remision(boolean es_remision) {
        this.es_remision = es_remision;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRuta() {
        return ruta;
    }

    public void setRuta(int ruta) {
        this.ruta = ruta;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getLista() {
        return lista;
    }

    public void setLista(int lista) {
        this.lista = lista;
    }

    public int getClasificacion_visita() {
        return clasificacion_visita;
    }

    public void setClasificacion_visita(int clasificacion_visita) {
        this.clasificacion_visita = clasificacion_visita;
    }

    public int getPosition_clasificacion_visita() {
        return position_clasificacion_visita;
    }

    public void setPosition_clasificacion_visita(int position_clasificacion_visita) {
        this.position_clasificacion_visita = position_clasificacion_visita;
    }

    public String getFecha_visita_inicio() {
        return fecha_visita_inicio;
    }

    public void setFecha_visita_inicio(String fecha_visita_inicio) {
        this.fecha_visita_inicio = fecha_visita_inicio;
    }

    public String getFecha_visita_fin() {
        return fecha_visita_fin;
    }

    public void setFecha_visita_fin(String fecha_visita_fin) {
        this.fecha_visita_fin = fecha_visita_fin;
    }

    public String getFecha_enviada() {
        return fecha_enviada;
    }

    public void setFecha_enviada(String fecha_enviada) {
        this.fecha_enviada = fecha_enviada;
    }

    public double getLat_visita_inicio() {
        return lat_visita_inicio;
    }

    public void setLat_visita_inicio(double lat_visita_inicio) {
        this.lat_visita_inicio = lat_visita_inicio;
    }

    public double getLong_visita_inicio() {
        return long_visita_inicio;
    }

    public void setLong_visita_inicio(double long_visita_inicio) {
        this.long_visita_inicio = long_visita_inicio;
    }

    public double getLat_visita_fin() {
        return lat_visita_fin;
    }

    public void setLat_visita_fin(double lat_visita_fin) {
        this.lat_visita_fin = lat_visita_fin;
    }

    public double getLong_visita_fin() {
        return long_visita_fin;
    }

    public void setLong_visita_fin(double long_visita_fin) {
        this.long_visita_fin = long_visita_fin;
    }

    public boolean isEnviada() {
        return enviada;
    }

    public void setEnviada(boolean enviada) {
        this.enviada = enviada;
    }

    public boolean isEs_credito() {
        return es_credito;
    }

    public void setEs_credito(boolean es_credito) {
        this.es_credito = es_credito;
    }

    public boolean isVisitada() {
        return visitada;
    }

    public void setVisitada(boolean visitada) {
        this.visitada = visitada;
    }

    public boolean isFinalizado_forzado() {
        return finalizado_forzado;
    }

    public void setFinalizado_forzado(boolean finalizado_forzado) {
        this.finalizado_forzado = finalizado_forzado;
    }

    public boolean isEstado_ventas() {
        return estado_ventas;
    }

    public void setEstado_ventas(boolean estado_ventas) {
        this.estado_ventas = estado_ventas;
    }

    public int getId_db() {
        return id_db;
    }

    public void setId_db(int id_db) {
        this.id_db = id_db;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}