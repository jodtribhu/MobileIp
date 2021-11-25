package CellularIp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class MobileNode2 {
	 public static void main(String args[]) throws Exception 
	    {
		 System.out.println("In mobile Node 2");
			  int mobile_node_Port = 4078;
			  int F_router_Port=4100;
		      DatagramSocket F_router_Socket = new DatagramSocket(mobile_node_Port);
		      InetAddress F__routerAddress = InetAddress.getByName("127.200.2.1");
		      byte[] receiveData2 = new byte[1024]; 
		      byte[] sendData  = new byte[1024];
			  DatagramPacket reciver2 = new DatagramPacket(receiveData2,
						1024);
			  long tsum=0;
	      while(true) 
	        {
	    	  F_router_Socket.receive(reciver2);
	    	  String str = new String(reciver2.getData(), 0, reciver2.getLength()); 
	    	  
	    	  String[] arrOfStr = str.split(",", 2);
	 
	    	  DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	    	  Date date = (Date)formatter.parse(arrOfStr[1]);
	    	  DateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");
	    	  Date date3 =(Date)formatter.parse(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())); 
	          long difference_In_Time= date3.getTime()- date.getTime();
	
	       
	          long difference_In_Seconds = (difference_In_Time/ 1000)% 60;
	          tsum=tsum+difference_In_Time;
	    	 
	    	  
	    	  System.out.println("Sequence Number in mobile node 2 = "+str+" Time = "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())+" Forwarded to foreign domain router :"+ F__routerAddress.getHostAddress()+"/"+F_router_Port);
	          if(Integer.parseInt(arrOfStr[0])==4) {
	        	  System.out.println("Transmission time of message "+tsum+" milliseconds");
	        	  int tlength=str.getBytes().length*4;
	        	  long sec = TimeUnit.MILLISECONDS.toSeconds(tsum) ;
	        	
	        	  long bandwidth=(tlength)/sec;
	        	  System.out.println("Bandwidth= "+bandwidth);
	          }

	        }
	      
	    } 
}
