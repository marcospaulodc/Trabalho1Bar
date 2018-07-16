package Trabalho1;

/**
 * Trabalho 1 de Computação Paralela e Sistemas Distribuídos;
 * Criação de um Bar, utilizando monitores e threads;
 * 
 * @author Marcos Paulo de Castro
 */

import java.util.Scanner;

public class Main 
{
	/**
	 * Classe Main
	 * Contém a variável leituradeDados que recebe os dados de maneira dinâmica;
	 * Foi criada uma condição para realizar o balanceamento, na qual o quociente 
	 * entre o número de clientes com o número de garçons deverá ser sempre maior 
	 * ou igual que a capacidade de garçons.
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
		System.out.println("Informe a quantidade de garçons do Buteco: ");
		int numeroDeGarcom = leituradeDados.nextInt();
		System.out.println("Informe a capacidade de atendimento de cada garçom: ");
		int capacidadeGarcom = leituradeDados.nextInt();
		System.out.println("Informe a quantidade de rodadas liberadas no Buteco: ");
		int numeroDeRodada = leituradeDados.nextInt();
		String msg = "Por favor. Execute o programa novamente!";
		
		//Condição para realizar o balanceamento
		int balanceamento = numeroDeCliente/numeroDeGarcom;
		if(balanceamento >= capacidadeGarcom)
		{
			//Verifica se o número de rodadas informado é permitido
			if(numeroDeRodada > 0)
			{
				//Instanciando meu objeto do tipo Bar que recebe os dados dinâmicos informados pelo usuário
				Bar bar = new Bar(numeroDeCliente, numeroDeGarcom, capacidadeGarcom, numeroDeRodada);
				
				//Instanciando meu objeto do tipo Pedido que recebe o objeto bar
				Pedido pedido = new Pedido(bar);
				
				for (int i = 0; i < numeroDeCliente; i++) 
				{
					new Cliente(bar, pedido, i+1).start(); //Criando as Threads de clientes baseadas no numeroDeCliente informado
				}
							
				for (int i = 0; i < numeroDeGarcom; i++) 
				{
					new Garcom(bar, pedido, i+1).start(); //Criando as Threads de garçons baseadas no numeroDeGarçom informado
				}
			}
			else
			{
				System.err.println("*** Atenção ***! O número de rodadas deve ser maior que 0!");
				System.err.println(msg);
				System.exit(0);
			}
		}
		else
		{
			System.err.println("*** Atenção ***! A capacidade dos garçons não atende a capacidade de clientes!");
			System.err.println(msg);
			System.exit(0);
		}
	}
}
