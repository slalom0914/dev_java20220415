package network.step1;

import java.net.*; 
import java.io.*; 
//https://api.openweathermap.org/data/2.5/weather?appid=4f9c5b0067c80f8b4d2afe3af1e611a8&q=seoul&units=metric
public class URLEx { 
	public static void main(String[] args) 
			throws MalformedURLException, IOException { 
		URL url = new URL("https://api.openweathermap.org/data/2.5/weather?appid=4f9c5b0067c80f8b4d2afe3af1e611a8&q=seoul&units=metric"); 
		String protocol = url.getProtocol(); 
		String host = url.getHost(); 
		int port = url.getPort(); 
		int defaultPort = url.getDefaultPort(); 

		String path = url.getPath(); 
		String query = url.getQuery(); 
		String ref = url.getRef(); 
		String _url = url.toExternalForm(); 
		String mixUrl = null; 
		if (port == -1) { 
			mixUrl = protocol + "//" + host + path + 
					"?" + query + "#" + ref; 
		} else { 
			mixUrl = protocol + "//" + host + ":" + 
					port + path + "?"+ query + "#" + ref; 
		} 
		if (port == -1) port = url.getDefaultPort(); 
		System.out.printf("프로토콜 : %s %n", protocol); 
		System.out.printf("호스트 : %s %n", host); 
		System.out.printf("포트 : %d %n", port); 
		System.out.printf("패스 : %s %n", path); 
		System.out.printf("쿼리 : %s %n", query); 
		System.out.printf("ref : %s %n", ref); 
		System.out.printf("mixURL : %s %n", mixUrl); 
		System.out.printf("URL : %s %n", _url); 

		url = new URL("https://api.openweathermap.org/data/2.5/weather?appid=4f9c5b0067c80f8b4d2afe3af1e611a8&q=seoul&units=metric"); 
		InputStream input = url.openStream(); 
		int readByte; 
		System.out.println("=== 문서의 내용 ==="); 
		while (((readByte = input.read()) != -1)) { 
			System.out.print((char) readByte); 
		} 
		input.close(); 
	} 
} 

