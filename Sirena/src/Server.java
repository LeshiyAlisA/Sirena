import java.net.*;
import java.io.*;

public class Server {
	static ServerSocket serverSocket = null;
	static Socket client = null;
	static BufferedReader inbound = null;
	static OutputStream outbound = null;
	static int port = 23230;
	
		
   public static void main(String[] args)    { 	   
	   try {
		   serverSocket = new ServerSocket(port);
		   System.out.println("Wait....");
		   while(true){
			   client = serverSocket.accept(); 	
			   new SE100Socket(client);
		   }		   
	   }
	   catch (IOException ioe){
		   System.out.println("Error in server " + ioe);
	   } 
   }
}