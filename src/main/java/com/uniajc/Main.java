package com.uniajc;

public class Main {

    // Método polimórfico: opera sobre la abstracción Criatura sin depender del tipo específico
    public static void simularBatalla(Criatura c1, Criatura c2) {
        System.out.println("==================================================");
        System.out.println("   COMIENZA EL COMBATE: " + c1.getNombre() + " VS " + c2.getNombre());
        System.out.println("==================================================");

        int turno = 1;

        // Bucle por turnos mientras ambas sigan en pie
        while (c1.estaViva() && c2.estaViva()) {
            System.out.println("\n--- Turno " + turno + " ---");

            // Turno c1
            c1.atacar(c2);
            if (!c2.estaViva()) {
                System.out.println("\n ¡" + c2.getNombre() + " ha sido derrotado!");
                System.out.println(" Ganador: " + c1.getNombre());
                break;
            }

            // Turno c2
            c2.atacar(c1);
            if (!c1.estaViva()) {
                System.out.println("\n ¡" + c1.getNombre() + " ha sido derrotado!");
                System.out.println(" Ganador: " + c2.getNombre());
                break;
            }

            turno++;
        }

        System.out.println("==================================================\n");
    }

    public static void main(String[] args) {
        // Polimorfismo:
        Criatura dragon = new Dragon("Smaug", 120, 20, "Escamas de Obsidiana");
        Criatura guerrero = new Guerrero("Aragorn", 100, 18, "Espada Andúril");
        Criatura mago = new Mago("Gandalf", 80, 25, "Rayo Arcano");

        // Batalla 1: Dragón vs Guerrero
        simularBatalla(dragon, guerrero);

        // Batalla 2: Mago vs nuevo Dragón
        Criatura dragonRojo = new Dragon("Balerion", 110, 22, "Escamas Volcánicas");
        simularBatalla(mago, dragonRojo);
    }
}