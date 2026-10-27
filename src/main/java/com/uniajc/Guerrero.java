package com.uniajc;

// Guerrero: subclase concreta de Criatura. Pelea cuerpo a cuerpo con un arma
// y puede potenciar su ataque con las armas que tenga equipadas (composición).
public class Guerrero extends Criatura {

    private String arma; // nombre del arma principal del Guerrero

    // Constructor: usa super(...) para los datos heredados y asigna el arma
    public Guerrero(String nombre, int salud, int fuerza, String arma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
    }

    // Ataque propio del Guerrero: fuerza base + daño de las armas equipadas
    @Override
    public void atacar(Criatura objetivo) {
        int dañoGenerado = this.fuerza + calcularDañoExtraArmas();
        System.out.println(this.nombre + " ataca con su " + this.arma
                + " a " + objetivo.getNombre() + " causando " + dañoGenerado + " de daño potencial.");
        objetivo.defender(dañoGenerado);
    }

    // Defensa propia: la armadura reduce el daño recibido en 3 puntos
    @Override
    public void defender(int daño) {
        int dañoMitigado = Math.max(0, daño - 3);
        this.salud = Math.max(0, this.salud - dañoMitigado);
        System.out.println(this.nombre + " se cubre con su armadura. Recibe " + dañoMitigado
                + " de daño. Salud restante: " + this.salud);
    }

    // Getter del atributo propio
    public String getArma() { return arma; }
    public void setArma(String arma) { this.arma = arma; }
}