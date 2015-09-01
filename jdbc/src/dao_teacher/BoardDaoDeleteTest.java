package dao_teacher;

import java.sql.Connection;

public class BoardDaoDeleteTest {

/*	public static void main(String[] args) {
		BoardDao boardDao = BoardDao.getInstance();
		int rows = boardDao.delete(34);
		if(rows == 1) {
			System.out.println(34 + "�� �Խù��� ������");
		} else {
			System.out.println(34 + "�� �Խù��� �������� ����");
		}
	}*/
	
	public static void main(String[] args)  throws Exception{
		Connection conn = ConnectionManager.getConnection();
		BoardDao boardDao = new BoardDao(conn);
		int rows = boardDao.delete(34);
		if(rows == 1) {
			System.out.println(34 + "번 게시물이 삭제됨");
		} else {
			System.out.println(34 + "번 게시물이 존재하지 않음");
		}
	}
	

}
