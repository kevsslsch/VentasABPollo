package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class WayPay extends RealmObject {
    private String descripcion;
    private String forma_SAT;

    public WayPay() {
    }

    public WayPay(
            String descripcion,
            String forma_SAT) {

        this.descripcion = descripcion;
        this.forma_SAT = forma_SAT;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getForma_SAT() {
        return forma_SAT;
    }

    public void setForma_SAT(String forma_SAT) {
        this.forma_SAT = forma_SAT;
    }
}
