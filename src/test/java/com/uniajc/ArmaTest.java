package com.uniajc;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

// Pruebas para la clase Arma
class ArmaTest {

    // Reviso que el arma guarde bien su nombre y su dano
    @Test
    void testCreacionArma() {
        Arma arma = new Arma("Varita Magica", 5);
        assertEquals("Varita Magica", arma.getNombre());
        assertEquals(5, arma.getDañoAdicional());
    }

    // Si le paso un dano negativo deberia quedar en 0, no en negativo
    @Test
    void testArmaDanoNoNegativo() {
        Arma arma = new Arma("Arma Rota", -3);
        assertEquals(0, arma.getDañoAdicional());
    }

    // Si cambio el dano con el setter deberia actualizarse
    @Test
    void testArmaSetter() {
        Arma arma = new Arma("Espada", 2);
        arma.setDañoAdicional(10);
        assertEquals(10, arma.getDañoAdicional());
    }
}