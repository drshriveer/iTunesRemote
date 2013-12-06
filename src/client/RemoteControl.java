package client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import client.connect.RemoteExClient;


/*
 * TODO:
 * -make "connecting dialog" for when first opened
 * -enable there to be a default display
 * -when user clicks next, play, or previous app checks if connected, and if not attempts to connect again
 * +get the auto refrsh down (this can also have auto connect if not connected in it)
 */


public class RemoteControl  extends JPanel implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	//
	//	BUTTONS
	//
	private JButton playPause_button = new JButton("Play/Pause");
	private JButton stop_button = new JButton("Play/Pause");
	private JButton	next_button = new JButton("Next");
	private JButton previous_button = new JButton("Previous");
	
	//
	//	Currently Playing
	//
	private String[] currentlyPlaying;
	private JTextField currentName = new JTextField();
	private JTextField currentArtist = new JTextField();
	private JTextField currentAlbum = new JTextField();
	
	
	//
	//	NETWORK COMMUNICATION
	//
	private RemoteExClient remote;
	private AutoFieldUpdate afu;
	
	public RemoteControl()
	{
		//
		//	SETUP PANEL
		//
		super(new BorderLayout());
		
		//
		//	CONNECT TO SERVER
		//
		remote = new RemoteExClient();
		
		//
		//	BUILD GUI
		//
		buildGUI();
		
		//
		//  UPDATE NOW PLAYING 
		//
		afu = new AutoFieldUpdate(this);

	}
	
	private void buildGUI()
	{
		//
		//	ACTION LISTENERS 
		//
		playPause_button.addActionListener(this);
		stop_button.addActionListener(this);
		next_button.addActionListener(this);
		previous_button.addActionListener(this);
		
		//
		//	ADD BUTTONS TO PANEL
		//
		this.add(playPause_button,BorderLayout.CENTER);
		this.add(next_button, BorderLayout.EAST);
		this.add(previous_button, BorderLayout.WEST);
	
		//
		//	TRACK INFO BOX SETUP
		//
		currentName.setEditable(false);
		currentName.setBorder(null);
		currentName.setDisabledTextColor(Color.black);
		currentName.setBackground(this.getBackground());
		
		currentArtist.setEditable(false);
		currentArtist.setBorder(null);
		currentArtist.setDisabledTextColor(Color.black);
		currentArtist.setBackground(this.getBackground());
		
		currentAlbum.setEditable(false);
		currentAlbum.setBorder(null);
		currentAlbum.setDisabledTextColor(Color.black);
		currentAlbum.setBackground(this.getBackground());
		
		JPanel pan = new JPanel(new GridLayout(3,1));
		pan.add(currentName);
		pan.add(currentArtist);
		pan.add(currentAlbum);
		
		this.add(pan, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (playPause_button == e.getSource())
		{
			remote.playPause();
			updateNowPlaying();
		}
		else if (next_button == e.getSource())
		{
			remote.next();
			updateNowPlaying();
		}
		else if (previous_button == e.getSource())
		{
			remote.previous();
			updateNowPlaying();
		}
		
	}
	
	public void updateNowPlaying()
	{
		currentlyPlaying = remote.getCurrentTrack();
		currentName.setText("Name:  "+currentlyPlaying[0]);
		currentArtist.setText("Artist:  "+currentlyPlaying[1]);
		currentAlbum.setText("Album:  "+currentlyPlaying[2]);
	}
	
	private void updateTimer()
	{
		while(true)
		{
			updateNowPlaying();
			try
			{ 
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	  private static void createAndShowGUI() 
		{
	        //Create and set up the window.
	        JFrame frame = new JFrame("iTunes Remote Control");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        
	        //Add content to the window.
	        frame.add(new RemoteControl(), BorderLayout.CENTER);
	        
	        //Display the window.
	        frame.pack();
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }
	    
	    public static void main(String[] args) 
	    {
	        //Schedule a job for the event dispatch thread:
	        //creating and showing this application's GUI.
	        SwingUtilities.invokeLater(new Runnable() 
	        {
	            public void run() 
	            {
	                //Turn off metal's use of bold fonts
	            	UIManager.put("swing.boldMetal", Boolean.FALSE);
	            	createAndShowGUI();
	            	//run();
	            	//updateTimer();
	            }
	        });
	        //updateTimer();
	    }



}
