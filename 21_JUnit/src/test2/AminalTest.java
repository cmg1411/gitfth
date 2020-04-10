package test2;

import static org.junit.Assert.*;

import org.junit.Test;

public class AminalTest {
	@Test
	public void test() {
		String ob1="강아지";
		String ob2="고양이";
		
		Animal m=new Animal(ob1);
		assertEquals(m.getAnimal(), ob2);    // 실패
	}
}





