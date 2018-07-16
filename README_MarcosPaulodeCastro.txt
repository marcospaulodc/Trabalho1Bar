Marcos Paulo de Castro

1- Execute o trabalho pela classe Main.
2- Informe os parâmetros necessários para a execução do programa. (Quantidade e clientes, quantidade de garçons, capacidade de atendimento de cada garçom e por fim, a quantidade de rodadas).
3- As classes e métodos mais complexos estão devidamente comentados, a fim de obter um melhor entendimento do funcionamento do programa.
4- Algumas entradas testadas: (4,2,2,2); (5,2,2,3); (10,3,3,5); (20,2,10,1); (20,2,10,2); (5,1,1,1)*


Descrição sucinta do programa

O programa necessita de uma entrada dinâmica dos dados para a execução;
Há uma condição para fazer o balanceamento da capacidade de atendimento de cada garçom em uma dada rodada;
O objeto Bar é instanciado recebendo os dados dinâmicos informados pelo usuário;
O objeto Pedido será o objeto compartilhado e é instanciado recebendo o objeto bar do tipo Bar no seu construtor;
São criadas as threads de clientes e garçons baseadas no parâmetro informado pelo usuário;
Nesse momento os métodos run() das classes Cliente e Garçom são executados, a definição de qual método executará primeiro é indefinido, pois não há como prever nessa concepção de implementação do programa qual processo leve utilizará a CPU primeiro;
Ambos os métodos run() das duas classes Cliente e Garçom, que obviamente estendem da classe Thread, contém uma condição de parada(mFecharBar), na qual o bar é fechado quando todas as rodadas estiverem sido executadas e as Threads são encerradas automaticamente pela JVM;
Caso o bar esteja aberto, o método run() da classe Cliente contém um método que permite que o cliente faça pedido e o método run() da classe Garçom contém um método que permite que o garçom registre pedido.
No método mFazerPedido(), contém algumas condições necessárias para o cliente fazer um pedido, e após pedir, ele notifica que pediu e após todos os clientes pedirem os garçons são notificados através do objeto compartilhado, os clientes aguardam pois poderá haver ou não uma nova rodada (Thread de cliente dorme);
No método mRegistarPedido(), contém algumas condições necessárias para o garçom registrar um pedido, o garçom entrega o pedido para o cliente, conforme a sua capacidade de atendimento e na ordem de qual cliente pediu primeiro na rodada corrente, e notifica que terminou seu serviço;
A Thread do garçom dorme até saber se haverá outra rodada ou não.
A fim de resolver um problema de Deadlock, caso o usuário informar muitos clientes, poucos garçons e pouca capacidade para cada garçom, foi necessário realizar um tratamento, informando de maneira amigável ao usuário para executar o programa novamente com parâmetros coerentes. Exemplo: (5,1,1,1), nesse exemplo de entrada, 1 garçom tem capacidade 1 e consegue atender apenas 1 cliente, deixando assim 4 clientes órfãos. O problema foi contornado com sucesso.


