package com.uniajc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Pruebas para la clase Dragon
class DragonTest {

    // Reviso que el dragon se cree bien con sus datos
    @Test
    void testCreacionDragon() {
        Dragon d = new Dragon("Smaug", 120, 20, "Escamas");
        assertEquals("Smaug", d.getNombre());
        assertEquals(120, d.getSalud());
        assertEquals(20, d.getFuerza());
        assertEquals("Escamas", d.getEscamas());
    }

    // Las escamas le bajan 5 al dano, de 10 deberia recibir 5
    @Test
    void testDragonReduceDano() {
        Dragon d = new Dragon("Smaug", 120, 20, "Escamas");
        d.defender(10);
        assertEquals(115, d.getSalud());
    }

    // Si el dano es muy bajo no deberia curarse
    @Test
    void testDragonDanoNoNegativo() {
        Dragon d = new Dragon("Smaug", 120, 20, "Escamas");
        d.defender(3);
        assertEquals(120, d.getSalud());
    }

    // Con vida esta vivo, con 0 ya no
    @Test
    void testDragonEstaViva() {
        Dragon d = new Dragon("Smaug", 120, 20, "Escamas");
        assertTrue(d.estaViva());
        d.setSalud(0);
        assertFalse(d.estaViva());
    }

    // El dragon pega el doble (fuerza x2), asi que su ataque es mas fuerte
    @Test
    void testDragonAtaqueDoble() {
        Dragon d = new Dragon("Smaug", 100, 20, "Escamas");
        Guerrero objetivo = new Guerrero("Conan", 100, 10, "Espada");
        // fuerza 20 x2 = 40 de dano, el guerrero mitiga 3 -> recibe 37
        d.atacar(objetivo);
        assertEquals(63, objetivo.getSalud());
    }
}