package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class connectionExample {
	
		public static void main(String[] args){
			Connection conn=null;
			PreparedStatement pstmt =null;
			
			try{	
			//ClassName인 클래스가 잇는지 확인하고 ,있으면 자기 자신 객체 만든 후, 메모리에 올려줌
			//없으면 예외처리함
			
				//oracle연결
				//   class OracleDriver static { 
							//       static {        
							  //   				OracleDriver d = new OracleDriver();  -    >정적 객체/ 자기 자신을 만듬
				            //      			DriverManager.registerDriver(driver); }  
							//      }  -> 자기자신을 드라이버 객체에 등록함
			
				//Class.forName("oracle.jdbc.OracleDriver"); 	
				
			//위에서 등록된 드라이버 사용해서 연결
			//url : 연결 문자열(connection stream) ->  IP, PORT, DB_NAME    3가지 가지고 잇음
			//user, password
		/*	conn = DriverManager.getConnection(
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
			
			String sql = "insert into user12_boards (board_title, board_content, board_writer,board_date) values(?,?,?,now())";
			pstmt = conn.prepareStatement(sql ,new String[]{"board_no"}); 
			pstmt.setString(1, "여러분 제목");
			pstmt.setString(2, "내일은 수욜하하하하");	
			pstmt.setString(3, "누구누구입니다");  
			pstmt.executeUpdate();
			
			}catch(ClassNotFoundException e){
				e.printStackTrace();
				System.out.println("연결실패");
				
			}catch( SQLException e){
				e.printStackTrace();
				System.out.println("연결실패");
			}finally{
				try{
					//연결하는거 자체에 돈이 듬 
					//close() 붙여주는게 좋음!!
					//써놧지만 close()실행 안되는 경우도 잇음 
					//따라서 finally에다가 써줄것!!
					//변수는 꼭 class 안에 정의한 것만 사용 가능 -> 따라서 전역으로 두는게 좋음 
					conn.close();
				}catch(SQLException e){
					
				}
			}
		}
}
