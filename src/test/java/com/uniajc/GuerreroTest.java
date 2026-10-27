package com.uniajc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Pruebas para la clase Guerrero
class GuerreroTest {

    // Reviso que el guerrero se cree bien con sus datos
    @Test
    void testCreacionGuerrero() {
        Guerrero g = new Guerrero("Conan", 100, 18, "Espada");
        assertEquals("Conan", g.getNombre());
        assertEquals(100, g.getSalud());
        assertEquals(18, g.getFuerza());
        assertEquals("Espada", g.getArma());
    }

    // La armadura le baja 3 al dano, asi que de 10 deberia recibir 7
    @Test
    void testGuerreroReduceDano() {
        Guerrero g = new Guerrero("Conan", 100, 18, "Espada");
        g.defender(10);
        assertEquals(93, g.getSalud());
    }

    // Si el dano es muy bajo no deberia curarse, la vida queda igual
    @Test
    void testGuerreroDanoNoNegativo() {
        Guerrero g = new Guerrero("Conan", 100, 18, "Espada");
        g.defender(2);
        assertEquals(100, g.getSalud());
    }

    // Con vida esta vivo, con 0 ya no
    @Test
    void testGuerreroEstaViva() {
        Guerrero g = new Guerrero("Conan", 100, 18, "Espada");
        assertTrue(g.estaViva());
        g.setSalud(0);
        assertFalse(g.estaViva());
    }

    // Si le equipo un arma extra deberia pegar mas duro
    @Test
    void testGuerreroConArmaHaceMasDano() {
        Guerrero g = new Guerrero("Conan", 100, 18, "Espada");
        Mago objetivo = new Mago("Gandalf", 100, 10, "Rayo");
        g.atacar(objetivo);
        int saludSinArma = objetivo.getSalud();

        Guerrero g2 = new Guerrero("Conan", 100, 18, "Espada");
        Mago objetivo2 = new Mago("Gandalf", 100, 10, "Rayo");
        g2.equiparArma(new Arma("Hacha de Guerra", 7));
        g2.atacar(objetivo2);

        // El segundo objetivo deberia quedar con menos vida
        assertTrue(objetivo2.getSalud() < saludSinArma);
    }
}