package Hawaii;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class H_Base_Station {
	public static void main(String args[]) throws Exception {
		int homebs = 4000;
		int hrouterport =4200;
		System.out.println("In Homebase station");
		DatagramSocket HomeBSSocket = new DatagramSocket(4000);
		DatagramSocket HomeBSSocket2 = new DatagramSocket();
		InetAddress hrouterAddress =  InetAddress.getByName("127.168.1.1");  
		InetAddress datasourceAddress = InetAddress.getByName("127.0.0.1"); 

		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		DatagramPacket reciver = new DatagramPacket(receiveData,
				1024);

		while (true) {
			try {
				 Thread.sleep(2000);
				HomeBSSocket.receive(reciver);
			    String str = new String(reciver.getData(), 0, reciver.getLength());  
				System.out.println("Sequence Number in home base station:" + str+" " + datasourceAddress.getHostName());
					System.out.println("Sending to router Sequence Number: "+str+" "+" Time: "+new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime())+ " Forwarded to ="+ hrouterAddress.getHostAddress()+"/"+hrouterport);
					DatagramPacket sendPacket = new DatagramPacket(str.getBytes(),
							str.getBytes().length, hrouterAddress, hrouterport);
					try {
						HomeBSSocket2.send(sendPacket);
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
