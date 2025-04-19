package com.pruebaSabado.UnitTesting;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

class Calculadora {
	
    public int sumar(int a, int b) {
        return a + b;
    }
    public int multiplicacion(int a, int b) {
    	return a * b;
    }
  
    void conectar() { System.out.println("Conectando..."); }
    void desconectar() { System.out.println("Desconectando..."); }
    
    Calculadora db;

    @BeforeEach
    void setUp() {
        db = new Calculadora();
        db.conectar();
    }

    @AfterEach
    void tearDown() {
        db.desconectar();
    }
    
    @Test
    void testSumar() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.sumar(2, 3));
    }
    
    @Test
    void testSumar2() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.sumar(2, 3));
    }
    
    @Test
    void testMultiplicar() {
    	Calculadora calc = new Calculadora();
    	assertEquals(5, calc.multiplicacion(1, 5));
    }
    
    @Test
    void testDivisionPorCero() {
        Assertions.assertThrows(ArithmeticException.class, () -> {
            int resultado = 10 / 0;
        });
    }

    @Test
    void testEsPar() {
        int numero = 6;
        Assertions.assertTrue(numero % 2 == 0);
    }

    
    @Test
    void testNoEsPar() {
        int numero = 7;
        Assertions.assertFalse(numero % 2 == 0);
    }

    @Test
    void testValorNulo() {
        String texto = null;
        Assertions.assertNull(texto);
    }

    @Test
    void testValorNoNulo() {
        String texto = "Hola";
        Assertions.assertNotNull(texto);
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 4, 6, 8})
    void testNumerosPares(int numero) {
        Assertions.assertTrue(numero % 2 == 0);
    }

    @Test
    void testMultiplesValores() {
        int numero = 10;
        Assertions.assertAll(
            () -> Assertions.assertTrue(numero > 5),
            () -> Assertions.assertEquals(10, numero),
            () -> Assertions.assertNotNull(numero)
        );
    }

    
    @Disabled("No implementada todavía")
    @Test
    void testNoImplementada() {
        // Lógica pendiente
    }

    
    
    
}
