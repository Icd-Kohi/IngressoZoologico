/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ingresso.ingressozoologico;

/**
 *
 * @author Luan silva aguiar uezo
 */
public class Pessoa {
    private final String nome;
    private final int idade;
    private int ingresso;
    
    public Pessoa(int idade){
// Construtor não usado.
        if(idade > 0){
            this.idade = idade;
        }else {
            this.idade = 0;
        }

        this.ingresso = 0;

        this.nome = "";
    }

    public Pessoa(String nome, int idade){
        if(idade > 0){
            this.idade = idade;
        }else {
            this.idade = 0;
        }

        this.ingresso = 0;

        this.nome = nome;
    }

    public String getNome(){ return this.nome; }

    public int getIdade(){
        return this.idade;
    }

    public int getIngresso(){
        return this.ingresso;
    }

    public void checaPreco(){
        if(this.idade <= 12){
            System.out.println("Idade <= 12, é desconto (R$10)");
        }
        if(this.idade > 12 && this.idade <= 59){
            System.out.println("Idade > 12 e <= 59, Preço Inteiro (R$30)");
        }
        if(this.idade >= 60){
            System.out.println("Idade >= 60, paga com desconto de meia (R$15)");
        }
    }

    public boolean precoInteiro(){
        if(this.idade > 12 && this.idade <= 59){
            return true;
        }
        return false;
    }

    public boolean precoReduzido(){
        if(this.idade <= 12){
            return true;
        }
        return false;
    }
    
    public boolean precoMeia(){
        if(this.idade >= 60){
            return true;
        }

        return false;
    }

    public void comprarIngresso(int quantidade){
        if(quantidade > 5){
            System.out.println("Não pode comprar mais que 5 ingressos");
            return;
        }

        if(this.ingresso + quantidade > 5){
            System.out.println("Quantidade de ingresso excedido");
            return;
        }

        this.ingresso += quantidade;
    }

    public int custoPessoa(){
        if(precoInteiro()){
            return this.ingresso * 30;
        }

        if(precoMeia()){
            return this.ingresso * 15;
        }

        if(precoReduzido()){
            return this.ingresso * 10;
        }

        return 0;
    }

    public String toString(){
        return "Nome: " + this.nome + " Idade: " + this.idade + " Qtd Ingressos: " + this.ingresso + " Valor total: R$" + this.custoPessoa();
    }
    
}
