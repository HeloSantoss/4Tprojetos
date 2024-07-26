package com.exemple;

//import das bibliotecas junit
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class CalculadoraTest {
    Calculadora calc;

    @Before
    public void setUp() {
        calc = new Calculadora();
    }

    @Test
    public void testSoma() {
        assertEquals(7, calc.soma(3, 4));
    }

    @Test
    public void testSubtracao() {
        assertEquals(1, calc.subtracao(3, 2));
    }

    @Test
    public void testMultiplicacao() {
        assertEquals(12, calc.multiplicacao(3, 4));
    }

    @Test
    public void testDivisao() {
        assertEquals(1.5, calc.divisao(3, 2), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivisaoPorZero() {
        calc.divisao(3, 0);
    }
    
    @Test
    public void testRaizQuadrada() {
        assertEquals(2.0, calc.raizQuadrada(4), 0.001);
        assertEquals(3.0, calc.raizQuadrada(9), 0.001);
        assertEquals(5.0, calc.raizQuadrada(25), 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRaizQuadradaNegativa() {
        calc.raizQuadrada(-1);
    }
}
