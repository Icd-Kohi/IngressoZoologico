package com.ingresso.ingressozoologico;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
// TESTES Classe Zoologico:
// Adiciona pessoa.
// Se adiciona `null`, não adiciona nada.
// Adidiona uma lista de Pessoas.
// Tenta adicionar uma lista `null`.
// `printPessoa` com pessoas, retorna o index e nomes.
// `printPessoa` vazio retorna -> [].
// `buscarPessoa` imprime pessoa certa no System.out.
// `toString` com pessoas concatena o `toString`de cada pessoa.
// `toString` vazio gera string vazia.
public class ZoologicoTest {

    private Zoologico zoologico;
    // Novamente para capturar a saída do que é impresso no System.out para validação.
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        zoologico = new Zoologico();
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    void testAdicionarPessoa() {
        Pessoa p = new Pessoa("Ana", 25);
        zoologico.adicionarPessoa(p);

        assertEquals(1, zoologico.getListaDePessoas().size());
        assertEquals("Ana", zoologico.getListaDePessoas().get(0).getNome());
    }

    @Test
    void testAdicionarPessoaNula() {
        zoologico.adicionarPessoa(null);
        assertTrue(zoologico.getListaDePessoas().isEmpty());
    }

    @Test
    void testAdicionarListaDePessoas() {
        ArrayList<Pessoa> lista = new ArrayList<>();
        lista.add(new Pessoa("Carlos", 30));
        lista.add(new Pessoa("Maria", 20));

        zoologico.adicionarListaDePessoas(lista);

        assertEquals(2, zoologico.getListaDePessoas().size());
        assertEquals("Carlos", zoologico.getListaDePessoas().get(0).getNome());
        assertEquals("Maria", zoologico.getListaDePessoas().get(1).getNome());
    }

    @Test
    void testAdicionarListaNula() {
        zoologico.adicionarListaDePessoas(null);
        assertTrue(zoologico.getListaDePessoas().isEmpty());
    }

    @Test
    void testPrintPessoa() {
        zoologico.adicionarPessoa(new Pessoa("Lucas", 15));
        zoologico.adicionarPessoa(new Pessoa("Fernanda", 40));

        String resultado = zoologico.printPessoa();

        assertTrue(resultado.contains("Index: 0 Nome: Lucas"));
        assertTrue(resultado.contains("Index: 1 Nome: Fernanda"));
    }

    @Test
    void testPrintPessoaSemPessoas() {
        String resultado = zoologico.printPessoa();
        assertEquals("[]", resultado);
    }

    @Test
    void testBuscarPessoa() {
        Pessoa p = new Pessoa("João", 50);
        zoologico.adicionarPessoa(p);

        zoologico.buscarPessoa(0);
        String saida = outputStreamCaptor.toString().trim();

        assertTrue(saida.contains("João"));
    }

    @Test
    void testToStringComPessoas() {
        Pessoa p1 = new Pessoa("Rafaela", 18);
        Pessoa p2 = new Pessoa("Miguel", 70);

        zoologico.adicionarPessoa(p1);
        zoologico.adicionarPessoa(p2);

        String resultado = zoologico.toString();

        assertTrue(resultado.contains("Rafaela"));
        assertTrue(resultado.contains("Miguel"));
    }

    @Test
    void testToStringSemPessoas() {
        String resultado = zoologico.toString();
        assertEquals("", resultado);
    }
}
