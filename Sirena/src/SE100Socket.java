import java.io.*;
import java.net.*;

public class SE100Socket extends Thread implements Protokol{
	private Socket socket;
	private BufferedInputStream in;
	private OutputStream out;
	private AnswerPacket bi;
	
	public SE100Socket(Socket s){
		System.out.println("connected..."+s.getInetAddress());
		socket = s;
		
		try {
			in = new BufferedInputStream(socket.getInputStream());
			out = socket.getOutputStream();
			socket.setSoTimeout(5000);
			start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
	public void run(){
		int byteValue;
		bi = new AnswerPacket();
		try {
	         while (true) {
	        	 boolean eof = false;
	        	 byte b;	        	 
	        	 System.out.println("Echoing: ");
	        	 while (!eof){
	        		 byteValue = in.read();
	        		 if (byteValue == 1){
		        		 System.out.println("!!!!!!!!!!!!!!!!!!!1");
		        		 b=2;
		        		 out.write(b);
		        	 };
		        	 if (byteValue == 3){
		        		 System.out.println("!!!!!!!!!!!!!!!!!!!3");
		        		 b=4;
		        		 out.write(b);
		        		 SE100 rp = new SE100();
		        		 rp.receivePacket(this.bi);
		        		 
		        	 }; 
	        		 //System.out.println(byteValue+',');
	        		 if (byteValue == -1)
	        			 eof = true;
	        	 }       	 
	            
	            	           
	         }	         
	      }
	      catch (IOException e) {
	         System.err.println("IO Exception");
	      }
	      finally {
	         try {
	            socket.close();
	         }
	         catch (IOException e) {
	            System.err.println("Socket not closed");
	         }
	      }
	   
	}

}
