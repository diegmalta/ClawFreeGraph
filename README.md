
# Detector de Garra em Grafo

Este projeto foi realizado como trabalho na disciplina de "Algoritmos e Grafos" na Universidade Federal do Rio de Janeiro.

No estudo de grafos, há diversas classificações para eles dependendo de características que eles apresentam. Uma destas classificações é o grafo com garra. Todos os grafos abaixo são grafos com garra:

![App Screenshot](https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Star_graphs.svg/500px-Star_graphs.svg.png)

Uma garra ocorre em um grafo quando um subgrafo não-direcionado, possui um nó pai, com pelo menos 3 nós filhos que não possuem uma aresta que ligue um destes filhos com algum dos outros 2.

Neste trabalho, o código escrito na linguagem Java irá, dado um grafo de entrada, verificar se o grafo possui um subgrafo que forme uma garra, e indicará qual a formação da garra, ou se não há uma garra em nenhum subgrafo do grafo de entrada do programa.
## Etiquetas

[![Java](https://img.shields.io/badge/Language-Java-orange)](https://www.java.com)
[![Claw Graph](https://img.shields.io/badge/Graph-Claw%20Graph-blue)](https://mathworld.wolfram.com/ClawGraph.html)


## Grafo sem garra e grafo com garra

O grafo abaixo, é o menor grafo que possui garra, e também é o mesmo que, quando presente em um grafo como subgrafo, define-o como um grafo com garra.

![App Screenshot](https://raw.githubusercontent.com/diegmalta/ClawFreeGraph/main/grafoSemGarra/myfiles/graph_images/graph3_image.png)

Acima, o vértice 1 possui 3 vértices filhos, que não possuem uma aresta ligando-os. Sendo assim, o grafo 1-2-3-4 forma uma garra e é um grafo com garra.

Abaixo, como o grafo agora possui uma aresta ligando os vértices 2 e 3, ele não possui mais uma garra.

![App Screenshot](https://raw.githubusercontent.com/diegmalta/ClawFreeGraph/main/grafoSemGarra/myfiles/graph_images/graph4_image.png)

A seguir, o grafo possui vários subgrafos que formam uma garra. Um exemplo é o subgrafo 1-2-5-7, em que 2, 5 e 7 são vértices filhos do vértice 1, e eles não possuem uma aresta que os liga.

![App Screenshot](https://raw.githubusercontent.com/diegmalta/ClawFreeGraph/main/grafoSemGarra/myfiles/graph_images/graph2_image.png)

O grafo abaixo também é um grafo com garra, pois há o subgrafo 1-3-5-2 que forma uma garra.

![App Screenshot](https://raw.githubusercontent.com/diegmalta/ClawFreeGraph/main/grafoSemGarra/myfiles/graph_images/graph1_image.png)


## Lógica e Complexidade


Dentro do código da classe 'Digraph.java', temos o algoritmo que identifica uma garra ou se não há garras no grafo. Analisando o algoritmo abaixo, ele possui complexidade O(n4), tendo 4 loops 'for' que dependem do tamanho do grafo.

    public void identifica_semGarra(){
        if(vertex_set.size()<4){
            System.out.println("\n\n----------- É um Grafo Sem Garra -----------");
            System.out.println("\nO Grafo nao possui vertices suficientes para ter uma Garra");
        }
        
        for(Vertex v1:vertex_set.values()){
            for(Vertex v2 : v1.nbhood.values()) { //pegamos os vizinhos de v1
                if (v1.id != v2.id) {
                    for (Vertex v3 : v1.nbhood.values())//pegamos o id dos vizinhos de v1
                    {
                        verificaGarra(v1, v2, v3);
                    }
                }
            }
        }
        System.out.println("\n\n----------- É um Grafo Sem Garra -----------");
        //é sem garra
    }

	private void verificaGarra(Vertex v1, Vertex v2, Vertex v3) {
		if ((v1.id != v3.id) && (v2.id != v3.id)) {

		    for (Vertex v4 : v1.nbhood.values()) {
		        if ((v1.id != v4.id) && (v2.id != v4.id) && (v3.id != v4.id)) {
		            if(!((v3.nbhood.containsKey(v2.id)) || (v4.nbhood.containsKey(v2.id)) || (v4.nbhood.containsKey(v3.id)))){
		                imprimeGarra(v1, v2, v3, v4);
		            }
		        }
		    }
		}
	}

	private void imprimeGarra(Vertex v1, Vertex v2, Vertex v3, Vertex v4) {
		System.out.println("\n\n----------- Possui Garra -----------");
		System.out.println("             Vertice: " + v1.getId());
		System.out.println("             Vizinho: " + v2.getId());
		System.out.println("             Vizinho: " + v3.getId());
		System.out.println("             Vizinho: " + v4.getId());
    }
## Como usar

Na pasta "myfiles", é adicionado um grafo em arquivo .txt.

#### A forma como é descrito um grafo é:

O primeiro caractere de cada linha representa um nó.
O segundo caractere é um sinal de igual (=).
Após o sinal de igual, dígitos seguintes são os vizinhos do nó representado anteriormente ao sinal de igual (=).

Por exemplo:  
1 = 2 3 4  
2 = 1  
3 = 1  
4 = 1  

Temos um grafo com nós 1, 2, 3 e 4.  
Sendo que 1 é vizinho dos nós 2, 3 e 4.  
2 é vizinho do nó 1.
3 é vizinho do nó 1.  
4 é vizinho do nó 1.
## Demonstração
### Grafo sem garra

Ao iniciar o programa, ele irá imprimir no console:

= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =  Displaying Files from the directory : **********\grafoSemGarra\myfiles  = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =  
grafo.txt  
grafo2.txt  
grafo3.txt  
grafo4.txt  
Select the graph you want to verify if it is a Claw-Free graph by typing the file name:  
#### Agora selecionamos por exemplo o arquivo grafo4.txt:  
grafo4.txt  
adicionado o vertice: 1  
adicionado o vertice: 2  
adicionado o vertice: 2 como vizinho do vertice: 1  
adicionado o vertice: 3  
adicionado o vertice: 3 como vizinho do vertice: 1  
adicionado o vertice: 4  
adicionado o vertice: 4 como vizinho do vertice: 1  
adicionado o vertice: 1 como vizinho do vertice: 2  
adicionado o vertice: 3 como vizinho do vertice: 2  
adicionado o vertice: 1 como vizinho do vertice: 3  
adicionado o vertice: 2 como vizinho do vertice: 3  
adicionado o vertice: 1 como vizinho do vertice: 4    

----------- É um Grafo Sem Garra -----------  

### Grafo com garra

= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =  
Displaying Files from the directory : C:\Users\diegm\git\repository\grafoSemGarra\myfiles  
= = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = =  
grafo.txt  
grafo2.txt
grafo3.txt  
grafo4.txt  
Select the graph you want to verify if it is a Claw-Free graph by typing the file name:  
grafo.txt  
adicionado o vertice: 1  
adicionado o vertice: 2  
adicionado o vertice: 2 como vizinho do vertice: 1  
adicionado o vertice: 3  
adicionado o vertice: 3 como vizinho do vertice: 1  
adicionado o vertice: 4  
adicionado o vertice: 4 como vizinho do vertice: 1  
adicionado o vertice: 5  
adicionado o vertice: 5 como vizinho do vertice: 1  
adicionado o vertice: 6  
adicionado o vertice: 6 como vizinho do vertice: 1  
adicionado o vertice: 7  
adicionado o vertice: 7 como vizinho do vertice: 1  
adicionado o vertice: 1 como vizinho do vertice: 2  
adicionado o vertice: 7 como vizinho do vertice: 2  
adicionado o vertice: 1 como vizinho do vertice: 3  
adicionado o vertice: 4 como vizinho do vertice: 3  
adicionado o vertice: 5 como vizinho do vertice: 3  
adicionado o vertice: 1 como vizinho do vertice: 4  
adicionado o vertice: 3 como vizinho do vertice: 4  
adicionado o vertice: 5 como vizinho do vertice: 4  
adicionado o vertice: 1 como vizinho do vertice: 5  
adicionado o vertice: 3 como vizinho do vertice: 5  
adicionado o vertice: 4 como vizinho do vertice: 5  
adicionado o vertice: 6 como vizinho do vertice: 5  
adicionado o vertice: 7 como vizinho do vertice: 5  
adicionado o vertice: 1 como vizinho do vertice: 6  
adicionado o vertice: 5 como vizinho do vertice: 6  
adicionado o vertice: 7 como vizinho do vertice: 6  
adicionado o vertice: 1 como vizinho do vertice: 7  
adicionado o vertice: 2 como vizinho do vertice: 7  
adicionado o vertice: 5 como vizinho do vertice: 7  
  
  
----------- Possui Garra -----------  
             Vertice: 1  
             Vizinho: 2  
             Vizinho: 3  
             Vizinho: 6  
  
#### Ele também imprime a primeira garra que o algoritmo encontrou.
## Referências

 - BOAVENTURA NETTO, Paulo Oswaldo (2001). Grafos. Teoria, Modelos Algoritmos. São Paulo: Edgard Blücher. p. 263. ISBN 85-212-0292-X
 - [Um Estudo das Estruturas de Grafos Sem Garras, Patrícia Rodrigues da Silva Soares](https://www.cos.ufrj.br/index.php/pt-BR/publicacoes-pesquisa/details/15/2649)
 - [Claw-FreeGraph - Wolfram](https://mathworld.wolfram.com/Claw-FreeGraph.html)
 - [Claw-FreeGraph - GraphClasses](https://www.graphclasses.org/classes/gc_62.html)
 - [Claws-Survey](https://web.math.princeton.edu/~mchudnov/claws_survey.pdf)

## Autores

- [@diegmalta](https://www.github.com/diegmalta)
- [@lucashelio](https://www.github.com/lucashelio)
