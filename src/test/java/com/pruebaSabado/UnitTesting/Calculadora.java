package com.pruebaSabado.UnitTesting;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class Calculadora {
	
    public int sumar(int a, int b) {
        return a + b;
    }
    
  
    
    @Test
    void testSumar() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.sumar(2, 3));
    }
    
    
    
    
 
    
    
    
   
    
}
