package CellularIp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Gateway {
	 public static void main(String args[]) throws Exception 
	    {
		
			  int gatewayPort = 4200;
			  int base_station2_port  = 4050;
			  System.out.println("IN Gateway");
		      DatagramSocket ForeignAgentSocket = new DatagramSocket(gatewayPort);
		    
		      InetAddress base_station2_Address = InetAddress.getByName("127.110.2.1"); 

		      byte[] receiveData2 = new byte[1024]; 
		      byte[] sendData  = new byte[1024];
			  DatagramPacket reciver2 = new DatagramPacket(receiveData2,
						1024);

	      while(true) 
	        {
	    	  Thread.sleep(2000);
			  ForeignAgentSocket.receive(reciver2);
	    	  String str = new String(reciver2.getData(), 0, reciver2.getLength()); 
	    	  System.out.println("Sequence Number recieved in Gateway = "+str+" Time = "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())+ " Forwarded to Base Station 2 :"+ base_station2_Address.getHostAddress()+"/"+base_station2_port);
	    	  DatagramPacket sendPacket = new DatagramPacket(str.getBytes(), str.getBytes().length, base_station2_Address, base_station2_port);
	    	  ForeignAgentSocket.send(sendPacket);
	        }
	      
	    } 
}
