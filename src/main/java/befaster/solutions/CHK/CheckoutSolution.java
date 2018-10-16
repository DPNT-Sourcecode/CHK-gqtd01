package befaster.solutions.CHK;



import java.util.HashMap;




public class CheckoutSolution {
    public Integer checkout(String skus) {
        
    	int totalPrice = 0;
    	HashMap<String, Integer> hmap = new HashMap<String, Integer>();
    	
    	if(skus == null ) {
    		return -1;
    	}
    	if(skus.length() == 0) {
    		return 0;
    	}
    	
    	
    		
    			try {
					processProductString(hmap, skus);
				} catch (IncorrectFormatException e) {
					
					return -1;
					
				}
    		
   
    	
    	for(String key : hmap.keySet()) {
    		totalPrice+= specialOffer(key, hmap.get(key));
    	}
    	
    	return totalPrice;
    	
    }
    
    private int specialOffer(HashMap<String, Integer> map, String item, int quantity) {
    	int totalPrice = 0;
    	int remainings = 0;
    	
    	if(item.equals("A")) {
    		
    		//totalPrice = (quantity / 3) * 130 + (quantity % 3) * 50;
    		if((quantity / 5) > 0) {
    			totalPrice+= (quantity / 5) * 200;
    			
    		}
    		
    		remainings = quantity % 5;
    		
    		if((remainings / 3) > 0) {
    			totalPrice+= (quantity / 3) * 130;
    		}
    		
    		totalPrice+= (quantity % 3) * 50;
    		
    	}
    	
    	else if(item.equals("B")) {
    		totalPrice = (quantity / 2) * 45 + (quantity % 2) * 30;
    	}
    	
    	else if(item.equals("C")) {
    		totalPrice = quantity * 20;
    	}
    	else if(item.equals("D")) {
    		totalPrice = quantity * 15;
    	}
    	
    	return totalPrice;
    	
    }
    
    
  
    private void processProductString(HashMap<String, Integer> map, String proString) throws IncorrectFormatException {
    	
    	int proStringLength = proString.length();
    	char item;
    	
    	for(int i=0; i< proStringLength; i++) {
    		item = proString.charAt(i);
    		if(item  != 'A' && item  != 'B' && item  != 'C' && item  != 'D') {
        		throw new IncorrectFormatException("Format exception");
        	}
    		if(map.get(item+"") == null) {
    			map.put(item + "", 1);
    		} else {
    			map.put(item + "", map.get(item+"") + 1);
    		}
    	}
    	
    	
    }
    
    
   /* @Test
	public void computeCase1(){
    	
    	CheckoutSolution checkSol = new CheckoutSolution();
		assertEquals((Integer)115, checkSol.checkout("ABCD"));
	}*/
   
  
}

class IncorrectFormatException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IncorrectFormatException(String errormessage) {
		super(errormessage);
	}

}
