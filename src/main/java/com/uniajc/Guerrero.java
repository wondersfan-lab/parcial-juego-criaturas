package com.uniajc;

// Guerrero: subclase concreta de Criatura. Ataca cuerpo a cuerpo con un arma.
public class Guerrero extends Criatura {

    private String arma; // atributo propio del Guerrero

    // Constructor: usa super(...) para los datos heredados y asigna el arma
    public Guerrero(String nombre, int salud, int fuerza, String arma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
    }

    // Ataque propio del Guerrero: golpea con su arma y aplica su fuerza como daño
    @Override
    public void atacar(Criatura objetivo) {
        System.out.println(this.nombre + " ataca con su " + this.arma
                + " a " + objetivo.getNombre() + ".");
        objetivo.defender(this.fuerza);
    }

    // Defensa propia: la armadura reduce el daño recibido en 3 puntos
    @Override
    public void defender(int daño) {
        int dañoReal = Math.max(0, daño - 3);
        this.salud -= dañoReal;
        System.out.println(this.nombre + " recibe " + dañoReal
                + " de daño. Vida restante: " + this.salud);
    }

    // Getter del arma
    public String getArma() {
        return this.arma;
    }
}