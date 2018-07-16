Marcos Paulo de Castro

1- Execute o trabalho pela classe Main.
2- Informe os par�metros necess�rios para a execu��o do programa. (Quantidade e clientes, quantidade de gar�ons, capacidade de atendimento de cada gar�om e por fim, a quantidade de rodadas).
3- As classes e m�todos mais complexos est�o devidamente comentados, a fim de obter um melhor entendimento do funcionamento do programa.
4- Algumas entradas testadas: (4,2,2,2); (5,2,2,3); (10,3,3,5); (20,2,10,1); (20,2,10,2); (5,1,1,1)*


Descri��o sucinta do programa

O programa necessita de uma entrada din�mica dos dados para a execu��o;
H� uma condi��o para fazer o balanceamento da capacidade de atendimento de cada gar�om em uma dada rodada;
O objeto Bar � instanciado recebendo os dados din�micos informados pelo usu�rio;
O objeto Pedido ser� o objeto compartilhado e � instanciado recebendo o objeto bar do tipo Bar no seu construtor;
S�o criadas as threads de clientes e gar�ons baseadas no par�metro informado pelo usu�rio;
Nesse momento os m�todos run() das classes Cliente e Gar�om s�o executados, a defini��o de qual m�todo executar� primeiro � indefinido, pois n�o h� como prever nessa concep��o de implementa��o do programa qual processo leve utilizar� a CPU primeiro;
Ambos os m�todos run() das duas classes Cliente e Gar�om, que obviamente estendem da classe Thread, cont�m uma condi��o de parada(mFecharBar), na qual o bar � fechado quando todas as rodadas estiverem sido executadas e as Threads s�o encerradas automaticamente pela JVM;
Caso o bar esteja aberto, o m�todo run() da classe Cliente cont�m um m�todo que permite que o cliente fa�a pedido e o m�todo run() da classe Gar�om cont�m um m�todo que permite que o gar�om registre pedido.
No m�todo mFazerPedido(), cont�m algumas condi��es necess�rias para o cliente fazer um pedido, e ap�s pedir, ele notifica que pediu e ap�s todos os clientes pedirem os gar�ons s�o notificados atrav�s do objeto compartilhado, os clientes aguardam pois poder� haver ou n�o uma nova rodada (Thread de cliente dorme);
No m�todo mRegistarPedido(), cont�m algumas condi��es necess�rias para o gar�om registrar um pedido, o gar�om entrega o pedido para o cliente, conforme a sua capacidade de atendimento e na ordem de qual cliente pediu primeiro na rodada corrente, e notifica que terminou seu servi�o;
A Thread do gar�om dorme at� saber se haver� outra rodada ou n�o.
A fim de resolver um problema de Deadlock, caso o usu�rio informar muitos clientes, poucos gar�ons e pouca capacidade para cada gar�om, foi necess�rio realizar um tratamento, informando de maneira amig�vel ao usu�rio para executar o programa novamente com par�metros coerentes. Exemplo: (5,1,1,1), nesse exemplo de entrada, 1 gar�om tem capacidade 1 e consegue atender apenas 1 cliente, deixando assim 4 clientes �rf�os. O problema foi contornado com sucesso.


