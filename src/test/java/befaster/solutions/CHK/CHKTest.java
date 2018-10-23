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
    	
    	CheckoutSolution checkSol = new CheckoutSolution();
		assertEquals((Integer)(220 + 90 + 17), checkSol.checkout("AAAAAFFFXXSSSZT"));
	}
	
	@Test
	public void computeCase2(){
    	
    	CheckoutSolution checkSol = new CheckoutSolution();
		assertEquals((Integer)(220 + 90 ), checkSol.checkout("AAAAAFFFXXSSZT"));
	}
	
	
	@Test
	public void computeCase3(){
    	
    	CheckoutSolution checkSol = new CheckoutSolution();
		assertEquals((Integer)(220 + 90 + 17), checkSol.checkout("AAAAAFFFSSSZTXX"));
	}
	
	
	/*@Test
	public void computeCase2(){
		
		assertEquals((Integer)50, checkSol.checkout("1A"));
	}
	
	@Test
	public void computeCase3(){
		
		assertEquals((Integer)15, checkSol.checkout("D"));
	}
	
	@Test
	public void computeCase4(){
		
		assertEquals(new Integer(-1), checkSol.checkout("1000Z"));
	}*/

}


