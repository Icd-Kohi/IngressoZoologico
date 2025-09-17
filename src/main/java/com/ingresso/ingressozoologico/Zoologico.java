package com.ingresso.ingressozoologico;
import java.util.ArrayList;
public class Zoologico {
    private ArrayList<Pessoa> listaDePessoas;

    public Zoologico(){
        this.listaDePessoas = new ArrayList<>();
    }

    public Zoologico(ArrayList<Pessoa> listaDePessoas){
        this.listaDePessoas = listaDePessoas;
    }

    public void adicionarPessoa(Pessoa pessoa){
        if(pessoa != null){
            this.listaDePessoas.add(pessoa);
        }
    }

    public void adicionarListaDePessoas(ArrayList<Pessoa> listaDePessoas){
        if(listaDePessoas != null){
            for(Pessoa pessoa: listaDePessoas){
                this.listaDePessoas.add(pessoa);
            }
        }
    }

    public String printPessoa(){
        int acc = 0;
        ArrayList<String> lista = new ArrayList<>();

        if(listaDePessoas != null){
            for(Pessoa pessoa: listaDePessoas){
                lista.add("Index: " + acc + " Nome: " + pessoa.getNome());
                acc++;
            }
        }

        return lista.toString();
    }

    public void buscarPessoa(int index){
        Pessoa aux = this.listaDePessoas.get(index);

        System.out.println(aux);
    }

    public ArrayList<Pessoa> getListaDePessoas(){
        return this.listaDePessoas;
    }

    public String toString (){
        String nomes = "";

        for(Pessoa pessoa: listaDePessoas){
            nomes += pessoa.toString() + "\n";
        }

        return nomes;
    }
}
