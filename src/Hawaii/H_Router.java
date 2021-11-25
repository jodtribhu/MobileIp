package Hawaii;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class H_Router {
	 public static void main(String args[]) throws Exception 
	    {
		
			  int hrouterPort = 4200;
			  int foreign_domain_router_port  = 4050;
			  System.out.println("IN home domain router");
		      DatagramSocket ForeignAgentSocket = new DatagramSocket(4200);
		    
		      InetAddress foreign_domain_routerAddress = InetAddress.getByName("127.110.2.1"); 

		      byte[] receiveData2 = new byte[1024]; 
		      byte[] sendData  = new byte[1024];
			  DatagramPacket reciver2 = new DatagramPacket(receiveData2,
						1024);

	      while(true) 
	        {
	    	  
			  ForeignAgentSocket.receive(reciver2);
	    	  String str = new String(reciver2.getData(), 0, reciver2.getLength()); 
	    	  System.out.println("Sequence Number recieved in Home Router = "+str+" Time = "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())+ " Forwarded to Home domain root  router :"+ foreign_domain_routerAddress.getHostAddress()+"/"+foreign_domain_router_port);
	    	  DatagramPacket sendPacket = new DatagramPacket(str.getBytes(), str.getBytes().length, foreign_domain_routerAddress, foreign_domain_router_port);
	    	  ForeignAgentSocket.send(sendPacket);
	        }
	      
	    } 
}
