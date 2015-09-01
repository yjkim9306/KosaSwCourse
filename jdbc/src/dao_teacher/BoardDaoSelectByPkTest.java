package dao_teacher;
/*
public class BoardDaoSelectByPkTest {

	public static void main(String[] args) {
		BoardDao boardDao = BoardDao.getInstance();
		Board board = boardDao.selectByPk(60);
		if(board != null) {
			System.out.println("��ȣ: " + board.getNo());
			System.out.println("����: " + board.getTitle());
			System.out.println("����: " + board.getContent());
			System.out.println("��¥: " + board.getDate());
			System.out.println("�۾���: " + board.getWriter());
			System.out.println("��ȸ��: " + board.getHitcount());
		} else {
			System.out.println(60 + "�� �Խù��� �������� ����");
		}
	}

}
*/

import java.sql.Connection;

public class BoardDaoSelectByPkTest {

	public static void main(String[] args) throws Exception {
		Connection conn = ConnectionManager.getConnection();
			BoardDao boardDao = new BoardDao(conn);
			Board board = boardDao.selectByPk(60);
			if(board != null) {
				System.out.println("번호: " + board.getNo());
				System.out.println("제목: " + board.getTitle());
				System.out.println("내용: " + board.getContent());
				System.out.println("날짜: " + board.getDate());
				System.out.println("글쓴이: " + board.getWriter());
				System.out.println("조회수: " + board.getHitcount());
			} else {
				System.out.println(60 + "번 게시물이 존재하지 않음");
			}
		conn.close();
	}

}
