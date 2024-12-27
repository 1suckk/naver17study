package day1227;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex7InetAddress {

	public static void main(String[] args) throws UnknownHostException {
		// TODO Auto-generated method stub
		// 자기 컴퓨터의 IP와 컴퓨터 이르믈 알아보자
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 IP 주소: " + local.getHostAddress());
		System.out.println("내 컴퓨터의 이름: " + local.getHostName());
		System.out.println("=".repeat(30));
		
		System.out.println("Naver 의 서버 컴퓨터의 IP");
		InetAddress[] naverInet = InetAddress.getAllByName("www.naver.com");
		for (InetAddress inet:naverInet)
		{
			System.out.println("Naver IP : " + inet.getHostAddress());
			System.out.println("Naver 컴퓨터 이름 : " + inet.getHostName());
			System.out.println("-".repeat(30));
		}
	}

}
