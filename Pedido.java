package Trabalho1;
/**
 * @author Marcos Paulo de Castro
 */

import java.util.ArrayList;

public class Pedido 
{
	private ArrayList<Integer> pedidos = new ArrayList<Integer>(); //Armazenos pedidos... 
	private ArrayList<Integer> cliente = new ArrayList<Integer>(); //Armazena os clientes que acessaram os pedidos na rodada atual
	private ArrayList<Integer> garcom = new ArrayList<Integer>(); //Armazena os gar�ons...
	
	private Bar bar;
	
	public Pedido(Bar bar) //Recebe os atributos: capacidadeGarcom, numeroDeCliente, numeroDeGarcom, numeroDeRodada, rodadaAtual
	{
		this.bar = bar;
	}
	
	//Adiciona um pedido para o cliente com base no seu id no meu ArrayList de Pedido
	public void mAdicionarPedido(int pedido)
	{
		this.pedidos.add(pedido);
	}
	
	//Pega o numero da rodada atual, printa na tela e adiciona um novo cliente no meu ArrayList de cliente
	public void mAdicionarCliente(int cliente)
	{
		if(this.cliente.size() == 0)
		{
			System.out.println("-----------------------------");
			System.out.println("* Rodada: " + bar.getRodadaAtual() + " *" + "\n");
		}
		this.cliente.add(cliente);
	}
	
	//Adiciona um gar�om no meu ArrayList de garcom.
	public void mAdicionarGarcom(int garcom)
	{
		this.garcom.add(garcom);
	}
	
	public boolean mGarcomAtendeu(int id)
	{
		boolean retorno = false;
		for (int i = 0; i < this.garcom.size(); i++) 
		{
			if(this.garcom.get(i) == id)
			{
				retorno = true;
			}
		}
		return retorno;
	}
	
	public boolean mExistePedidos()
	{
		if(this.pedidos.size() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	//Verifica se o cliente j� pediu na rodada corrente
	public boolean mClientePediu(int id)
	{
		boolean retorno = false;
		for (int i = 0; i < this.cliente.size(); i++) 
		{
			if(this.cliente.get(i) == id)
			{
				retorno = true;
			}
		}
		return retorno;
	}
	
	/* Verifica se todos os clientes fizeram o pedido
	 * Quando o tamanho do meu ArrayList de clientes que est� dentro do meu objeto compartilhado Pedido,
	 * for igual ao meu numerodeclientes, a condi��o retorna true, informando que todos os clientes
	 * j� fizeram o seu pedido na rodada corrente.
	 */
	public boolean mTodosOsClientesPediram()
	{
		if(this.cliente.size() == bar.getNumeroDeCliente())
		{
			return true;
		}
		else
		{
			return false;//retorna false se ainda h� clientes para fazer o pedido
		}
	}
	
	/* Se o tamanho do meu ArrayList de gar�om for igual ao meu n�mero de gar�ons
	 * retorna verdadeiro, logo, todos os gar�ons j� atenderam
	 */
	public boolean mTodosOsGarconsAtenderam()
	{
		if(this.garcom.size() == bar.getNumeroDeGarcom())
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public int mReceberPedido()
	{
		int cliente = 0;
		if(this.pedidos.size() > 0)
		{
			cliente = this.pedidos.get(0); //o primeiro cliente que pediu ir� receber seu pedido
			this.pedidos.remove(0); //cliente ser� removido do ArrayList
		}
		return cliente;
	}
	
	//Limpa os registros de pedidos da rodada atual e printa na tela
	public void mLimparPedidos()
	{
		this.pedidos.clear();
		this.cliente.clear();
		this.garcom.clear();
		System.out.println("***Limpando pedidos da rodada: " + (bar.getRodadaAtual()-1) + "***");
	}
}
