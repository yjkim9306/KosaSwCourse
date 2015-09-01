package service;

public class BankServiceTest {

	public static void main(String[] args) {
		BankService bankservice = new BankService();
		
		bankservice.transfer(1, 2, 100);
		//그런데, 없는 계좌가 잇을 경우, 예외는 발생하나, db에선 다름!
	
	}

}
