package socket;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
	public ServerSocket svrSocket = null;
	public Socket socket = null;
	public InputStream inputStream = null;
	public OutputStream outputStream = null;
	public DataInputStream dataStream = null;
	public PrintStream printStream = null;
	public DataOutputStream dataoutputStream = null;
	public String message;
	public BufferedReader charStream = new BufferedReader(new InputStreamReader(System.in));

	public Server() {
		try {
			svrSocket = new ServerSocket(1056);
			System.out.println("\nInitializing Port...");
			System.out.println("\nListen...");
			socket = svrSocket.accept();
			System.out.println("\nConnect to Client!\n");
			inputStream = socket.getInputStream();
			dataStream = new DataInputStream(inputStream);
			outputStream = socket.getOutputStream();
			dataoutputStream = new DataOutputStream(outputStream);

			message = dataStream.readUTF();
			System.out.println(message + "\n");
		} catch (UnknownHostException e) {
			System.out.println("Error : Cannot find server." + e);
		} catch (IOException e) {
			System.out.println("Error : I/O Error." + e);
		}
	}

	public void readSocket() {
		try {

			message = dataStream.readUTF();
			System.out.println(">> " + message + "\n");

		} catch (UnknownHostException e) {
			System.out.println("Error : Cannot find server." + e);
		} catch (IOException e) {
			System.out.println("Error : I/O Error." + e);
		}
	}

	public void writeSocket() {
		try {
			
			String initmsg_r = new String("<< ");
			dataoutputStream.writeUTF(initmsg_r);
			System.out.print("<< ");
			Scanner input = new Scanner(System.in);
			String messageToSend = input.nextLine();
			dataoutputStream.writeUTF(messageToSend);
			//message = charStream.readLine();

		} catch (UnknownHostException e) {
			System.out.println("Error : Cannot find server." + e);
		} catch (IOException e) {
			System.out.println("Error : I/O Error." + e);
		}
	}

	public static void main(String args[]) {
		Server svr = new Server();
		for (;;) {
			svr.writeSocket();
			svr.readSocket();
		}
	}
}
// End of Server
