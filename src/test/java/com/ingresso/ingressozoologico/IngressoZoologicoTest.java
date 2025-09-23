package com.ingresso.ingressozoologico;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
// TESTES:
// Todas as faixas etárias.
// Quantidade negativa ajustada para zero.
// Quantidade de ingresso > 5, ajustada para 5.
// Idade negativa ajustada para zero.
public class IngressoZoologicoTest {
    // ByteArrayOutputStream é pra capturar o que é impresso no System.out, permitindo validar as mensagens exibidas.
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testPrecoCrianca() {
        IngressoZoologico.simulaPreco(10, 2);
        String saida = outputStreamCaptor.toString().trim();
        assertTrue(saida.contains("Pagará preco com desconto"));
        assertTrue(saida.contains("R$20"));
    }

    @Test
    void testPrecoAdulto() {
        IngressoZoologico.simulaPreco(30, 3);
        String saida = outputStreamCaptor.toString().trim();
        assertTrue(saida.contains("Pagará preco inteiro"));
        assertTrue(saida.contains("R$90")); //  para 3
    }

    @Test
    void testPrecoIdoso() {
        IngressoZoologico.simulaPreco(65, 4);
        String saida = outputStreamCaptor.toString().trim();
        assertTrue(saida.contains("Pagará preco de meia"));
        assertTrue(saida.contains("R$60")); // para 4
    }

    @Test
    void testPrecoQuantidadeNegativa() {
        IngressoZoologico.simulaPreco(25, -3);
        String saida = outputStreamCaptor.toString().trim();
        assertTrue(saida.contains("R$0")); // ajusta para 0
    }

    @Test
    void testPrecoQuantidadeMaiorQue5() {
        IngressoZoologico.simulaPreco(25, 10);
        String saida = outputStreamCaptor.toString().trim();
        assertTrue(saida.contains("R$150")); // limitado a 5 ingressos * 30
    }

    @Test
    void testComprarIngresso() {
        Pessoa pessoa = new Pessoa("Carlos", 20);
        pessoa.comprarIngresso(2);

        outputStreamCaptor.reset();

        IngressoZoologico.comprarIngresso(pessoa, 5); // Tentativa acima do máximo

        assertEquals(2, pessoa.getIngresso());
    }

    @Test
    void testPrecoIdadeNegativa() {
        IngressoZoologico.simulaPreco(-5, 2);
        String saida = outputStreamCaptor.toString().trim();
        assertTrue(saida.contains("Pagará preco com desconto")); // idade ajustada para 0 == criança
    }
}
