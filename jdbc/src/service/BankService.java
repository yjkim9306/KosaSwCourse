package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao_teacher.Account;
import dao_teacher.AccountDao;
import dao_teacher.ConnectionManager;

public class BankService {

	public void transfer(int from, int to, int amount) {
		
		Connection conn = null;
		try {
			conn = ConnectionManager.getConnection();
			
			//트랜잭션 작업 시작/////////////////////////////////////////////////////////////
			conn.setAutoCommit(false);
			AccountDao accountDao = new AccountDao(conn);
			
			//해당 계좌번호 가져오기
			//해당 계좌번호 없으면 null 리턴함
			Account fromAccount = accountDao.selectByPk(from);
			Account toAccount = accountDao.selectByPk(to);
			
			//update할 떄, null을 넣으면 예외발생됨!
			
			//출금작업
			fromAccount.setBalance(fromAccount.getBalance()- amount);
			accountDao.update(fromAccount);
			
			//입금작업
			toAccount.setBalance(toAccount.getBalance()+ amount);
			accountDao.update(toAccount);
			
			//에러 없이 정상작동햇으면, commit!////////////////////
			conn.commit();
			System.out.println("계좌이체 성공");
			
		} catch (Exception e) {//에러 발생시 rollback 해!!
			try {
				conn.rollback();
			} catch (SQLException e1) {e1.printStackTrace();}
			System.out.println("계좌이체 실패");
			e.printStackTrace();
		}finally{
			try{ conn.close() ; }catch(Exception e){}
		}
		
	}
}
