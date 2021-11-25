package CellularIp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BaseStation2 {
	 public static void main(String args[]) throws Exception 
	    {
		
			  int base_station_2_Port = 4050;
			  int mobile_node_2_Port  = 4078;
			  System.out.println("IN Base Station 2");
		      DatagramSocket mobile_node_2_Socket = new DatagramSocket(4050);
		    
		  	   InetAddress mobile_node_2_Socket_Address = InetAddress.getByName("127.142.2.1"); 

		      byte[] receiveData2 = new byte[1024]; 
		      byte[] sendData  = new byte[1024];
			  DatagramPacket reciver2 = new DatagramPacket(receiveData2,
						1024);

	      while(true) 
	        {
	    	  
	    	  mobile_node_2_Socket.receive(reciver2);
	    	  String str = new String(reciver2.getData(), 0, reciver2.getLength()); 
	    	  System.out.println("Sequence Number recieved in Base Station 2 = "+str+" Time = "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())+ " Forwarded to mobile node 2 :"+ mobile_node_2_Socket_Address.getHostAddress()+"/"+mobile_node_2_Port);
	    	  DatagramPacket sendPacket = new DatagramPacket(str.getBytes(), str.getBytes().length, mobile_node_2_Socket_Address, mobile_node_2_Port);
	    	  mobile_node_2_Socket.send(sendPacket);
	        }
	      
	    } 
}
