package mail;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.Queue;

public class MessagePoolServer extends UnicastRemoteObject implements MessagePool {
    Queue<String> store;
    final int max_size = 100;

    class QueueFullException extends Exception{
        public QueueFullException(String msg){
            super(msg);
        }
    }

    class MessageNullException extends Exception{
        public MessageNullException(String msg){
            super(msg);
        }
    }

    class QueueEmptyException extends Exception{
        public QueueEmptyException(String msg){
            super(msg);
        }
    }

    public MessagePoolServer() throws RemoteException{
        store = new LinkedList<String>();
    }

    @Override
    public void put(String msg) throws RemoteException, QueueFullException, MessageNullException {
        if(msg.length()<=100 && msg.length() > 0 && store.size() < 100)
            store.add(msg);
        else{
            if(store.size() >= 100)
                throw new QueueFullException("queue full");
            else
                throw new MessageNullException("no message");
        }
    }

    @Override
    public String get() throws RemoteException, QueueEmptyException {
        if(store.size() > 0)
            return store.poll();
        else{
            throw new QueueEmptyException("queue empty");
        }
    }

    public static void main(String... args) throws RemoteException, MalformedURLException {
        MessagePoolServer obj = new MessagePoolServer();
        LocateRegistry.createRegistry(6600);
        Naming.rebind("rmi://127.0.0.1:6600/MailServer", obj);
        System.out.println("In registry");
    }
}
