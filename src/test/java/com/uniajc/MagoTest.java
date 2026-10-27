package com.uniajc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Pruebas para la clase Mago
class MagoTest {

    // Reviso que el mago se cree bien con los datos que le paso
    @Test
    void testCreacionMago() {
        Mago mago = new Mago("Gandalf", 80, 25, "Rayo Arcano");
        assertEquals("Gandalf", mago.getNombre());
        assertEquals(80, mago.getSalud());
        assertEquals(25, mago.getFuerza());
        assertEquals("Rayo Arcano", mago.getHechizos());
    }

    // El escudo de mana le baja 2 al dano, asi que de 10 deberia recibir 8
    @Test
    void testMagoReduceDano() {
        Mago mago = new Mago("Gandalf", 80, 25, "Rayo Arcano");
        mago.defender(10);
        assertEquals(72, mago.getSalud());
    }

    // Si el dano es muy bajo no deberia curarse, la vida se queda igual
    @Test
    void testMagoDanoNoNegativo() {
        Mago mago = new Mago("Gandalf", 80, 25, "Rayo Arcano");
        mago.defender(1);
        assertEquals(80, mago.getSalud());
    }

    // Con vida deberia estar vivo, y con 0 ya no
    @Test
    void testMagoEstaViva() {
        Mago mago = new Mago("Gandalf", 80, 25, "Rayo Arcano");
        assertTrue(mago.estaViva());
        mago.setSalud(0);
        assertFalse(mago.estaViva());
    }

    // Si le pongo una varita deberia pegar mas duro que sin ella
    @Test
    void testMagoConVaritaHaceMasDano() {
        Mago mago = new Mago("Gandalf", 80, 25, "Rayo Arcano");
        Guerrero objetivo = new Guerrero("Conan", 100, 10, "Espada");
        mago.atacar(objetivo);
        int saludSinArma = objetivo.getSalud();

        Mago mago2 = new Mago("Gandalf", 80, 25, "Rayo Arcano");
        Guerrero objetivo2 = new Guerrero("Conan", 100, 10, "Espada");
        mago2.equiparArma(new Arma("Varita Magica", 5));
        mago2.atacar(objetivo2);

        // El segundo objetivo deberia quedar con menos vida
        assertTrue(objetivo2.getSalud() < saludSinArma);
    }
}