package dao;

public class BoardDaoTest {

	public static void main(String[] args) {
		
		Board board = new Board();
		board.setNo(4);
		board.setTitle("오늘은 dao를 만드는 날!");
		board.setContent("DAO가 참 유용하네yo.");
		board.setHitcount(2);
		
		//싱글턴임!
		BoardDao boardDao =  BoardDao.getInstance();
		
		//insert일 때
		/*
		Integer pk = boardDao.insert(board); //null값 올수도 잇으니깐 Integer 
		if(pk != null){
			System.out.println(pk+ " 번 게시물이 저장됨");
		}else{
			System.out.println("저장 실패!!");
		}*/
		
		//update일 떄
		int rows = boardDao.update(board); //null값 올수도 잇으니깐 Integer 
		if(rows==1){
			System.out.println(board.getNo()+ " 번 게시물이 수정됨");
		}else{
			System.out.println(board.getNo()+" 번 게시물이 존재하지 않습니다");
		}
		
	}

}
