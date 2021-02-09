package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class ClientsLists extends RealmObject {

    private int cliente;
    private int lista;
    private int orden;

    public ClientsLists() {
    }

    public ClientsLists(
            int cliente,
            int lista,
            int orden) {

        this.cliente = cliente;
        this.lista = lista;
        this.orden = orden;
    }

    public int getOrden() {
        return orden;
    }

    public void setOrden(int orden) {
        this.orden = orden;
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
}
