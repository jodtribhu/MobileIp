package Hawaii;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class F_Router {
	 public static void main(String args[]) throws Exception 
	    {
		 System.out.println("In foreign domain router");
			  int F_router_Port = 4100;
			  int F_BS_Port=4120;
		      DatagramSocket F_router_Socket = new DatagramSocket(F_router_Port);
		      InetAddress F_BS_routerAddress = InetAddress.getByName("127.210.2.1");
		      byte[] receiveData2 = new byte[1024]; 
		      byte[] sendData  = new byte[1024];
			  DatagramPacket reciver2 = new DatagramPacket(receiveData2,
						1024);

	      while(true) 
	        {
	    	 
	    	  F_router_Socket.receive(reciver2);
	    	  String str = new String(reciver2.getData(), 0, reciver2.getLength()); 
	    	  System.out.println("Sequence Number in foreign domain router  = "+str+" Time = "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())+" Forwarded to foreign base station :"+ F_BS_routerAddress.getHostAddress()+"/"+F_BS_Port);
	    	  DatagramPacket sendPacket = new DatagramPacket(str.getBytes(), str.getBytes().length, F_BS_routerAddress, F_BS_Port);
	    	  F_router_Socket.send(sendPacket);
	        }
	      
	    } 
}
