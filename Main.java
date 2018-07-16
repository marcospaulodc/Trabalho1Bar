package Trabalho1;

/**
 * Trabalho 1 de Computa��o Paralela e Sistemas Distribu�dos;
 * Cria��o de um Bar, utilizando monitores e threads;
 * 
 * @author Marcos Paulo de Castro
 */

import java.util.Scanner;

public class Main 
{
	/**
	 * Classe Main
	 * Cont�m a vari�vel leituradeDados que recebe os dados de maneira din�mica;
	 * Foi criada uma condi��o para realizar o balanceamento, na qual o quociente 
	 * entre o n�mero de clientes com o n�mero de gar�ons dever� ser sempre maior 
	 * ou igual que a capacidade de gar�ons.
	 */
	
	private static Scanner leituradeDados;

	public static void main(String[] args) 
	{
		leituradeDados = new Scanner(System.in);
		System.out.println("******************************");
		System.out.println("*** Buteco do Marcos Paulo ***");
		System.out.println("******************************");
		System.out.println("Informe a quantidade de clientes do Buteco: ");
		int numeroDeCliente = leituradeDados.nextInt();
		System.out.println("Informe a quantidade de gar�ons do Buteco: ");
		int numeroDeGarcom = leituradeDados.nextInt();
		System.out.println("Informe a capacidade de atendimento de cada gar�om: ");
		int capacidadeGarcom = leituradeDados.nextInt();
		System.out.println("Informe a quantidade de rodadas liberadas no Buteco: ");
		int numeroDeRodada = leituradeDados.nextInt();
		String msg = "Por favor. Execute o programa novamente!";
		
		//Condi��o para realizar o balanceamento
		int balanceamento = numeroDeCliente/numeroDeGarcom;
		if(balanceamento >= capacidadeGarcom)
		{
			//Verifica se o n�mero de rodadas informado � permitido
			if(numeroDeRodada > 0)
			{
				//Instanciando meu objeto do tipo Bar que recebe os dados din�micos informados pelo usu�rio
				Bar bar = new Bar(numeroDeCliente, numeroDeGarcom, capacidadeGarcom, numeroDeRodada);
				
				//Instanciando meu objeto do tipo Pedido que recebe o objeto bar
				Pedido pedido = new Pedido(bar);
				
				for (int i = 0; i < numeroDeCliente; i++) 
				{
					new Cliente(bar, pedido, i+1).start(); //Criando as Threads de clientes baseadas no numeroDeCliente informado
				}
							
				for (int i = 0; i < numeroDeGarcom; i++) 
				{
					new Garcom(bar, pedido, i+1).start(); //Criando as Threads de gar�ons baseadas no numeroDeGar�om informado
				}
			}
			else
			{
				System.err.println("*** Aten��o ***! O n�mero de rodadas deve ser maior que 0!");
				System.err.println(msg);
				System.exit(0);
			}
		}
		else
		{
			System.err.println("*** Aten��o ***! A capacidade dos gar�ons n�o atende a capacidade de clientes!");
			System.err.println(msg);
			System.exit(0);
		}
	}
}
