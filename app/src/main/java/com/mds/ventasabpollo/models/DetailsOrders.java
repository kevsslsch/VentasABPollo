package com.mds.ventasabpollo.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class DetailsOrders extends RealmObject {
    @PrimaryKey
    private int     clave_articulo;
    private String articulo;
    private int     visita;
    private int     pedido;
    private String nombre_articulo;
    private String nombre_unidad;
    private String descripcion_extendida;
    private double  cantidad;
    private double  precio;
    private double  IVA;
    private double  IEPS;
    private double  tasa_IVA;
    private double  tasa_IEPS;
    private double  importe;
    private boolean es_credito;
    private boolean enviado;
    private String fecha_enviado;

    public DetailsOrders() {
    }

    public DetailsOrders(
            int    clave_articulo,
            String articulo,
            int    visita,
            int    pedido,
            String nombre_articulo,
            String nombre_unidad,
            String descripcion_extendida,
            double cantidad,
            double precio,
            double IVA,
            double IEPS,
            double tasa_IVA,
            double tasa_IEPS,
            double importe,
            boolean es_credito) {

        this.clave_articulo =  clave_articulo;
        this.articulo = articulo;
        this.visita = visita;
        this.pedido = pedido;
        this.nombre_articulo = nombre_articulo;
        this.nombre_unidad = nombre_unidad;
        this.descripcion_extendida = descripcion_extendida;
        this.cantidad = cantidad;
        this.precio = precio;
        this.IVA = IVA;
        this.IEPS = IEPS;
        this.tasa_IVA = tasa_IVA;
        this.tasa_IEPS = tasa_IEPS;
        this.importe = importe;
        this.importe = importe;
        this.es_credito = es_credito;
        this.fecha_enviado = fecha_enviado;
    }

    public int getClave_articulo() {
        return clave_articulo;
    }

    public void setClave_articulo(int clave_articulo) {
        this.clave_articulo = clave_articulo;
    }

    public String getArticulo() {
        return articulo;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public int getVisita() {
        return visita;
    }

    public void setVisita(int visita) {
        this.visita = visita;
    }

    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
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
    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getIVA() {
        return IVA;
    }

    public void setIVA(double IVA) {
        this.IVA = IVA;
    }

    public double getIEPS() {
        return IEPS;
    }

    public void setIEPS(double IEPS) {
        this.IEPS = IEPS;
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

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public boolean getEs_credito() {
        return es_credito;
    }

    public void setEs_credito(boolean es_credito) {
        this.es_credito = es_credito;
    }

    public boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }

    public String getFecha_enviado() {
        return fecha_enviado;
    }

    public void setFecha_enviado(String fecha_enviado) {
        this.fecha_enviado = fecha_enviado;
    }
}
