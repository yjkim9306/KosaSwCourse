package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

//하나의 테이블에 DAO를 일반적으로 하나만 만듬-> singleton
public class BoardDao {
	
	//싱글톤으로 사용
	private static BoardDao singleton = new BoardDao();
	private BoardDao() {}  //프라이베잇 으로 생성장 접근 막음
	public static BoardDao getInstance(){
		return singleton;
	} 
	
	//데이터 작업 메소드
	
	//서비스 수준의 작명(addBoard)보단 insert로 지어주기!
	//제대로 insert하면 pk값이 올거임
	// 실패 시 return = null  -> 따라서 Long,Integer로 null값 받음!  
	public Integer insert(Board board){
		Integer pk = null;
		String sql = "insert into boards (board_title, board_content, board_writer) values(?,?,?)";
	
		Connection conn=null;
		PreparedStatement pstmt = null;

		try{	
			Class.forName("oracle.jdbc.OracleDriver"); 	
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@70.12.108.154:1521:orcl",    //url   // thin: tcp 로 들어감
				"user0",   //user : 사용자 이름
				"12345");   //password
		
			pstmt = conn.prepareStatement(sql, new String[]{"board_no"}); //위의 sql 문 실행 -> 준비한다 는 뜻
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setString(3, board.getWriter());
			int row = pstmt.executeUpdate();
					
		 if(row==1){
			//커서 사용하기 위해!!
				//공용으로 사용하지 못함
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()){
					pk = rs.getInt(1);
				}
				rs.close();
		 }
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch( SQLException e){
			e.printStackTrace();
		}finally{ //꼭 닫아주기!!!
			try{pstmt.close();} catch(SQLException e){	}
			try{conn.close();}  catch(SQLException e){}
		}
		
		return pk;
	}
	
	public int update(Board board){
		int rows = 0;
		String sql = "update boards set board_title=?, board_content=?, board_hitcount=? where board_no=?";
		
		Connection conn=null;
		PreparedStatement pstmt = null;

		try{	
			Class.forName("oracle.jdbc.OracleDriver"); 	
			conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@70.12.108.154:1521:orcl",    //url   // thin: tcp 로 들어감
				"user0",   //user : 사용자 이름
				"12345");   //password
		
			pstmt = conn.prepareStatement(sql); //위의 sql 문 실행 -> 준비한다 는 뜻				
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getHitcount());
			pstmt.setInt(4,board.getNo());
			rows = pstmt.executeUpdate();
						
		}catch( Exception e){
			e.printStackTrace();
		}finally{ //꼭 닫아주기!!!
			try{
				pstmt.close();
			}catch(SQLException e){	}
			try{
				conn.close();
			}catch(SQLException e){			}
		}
		return rows;
	}
/*	public int updateHitcount(Board board){
		int rows = 0;
		String sql = "update boards set board_hitcount=?  where board_no=?";
		
		return rows;
	}*/
	
}














