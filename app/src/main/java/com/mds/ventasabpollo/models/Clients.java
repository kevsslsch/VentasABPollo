package com.mds.ventasabpollo.models;

import io.realm.RealmObject;

public class Clients extends RealmObject {

    private int cliente;
    private int sucursal;
    private String nombre_cliente;
    private String nombre_comercial;
    private String calle;
    private String numero_exterior;
    private String codigo_postal;
    private String domicilio;
    private String colonia;
    private String ciudad;
    private int    id_ciudad;
    private int    id_domicilio;
    private String telefono;
    private String fecha_ultima_compra;
    private String calle_nueva;
    private String numero_exterior_nuevo;
    private String colonia_nueva;
    private String codigo_postal_nuevo;
    private String listas;
    private int ciudad_nueva;
    private double latitud;
    private double longitud;
    private double latitud_nueva;
    private double longitud_nueva;
    private double latitud_anterior;
    private double longitud_anterior;
    private double limite_credito;
    private double saldo_actual;
    private int numero_precio;
    private int user_id;

    public Clients() {
    }

    public Clients(int cliente, int sucursal, String nombre_cliente, String nombre_comercial, String calle, String numero_exterior, String codigo_postal, String domicilio, String colonia, String ciudad, int id_ciudad, int id_domicilio, String telefono, String fecha_ultima_compra, String listas, double latitud, double longitud, double limite_credito, double saldo_actual, int numero_precio) {
        this.cliente = cliente;
        this.sucursal = sucursal;
        this.nombre_cliente = nombre_cliente;
        this.nombre_comercial = nombre_comercial;
        this.calle = calle;
        this.numero_exterior = numero_exterior;
        this.codigo_postal = codigo_postal;
        this.domicilio = domicilio;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.id_ciudad = id_ciudad;
        this.id_domicilio = id_domicilio;
        this.telefono = telefono;
        this.fecha_ultima_compra = fecha_ultima_compra;
        this.listas = listas;
        this.latitud = latitud;
        this.longitud = longitud;
        this.limite_credito = limite_credito;
        this.saldo_actual = saldo_actual;
        this.numero_precio = numero_precio;
    }

    public Clients(
            int cliente,
            int sucursal,
            String nombre,
            String comercial,
            String calle,
            String numero_exterior,
            String codigo_postal,
            String domicilio,
            String colonia,
            String ciudad,
            int    id_ciudad,
            int    id_domicilio,
            String telefono,
            String fecha_ultima_compra,
            String calle_nueva,
            String numero_exterior_nuevo,
            String colonia_nueva,
            String codigo_postal_nuevo,
            String listas,
            int ciudad_nueva,
            double latitud,
            double longitud,
            double latitud_nueva,
            double longitud_nueva,
            double latitud_anterior,
            double longitud_anterior,
            double limite_credito,
            double saldo_actual,
            int numero_precio,
            int user_id) {

        this.cliente = cliente;
        this.sucursal = sucursal;
        this.nombre_cliente = nombre;
        this.nombre_comercial = comercial;
        this.calle = calle;
        this.numero_exterior = numero_exterior;
        this.codigo_postal = codigo_postal;
        this.domicilio = domicilio;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.id_ciudad = id_ciudad;
        this.id_domicilio = id_domicilio;
        this.telefono = telefono;
        this.fecha_ultima_compra = fecha_ultima_compra;
        this.calle_nueva = calle_nueva;
        this.numero_exterior_nuevo = numero_exterior_nuevo;
        this.colonia_nueva = colonia_nueva;
        this.codigo_postal_nuevo = codigo_postal_nuevo;
        this.listas = listas;
        this.ciudad_nueva = ciudad_nueva;
        this.latitud = latitud;
        this.longitud = longitud;
        this.latitud_nueva = latitud_nueva;
        this.longitud_nueva = longitud_nueva;
        this.latitud_anterior = latitud_anterior;
        this.longitud_anterior = longitud_anterior;
        this.limite_credito = limite_credito;
        this.saldo_actual = saldo_actual;
        this.numero_precio = numero_precio;
        this.user_id = user_id;
    }

    public int getNumero_precio() {
        return numero_precio;
    }

    public void setNumero_precio(int numero_precio) {
        this.numero_precio = numero_precio;
    }

    public String getListas() {
        return listas;
    }

    public void setListas(String listas) {
        this.listas = listas;
    }

    public int getId_domicilio() {
        return id_domicilio;
    }

    public void setId_domicilio(int id_domicilio) {
        this.id_domicilio = id_domicilio;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getSucursal() {
        return sucursal;
    }

    public void setSucursal(int sucursal) {
        this.sucursal = sucursal;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFecha_ultima_compra() {
        return fecha_ultima_compra;
    }

    public void setFecha_ultima_compra(String fecha_ultima_compra) {
        this.fecha_ultima_compra = fecha_ultima_compra;
    }

    public String getCalle_nueva() {
        return calle_nueva;
    }

    public void setCalle_nueva(String calle_nueva) {
        this.calle_nueva = calle_nueva;
    }

    public String getNumero_exterior_nuevo() {
        return numero_exterior_nuevo;
    }

    public void setNumero_exterior_nuevo(String numero_exterior_nuevo) {
        this.numero_exterior_nuevo = numero_exterior_nuevo;
    }

    public String getColonia_nueva() {
        return colonia_nueva;
    }

    public void setColonia_nueva(String colonia_nueva) {
        this.colonia_nueva = colonia_nueva;
    }

    public String getCodigo_postal_nuevo() {
        return codigo_postal_nuevo;
    }

    public void setCodigo_postal_nuevo(String codigo_postal_nuevo) {
        this.codigo_postal_nuevo = codigo_postal_nuevo;
    }

    public int getCiudad_nueva() {
        return ciudad_nueva;
    }

    public void setCiudad_nueva(int ciudad_nueva) {
        this.ciudad_nueva = ciudad_nueva;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public double getLatitud_nueva() {
        return latitud_nueva;
    }

    public void setLatitud_nueva(double latitud_nueva) {
        this.latitud_nueva = latitud_nueva;
    }

    public double getLongitud_nueva() {
        return longitud_nueva;
    }

    public void setLongitud_nueva(double longitud_nueva) {
        this.longitud_nueva = longitud_nueva;
    }

    public double getLatitud_anterior() {
        return latitud_anterior;
    }

    public void setLatitud_anterior(double latitud_anterior) {
        this.latitud_anterior = latitud_anterior;
    }

    public double getLongitud_anterior() {
        return longitud_anterior;
    }

    public void setLongitud_anterior(double longitud_anterior) {
        this.longitud_anterior = longitud_anterior;
    }

    public double getLimite_credito() {
        return limite_credito;
    }

    public void setLimite_credito(double limite_credito) {
        this.limite_credito = limite_credito;
    }

    public double getSaldo_actual() {
        return saldo_actual;
    }

    public void setSaldo_actual(double saldo_actual) {
        this.saldo_actual = saldo_actual;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNumero_exterior() {
        return numero_exterior;
    }

    public void setNumero_exterior(String numero_exterior) {
        this.numero_exterior = numero_exterior;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public int getId_ciudad() {
        return id_ciudad;
    }

    public void setId_ciudad(int id_ciudad) {
        this.id_ciudad = id_ciudad;
    }
}
