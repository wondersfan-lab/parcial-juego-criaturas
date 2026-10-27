package com.uniajc;

public class Main {

    // Método polimórfico: recibe referencias abstractas de tipo Criatura
    public static void simularBatalla(Criatura c1, Criatura c2) {
        System.out.println("==================================================");
        System.out.println("   COMIENZA EL COMBATE: " + c1.getNombre() + " VS " + c2.getNombre());
        System.out.println("==================================================");

        int turno = 1;

        // Bucle por turnos mientras ambas criaturas permanezcan vivas
        while (c1.estaViva() && c2.estaViva()) {
            System.out.println("\n--- Turno " + turno + " ---");

            // Turno de ataque de la criatura 1
            c1.atacar(c2);
            if (!c2.estaViva()) {
                System.out.println("\n ¡" + c2.getNombre() + " ha sido derrotado!");
                System.out.println(" Ganador: " + c1.getNombre());
                break;
            }

            // Contraataque de la criatura 2
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
        // 1. Instanciación polimórfica (tipo base = subtipo concreto)
        Criatura dragon = new Dragon("Smaug", 130, 18, "Escamas de Obsidiana");
        Criatura guerrero = new Guerrero("Aragorn", 110, 16, "Espada Andúril");
        Criatura mago = new Mago("Gandalf", 90, 22, "Rayo Arcano");

        // 2. Creación de armas (Composición)
        Arma garraTitan = new Arma("Garras de Fuego", 6);
        Arma gemaCaos = new Arma("Gema del Vacío", 8);
        Arma filoRunico = new Arma("Daga Élfica", 5);
        Arma varita = new Arma("Varita de Sauco", 12);

        // 3. Equipamiento de armas (0, 1 o varias por criatura)
        System.out.println("=== EQUIPANDO ARMAMENTO (COMPOSICIÓN) ===");
        // Dragón equipa múltiples armas
        dragon.equiparArma(garraTitan);
        dragon.equiparArma(gemaCaos);

        // Guerrero equipa un arma extra
        guerrero.equiparArma(filoRunico);

        // Mago equipa su varita
        mago.equiparArma(varita);
        System.out.println("=========================================\n");

        // 4. Ejecución de las batallas
        simularBatalla(dragon, guerrero);

        // Segunda batalla con una nueva instancia
        Criatura dragonJoven = new Dragon("Balerion", 100, 15, "Escamas Rojas");
        simularBatalla(mago, dragonJoven);
    }
}