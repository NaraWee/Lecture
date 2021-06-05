package com.greedy.section02.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Application {

	public static void main(String[] args) throws IOException {
		
		/* Header 값을 출력하는 간단한 웹서버를 만들어보자 */
		
		ServerSocket listener = new ServerSocket(8002);
		
		/* 요청 횟수를 판단하기 위한 변수 선언 */
		int count = 1;
		
		try {
			System.out.println("Http Server started at 8002 port");
			
			while(true) {				
				Socket socket = listener.accept();
				try {
					System.out.printf("New Client Connect! Connected IP : %s, Port : %d\n", socket.getInetAddress(), socket.getPort());
					
					count++;
					
					InputStream in = socket.getInputStream();
					OutputStream out = socket.getOutputStream();
					
					/* 파비콘 요청을 위한 요청은 건너뛰고 header 내용은 3번째 요청으로 읽어들인다. */
					int value = 0;
					while((value = in.read()) != -1 && count == 3) {
						System.out.print((char)value);
					}
					
					String responseText = "<h1>Hello World!!</h1>";
					
					String responseGeneralHeader = "Http/1.1 200 OK \r\n";
					String contentType = "Content-Type : text/html; charset=utf-8\r\n";
					String contentLength = "Content-Length : " + responseText.length() + "\r\n";
					String whiteLine = "\r\n";
					
					out.write(responseGeneralHeader.getBytes());
					out.write(contentType.getBytes());
					out.write(contentLength.getBytes());
					out.write(whiteLine.getBytes());
					
					out.write(responseText.getBytes());
					out.write(whiteLine.getBytes());
					
					out.flush();
					
				} catch(Exception e) {
					
				} finally {
					socket.close();
				}
				
			}
		} catch(Exception e) {
			
		} finally {
			listener.close();
		}
	}

}
