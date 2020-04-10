package test1;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
	@Before
	public void setUp() {
		System.out.println("setUp");
	}
	
	@After
	public void tearDown() {
		System.out.println("tearDown");
	}
	
	@Test
	public void concatenate() {
		Calculator ob=new Calculator();
		String n=ob.concatenate("abc","xyz");
		assertEquals("abcxyz", n);
	}
	
	@Test
	public void add() {
		Calculator ob=new Calculator();
		int n=ob.add(3, 5);
		assertEquals(7, n);/////////////
	}
	
	@Test
	public void subtract() {
		Calculator ob=new Calculator();
		int n=ob.subtract(7, 5);
		assertEquals(2, n);
	}
}
//---------------------------------------------------
/*
public class CalculatorTest {
	@Test
	public void concatenate() {
		Calculator ob=new Calculator();
		String n=ob.concatenate("abc","xyz");
		assertEquals("abcxyz", n);
	}
	
	@Test
	public void add() {
		Calculator ob=new Calculator();
		int n=ob.add(3, 5);
		assertEquals(8, n);
	}
	
	@Test
	public void subtract() {
		Calculator ob=new Calculator();
		int n=ob.subtract(7, 5);
		assertEquals(2, n);
	}
}
*/







