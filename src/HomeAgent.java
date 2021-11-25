import java.io.*;
import java.net.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HomeAgent {
	public static void main(String args[]) throws Exception {
		int homeagentport = 4000;
		int foreignagent1port =4200;
		int foreignagent2port = 4002;
		
		DatagramSocket HomeAgentSocket = new DatagramSocket(4000);
		DatagramSocket HomeAgentSocket2 = new DatagramSocket();
		InetAddress foreign1Address =  InetAddress.getByName("127.168.1.1");  
		InetAddress foreign2Address = InetAddress.getByName("162.0.0.1"); 
		InetAddress datasourceAddress = InetAddress.getByName("152.0.0.1"); 

		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		DatagramPacket reciver = new DatagramPacket(receiveData,
				1024);

		while (true) {
			try {
				Thread.sleep(3000);
				HomeAgentSocket.receive(reciver);
			    String str = new String(reciver.getData(), 0, reciver.getLength());  
				System.out.println("Sequence Number:" + str+" " + datasourceAddress.getHostName());
					System.out.println("Sending to FA Sequence Number: "+str+" "+" Time: "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())+ " Forwarded to ="+ foreign1Address.getHostAddress()+"/"+foreignagent1port);
					DatagramPacket sendPacket = new DatagramPacket(str.getBytes(),
							str.getBytes().length, foreign1Address, foreignagent1port);
					try {
						HomeAgentSocket2.send(sendPacket);
					}
					catch(Exception e) {
						System.out.print(e);
					}
					
				}
				catch(Exception e) {
				 System.out.println(e);
				}


		}

	}
}
