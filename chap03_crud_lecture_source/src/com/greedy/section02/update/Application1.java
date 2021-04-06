package com.greedy.section02.update;

import static com.greedy.common.JDBCTemplate.close;
import static com.greedy.common.JDBCTemplate.getConnection;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Scanner;

import com.greedy.model.dto.MenuDTO;

public class Application1 {

	public static void main(String[] args) {

		Connection con = getConnection();
		PreparedStatement pstmt = null;
		int result = 0;
		
		Properties prop = new Properties();
		
		// menu-query.xml에서 updateMenu
		try {
			prop.loadFromXML(new FileInputStream("mapper/menu-query.xml"));
			
			String query = prop.getProperty("updateMenu");
			
			Scanner sc = new Scanner(System.in);

			System.out.print("변경할 메뉴 번호를 입력하세요 : ");
			int menuCode = sc.nextInt();
			sc.nextLine();

			System.out.print("변경할 메뉴의 이름을 입력하세요 : ");
			String updateName = sc.nextLine();

			System.out.print("변경할 메뉴의 가격을 입력하세요 : ");
			int updatePrice = sc.nextInt();
			
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, updateName);
			pstmt.setInt(2, updatePrice);
			pstmt.setInt(3, menuCode);
			
			result = pstmt.executeUpdate();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(con);
		}
		
		if(result >0) {
			System.out.println("메뉴 수정 성공");
		} else {
			System.out.println("메뉴 수정 실패");
		}
		
		

		
	}

}
