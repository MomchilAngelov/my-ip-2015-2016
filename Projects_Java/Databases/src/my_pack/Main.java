package my_pack;

import java.sql.*;

public class Main {
	public static void main(String[] aegs){
		System.out.println("Hello world! This is my sql application!");
		DriverManager.registerDriver( new oracle.jdbc.driver.OracleDriver() );
	}
}
