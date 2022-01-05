package wartproject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;

public class database {

	private final static String username = "root";
	private final static String pass = "123456";
	private final static String driver = "com.mysql.jdbc.Driver";
	private final static String mysqlurl = "jdbc:mysql://49.234.84.12:3306/wart";
	
	public static void main(String []args) {
		Connection connection = null;
		Statement stmt = null;
		
		try {
			//registe JDBC driver
			Class.forName(driver);
			
			//open link 
			System.out.println("connecting to the database ...");
			connection = DriverManager.getConnection(mysqlurl,username,pass);
			stmt = (Statement) connection.createStatement();
			
			//insert
			String date = "2021.1.8";
			String address = "1598746";
			String sql = "INSERT INTO `skindata`(`DATE`, `ADDRESS`) VALUES (\""+ date +"\",\""+ address +"\")";
			stmt.executeUpdate(sql);
			System.out.println("Successfully inserted !");
			
//			//执行查询
//			System.out.println("The data from database: ");
//			String sql = "SELECT `ID`, `DATE`, `ADDRESS` FROM `skindata`";
//			ResultSet rs = stmt.executeQuery(sql);
//			
//			// 展开结果集数据库
//            while(rs.next()){
//                // 通过字段检索
//                int id  = rs.getInt("ID");
//                String name = rs.getString("DATE");
//                String url = rs.getString("ADDRESS");
//    
//                // 输出数据
//                System.out.print("ID: " + id);
//                System.out.print(", DATE " + name);
//                System.out.print(", ADDRESS: " + url);
//                System.out.print("\n");
//            }
//			rs.close();
			
            // 完成后关闭
			
            stmt.close();
            connection.close();
		
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			// 关闭资源
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// 什么都不做
            try{
                if(connection!=null) connection.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
   
		}
		
		
		
	}

	
}