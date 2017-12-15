package RMI;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.rmi.Naming;
import java.rmi.RMISecurityManager;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;


public class GetInfoImpl extends UnicastRemoteObject implements GetInfo {
	public GetInfoImpl() throws RemoteException {
		super();
	}

	@Override
	public String getName() throws RemoteException, UnknownHostException {
		return InetAddress.getLocalHost().getHostName();
	}

	@Override
	public String getOs() throws RemoteException {
		return System.getProperty("os.name");
	}

	public static void main(String args[]) {
		// Create and install a security manager
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new RMISecurityManager());
		}

		try {
			GetInfoImpl obj = new GetInfoImpl();
			LocateRegistry.createRegistry(6600);
			// Bind this object instance to the name "HelloServer"
			Naming.rebind("rmi://127.0.0.1:6600/GetInfoServer", obj);
			System.out.println("GetInfoServer bound in registry");
		} catch (Exception e) {
			System.out.println("GetInfoImpl err: " + e.getMessage());
			e.printStackTrace();
		}
	}

}
