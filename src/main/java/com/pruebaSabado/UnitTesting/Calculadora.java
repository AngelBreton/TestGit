package com.pruebaSabado.UnitTesting;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

//import com.pruebaSabado.model.Usuario;
//import com.pruebaSabado.repo.UsuarioRepositorio;
//import com.pruebaSabado.service.UsuarioService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.*;


//import org.



//@ExtendWith(MockitoExtension.class)
class Calculadora {
	
	private int valor = 0;
    public synchronized void incrementar() { valor++; }
    public int getValor() { return valor; }
	
    public int sumar(int a, int b) {
        return a + b;
    }
    
    public int dividir(int a, int b) {
        if (b == 0) throw new ArithmeticException("División por cero");
        return a / b;
    }
    
    public String invertirCadena(String input) {
        return new StringBuilder(input).reverse().toString();
    }
    
    public List<Integer> obtenerPares(List<Integer> lista) {
        return lista.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
    }
    
    public boolean esFechaFutura(LocalDate fecha) {
        return fecha.isAfter(LocalDate.now());
    }
    
    public boolean esPrimo(int numero) {
        if (numero <= 1) return false;
        for (int i = 2; i < numero; i++) {
            if (numero % i == 0) return false;
        }
        return true;
    }
    
    public int calcularSalario(int horas) {
        return Math.max(0, Math.min(horas, 40)) * 20;
    }
    
    private String nombre;
    public void Usuario(String nombre) { 
    	this.nombre = nombre; 
    	}
    public String getNombre() { 
    	return nombre; 
    	}
    //Test JUnit
    
    @Test
    void testSumar() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.sumar(2, 3));
    }
    
    @Test
    void testDividirPorCero() {
        Calculadora calc = new Calculadora();
        assertThrows(ArithmeticException.class, () -> calc.dividir(5, 0));
    }
    
    @Test
    void testInvertirCadena() {
        Calculadora util = new Calculadora();
        assertEquals("odnum", util.invertirCadena("mundo"));
    }
    
    @Test
    void testObtenerPares() {
    	Calculadora util = new Calculadora();
        List<Integer> resultado = util.obtenerPares(List.of(1, 2, 3, 4, 5, 6));
        assertEquals(List.of(2, 4, 6), resultado);
    }
    
    @Test
    void testEsFechaFutura() {
        Calculadora util = new Calculadora();
        assertTrue(util.esFechaFutura(LocalDate.now().plusDays(1)));
    }
    
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 5, 7, 11})
    void testEsPrimo(int numero) {
        Calculadora mat = new Calculadora();
        assertEquals(true, mat.esPrimo(numero));
    }
    
    @Test
    void testSalarioLimites() {
    	Calculadora emp = new Calculadora();
        assertEquals(0, emp.calcularSalario(0));
        assertEquals(800, emp.calcularSalario(40));
    }
    
    @Test
    void testIncrementar() throws InterruptedException {
    	Calculadora contador = new Calculadora();
        Thread t1 = new Thread(contador::incrementar);
        Thread t2 = new Thread(contador::incrementar);

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        assertEquals(2, contador.getValor());
    }
    
    
    
 
    
    
    
   
    
}
