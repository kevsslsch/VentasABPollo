package com.mds.ventasabpollo.models;


import io.realm.RealmObject;

public class VisitsPayments extends RealmObject {
    private int     pago;
    private int     ruta;
    private int     visita;
    private int     cliente;
    private double  importe;
    private double  importe_pago; // con lo que se pagó
    private double  importe_saldado; // lo que se ha abonado
    private String metodo_pago;
    private String fecha;
    private String fecha_cobrado;
    private boolean enviado;
    private boolean cobrado;
    private boolean descargado;
    private int     user_id;

    public VisitsPayments() {
    }

    public VisitsPayments(int pago, int visita, int cliente, double importe, String metodo_pago, String fecha, boolean descargado, int user_id) {
        this.pago = pago;
        this.visita = visita;
        this.cliente = cliente;
        this.importe = importe;
        this.metodo_pago = metodo_pago;
        this.fecha = fecha;
        this.descargado = descargado;
        this.user_id = user_id;
    }

    public VisitsPayments(
            int     pago,
            int     ruta,
            int     visita,
            int     cliente,
            double  importe,
            double  importe_saldado,
            String metodo_pago,
            String fecha,
            String fecha_cobrado,
            boolean enviado,
            boolean cobrado,
            boolean descargado,
            int     user_id) {

        this.pago   = pago;
        this.ruta = ruta;
        this.visita = visita;
        this.cliente = cliente;
        this.importe = importe;
        this.importe_saldado = importe_saldado;
        this.metodo_pago = metodo_pago;
        this.fecha = fecha;
        this.fecha_cobrado = fecha_cobrado;
        this.enviado = enviado;
        this.cobrado = cobrado;
        this.descargado = descargado;
        this.user_id = user_id;
    }

    public double getImporte_pago() {
        return importe_pago;
    }

    public void setImporte_pago(double importe_pago) {
        this.importe_pago = importe_pago;
    }

    public int getPago() {
        return pago;
    }

    public void setPago(int pago) {
        this.pago = pago;
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

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public double getImporte_saldado() {
        return importe_saldado;
    }

    public void setImporte_saldado(double importe_saldado) {
        this.importe_saldado = importe_saldado;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getFecha_cobrado() {
        return fecha_cobrado;
    }

    public void setFecha_cobrado(String fecha_cobrado) {
        this.fecha_cobrado = fecha_cobrado;
    }

    public boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }

    public boolean isCobrado() {
        return cobrado;
    }

    public void setCobrado(boolean cobrado) {
        this.cobrado = cobrado;
    }

    public boolean isDescargado() {
        return descargado;
    }

    public void setDescargado(boolean descargado) {
        this.descargado = descargado;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}