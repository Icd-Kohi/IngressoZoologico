package com.ingresso.ingressozoologico;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
// TESTES Classe Pessoa
// Construtores.
// Métodos de preços (`precoInteiro`, `precoReduzido`, `precoMeia`).
// Checagem de saída para cada faixa etária.
// `comprarIngresso` dentro do limite, acima e acumulado.
// `custoPessoa` para criança, adulto e idoso.
// Variações para checagem do método `toString`.

public class PessoaTest {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testConstrutorComNomeEIdadeValida() {
        Pessoa p = new Pessoa("Ana", 25);
        assertEquals("Ana", p.getNome());
        assertEquals(25, p.getIdade());
        assertEquals(0, p.getIngresso());
    }

    @Test
    void testConstrutorComNomeEIdadeInvalida() {
        Pessoa p = new Pessoa("Carlos", -5);
        assertEquals("Carlos", p.getNome());
        assertEquals(0, p.getIdade());
    }

    @Test
    void testConstrutorSoIdadeValida() {
        Pessoa p = new Pessoa(10);
        assertEquals("", p.getNome());
        assertEquals(10, p.getIdade());
    }

    @Test
    void testConstrutorSoIdadeInvalida() {
        Pessoa p = new Pessoa(-1);
        assertEquals(0, p.getIdade());
        assertEquals("", p.getNome());
    }

    @Test
    void testPrecoInteiro() {
        Pessoa p = new Pessoa("Lucas", 30);
        assertTrue(p.precoInteiro());
        assertFalse(p.precoReduzido());
        assertFalse(p.precoMeia());
    }

    @Test
    void testPrecoReduzido() {
        Pessoa p = new Pessoa("Mariana", 10);
        assertTrue(p.precoReduzido());
        assertFalse(p.precoInteiro());
        assertFalse(p.precoMeia());
    }

    @Test
    void testPrecoMeia() {
        Pessoa p = new Pessoa("José", 70);
        assertTrue(p.precoMeia());
        assertFalse(p.precoInteiro());
        assertFalse(p.precoReduzido());
    }

    @Test
    void testChecaPrecoCrianca() {
        Pessoa p = new Pessoa("Criança", 8);
        p.checaPreco();
        String saida = outputStreamCaptor.toString().trim();
        assertTrue(saida.contains("Idade <= 12"));
    }

    @Test
    void testChecaPrecoAdulto() {
        Pessoa p = new Pessoa("Adulto", 40);
        p.checaPreco();
        String saida = outputStreamCaptor.toString().trim();
        assertTrue(saida.contains("Preço Inteiro"));
    }

    @Test
    void testChecaPrecoIdoso() {
        Pessoa p = new Pessoa("Idoso", 65);
        p.checaPreco();
        String saida = outputStreamCaptor.toString().trim();
        assertTrue(saida.contains("Idade >= 60"));
    }

    @Test
    void testComprarIngressoDentroDoLimite() {
        Pessoa p = new Pessoa("Pedro", 20);
        p.comprarIngresso(3);
        assertEquals(3, p.getIngresso());
    }

    @Test
    void testComprarMaisQue5IngressosDeUmaVez() {
        Pessoa p = new Pessoa("Maria", 22);
        p.comprarIngresso(6);
        assertEquals(0, p.getIngresso()); // não comprou nada
        String saida = outputStreamCaptor.toString().trim();
        assertTrue(saida.contains("Não pode comprar mais que 5 ingressos"));
    }

    @Test
    void testComprarIngressosAcumulandoExcedeLimite() {
        Pessoa p = new Pessoa("João", 22);
        p.comprarIngresso(4);
        p.comprarIngresso(3); // tentará ultrapassar 5
        assertEquals(4, p.getIngresso()); // não passou do limite
        String saida = outputStreamCaptor.toString().trim();
        assertTrue(saida.contains("Quantidade de ingresso excedido"));
    }

    @Test
    void testCustoPessoaPrecoInteiro() {
        Pessoa p = new Pessoa("Clara", 35);
        p.comprarIngresso(2);
        assertEquals(60, p.custoPessoa()); // 2 * 30
    }

    @Test
    void testCustoPessoaPrecoReduzido() {
        Pessoa p = new Pessoa("Luan", 10);
        p.comprarIngresso(3);
        assertEquals(30, p.custoPessoa()); // 3 * 10
    }

    @Test
    void testCustoPessoaPrecoMeia() {
        Pessoa p = new Pessoa("Helena", 70);
        p.comprarIngresso(2);
        assertEquals(30, p.custoPessoa()); // 2 * 15
    }

    @Test
    void testToString() {
        Pessoa p = new Pessoa("Bruno", 25);
        p.comprarIngresso(2);
        String str = p.toString();
        assertTrue(str.contains("Nome: Bruno"));
        assertTrue(str.contains("Idade: 25"));
        assertTrue(str.contains("Qtd Ingressos: 2"));
        assertTrue(str.contains("Valor total: R$60"));
    }
}

