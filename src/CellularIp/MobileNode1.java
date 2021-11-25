package CellularIp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MobileNode1 {
	public static void main(String args[]) throws Exception
	   {
		System.out.println("Mobile Node 1");
		 int basestationport = 4000;
	     for(int i=1;i<5;i++)
	     { 
	      DatagramSocket DataSourceSocket = new DatagramSocket();
	      InetAddress basestationhost = InetAddress.getByName("127.0.0.1");  
	      String x=Integer.toString(i)+","+ new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
	      
	      DatagramPacket sendPacket = new DatagramPacket(x.getBytes(), x.length(), basestationhost,basestationport);
	      try {
	    	  DataSourceSocket.send(sendPacket);
	    	}
	    	catch(Exception e) {
	    	  System.out.println(e);
	    	}
	     
	      System.out.println("Sequence Number (Mobile Node 1): "+i+" Time: "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())+ " Dest ="+ basestationhost.getHostAddress()+"/"+basestationport);
	   
	      DataSourceSocket.close();
	     }
	}
}
