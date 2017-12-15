package RMI;

import java.rmi.Naming; 
import java.rmi.RemoteException; 

public class GetInfoClient { 

  public static void main(String args[]) {
    String message = "Hello: This is my test message"; 
  
    // "obj" is the identifier that we'll use to refer 
    // to the remote object that implements the "Hello" 
    // interface 
    
    GetInfo obj = null; 

    try { 
	    obj = (GetInfo)Naming.lookup("rmi://127.0.0.1:6600/GetInfoServer");
	    message = "OS of " + obj.getName() + " is " + obj.getOs(); 
	} catch (Exception e) { 
	    System.out.println("GetInfoClient exception: " + e.getMessage()); 
	    e.printStackTrace(); 
	} 
    System.out.println(message);
  } // end of main
} // end of HelloClient

