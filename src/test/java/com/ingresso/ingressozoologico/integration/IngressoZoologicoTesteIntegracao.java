package com.ingresso.ingressozoologico.integration;

import com.ingresso.ingressozoologico.IngressoZoologico;
import com.ingresso.ingressozoologico.Pessoa;
import com.ingresso.ingressozoologico.Zoologico;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
// * Author: LUAN SILVA AGUIAR. UERJ 2025/2. 202123311511.
// TESTE DE INTEGRAÇÂO COBRINDO AS CLASSES: `IngressoZoologico.java`, `Pessoa.java`, `Zoologico.java`.
// ETAPAS:
// 1. CADASTRO DE UMA PESSOA.
// 2. SIMULACAO DE PRECO DA PESSOA.
// 3. COMPRA DE INGRESSOS.
// 4. TENTATIVA DE ULTRAPASSAR O LIMITE DE INGRESSOS PERMITIDO.
// 5. CHECAGEM FINAL PARA VER SE AINDA TEM OS MESMOS INGRESSOS COMPRADOS.
public class IngressoZoologicoTesteIntegracao {
    // ByteArrayOutputStream é pra capturar o que é impresso no System.out, permitindo validar as mensagens exibidas.
    private final ByteArrayOutputStream outputCaptor = new ByteArrayOutputStream();
    @BeforeEach
    void setUp(){
        System.setOut(new PrintStream(outputCaptor));
    }

    @Test
    void integracaoDeCadastroChecagemECompra(){
        // 1. CADASTRO DE UMA PESSOA
        Zoologico zoologico = new Zoologico();
        Pessoa pessoa = new Pessoa("Luan", 10);
        zoologico.adicionarPessoa(pessoa);
        // 2. SIMULACAO DE PRECO ABAIXO
        outputCaptor.reset();
        IngressoZoologico.simulaPreco(pessoa.getIdade(), 3);

        String outputSimulacao = outputCaptor.toString().trim();
        assertTrue(outputSimulacao.contains("Pagará preco com desconto:"));
        assertTrue(outputSimulacao.contains("R$30"));

        // 3. COMPRA DE 3 INGRESSOS ABAIXO:
        outputCaptor.reset();
        IngressoZoologico.comprarIngresso(pessoa,3);
        String outputCompra = outputCaptor.toString().trim();
        assertTrue(outputCompra.contains("Compra de 3 Ingressos para Luan efetuada com sucesso!"));

        assertEquals(3, pessoa.getIngresso());

        // 4. TENTATIVA DE ULTRAPASSAR O LIMITE DE INGRESSOS ABAIXO:
        outputCaptor.reset();
        IngressoZoologico.comprarIngresso(pessoa,3);
        String outputFalhaDaCompra = outputCaptor.toString().trim();
        assertTrue(outputFalhaDaCompra.contains("Essa quantidade ultrapassa o limite permitido!"));
        // 5. CHECAGEM FINAL PARA VER SE AINDA TEM OS MESMOS 3 INGRESSOS ABAIXO:
        assertEquals(3, pessoa.getIngresso());

    }
}
