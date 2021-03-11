package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class Prices extends RealmObject {
    private int cliente;
    private int clave_articulo;
    private double precio_contado;
    private double precio_credito;
    private int    tiene_iva;
    private double tasa_IVA;
    private double tasa_IEPS;
    private String tipo_IEPS;
    private String fecha_actualizacion;
    private int promedio_piezas;
    private int user_id;

    public Prices() {
    }

    public Prices(
            int     cliente,
            int     clave_articulo,
            double  precio_contado,
            double  precio_credito,
            int     tiene_iva,
            double  tasa_IVA,
            double  tasa_IEPS,
            String tipo_IEPS,
            String fecha_actualizacion,
            int     promedio_piezas,
            int     user_id) {

        this.cliente = cliente;
        this.clave_articulo = clave_articulo;
        this.precio_contado = precio_contado;
        this.precio_credito = precio_credito;
        this.tiene_iva = tiene_iva;
        this.tasa_IVA = tasa_IVA;
        this.tasa_IEPS = tasa_IEPS;
        this.tipo_IEPS = tipo_IEPS;
        this.fecha_actualizacion = fecha_actualizacion;
        this.promedio_piezas = promedio_piezas;
        this.user_id = user_id;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getClave_articulo() {
        return clave_articulo;
    }

    public void setClave_articulo(int clave_articulo) {
        this.clave_articulo = clave_articulo;
    }

    public double getPrecio_contado() {
        return precio_contado;
    }

    public void setPrecio_contado(double precio_contado) {
        this.precio_contado = precio_contado;
    }

    public double getPrecio_credito() {
        return precio_credito;
    }

    public void setPrecio_credito(double precio_credito) {
        this.precio_credito = precio_credito;
    }

    public int getTiene_iva() {
        return tiene_iva;
    }

    public void setTiene_iva(int tiene_iva) {
        this.tiene_iva = tiene_iva;
    }

    public double getTasa_IVA() {
        return tasa_IVA;
    }

    public void setTasa_IVA(double tasa_IVA) {
        this.tasa_IVA = tasa_IVA;
    }

    public double getTasa_IEPS() {
        return tasa_IEPS;
    }

    public void setTasa_IEPS(double tasa_IEPS) {
        this.tasa_IEPS = tasa_IEPS;
    }

    public String getTipo_IEPS() {
        return tipo_IEPS;
    }

    public void setTipo_IEPS(String tipo_IEPS) {
        this.tipo_IEPS = tipo_IEPS;
    }


    public String getFecha_actualizacion() {
        return fecha_actualizacion;
    }

    public void setFecha_actualizacion(String fecha_actualizacion) {
        this.fecha_actualizacion = fecha_actualizacion;
    }

    public int getPromedio_piezas() {
        return promedio_piezas;
    }

    public void setPromedio_piezas(int promedio_piezas) {
        this.promedio_piezas = promedio_piezas;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
