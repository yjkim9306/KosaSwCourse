package basic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GetAutoIncrementValueExample {
	
		public static void main(String[] args){
			Connection conn=null;
			PreparedStatement pstmt = null;

			try{	
				Class.forName("oracle.jdbc.OracleDriver"); 	
				conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@70.12.108.154:1521:orcl",    //url   // thin: tcp 로 들어감
					"user0",   //user : 사용자 이름
					"12345");   //password
			
				String sql = "insert into boards (board_title, board_content, board_writer) values(?,?,?)";
				pstmt = conn.prepareStatement(sql, new String[] {"board_no"}); //위의 sql 문 실행 -> 준비한다 는 뜻
				pstmt.setString(1, "오늘은...");
				pstmt.setString(2, "수요이류ㅠ");
				pstmt.setString(3, "하아,...");
				int row = pstmt.executeUpdate();
				int boardNo = 0;
						
			 if(row==1){
				//커서 사용하기 위해!!
					//공용으로 사용하지 못함
					ResultSet rs = pstmt.executeQuery();
					if(rs.next()){
						boardNo = rs.getInt("board_no");
					}
					rs.close();
			 }
			 
			System.out.println(boardNo+"번 게시물이 저장됨");				
			
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
					conn.close();
				}catch(SQLException e){			}
			}
		}
}
