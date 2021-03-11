package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class Images extends RealmObject {
    private int     foto;
    private int     clave_integer;
    private String texto_base64;
    private String tabla;

    public Images() {
    }

    public Images(
            int foto,
            int clave_integer,
            String texto_base64,
            String tabla) {

        this.foto = foto;
        this.clave_integer = clave_integer;
        this.texto_base64 = texto_base64;
        this.tabla = tabla;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getClave_integer() {
        return clave_integer;
    }

    public void setClave_integer(int clave_integer) {
        this.clave_integer = clave_integer;
    }

    public String getTexto_base64() {
        return texto_base64;
    }

    public void setTexto_base64(String texto_base64) {
        this.texto_base64 = texto_base64;
    }

    public String getTabla() {
        return tabla;
    }

    public void setTabla(String tabla) {
        this.tabla = tabla;
    }
}
