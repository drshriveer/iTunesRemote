package client.connect;

import java.rmi.ConnectException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.Communicate;
import client.prefs.PrefsDynamics;

public class RemoteExClient
{
	private Communicate stub;
	private ConnectionRefresh cr;
	
	public RemoteExClient() 
	{
		cr = new ConnectionRefresh(this);
		cr.refresh();
	}
	
	public boolean connect() throws ConnectException, RemoteException, NotBoundException
	{
		try
		{
				Registry registry = LocateRegistry.getRegistry(PrefsDynamics.serverAddress);
				stub = (Communicate) registry.lookup("Communicate");
			 
				String response = stub.sayHello();
				System.out.println("response: " + response);
		}
		catch(ConnectException e)
		{
			return false;
		}
		catch(RemoteException e)
		{
			return false;
		}
		catch(NotBoundException e)
		{
			return false;
		}
		
		return true;
	}
 
	public void playPause()
	{
		try
		{
			stub.playPause();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
			cr.refresh(); //assumes that the connection to server has been lost, attempts to reconnect.
		}
	}
		
	public void play()
	{
		try
		{
			stub.play();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
			cr.refresh(); //assumes that the connection to server has been lost, attempts to reconnect.

		}
	}
		
	public void pause()
	{
		try
		{
			stub.pause();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
			cr.refresh(); //assumes that the connection to server has been lost, attempts to reconnect.

		}
	}
		
	public void stop()
	{
		try
		{
			stub.stop();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
			cr.refresh(); //assumes that the connection to server has been lost, attempts to reconnect.
		}
	}
		
	public void next()
	{
		try
		{
			stub.next();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
			cr.refresh(); //assumes that the connection to server has been lost, attempts to reconnect.
		}
	}
		
	public void previous()
	{
		try
		{
			stub.previous();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
			cr.refresh(); //assumes that the connection to server has been lost, attempts to reconnect.
		}
	}
		
	public String[] getCurrentTrack()
	{
		System.out.println(stub.toString());
		// System.out.println(stub.getCurrentTrack.()toString());
		try
		{
			return stub.getCurrentTrack();
		}
		catch (RemoteException e)
		{
			e.printStackTrace();
			cr.refresh(); //assumes that the connection to server has been lost, attempts to reconnect.
		}		
		return new String[]{null,null,null};
	}
		
	public static void main(String[] args)
	{
		new RemoteExClient();
	}	
		
		
}