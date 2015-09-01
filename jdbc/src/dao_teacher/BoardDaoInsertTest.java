package dao_teacher;
/*
public class BoardDaoInsertTest {

	public static void main(String[] args) {
		Board board = new Board();
		board.setTitle("������ DAO�� ����� ��");
		board.setContent("DAO�� �� �����ϳ׿�. ������ ���� �ؾ� �� �� �����ϴ�.");
		board.setWriter("ȫ�浿");

		BoardDao boardDao = BoardDao.getInstance();
		Integer pk = boardDao.insert(board);
		if(pk != null) {
			System.out.println(pk + "�� �Խù��� �����");
		} else {
			System.out.println("���� ����");
		}
	}

}
*/

import java.sql.Connection;

public class BoardDaoInsertTest {

	public static void main(String[] args) throws Exception {
		Board board = new Board();
		board.setTitle("오늘은 DAO를 만드는 날");
		board.setContent("DAO가 참 유용하네요. 연습을 많이 해야 될 것 같습니다.");
		board.setWriter("홍길동");

		Connection conn = ConnectionManager.getConnection();
			BoardDao boardDao = new BoardDao(conn);
			Integer pk = boardDao.insert(board);
			if(pk != null) {
				System.out.println(pk + "번 게시물이 저장됨");
			} else {
				System.out.println("저장 실패");
			}
		conn.close();
	}

}
