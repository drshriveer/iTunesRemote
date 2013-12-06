package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ServerConsts
{
	//
	//	APPLE SCRIPT COMMANDS
	//
	public static final String[] PLAY_PAUSE = {"osascript","-e","tell app \"iTunes\" to playpause"};
	public static final String[] PLAY = {"osascript","-e","tell app \"iTunes\" to play"};
	public static final String[] PAUSE = {"osascript","-e","tell app \"iTunes\" to pause"};
	public static final String[] STOP = {"osascript","-e","tell app \"iTunes\" to stop"};
	public static final String[] NEXT = {"osascript","-e","tell app \"iTunes\" to next track"};
	public static final String[] PREVIOUS = {"osascript","-e","tell app \"iTunes\" to previous track"};
	public static final String[] CURRENT_NAME = {"osascript","-e","tell app \"iTunes\" to name of current track"};
	public static final String[] CURRENT_ARTIST = {"osascript","-e","tell app \"iTunes\" to artist of current track"};
	public static final String[] CURRENT_ALBUM = {"osascript","-e","tell app \"iTunes\" to album of current track"};
	public static final String[] CURRENT_DURATION =  {"osascript","-e","tell app \"iTunes\" to duration of current track"};
	public static final String[] CURRENT_POSITION =  {"osascript","-e","tell app \"iTunes\" to player position"};
	
	//
	// ONLY FOR TESTING BELOW:
	//
	
	public static void main(String args[])
	{
		Runtime runtime;
		runtime = Runtime.getRuntime();
		
		try
		{
			Process process = runtime.exec(CURRENT_POSITION);
			System.out.println((new BufferedReader(new InputStreamReader(process.getInputStream()))).readLine());
			process = runtime.exec(CURRENT_NAME);
			System.out.println((new BufferedReader(new InputStreamReader(process.getInputStream()))).readLine());
			process = runtime.exec(CURRENT_ARTIST);
			System.out.println((new BufferedReader(new InputStreamReader(process.getInputStream()))).readLine());
			process = runtime.exec(CURRENT_ALBUM);
			System.out.println((new BufferedReader(new InputStreamReader(process.getInputStream()))).readLine());
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
}


