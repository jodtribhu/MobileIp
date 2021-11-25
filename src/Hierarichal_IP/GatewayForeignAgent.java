package Hierarichal_IP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class GatewayForeignAgent {
	 public static void main(String args[]) throws Exception 
	    {
		
			  int foreignAgentPort = 4050;
			  int correspondantNodePort  = 4020;
			  System.out.println("IN GFA");
		      DatagramSocket ForeignAgentSocket = new DatagramSocket(4050);
		    
		  	   InetAddress correspondantAddress = InetAddress.getByName("127.142.2.1"); 

		      byte[] receiveData2 = new byte[1024]; 
		      byte[] sendData  = new byte[1024];
			  DatagramPacket reciver2 = new DatagramPacket(receiveData2,
						1024);

	      while(true) 
	        {
	    	  Thread.sleep(2500);
			  ForeignAgentSocket.receive(reciver2);
	    	  String str = new String(reciver2.getData(), 0, reciver2.getLength()); 
	    	  System.out.println("Sequence Number recieved in Gateway FA = "+str+" Time = "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())+ " Forwarded to Correspondant Node :"+ correspondantAddress.getHostAddress()+"/"+correspondantNodePort);
	    	  DatagramPacket sendPacket = new DatagramPacket(str.getBytes(), str.getBytes().length, correspondantAddress, correspondantNodePort);
	    	  ForeignAgentSocket.send(sendPacket);
	        }
	      
	    } 
}
