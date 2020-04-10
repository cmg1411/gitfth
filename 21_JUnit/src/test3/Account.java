package test3;

public class Account {
	private int balance;

	public Account(int balance) {  //통장 초깃값
		super();
		this.balance = balance;
	}

	public int getBalance() {
		return balance;
	}
	
	public void deposit(int money) {  //입금
		this.balance += money;
	}
	
	public void withdraw(int money) {  //출금
		this.balance -= money;
	}
}





