package com.alarm.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientCreate {
	public static void main(String[] args) {
		
		try {
			//创建socket客户端 并绑定服务器IP和端口号
			Socket socket=new Socket("192.168.0.30", 7080);
			//创建输出流 向服务器发送请求
			OutputStream outputStream = socket.getOutputStream();
			PrintWriter printWriter = new PrintWriter(outputStream);
			printWriter.write("用户名:admin3;密码:123456");
			printWriter.flush();
			socket.shutdownOutput();
			//创建输入流 接收服务器返回的信息
			InputStream inputStream = socket.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String backMessage=null;
			while((backMessage=bufferedReader.readLine())!=null) {
				System.out.println("接收到了服务器的信息: "+backMessage);
			}
			socket.shutdownInput();
			//关闭资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			
			printWriter.close();
			outputStream.close();
			
			socket.close();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
