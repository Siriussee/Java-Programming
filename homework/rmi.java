import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.UnknownHostException;

public class rmi {
    public static void main(String... args) throws RemoteException, java.net.UnknownHostException, MalformedURLException, NotBoundException {
        information obj = null;
        String name="",os="";
        try{
            obj = (information) Naming.lookup("//"+"/info");
            name = obj.getName();
            os = obj.getOs();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(name + ":" + os);
    }
}
