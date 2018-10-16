package befaster.solutions.CHK;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CHKTest {
	
	
	private CheckoutSolution checkSol;
	
	@Before
	public void setUp() {
		checkSol = new CheckoutSolution();
	}
	
	@Test
	public void computeCase1(){
		
		assertEquals((Integer)660, checkSol.checkout("6A,10B,5C,5D"));
	}
	
	@Test
	public void computeCase2(){
		
		assertEquals((Integer)50, checkSol.checkout("1A"));
	}
	
	@Test
	public void computeCase3(){
		
		assertEquals((Integer)15000, checkSol.checkout("1000D"));
	}

}


