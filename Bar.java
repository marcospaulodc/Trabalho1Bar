package Trabalho1;
/**
 * @author Marcos Paulo de Castro
 */

public class Bar 
{
	private int numeroDeCliente;
	private int numeroDeGarcom;
	private int numeroDeRodada;
	private int rodadaAtual;
	private int capacidadeGarcom;
	
	public Bar(int numeroDeCliente, int numeroDeGarcom, int capacidadeGarcom, int numeroDeRodada)
	{
		this.numeroDeCliente = numeroDeCliente;
		this.numeroDeGarcom = numeroDeGarcom;
		this.numeroDeRodada = numeroDeRodada;
		this.capacidadeGarcom = capacidadeGarcom;
		this.rodadaAtual = 1; //setando 1 para a primeira rodada
	}
	
	public void setUmaNovaRodada()
	{
		this.rodadaAtual++; //incremento da nova rodada
	}
	
	public boolean mVerificarClientesBar()
	{
		if(getNumeroDeCliente() > 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/* Método que fecha o bar, caso o número de rodada for menor que o número da rodada atual.
	 * Após a execução de todas as rodadas permitidas, a variável rodadaAtual sofre um último
	 * incremento, definindo assim a condição true (bar fechado)
	 */
	public boolean mFecharBar()
	{
		if(getNumeroDeRodada() < getRodadaAtual())
		{
			return true;//Bar Fechado
		}
		else
		{
			return false;//Bar aberto
		}
	}
	
	//Métodos Get da minha classe Bar
	public int getNumeroDeCliente() 
	{
		return numeroDeCliente;
	}

	public int getNumeroDeGarcom() 
	{
		return numeroDeGarcom;
	}

	public int getNumeroDeRodada() 
	{
		return numeroDeRodada;
	}

	public int getRodadaAtual() 
	{
		return rodadaAtual;
	}

	public int getCapacidadeGarcom() 
	{
		return capacidadeGarcom;
	}
}
