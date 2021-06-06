package com.greedy.section01.insert;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

public class Application2 {

	public static void main(String[] args) {

		/* 메뉴의 이름을 입력하세요, 메뉴의 가격을 입력하세요, 카테고리 코드를 입력하세요, 판매 여부를 결정해주세요(Y/N) : 무조건 Y/N */
		Connection con = getConnection();
		PreparedStatement pstmt = null;
		
		int result = 0;
		
		Properties prop = new Properties();
		Scanner sc = new Scanner(System.in);
		
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
			
			String query = prop.getProperty("insertMenu");
			
			pstmt = con.prepareStatement(query);
			System.out.print("메뉴의 이름을 입력하세요 : ");
			String menu = sc.nextLine();
			pstmt.setString(1, menu);
			System.out.print("메뉴의 가격을 입력하세요 : ");
			int price = sc.nextInt();
			pstmt.setInt(2, price);
			System.out.print("카테고리 코드를 입력하세요 : ");
			int code = sc.nextInt();
			pstmt.setInt(3, code);
			System.out.print("판매여부를 결정해주세요(Y/N) : ");
			String yn = sc.next();
			pstmt.setString(4, yn.toUpperCase());
			result = pstmt.executeUpdate();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		if(result > 0) {
			System.out.println("메뉴 등록 성공!");
		} else {
			System.out.println("메뉴 등록 실패!");
		}

	}

}
