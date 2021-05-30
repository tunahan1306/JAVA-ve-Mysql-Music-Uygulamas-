import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class baglanti {
	
	static String url;  
	static Connection con; 
	static ResultSet myRs;
	static Statement myStat;
	
	static ResultSet yap() {
		con = null;
		myRs = null;
	     try {  
	         Class.forName("com.mysql.jdbc.Driver");  
	     url="jdbc:mysql://localhost:3306/deneme";  
	         con = DriverManager.getConnection(url,"root","1234");  
	         myStat = (Statement) con.createStatement();
	         myRs = myStat.executeQuery("select * from sarkilar");
	         }  
	         catch (Exception e) {  
	         System.out.println(e.toString());  
	     }  
	     return myRs;
	 }
	
static void ekle(String sql_sorgu) {
		
		try {
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void update(String sql_sorgu) {
		try {
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static void sil(String sql_sorgu) {
		try {
			myStat.executeUpdate(sql_sorgu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static ResultSet sorgula(String sql_sorgu) {
		ResultSet myRs = null;		
		try {			
			myRs = myStat.executeQuery(sql_sorgu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return myRs;
	}
	 
}
