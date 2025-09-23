# TUI - Sistema de compra de ingresso de Zoologico
@Author: Luan Silva Aguiar. 202123311511.
<br> 
Universidade Estadual do Rio de Janeiro DepComp - C.C 2025/2
<br>
Disciplina: Teste de Software - Prof: Fabio 


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
 - Crianças (até 12 anos) pagam um preço reduzido (Preço com desconto: R$10).

 - Adultos (13 a 59 anos) pagam o preço completo (Inteira: R$30).

 - Idosos (60 anos ou mais) pagam um preço com desconto (Meia: R$15).

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
- Dados: 
`String nome`,
`int idade, ingresso`
- Métodos: 
`checaPreco()` -> Checa o valor a pagar para cada ingressos,
`comprarIngresso(int quantidade)` -> Compra a quantidade desejada de ingressos,
`custoPessoa()` -> Valor total a pagar da pessoa.

###### Zoologico.java
Dados das pessoas serão alocados nesta classe.
- Dados: 
`ArrayList<Pessoa> listaDePessoas` -> Lista de Pessoas. (Clientes)
- Métodos: 
`adicionarPessoa(Pessoa pessoa)` -> adiciona um objeto Pessoa na lista, 
`adicionarListaDePessoas(ArrayList<Pessoa> lista)` -> Em caso de uma lista já existente, a utiliza,
`printPessoa()` -> retorna uma String de todas as pessoas no Zoologico.
-----
# Testes Unitários:
Testes unitários em cada classe do sistema.
1. `IngressoZoologicoTest`:

- Todas as faixas etárias.
- Quantidade negativa ajustada para zero.
- Quantidade de ingresso > 5, ajustada para 5.
- Idade negativa ajustada para zero.

2. `ZoologicoTest`:

- Adiciona pessoa.
- Se adiciona `null`, não adiciona nada.
- Adidiona uma lista de Pessoas.
- Tenta adicionar uma lista `null`.
- `printPessoa` com pessoas, retorna o index e nomes.
- `printPessoa` vazio retorna -> [].
- `buscarPessoa` imprime pessoa certa no System.out.
- `toString` com pessoas concatena o `toString`de cada pessoa.
- `toString` vazio gera string vazia.

3. `PessoaTest`:

- Construtores
- Métodos de preços (`precoInteiro`, `precoReduzido`, `precoMeia`)
- Checagem de saída para cada faixa etária.
- `comprarIngresso` dentro do limite, acima e acumulado.
- `custoPessoa` para criança, adulto e idoso.
- Variações para checagem do método `toString`.

--------

# Diagrama de Fluxo de controle: 

Fórmula da *complexidade ciclomática*:
V(G) = E - N + 2  
onde: 
E => Número de Arestas.
N => Número de Nós.
+2 => Ajuste constante que garante que o valor reflita o número de regiões independentes do grafo.
#### Diagrama:

![Diagrama de Fluxo de Controle: LUAN SILVA AGUIAR.](/DiagramaDeFluxo-LuanSilvaAguiar.png "Autor: LUAN SILVA AGUIAR")

Neste sistema, destaco as seguintes informações:
17 nós.
28 arestas. 
+2.
<br>
Montando a fórmula: V(G) = 28 - 17 + 2 => **13**
<br>
A complexidade ciclomática deste sistema é de 13 possibilidades.

