package com.mds.ventasabpollo.models;


import io.realm.RealmObject;

public class NewClients extends RealmObject {

    private int id;
    private String nombre_cliente;
    private String nombre_comercial;
    private String rfc;
    private String curp;
    private String forma_pago;
    private String no_cuenta;
    private String uso_cfdi;
    private String metodo_pago;
    private String correo_electronico;
    private String nombre_contacto;
    private String apellido_contacto;
    private String nombre_calle;
    private String no_exterior;
    private String no_interior;
    private String colonia;
    private String codigo_postal;
    private int ciudad;
    private String telefono;
    private String descripcion;
    private String localidad;
    private String municipio;
    private String fecha_registro;
    private double latitud;
    private double longitud;
    private int id_db;
    private boolean borrador;
    private boolean sincronizado;
    private String fecha_sincronizado;

    public NewClients() {
    }

    public NewClients(
            int     id,
            String nombre_cliente,
            String nombre_comercial,
            String rfc,
            String curp,
            String forma_pago,
            String no_cuenta,
            String uso_cfdi,
            String metodo_pago,
            String correo_electronico,
            String nombre_contacto,
            String apellido_contacto,
            String nombre_calle,
            String no_exterior,
            String no_interior,
            String colonia,
            String codigo_postal,
            int     ciudad,
            String telefono,
            String descripcion,
            String localidad,
            String municipio,
            String fecha_registro,
            int     id_db,
            boolean borrador,
            boolean sincronizado,
            String fecha_sincronizado) {

            this.id = id;
            this.nombre_cliente = nombre_cliente;
            this.nombre_comercial = nombre_comercial;
            this.rfc = rfc;
            this.curp = curp;
            this.forma_pago = forma_pago;
            this.no_cuenta = no_cuenta;
            this.uso_cfdi = uso_cfdi;
            this.metodo_pago = metodo_pago;
            this.correo_electronico = correo_electronico;
            this.nombre_contacto = nombre_contacto;
            this.apellido_contacto = apellido_contacto;
            this.nombre_calle = nombre_calle;
            this.no_exterior = no_exterior;
            this.no_interior = no_interior;
            this.colonia = colonia;
            this.codigo_postal = codigo_postal;
            this.ciudad = ciudad;
            this.telefono = telefono;
            this.descripcion = descripcion;
            this.localidad = localidad;
            this.municipio = municipio;
            this.fecha_registro = fecha_registro;
            this.id_db = id_db;
            this.borrador = borrador;
            this.sincronizado = sincronizado;
            this.fecha_sincronizado = fecha_sincronizado;
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

    public String getNombre_comercial() {
        return nombre_comercial;
    }

    public void setNombre_comercial(String nombre_comercial) {
        this.nombre_comercial = nombre_comercial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_cliente() {
        return nombre_cliente;
    }

    public void setNombre_cliente(String nombre_cliente) {
        this.nombre_cliente = nombre_cliente;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getForma_pago() {
        return forma_pago;
    }

    public void setForma_pago(String forma_pago) {
        this.forma_pago = forma_pago;
    }

    public String getNo_cuenta() {
        return no_cuenta;
    }

    public void setNo_cuenta(String no_cuenta) {
        this.no_cuenta = no_cuenta;
    }

    public String getUso_cfdi() {
        return uso_cfdi;
    }

    public void setUso_cfdi(String uso_cfdi) {
        this.uso_cfdi = uso_cfdi;
    }

    public String getMetodo_pago() {
        return metodo_pago;
    }

    public void setMetodo_pago(String metodo_pago) {
        this.metodo_pago = metodo_pago;
    }

    public String getCorreo_electronico() {
        return correo_electronico;
    }

    public void setCorreo_electronico(String correo_electronico) {
        this.correo_electronico = correo_electronico;
    }

    public String getNombre_contacto() {
        return nombre_contacto;
    }

    public void setNombre_contacto(String nombre_contacto) {
        this.nombre_contacto = nombre_contacto;
    }

    public String getApellido_contacto() {
        return apellido_contacto;
    }

    public void setApellido_contacto(String apellido_contacto) {
        this.apellido_contacto = apellido_contacto;
    }

    public String getNombre_calle() {
        return nombre_calle;
    }

    public void setNombre_calle(String nombre_calle) {
        this.nombre_calle = nombre_calle;
    }

    public String getNo_exterior() {
        return no_exterior;
    }

    public void setNo_exterior(String no_exterior) {
        this.no_exterior = no_exterior;
    }

    public String getNo_interior() {
        return no_interior;
    }

    public void setNo_interior(String no_interior) {
        this.no_interior = no_interior;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public int getCiudad() {
        return ciudad;
    }

    public void setCiudad(int ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getFecha_registro() {
        return fecha_registro;
    }

    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }

    public int getId_db() {
        return id_db;
    }

    public void setId_db(int id_db) {
        this.id_db = id_db;
    }

    public boolean isBorrador() {
        return borrador;
    }

    public void setBorrador(boolean borrador) {
        this.borrador = borrador;
    }

    public boolean isSincronizado() {
        return sincronizado;
    }

    public void setSincronizado(boolean sincronizado) {
        this.sincronizado = sincronizado;
    }

    public String getFecha_sincronizado() {
        return fecha_sincronizado;
    }

    public void setFecha_sincronizado(String fecha_sincronizado) {
        this.fecha_sincronizado = fecha_sincronizado;
    }
}
