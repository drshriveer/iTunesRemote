package client.prefs;
/*
 * 	PrefsDynamics.java
 * 	Created by Gavin Shriver 1/07/2010
 * 
 * 	This class is meant to hold dynamic *settings* for the entire program. 
 * 	at the time of this note (3/26/10) I'm not sure if it is implemented yet.
 *  At the time of checking this note (12/05/13) settings are NOT implemented.
 *  However this is still where you would hard code useful values (such as serverAddress)!
 */


public class PrefsDynamics
{
	//
	//	CONNECTION PREFERENCES
	//
	public static String serverAddress = "127.0.0.1";
	public static int fieldUpdateTime = 1000; // milliseconds before updating field information
	public static int connectionUpdateTime = 5000; // milliseconds before attempting to reconnect
	
}
