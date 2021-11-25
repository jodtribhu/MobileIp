package Hierarichal_IP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Mobile_Node2 {
	   public static void main(String args[]) throws Exception
	   {

		 int homeagentport = 4010;
	     for(int i=1;i<5;i++)
	     { 
	      DatagramSocket DataSourceSocket = new DatagramSocket();
	      InetAddress homehost = InetAddress.getByName("127.0.0.10");  
	      DatagramPacket sendPacket = new DatagramPacket(Integer.toString(i).getBytes(), Integer.toString(i).length(), homehost,homeagentport);
	      try {
	    	  DataSourceSocket.send(sendPacket);
	    	}
	    	catch(Exception e) {
	    	  System.out.println(e);
	    	}
	     
	      System.out.println("Sequence Number: "+i+" Time: "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())+ " Dest ="+ homehost.getHostAddress()+"/"+homeagentport);
	      Thread.sleep(1000);
	      
	      DataSourceSocket.close();
	     }
	}
}
