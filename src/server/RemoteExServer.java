package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import common.Communicate;


public class RemoteExServer implements Communicate 
{
	//
	//	FOR EXECUTION
	//
	Runtime runtime;
	
	
	public RemoteExServer()
	{
		runtime = Runtime.getRuntime();
	}
	
	//
	//	SCRIPT EXECUTION COMMANDS
	//
	public void playPause()
	{		
		try
		{
			Process process = runtime.exec(ServerConsts.PLAY_PAUSE);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void play()
	{
		try
		{
			Process process = runtime.exec(ServerConsts.PLAY);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void stop()
	{
		try
		{
			Process process = runtime.exec(ServerConsts.STOP);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void pause()
	{
		try
		{
			Process process = runtime.exec(ServerConsts.PAUSE);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void next()
	{
		try
		{
			Process process = runtime.exec(ServerConsts.NEXT);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void previous()
	{
		try
		{
			Process process = runtime.exec(ServerConsts.PREVIOUS);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public String[] getCurrentTrack()
	{
		String[] trackInfo = {null,null,null};
		try
		{
			Process process = runtime.exec(ServerConsts.CURRENT_NAME);
			trackInfo[0] = (new BufferedReader(new InputStreamReader(process.getInputStream()))).readLine();
			process = runtime.exec(ServerConsts.CURRENT_ARTIST);
			trackInfo[1] = (new BufferedReader(new InputStreamReader(process.getInputStream()))).readLine();
			process = runtime.exec(ServerConsts.CURRENT_ALBUM);
			trackInfo[2] = (new BufferedReader(new InputStreamReader(process.getInputStream()))).readLine();
			
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return trackInfo;
	}
	
	public String sayHello() throws RemoteException
	{
		return "hello, first contact made";
	}
	
	
    public static void main (String args[]) 
	{
        try 
		{
        	try 
        	{
	       		 java.rmi.registry.LocateRegistry.createRegistry(1099);
	       		 System.out.println("RMI registry ready.");
       	  	}
        	catch (Exception e) 
        	{
	       		 System.out.println("Exception starting RMI registry: (or RMI registry already started)");
       	  	}	
       		 
			RemoteExServer obj = new RemoteExServer();
			Communicate stub = (Communicate) UnicastRemoteObject.exportObject(obj, 0);
			
			// Bind the remote object's stub in the registry
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("Communicate", stub);
			
			System.err.println("Server ready");
			
		} catch (Exception e) 
		{
			System.err.println("Server exception: " + e.toString());
			e.printStackTrace();
		}
		
    }
  
   
}
