package Hawaii;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Foreign_Domain_router {
	 public static void main(String args[]) throws Exception 
	    {
		 System.out.println("In foreign domain root router");
			  int F_domain_router_Port = 4078;
			  int F_router_Port=4100;
		      DatagramSocket F_router_Socket = new DatagramSocket(F_domain_router_Port);
		      InetAddress F__routerAddress = InetAddress.getByName("127.200.2.1");
		      byte[] receiveData2 = new byte[1024]; 
		      byte[] sendData  = new byte[1024];
			  DatagramPacket reciver2 = new DatagramPacket(receiveData2,
						1024);

	      while(true) 
	        {
	    	  Thread.sleep(2000);
	    	  F_router_Socket.receive(reciver2);
	    	  String str = new String(reciver2.getData(), 0, reciver2.getLength()); 
	    	  System.out.println("Sequence Number in foreign domain root router  = "+str+" Time = "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())+" Forwarded to foreign domain router :"+ F__routerAddress.getHostAddress()+"/"+F_router_Port);
	    	  DatagramPacket sendPacket = new DatagramPacket(str.getBytes(), str.getBytes().length, F__routerAddress, F_router_Port);
	    	  F_router_Socket.send(sendPacket);
	        }
	      
	    } 
}
