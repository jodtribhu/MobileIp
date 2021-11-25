package Hawaii;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Home_Domain_router {
	 public static void main(String args[]) throws Exception 
	    {
		
			  int Home_domain_router_l_Port = 4050;
			  int Foreign_domain_router_l_Port  = 4078;
			  System.out.println("IN Home domain root router");
		      DatagramSocket Home_domain_l_Socket = new DatagramSocket(4050);
		    
		  	   InetAddress Foreign_domain_router_l_Address = InetAddress.getByName("127.142.2.1"); 

		      byte[] receiveData2 = new byte[1024]; 
		      byte[] sendData  = new byte[1024];
			  DatagramPacket reciver2 = new DatagramPacket(receiveData2,
						1024);

	      while(true) 
	        {
	    	  Thread.sleep(2000);
	    	  Home_domain_l_Socket.receive(reciver2);
	    	  String str = new String(reciver2.getData(), 0, reciver2.getLength()); 
	    	  System.out.println("Sequence Number recieved in Home domain root router = "+str+" Time = "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())+ " Forwarded to foreign domain root router :"+ Foreign_domain_router_l_Address.getHostAddress()+"/"+Foreign_domain_router_l_Port);
	    	  DatagramPacket sendPacket = new DatagramPacket(str.getBytes(), str.getBytes().length, Foreign_domain_router_l_Address, Foreign_domain_router_l_Port);
	    	  Home_domain_l_Socket.send(sendPacket);
	        }
	      
	    } 
}
