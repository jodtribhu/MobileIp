package Hawaii;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class F_Base_Station {
	 public static void main(String args[]) throws Exception 
	    {
		 System.out.println("In foreign domain base station");

			  int F_bs_Port = 4120;
			  int mobile_node_domain_Port=4140;
		      DatagramSocket F_router_Socket = new DatagramSocket(F_bs_Port);
		      InetAddress mobile_node_domain_Address = InetAddress.getByName("127.230.2.1");
		      byte[] receiveData2 = new byte[1024]; 
		      byte[] sendData  = new byte[1024];
			  DatagramPacket reciver2 = new DatagramPacket(receiveData2,
						1024);

	      while(true) 
	        {
	    	  Thread.sleep(2000);
	    	  F_router_Socket.receive(reciver2);
	    	  String str = new String(reciver2.getData(), 0, reciver2.getLength()); 
	    	  System.out.println("Sequence Number in foreign base station  = "+str+" Time = "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())+" Forwarded to foreign mobile node :"+ mobile_node_domain_Address.getHostAddress()+"/"+mobile_node_domain_Port);
	    	  DatagramPacket sendPacket = new DatagramPacket(str.getBytes(), str.getBytes().length, mobile_node_domain_Address, mobile_node_domain_Port);
	    	  F_router_Socket.send(sendPacket);
	        }
	      
	    } 
}
