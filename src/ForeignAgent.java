import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class ForeignAgent {
	 public static void main(String args[]) throws Exception 
	    {
		
			  int foreignAgentPort = 4001;
			  int mobileNodePort  = 4004;
			  System.out.println("IN FA");
		      DatagramSocket ForeignAgentSocket = new DatagramSocket(4200);
		    
		  	   InetAddress mobileAddress = InetAddress.getByName("127.150.2.1"); 

		      byte[] receiveData2 = new byte[1024]; 
		      byte[] sendData  = new byte[1024];
			  DatagramPacket reciver2 = new DatagramPacket(receiveData2,
						1024);

	      while(true) 
	        {
	    	  Thread.sleep(3000);
			  ForeignAgentSocket.receive(reciver2);
	    	  String str = new String(reciver2.getData(), 0, reciver2.getLength()); 
	    	  System.out.println("Sequence Number recieved in FA = "+str+" Time = "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())+ " Forwarded to Correspondant Node :"+ mobileAddress.getHostAddress()+"/"+mobileNodePort);
	    	  DatagramPacket sendPacket = new DatagramPacket(str.getBytes(), str.getBytes().length, mobileAddress, mobileNodePort);
	    	  ForeignAgentSocket.send(sendPacket);
	        }
	      
	    } 
}
