package com.uniajc;

import java.util.ArrayList;
import java.util.List;

public abstract class Criatura {
    protected String nombre;
    protected int salud;
    protected int fuerza;
    // Composición: una criatura puede portar 0, 1 o varias armas
    protected List<Arma> armas;

    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = Math.max(0, salud);
        this.fuerza = Math.max(0, fuerza);
        this.armas = new ArrayList<>();
    }

    public boolean estaViva() {
        return this.salud > 0;
    }

    // Permite agregar un arma al inventario de la criatura
    public void equiparArma(Arma arma) {
        if (arma != null) {
            this.armas.add(arma);
            System.out.println(this.nombre + " ha equipado: " + arma.getNombre() + " (+" + arma.getDañoAdicional() + " daño).");
        }
    }

    // Suma el daño de todas las armas equipadas
    public int calcularDañoExtraArmas() {
        int dañoTotal = 0;
        for (Arma a : armas) {
            dañoTotal += a.getDañoAdicional();
        }
        return dañoTotal;
    }

    public abstract void atacar(Criatura objetivo);
    public abstract void defender(int daño);

    // Getters y Setters
    public String getNombre() { return nombre; }
    public int getSalud() { return salud; }
    public void setSalud(int salud) { this.salud = Math.max(0, salud); }
    public int getFuerza() { return fuerza; }
    public void setFuerza(int fuerza) { this.fuerza = Math.max(0, fuerza); }
    public List<Arma> getArmas() { return armas; }
}