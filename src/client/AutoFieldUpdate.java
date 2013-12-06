package client;

import client.prefs.PrefsDynamics;

/**
 * AutoFieldUpdate 
 * resyncs data with the server such as currently playing track
 * @author gs
 *
 */
public class AutoFieldUpdate implements Runnable
{
	private RemoteControl rc;
	private Thread updater;
	
	AutoFieldUpdate(RemoteControl rc)
	{
		this.rc = rc;
		updater = new Thread(this, "updater");
		updater.start();
	}
	
	public void run()
	{
		while(true)
		{
			// must catch the first null pointer since the async connection may not be completed yet
			try{
				rc.updateNowPlaying();
			}
			catch(NullPointerException e){
				e.printStackTrace();
			}

			try{
				Thread.sleep(PrefsDynamics.fieldUpdateTime);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}//end while
		
	}//end run()
}
