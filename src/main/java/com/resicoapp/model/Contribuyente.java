package com.resicoapp.model;

public class Contribuyente {
    private int id;
    private String rfc;
    private String nombre;

    public Contribuyente() {

    }

    public Contribuyente(String rfc, String nombre) {
        this.rfc = rfc;
        this.nombre = nombre;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getRfc() { return rfc; }
    public void setRfc(String rfc) { this.rfc = rfc; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
}
