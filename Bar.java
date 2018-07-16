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
	
	/* M�todo que fecha o bar, caso o n�mero de rodada for menor que o n�mero da rodada atual.
	 * Ap�s a execu��o de todas as rodadas permitidas, a vari�vel rodadaAtual sofre um �ltimo
	 * incremento, definindo assim a condi��o true (bar fechado)
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
	
	//M�todos Get da minha classe Bar
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
