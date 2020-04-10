package test4;

/* 
* -money:int
* +insertCoin(money:int):void       // 동전주입
* +getCurrent():int                      // 누적된 동전 확인
*/
public class VendingMachine {
	private int money;
	
	public void insertCoin(int money) {
		if(money <= 0) {
			throw new RuntimeException("zero or nagative money: " + money);
		}
		this.money += money;
	}
	
	public int getCurrent() {
		return money;
	}
}




