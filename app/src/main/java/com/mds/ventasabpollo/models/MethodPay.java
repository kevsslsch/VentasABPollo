package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class MethodPay extends RealmObject {
    private String descripcion;
    private String metodo_SAT;

    public MethodPay() {
    }

    public MethodPay(
            String descripcion,
            String forma_SAT) {

        this.descripcion = descripcion;
        this.metodo_SAT = metodo_SAT;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMetodo_SAT() {
        return metodo_SAT;
    }

    public void setMetodo_SAT(String metodo_SAT) {
        this.metodo_SAT = metodo_SAT;
    }
}
