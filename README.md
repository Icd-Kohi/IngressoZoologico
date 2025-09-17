# TUI - Sistema de compra de ingresso de Zoologico
@Author: Luan Silva Aguiar. 202123311511.
----
#### Objetivo: Compra e checagem de ingressos de Pessoas num Zoologico. 

#### Dados de Entrada:
- Idade: Idade do visitante.
- Nome: Nome do visitante.
- Quantidade: Número de bilhetes comprados.

#### Processamento:
- Verificar se a quantidade de bilhetes solicitada está dentro do limite permitido
(máximo 5 por pessoa)

- Determinar o preço do bilhete com base na idade:
 - Crianças ( até 12 anos ) pagam um preço reduzido ( preço com desconto : R$10 ).

 - Adultos ( 13 a 59 anos ) pagam o preço completo ( Inteira: R$30 ).

 - Idosos ( 60 anos ou mais ) pagam um preço com desconto ( meia R$15 ).

- Se a quantidade de bilhetes for aceitável, calcular o preço total.


#### SAÍDA:
- Exibir o preço total se a quantidade for permitida, ou uma mensagem de erro se não for.
------------

# Funcionamento:

Após a inicialização do programa, a interface gráfica é chamada e solicita a entrada do usuário conforme o programa solicita. Cada pessoa criada, é um objeto `Pessoa` criado e adicionado na lista no `Zoologico`.

*Por enquanto dados só persistem enquanto o programa não for finalizado.* 

#### Classes:
###### IngressoZoologico.java
- Chama a interface gráfica. 
- Métodos: `simulaPreco(int idade, int qtd)` -> simula o total a ser pago pela quantidade de ingresso de forma independente.
*Não é possível selecionar mais que 5 ingressos*

###### Pessoa.java
Cria um objeto pessoa, que será alocada na lista de pessoas no Zoologico.
- Dados: nome,idade,ingresso.
- Métodos: `getNome()`, `getIdade()`, `getIngresso()`, `checaPreco()` -> Checa o valor a pagar para cada ingresso, `comprarIngresso(int quantidade)` -> Compra a quantidade desejada de ingressos, `custoPessoa()` -> Valor total a pagar da pessoa.

###### Zoologico.java
Dados das pessoas serão alocados nesta classe.
- Dados: Lista de Pessoas. (Clientes)
- Métodos: `adicionarPessoa(Pessoa pessoa)`, `adicionarListaDePessoas(ArrayList<Pessoa> lista)` -> Em caso de uma lista já existente, a utiliza, `printPessoa()` -> retorna uma String de todas as pessoas no Zoologico.
