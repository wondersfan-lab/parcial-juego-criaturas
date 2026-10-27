package com.uniajc;

public abstract class Criatura {
    // Encapsulamiento: atributos protegidos para que las subclases los hereden
    protected String nombre;
    protected int salud;
    protected int fuerza;

    
    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = Math.max(0, salud);
        this.fuerza = Math.max(0, fuerza);
    }

    
    public boolean estaViva() {
        return this.salud > 0;
    }

   
    public abstract void atacar(Criatura objetivo);
    public abstract void defender(int daño);

     
    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = Math.max(0, salud);
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = Math.max(0, fuerza);
    }
}