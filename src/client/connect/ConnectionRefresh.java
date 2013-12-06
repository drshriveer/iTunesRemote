package client.connect;

import client.prefs.PrefsDynamics;

public class ConnectionRefresh implements Runnable
{
	private RemoteExClient rec;
	private Thread connectionUpdater;
	
	ConnectionRefresh(RemoteExClient rec)
	{
		this.rec = rec;
		connectionUpdater = new Thread(this, "updater");
		//updater.start();
	}
	
	public void refresh()
	{
		connectionUpdater.start();
	}
	
	public void run()
	{
		while(!rec.connect())
		{
			System.out.println("connection failed, retrying in " +PrefsDynamics.connectionUpdateTime + "ms");
			try
			{ 
				Thread.sleep(PrefsDynamics.connectionUpdateTime);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}//end while
	}
}
