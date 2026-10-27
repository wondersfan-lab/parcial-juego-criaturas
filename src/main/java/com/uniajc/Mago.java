package com.uniajc;

// Mago: subclase concreta de Criatura. Ataca a distancia con hechizos.
public class Mago extends Criatura {

    private String hechizos; // atributo propio del Mago

    // Constructor: usa super(...) para los datos heredados y asigna los hechizos
    public Mago(String nombre, int salud, int fuerza, String hechizos) {
        super(nombre, salud, fuerza);
        this.hechizos = hechizos;
    }

    // Ataque propio del Mago: lanza un hechizo y aplica su fuerza como daño
    @Override
    public void atacar(Criatura objetivo) {
        System.out.println(this.nombre + " lanza el hechizo '" + this.hechizos
                + "' sobre " + objetivo.getNombre() + ".");
        objetivo.defender(this.fuerza);
    }

    // Defensa propia: el escudo de maná reduce el daño recibido en 2 puntos
    @Override
    public void defender(int daño) {
        int dañoReal = Math.max(0, daño - 2);
        this.salud -= dañoReal;
        System.out.println(this.nombre + " recibe " + dañoReal
                + " de daño. Vida restante: " + this.salud);
    }

    // Getter de los hechizos
    public String getHechizos() {
        return this.hechizos;
    }
}