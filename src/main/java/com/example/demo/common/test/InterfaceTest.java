package com.example.demo.common.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Date;
import java.util.Scanner;

import com.alibaba.fastjson.JSONObject;

public class InterfaceTest {

	public static void main(String[] args) {
		
		for(int i=0;i<1;i++) {
			Runnable oneRunnable = new SomeRunnable();   
			Thread oneThread = new Thread(oneRunnable);   
			oneThread.start(); 
		}
	}

}
class SomeRunnable implements Runnable   { 
	  public void run()   {
		  String address="http://localhost:8080/chnet/dood/vid";
//		  String address="http://123.57.43.71/chnet/dood/vid";
		  try {
			URL url = new URL(address);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.addRequestProperty("Content-Type", "application/json");
			
			JSONObject jb = new JSONObject();
			jb.put("title", "任务提醒");
			jb.put("titleBgColor", "#FFFFF0");
			jb.put("titleColor", "#2C2255");
			
			OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "utf-8");
			out.write(jb.toJSONString());
			out.flush();
			InputStream fi = connection.getInputStream();
			Scanner fs = new Scanner(fi,"utf-8");
			StringBuilder sb = new StringBuilder();
			while(fs.hasNext()){
				String scsc2 = fs.nextLine();
				sb.append(scsc2);
			}
			fs.close();
			System.out.println(new Date().getSeconds()+"::"+sb.toString());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	  }  
}
