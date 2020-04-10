package test3;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
	private Account account;
	
	@Before
	public void setUp() {
		account=new Account(100000);
//		System.out.println("setUp");
	}
	
	@Test
	public void testAccount() throws Exception {
		if(account==null) {
			throw new Exception("계좌 생성실패");
		}
//		System.out.println("testAccount");
	}

	@Test
	public void testGetBalance() {
		Assert.assertEquals(100000, account.getBalance());
		
		account=new Account(50000);
		Assert.assertEquals(50000, account.getBalance());
	}
	
	//계좌에 30000원 입금 ==> 130000
	@Test
	public void testDeposit() {
		account.deposit(30000);
		Assert.assertEquals(130000, account.getBalance());
	}
	
	//계좌에 20000원 출금 ==> 80000
	@Test
	public void testWithdraw() {
		account.withdraw(20000);
		Assert.assertEquals(80000, account.getBalance());
	}
}






