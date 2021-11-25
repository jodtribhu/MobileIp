package CellularIp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BaseStation1 {
	public static void main(String args[]) throws Exception {
		int homebs = 4000;
		int hrouterport =4200;
		System.out.println("In base station 1" );
		DatagramSocket BS1Socket = new DatagramSocket(4000);
		DatagramSocket BS1Socket2 = new DatagramSocket();
		InetAddress gatewayAddress =  InetAddress.getByName("127.168.1.1");  
		InetAddress datasourceAddress = InetAddress.getByName("127.0.0.1"); 

		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		DatagramPacket reciver = new DatagramPacket(receiveData,
				1024);

		while (true) {
			try {
		
				BS1Socket.receive(reciver);
			    String str = new String(reciver.getData(), 0, reciver.getLength());  
				System.out.println("Sequence Number In base station 1:" + str+" " + datasourceAddress.getHostName());
					System.out.println("Sending to Gateway Sequence Number: "+str+" "+" Time: "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())+ " Forwarded to ="+ gatewayAddress.getHostAddress()+"/"+hrouterport);
					DatagramPacket sendPacket = new DatagramPacket(str.getBytes(),
							str.getBytes().length, gatewayAddress, hrouterport);
					try {
						BS1Socket2.send(sendPacket);
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
