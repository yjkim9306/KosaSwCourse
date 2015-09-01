package dao_teacher;

import java.sql.Connection;

public class BoardDaoUpdateTest {

	/*public static void main(String[] args) {
		Board board = new Board();
		board.setNo(34);
		board.setTitle("������ DAO�� �մϴ�.");
		board.setContent("DAO�� �� ���׿�. ����־��.");
		board.setHitcount(2);

		BoardDao boardDao = BoardDao.getInstance();
		int rows = boardDao.update(board);
		if(rows == 1) {
			System.out.println(board.getNo() + "�� �Խù��� ������");
		} else {
			System.out.println(board.getNo() + "�� �Խù��� �������� ����");
		}
	}
*/
	
	public static void main(String[] args) throws Exception{
		Board board = new Board();
		board.setNo(62);
		board.setTitle("참쉽죠잉.");
		board.setContent("더 쉬워졋쬬? 헷갈려욤");
		board.setHitcount(2);

		Connection conn = ConnectionManager.getConnection();
		BoardDao boardDao = new BoardDao(conn);
		int rows = boardDao.update(board);
		if(rows == 1) {
			System.out.println(board.getNo() + "번 게시물이 수정됨");
		} else {
			System.out.println(board.getNo() + "번 게시물이 존재하지 않음");
		}
	}
}
