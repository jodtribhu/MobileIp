package Hierarichal_IP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CorrespondantNode {
	 public static void main(String args[]) throws Exception 
	    {
		
			  int CorrespondantPort = 4020;
			  System.out.println("IN Correspondant Node");
		      DatagramSocket CorrespondantSocket = new DatagramSocket(CorrespondantPort);
		   
		      byte[] receiveData2 = new byte[1024]; 
		      byte[] sendData  = new byte[1024];
			  DatagramPacket reciver2 = new DatagramPacket(receiveData2,
						1024);
			  long tsum=0;
	      while(true) 
	        {
	    	  
	    	  int i=1;
	    	  CorrespondantSocket.receive(reciver2);
	    	  String str = new String(reciver2.getData(), 0, reciver2.getLength()); 
	    	  String[] arrOfStr = str.split(",", 2);
	  
	    	  DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
	    	  Date date = (Date)formatter.parse(arrOfStr[1]);
	    	  DateFormat formatter2 = new SimpleDateFormat("HH:mm:ss");
	    	  Date date3 =(Date)formatter.parse(new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())); 
	          long difference_In_Time= date3.getTime()- date.getTime();
	
	        
	          long difference_In_Seconds = (difference_In_Time/ 1000)% 60;
	          tsum=tsum+difference_In_Time;
	      
	    	  System.out.println("Sequence Number in Correspondant Node  = "+str+" Time = "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime()));
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