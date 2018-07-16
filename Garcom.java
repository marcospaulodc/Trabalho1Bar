package Trabalho1;
/**
 * @author Marcos Paulo de Castro
 */

public class Garcom extends Thread
{
	private Bar bar;
	private Pedido pedido;
	private int id;
	
	public Garcom(Bar bar, Pedido pedido, int id)
	{
		this.bar = bar;
		this.pedido = pedido;
		this.id = id;
	}
	
	@SuppressWarnings("deprecation")
	public void mRegistrarPedido()
	{
		synchronized (this.pedido)//recebendo o objeto compartilhado
		{
			if(this.pedido.mTodosOsGarconsAtenderam())
			{
				if(!this.pedido.mExistePedidos())
				{
				//Preparando para a pr�xima rodada, incremento e limpeza no registro de pedidos.
				bar.setUmaNovaRodada();
				this.pedido.mLimparPedidos();
				}
			}
			else if(this.pedido.mTodosOsClientesPediram())
			{
				if(!this.pedido.mGarcomAtendeu(this.id))
				{
					System.out.println("Gar�om " + this.id + " atendeu!");
					this.pedido.mAdicionarGarcom(this.id);
					
					//Condi��o para satisfazer quando o cliente n�o realizar seu pedido
					if(!this.pedido.mExistePedidos())//false: n�o h� pedido
					{
						System.out.println("Ningu�m pediu!");
					}
					for (int i = 0; i < bar.getCapacidadeGarcom(); i++)
					{
						if(this.pedido.mExistePedidos())
						{
							int receberPedido = this.pedido.mReceberPedido();
							System.out.println("Cliente " + receberPedido + " recebeu o pedido!");
						}
					}
				}
			}
			this.pedido.notifyAll();//gar�om notifica que terminou seu servi�o
			
			if(!bar.mFecharBar())
			{
				try
				{
					this.pedido.wait();//gar�om aguarda, thread dorme, pois pode haver uma nova rodada onde poder� registrarPedido...
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
	}
	
	public void run()
	{
		while(!bar.mFecharBar())
		{
			mRegistrarPedido();//leva para o bloco syncronized - Gar�om
		}
		System.err.println("O Bar fechou, volte depois!!!");
	}
}
