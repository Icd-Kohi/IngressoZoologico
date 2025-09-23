/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.ingresso.ingressozoologico;
import java.util.Scanner;
/**
 *
 * @author Luan silva aguiar uezo 202123311511
 */
// 1 - * VERIFICAR QUANTIDADE DE BILHETES SOLICITADA
// MÁXIMO DE 5 POR PESSOA
// 2 - * PREÇOS DO INGRESSO
// INTEIRA: R$30 (ADULTOS, >= 13 ATÉ 59 <= ANOS
// MEIA: R$15 (IDOSOS, >= 60 ANOS)
// PREÇO COM DESCONTO: R$ 10 (CRIANÇAS ATÉ 0 - 12 ANOS)
// SAÍDA: PREÇO TOTAL : PREÇO, OU ERRO.

public class IngressoZoologico {

    public static void main(String[] args) {
        System.out.println("Hello World!\n");
        System.out.println("Início do sistema de Ingresso do Zoologico\n Pressione \"q\" para sair");
        System.out.println("Pressione c para checar e simular a precificacao");
        System.out.println("Pressione p para cadastrar uma pessoa");
        System.out.println("Pressione v para ver pessoas cadastradas");
        System.out.println("Pressione s selecionar uma pessoa");

        interfaceDoPrograma();
    }
    public static void interfaceDoPrograma(){
        //ArrayList<Pessoa> listaDePessoas = new ArrayList<>();
        Zoologico zoologico = new Zoologico();

        Scanner scanner = new Scanner(System.in);

        while(true){
            String input = scanner.nextLine();

            if(input.equals("q")){
                System.out.println("Tem certeza? Os dados serão apagados. (s/n)");
                if(scanner.nextLine().equals("s")){
                    break;
                }
                continue;
            }

            System.out.println("Pressione c para checar e simular a precificacao");
            System.out.println("Pressione p para cadastrar uma pessoa");
            System.out.println("Pressione v para ver pessoas cadastradas");
            System.out.println("Pressione s selecionar uma pessoa");

            switch (input) {
                case "c" -> {
                    System.out.println("Digite a idade: ");
                    int idade = Integer.parseInt(scanner.nextLine());

                    System.out.println("Digite a quantidade de ingressos: ");
                    int qtd = Integer.parseInt(scanner.nextLine());

                    simulaPreco(idade, qtd); 
                }
                case "p" -> {
                    System.out.println("Digite o nome da pessoa: ");

                    String nome = scanner.nextLine();

                    System.out.println("Digite a idade da pessoa: ");

                    int idade = Integer.parseInt(scanner.nextLine());

                    if (idade < 0) {
                        idade = 0;
                    }

                    Pessoa pessoa = new Pessoa(nome, idade);

                    zoologico.adicionarPessoa(pessoa);
                }
                case "v" -> {
                    if (zoologico.printPessoa() == null) {
                        System.out.println("Nenhuma pessoa cadastrada\n");
                        continue;
                    }

                    System.out.print(zoologico);

                    System.out.println("\n");
                }
                case "s" -> {
                    if (zoologico.toString().isEmpty()){
                        System.out.println("Nenhuma pessoa cadastrada.\n");
                    }else {
                        System.out.println("Caso esteja cadastrada, digite o nome da pessoa: ");
                        String nome = scanner.nextLine();

                        for (Pessoa pessoa : zoologico.getListaDePessoas()) {
                            if (pessoa.getNome().equals(nome)) {
                                System.out.println(pessoa + " Encontrado(a)!");
                                if(pessoa.getIngresso() > 5){
                                    System.out.println(pessoa.getNome() + " já possui a quantidade máxima de 5 ingressos.");
                                    continue;
                                }
                                System.out.println("Deseja comprar ingresso para " + pessoa.getNome() + " ? (s/n)");
                                if (scanner.nextLine().equals("s")) {
                                    System.out.println("Quantos ingressos deseja comprar? (Max de 5 por pessoa)");
                                    int quantia = Integer.parseInt(scanner.nextLine());
                                    comprarIngresso(pessoa, quantia);
                                }

                                System.out.println(" Obrigado!");
                            }
                        }
                    }
                }
            }
        }
    }

    public static void comprarIngresso(Pessoa pessoa, int qtdIngresso){
        if(qtdIngresso + pessoa.getIngresso() > 5) {
            System.out.println("Essa quantidade ultrapassa o limite permitido!");
        }else{
            pessoa.comprarIngresso(qtdIngresso);

            System.out.println("Compra de " + qtdIngresso + " Ingressos para " + pessoa.getNome() + " efetuada com sucesso!");
        }
    }
    public static void simulaPreco(int idade, int qtd){
        if (idade < 0){
            idade = 0;
        }
        if(qtd < 0){
            qtd = 0;
        }
        if(qtd > 5){
            qtd = 5;
        }
        if(idade > 12 && idade <= 59){
            System.out.println("Pagará preco inteiro: R$30. para " + qtd + " ingressos, total: R$" + (qtd *30));
        }
        if(idade <= 12){
            System.out.println("Pagará preco com desconto: R$10. para " + qtd + " ingressos, total: R$" + (qtd * 10));
        }
        if(idade >= 60){
            System.out.println("Pagará preco de meia: R$15. para " + qtd + " ingressos, total: R$" + (qtd * 15));
        }
    }
}