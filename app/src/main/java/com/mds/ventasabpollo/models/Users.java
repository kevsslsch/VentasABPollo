package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class Users extends RealmObject {
    private int     persona;
    private String nombre_persona;

    public Users() {
    }

    public Users(
            int persona,
            String nombre_persona) {

        this.persona = persona;
        this.nombre_persona = nombre_persona;
    }

    public int getPersona() {
        return persona;
    }

    public void setPersona(int persona) {
        this.persona = persona;
    }

    public String getNombre_persona() {
        return nombre_persona;
    }

    public void setNombre_persona(String nombre_persona) {
        this.nombre_persona = nombre_persona;
    }
}
