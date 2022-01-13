package network;

import java.net.UnknownHostException;

public class HostIp {
	
	public static void main(String[] args) throws UnknownHostException {
		System.out.println("Host:" + java.net.InetAddress.getLocalHost());
		System.out.println("Server-IP:" +  java.net.InetAddress.getLocalHost().getHostAddress());
	}
}
