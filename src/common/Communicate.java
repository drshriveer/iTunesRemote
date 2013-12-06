package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Communicate extends Remote 
{
    void playPause() throws RemoteException;
    
    void play() throws RemoteException;
    
    void pause() throws RemoteException;
    
    void stop() throws RemoteException;
    
    void next() throws RemoteException;
    
    void previous() throws RemoteException;
    
    String[] getCurrentTrack() throws RemoteException;
    
    String sayHello() throws RemoteException;
    
}