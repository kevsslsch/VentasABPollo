package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class BranchOffices extends RealmObject {
    private int    sucursal;
    private String nombre_sucursal;
    private String rfc;
    private String direccion;
    private String colonia;
    private String municipio;
    private int area;
    private int telefono;
    private String email;
    private String sitio_web;

    public BranchOffices() {
    }

    public BranchOffices(int sucursal, String nombre_sucursal, String rfc, String direccion, String colonia, String municipio, int area, int telefono, String email, String sitio_web) {
        this.sucursal = sucursal;
        this.nombre_sucursal = nombre_sucursal;
        this.rfc = rfc;
        this.direccion = direccion;
        this.colonia = colonia;
        this.municipio = municipio;
        this.area = area;
        this.telefono = telefono;
        this.email = email;
        this.sitio_web = sitio_web;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public String getNombre_sucursal() {
        return nombre_sucursal;
    }

    public void setNombre_sucursal(String nombre_sucursal) {
        this.nombre_sucursal = nombre_sucursal;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSitio_web() {
        return sitio_web;
    }

    public void setSitio_web(String sitio_web) {
        this.sitio_web = sitio_web;
    }
}
