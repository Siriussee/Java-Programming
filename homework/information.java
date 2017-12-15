import java.net.UnknownHostException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface information extends Remote {
    public String getName() throws RemoteException, UnknownHostException;
    public String getOs() throws RemoteException;
}
