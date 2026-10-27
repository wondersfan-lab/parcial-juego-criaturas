package com.uniajc;

// Mago: subclase concreta de Criatura. Ataca a distancia con hechizos
// y puede potenciar su ataque con las armas que tenga equipadas (ej: una varita).
public class Mago extends Criatura {

    private String hechizos; // atributo propio del Mago

    // Constructor: usa super(...) para los datos heredados y asigna los hechizos
    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
    }

    // Ataque propio del Mago: fuerza base + daño de las armas equipadas (composición)
    @Override
    public void atacar(Criatura objetivo) {
        int dañoGenerado = this.fuerza + calcularDañoExtraArmas();
        System.out.println(this.nombre + " lanza el hechizo '" + this.hechizos
                + "' sobre " + objetivo.getNombre() + " causando " + dañoGenerado + " de daño potencial.");
        objetivo.defender(dañoGenerado);
    }

    // Defensa propia: el escudo de maná reduce el daño recibido en 2 puntos
    @Override
    public void defender(int daño) {
        int dañoMitigado = Math.max(0, daño - 2);
        this.salud = Math.max(0, this.salud - dañoMitigado);
        System.out.println(this.nombre + " se protege con su escudo de maná. Recibe " + dañoMitigado
                + " de daño. Salud restante: " + this.salud);
    }

    // Getter del atributo propio
    public String getHechizos() { return hechizos; }
    public void setHechizos(String hechizos) { this.hechizos = hechizos; }
}