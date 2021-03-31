package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class UseCFDI extends RealmObject {
    private String descripcion;
    private String uso_SAT;

    public UseCFDI() {
    }

    public UseCFDI(
            String descripcion,
            String forma_SAT) {

        this.descripcion = descripcion;
        this.uso_SAT = uso_SAT;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUso_SAT() {
        return uso_SAT;
    }

    public void setUso_SAT(String uso_SAT) {
        this.uso_SAT = uso_SAT;
    }
}
