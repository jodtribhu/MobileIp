package Hierarichal_IP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class HomeAgent2 {
	public static void main(String args[]) throws Exception {
		int homeagentport = 4010;
		int foreignagent2port =4210;
		
		DatagramSocket HomeAgent2Socket = new DatagramSocket(4010);
		DatagramSocket HomeAgent2Socket2 = new DatagramSocket();
		InetAddress foreign2Address =  InetAddress.getByName("127.156.1.1");  
		InetAddress datasourceAddress = InetAddress.getByName("126.0.0.1"); 
 

		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		DatagramPacket reciver = new DatagramPacket(receiveData,
				1024);

		while (true) {
			try {
				Thread.sleep(2000);
				HomeAgent2Socket.receive(reciver);
			    String str = new String(reciver.getData(), 0, reciver.getLength());  
				System.out.println("Sequence Number:" + str+" " + datasourceAddress.getHostName());
					System.out.println("Sending to FA Sequence Number: "+str+" "+" Time: "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())+ " Forwarded to ="+ foreign2Address.getHostAddress()+"/"+foreignagent2port);
					DatagramPacket sendPacket = new DatagramPacket(str.getBytes(),
							str.getBytes().length, foreign2Address, foreignagent2port);
					try {
						HomeAgent2Socket2.send(sendPacket);
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
