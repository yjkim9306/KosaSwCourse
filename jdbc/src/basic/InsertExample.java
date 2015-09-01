package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertExample {
	
		public static void main(String[] args){
			Connection conn=null;
			PreparedStatement pstmt = null;

			try{	
			/*	Class.forName("oracle.jdbc.OracleDriver"); 	
				conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@70.12.108.154:1521:orcl",    //url   // thin: tcp 로 들어감
					"user0",   //user : 사용자 이름
					"12345");   //password
			*/
				
				//mysql연결
				Class.forName("com.mysql.jdbc.Driver"); 	
				conn = DriverManager.getConnection(
						"jdbc:mysql://blueskii.iptime.org:3306/team4",    //url   // thin: tcp 로 들어감
						"team4",   //user : 사용자 이름
						"123456");   //password
			System.out.println("연결성공");
				
				//?자리에 앞으로 값이 들어갈 거임
				String sql = "update user12_boards set board_title=?, board_content=?, board_writer=? where board_no=?";
				pstmt = conn.prepareStatement(sql); //위의 sql 문 실행 -> 준비한다 는 뜻
				pstmt.setString(1, "제목");
				pstmt.setString(2, "수욜하하하하");	
				pstmt.setString(3, "누구누구입니다");  
				pstmt.setInt(4, 1);
				
				//실행하기
				//row : 실제로 insert된 행의 수 반환됨
				int row = pstmt.executeUpdate();
				System.out.println(row+ "1개의 행이 수정됨");
			
			}catch(ClassNotFoundException e){
				e.printStackTrace();

			}catch( SQLException e){
				e.printStackTrace();
				
			}finally{ //꼭 닫아주기!!!
				/*  다음과 같이 하면 안됨!!! pstmt에서 예외 발생하면 conn,close()실행 못할 수도!
				try{
					pstmt.close();
					conn.close();
				}catch(SQLException e){
				
				}*/
				try{
					pstmt.close();
					
				}catch(SQLException e){	}
				try{
					pstmt.close();
					conn.close();
				}catch(SQLException e){			}
			}
		}
}
