import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Handler extends UnicastRemoteObject implements information {
    @Override
    public String getName() throws RemoteException, UnknownHostException {
        return InetAddress.getLocalHost().getHostName();
    }

    @Override
    public String getOs() throws RemoteException {
        return System.getProperty("os.name");
    }

    public Handler() throws RemoteException{
        super();
    }

    public static void main(String... args) throws RemoteException{
        try{
            Handler obj = new Handler();
            Naming.rebind("info",obj);
            System.out.println("In registry");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
