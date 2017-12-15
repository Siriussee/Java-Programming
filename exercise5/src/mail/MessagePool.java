package mail;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MessagePool extends Remote {
    public void put(String msg) throws RemoteException, MessagePoolServer.QueueFullException, MessagePoolServer.MessageNullException;
    public String get() throws RemoteException, MessagePoolServer.QueueEmptyException;
}
