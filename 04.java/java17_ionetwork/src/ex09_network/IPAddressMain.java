package ex09_network;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressMain {

	public static void main(String[] args) throws Exception {
		
		InetAddress ip1=InetAddress.getLocalHost();
		System.out.println("LOCAL IP ADDRESS="+ip1);
		System.out.println("LOCAL IP ADDRESS="+ip1.getHostAddress());
		System.out.println("LOCAL HOST NAME="+ip1.getHostName());
		System.out.println();
		
		InetAddress[] ips=InetAddress.getAllByName("www.naver.com");
		for(InetAddress ip:ips) {
			System.out.println("네이버 IP: "+ip.getHostAddress());
		}
		System.out.println();

	}

}
