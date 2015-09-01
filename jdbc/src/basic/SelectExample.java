package basic;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectExample {
	
		public static void main(String[] args){
			Connection conn=null;
			PreparedStatement pstmt = null;

			try{	
				/*Class.forName("oracle.jdbc.OracleDriver"); 	
				conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@70.12.108.154:1521:orcl",    //url   // thin: tcp 로 들어감
					"user0",   //user : 사용자 이름
					"12345");   //password*/
			
				//mysql연결
				Class.forName("com.mysql.jdbc.Driver"); 	
				conn = DriverManager.getConnection(
						"jdbc:mysql://blueskii.iptime.org:3306/team4",    //url   // thin: tcp 로 들어감
						"team4",   //user : 사용자 이름
						"123456");   //password
			System.out.println("연결성공");
				
				String sql = "select * from user12_boards where  board_content like ?";
				pstmt = conn.prepareStatement(sql); //위의 sql 문 실행 -> 준비한다 는 뜻
				pstmt.setString(1, "%내일%"); //1번 ?에 3번 게시물 가져와라
				
				//커서 사용하기 위해!!
				//공용으로 사용하지 못함
				ResultSet rs = pstmt.executeQuery();
						
				while(rs.next()){
				
					int boardNo = rs.getInt("board_no");
					String boardTitle= rs.getString("board_title");
					String boardContent = rs.getString("board_content");
					Date boardDate = rs.getDate("board_date");
					String boardWriter = rs.getString("board_writer");
					int boardcount= rs.getInt("board_hitcount");
				
					System.out.println(boardNo + "\t" + boardTitle + "\t" + boardContent+"\t"+boardDate);
				}
				//finally에서 닫지 않고 여기서 닫음 -> 공유되지 않아서!
				rs.close();
							
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
