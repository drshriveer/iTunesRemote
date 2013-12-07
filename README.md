iTunesRemote
============

This is a simple iTunesRemote control (for use between computers) using Java and Java's RMI. It requires the use of a RMI server (included), and client computer. It was written several years ago for personal use -- I've finally gotten around to open sourcing some of my old projects

##### Server does NOT support Windows. Only OSX.
##### Client supports any OS.

Usage
-------------
As this was originally a personal project for home use it was not built out very much. It allows you to play, pause, and skip tracks. To set it up you will need to modify the source file `src/client/prefs/PrefsDynamics.java` and change the serverAddress to the ip or dns of the computer the server will run on. This line looks like:

      public static String serverAddress = "127.0.0.1";

Just change the address to whatever works for you. For example `192.168.10.1`, `www.myhomeserver.com`.

The server can only be run on OSX as it makes use of applescript commands to control iTunes. No additional setup should be required to run the server besides compiling and running! 

To compile and run the program navigate to the `src` directory in a terminal and type:

    $ javac server/*.java             # to compile
    $ java server/RemoteExServer      # to run the server

    $ javac client/*.java             # to compile
    $ java client/RemoteControl       # to run the server


##### Alternatively
  Alternatively, use fatJAR or another JARing program and create `.jar` files for the client and server independently so that you can run them with a double click! 

Questions & Comments
-------------
If you have any questions or comments about the code don’t hesitate to contact me at [gavin.shriver@gmail.com](mailto:gavin.shriver@gmail.com) I'll do my best to help in any way I can!.



License
-------------
© Gavin Shriver. CC BY-SA.   
( You can find the full license [here](http://creativecommons.org/licenses/by-sa/4.0/legalcode) )
