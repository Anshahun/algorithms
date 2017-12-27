package junit_src;

import junit.framework.TestCase;

public class Demo1 extends TestCase {
	
	public void testFail(){
		fail();
	}
	
	public static void main(String[] args) {
		Demo1 demo1 = new Demo1();
		//demo1.fail();
	}

}
