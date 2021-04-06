package com.greedy.section02.preparedstatement;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		
		Properties prop = new Properties();
		
		prop.setProperty("keyString", "valueString");
		
		try {
			prop.storeToXML(new FileOutputStream("src/com/greedy/section02/preparedStatement/employee-query.xml"), "");
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
