package com.uniajc;

public class Arma {
    private String nombre;
    private int dañoAdicional;

    public Arma(String nombre, int dañoAdicional) {
        this.nombre = nombre;
        this.dañoAdicional = Math.max(0, dañoAdicional);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDañoAdicional() {
        return dañoAdicional;
    }

    public void setDañoAdicional(int dañoAdicional) {
        this.dañoAdicional = Math.max(0, dañoAdicional);
    }
}