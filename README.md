# Controlador de aterrissagem e decolagem em um aeroporto.
Projeto desenvolvido na disciplina de Algoritmos e Estrutura de Dados no UniBH.
O objetivo deste projeto é simular os padrões de aterrissagem e decolagem em um aeroporto.
Suponha um aeroporto que possui três pistas, numeradas como 1, 2 e 3. Existem quatro “prateleiras” de espera para aterrissagem, duas para cada uma das pistas 1 e 2. Aeronaves que se aproximam do aeroporto
devem integrar-se a uma das prateleiras (filas) de espera, sendo que estas filas devem procurar manter o
mesmo tamanho. Assim que um avião entra em uma fila de aterrissagem, ele recebe um número de
identificação ID e outro número inteiro que indica a quantidade de unidades de tempo que o avião pode
permanecer na fila antes que ele tenha de descer (do contrário, seu combustível termina e ele cai).
Existem também filas para decolagem, uma para cada pista. Os aviões que chegam nessas filas também recebem uma identificação ID. Essas filas também devem procurar manter o mesmo tamanho. 
A cada unidade de tempo, de zero a três aeronaves podem chegar nas filas de decolagem e de zero
a três aeronaves podem chegar nas prateleiras. A cada unidade de tempo, cada pista pode ser usada para
um pouso ou uma decolagem. A pista 3 em geral só é usada para decolagens a não ser que um dos aviões
nas prateleiras fique com pouco combustível, quando então ela deve ser imediatamente usada para pouso. 
Utilize inteiros pares (ímpares) sucessivos para os IDs dos aviões chegando nas filas de decolagem (aterrissagem). A cada unidade de tempo assuma que os aviões entram nas filas antes que aterrissagens ou
decolagens ocorram.
Coloque os aviões sempre no final das filas, que não devem ser reordenadas.
A saída do programa deverá indicar o que ocorre a cada unidade de tempo. Periodicamente,
imprima:
a) o conteúdo de cada fila;
b) o tempo médio de espera para decolagem;
c) o tempo médio de espera para aterrissagem; e
d) o número de aviões que aterrissaram sem reserva de combustível.
Os itens b e c acima devem ser calculados para os aviões que já decolaram ou pousaram, respectivamente.
Para a implementação deste projeto desenvolvi minha própria lista encadeada.

A baixo a video aula usada para implementação da lista encadeada.
https://www.youtube.com/watch?v=ZT8DBnMeDLo&list=LLbA0dz3KiDQv-sjmcE1UOrQ&index=36&t=0s
