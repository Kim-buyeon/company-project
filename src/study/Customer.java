package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Customer {
	
/*	public static void main(String[] args) {
		//createTable();
		//createCustomer("Danny","123456789","Male","23","Random Note....");
		createCustomer("David","4441122211","Female","25","Important Cusstomer");
		ArrayList<String> list = getCustomers();
		for(String item:list) {
			System.out.println(item);
		}
		
	}*/
	public static void createCustomer(String name,String phone,String gender
			,String age,String note) {
		try {
			Connection con = getConnection();
			PreparedStatement insert = con.prepareStatement(""
					+ "INSERT INTO customer"
					+ "(name,phone,gender,age,note) "
					+ "VALUE "
					+ "('"+name+"','"+phone+"','"+gender+"','"+age+"','"+note+"')");
			insert.executeUpdate();
			System.out.println("The data has benn saved");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public static String[][] getCustomers(){
		try {
			Connection con = getConnection();
			PreparedStatement statement = con.prepareStatement("Select name,phone,gender,age,note From customer");
			ResultSet results = statement.executeQuery();
			ArrayList<String[]>list = new ArrayList<String[]>();
			while(results.next()) {
				list.add(new String[] {
						results.getString("name"),
						results.getString("phone"),
						results.getString("gender"),
						results.getString("age"),
						results.getString("note")
				});
			}
			String[][] arr = new String[list.size()][5];//행: 배열이 몇개 인지 나태냄
			System.out.println("The data has been fetched");
			return list.toArray(arr);//리스트 배열로 만들어줌 인자에 들어가는 배열의 크기로
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	public static void createTable() {
		try {
			Connection con = getConnection();
		    PreparedStatement createTable = con.prepareStatement(
		            "CREATE TABLE IF NOT EXISTS customer ("
		            + "id int NOT NULL AUTO_INCREMENT, "
		            + "name VARCHAR(255), "
		            + "phone VARCHAR(255), "
		            + "gender VARCHAR(255), "
		            + "age VARCHAR(255), "
		            + "note VARCHAR(255), "
		            + "PRIMARY KEY(id))");
		    createTable.execute();
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			System.out.println("Table successfully created");
		}
	}
	public static Connection getConnection() {
		try {
			String driver = "com.mysql.cj.jdbc.Driver";
			String url = "jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12743640";
			String user = "sql12743640";
			String pass = "pWU6K7IUC5";
			Class.forName(driver);
			Connection con = DriverManager.getConnection(url,user,pass);
			System.out.println("The connection Sucessful");
			return con;
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
