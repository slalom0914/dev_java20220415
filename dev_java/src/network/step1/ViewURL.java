package network.step1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class ViewURL {
	public ViewURL(String strURL){
		URL myURL;
		URLConnection myCon;
		InputStream is;
		BufferedReader br;
		String data;
		String headerType;
		try {
			myURL = new URL(strURL);
			myCon = myURL.openConnection();
			myCon.connect();
			headerType = myCon.getContentType();
			System.out.println("headerType : "+headerType);
			is = myCon.getInputStream();
			br = new BufferedReader(new InputStreamReader(is));
			File f = null;
			f = new File("src\\network\\step1\\ViewURL.txt");
			FileOutputStream fos = new FileOutputStream(f);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			while((data = br.readLine()) != null){
	            bos.write(data.getBytes());
				System.out.println(data);
			}
			bos.flush();	  
			bos.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	public static void main(String[] args) {
		new ViewURL("https://api.openweathermap.org/data/2.5/weather?appid=4f9c5b0067c80f8b4d2afe3af1e611a8&q=seoul&units=metric");
	}

}

