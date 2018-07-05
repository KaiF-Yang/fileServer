package com.newer.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;



public class Client {

	
	 
	
	//创建输出流
	OutputStream out;
	
	String serverAdderss="";
	
	//创建服务接口
	int serbverPort=9000;
	
////创建文件输入流
			FileInputStream fileIn;
			
			Socket socket;
	//定义一个复制文件的方法
	public void start() {
		System.out.println("请输入要复制文件的路径");
		Scanner sc=new Scanner(System.in);
		String file=sc.next();
		sc.close();
		
		//创建套接字
		try {
			socket =new Socket(serverAdderss,serbverPort);
			
			out=socket.getOutputStream();
			
			byte [] buf=new byte[1024*4];
			
			int size;
			fileIn =new FileInputStream(file);
			while(-1!=(size=fileIn.read(buf))) {
				out.write(buf,0,size);
			     out.flush();
			     
			}
			System.out.println("上传完成");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				fileIn.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
