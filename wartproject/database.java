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
			
//			//ִ�в�ѯ
//			System.out.println("The data from database: ");
//			String sql = "SELECT `ID`, `DATE`, `ADDRESS` FROM `skindata`";
//			ResultSet rs = stmt.executeQuery(sql);
//			
//			// չ����������ݿ�
//            while(rs.next()){
//                // ͨ���ֶμ���
//                int id  = rs.getInt("ID");
//                String name = rs.getString("DATE");
//                String url = rs.getString("ADDRESS");
//    
//                // �������
//                System.out.print("ID: " + id);
//                System.out.print(", DATE " + name);
//                System.out.print(", ADDRESS: " + url);
//                System.out.print("\n");
//            }
//			rs.close();
			
            // ��ɺ�ر�
			
            stmt.close();
            connection.close();
		
		}catch (Exception e){
			e.printStackTrace();
		}finally {
			// �ر���Դ
            try{
                if(stmt!=null) stmt.close();
            }catch(SQLException se2){
            }// ʲô������
            try{
                if(connection!=null) connection.close();
            }catch(SQLException se){
                se.printStackTrace();
            }
   
		}
		
		
		
	}

	
}