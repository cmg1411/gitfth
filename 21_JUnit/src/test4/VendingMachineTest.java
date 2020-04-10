package test4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*   @Before   : VedingMachine객체생성
 *   @After    : 잔돈표시
 *   @Test     : testInsertCoin    <-- 500,100,100주입한후 현재 금액확인    
 *   @Test     : testNegativeCoin  <-- -100주입                                          
 */
public class VendingMachineTest {
	private VendingMachine vm;
	
	@Before
	public void setUp() {
		vm=new VendingMachine();
	}
	
	@After
	public void tearDown() {
		Assert.assertEquals(0, vm.getCurrent());
	}
	
//	@Test
//	public void testInsertCoin() {
//		vm.insertCoin(500);
//		vm.insertCoin(100);
//		vm.insertCoin(100);
//		Assert.assertEquals(700, vm.getCurrent());
//	}
	
	@Test(expected=RuntimeException.class)
	public void testNagativeCoin() {
		vm.insertCoin(-100);
	}
}







