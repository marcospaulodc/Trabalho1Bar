package Trabalho1;
/**
 * @author Marcos Paulo de Castro
 */

import java.util.Random;

public class Cliente extends Thread
{
	private Bar bar;
	private Pedido pedido;
	private int id;
	
	public Cliente(Bar bar, Pedido pedido, int id)
	{
		this.bar = bar;
		this.pedido = pedido;
		this.id = id;
	}
	
	@SuppressWarnings("deprecation")
	public void mFazerPedido()
	{
		Random rd = new Random();
		synchronized (this.pedido) 
		{
			if(!this.pedido.mTodosOsClientesPediram())//false: todos os clientes ainda n�o pediram
			{
				if(!this.pedido.mClientePediu(this.id))//false: o cliente ainda n�o fez pedido
				{
					this.pedido.mAdicionarCliente(this.id);
					if(rd.nextInt(2) == 1)
					{
						this.pedido.mAdicionarPedido(this.id);
						System.out.println("Cliente " + this.id + " fez um pedido.");
					}
					this.pedido.notify();//notifica que o cliente fez um pedido
					try
					{
						this.pedido.wait();//cliente aguarda o seu pedido, thread dorme...
						if(this.pedido.mExistePedidos() && this.pedido.mTodosOsGarconsAtenderam())
						{
							System.err.println("*** Aten��o ***! Bar com muitos clientes e poucos gar�ons, execute o programa novamente!");
							Thread.currentThread().suspend();
						}
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
			}
			this.pedido.notifyAll();//notifica as threads dos gar�ons que todos os clientes pediram...
			if (!bar.mFecharBar()) 
			{
				try 
				{
					this.pedido.wait();//cliente aguarda, thread dorme, pois pode haver uma nova rodada onde poder� fazerPedido...
				} 
				catch (InterruptedException e) 
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public void run()
	{
		while(!bar.mFecharBar())//verifica se o bar n�o est� fechado
		{
			mFazerPedido();//leva para o bloco syncronized - Cliente
		}
	}
	
}
