package befaster.solutions.CHK;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        
    	int totalPrice = 0;
    	HashMap<String, Integer> hmap = new HashMap<String, Integer>();
    	
    	String[] products = skus.split(",");
    	
    	for(String product : products) {
    		
    			processProductString(hmap, product);
    		
    	}
    	
    	for(String key : hmap.keySet()) {
    		totalPrice+= specialOffer(key, hmap.get(key));
    	}
    	
    	return totalPrice;
    	//throw new SolutionNotImplementedException();
    }
    
    private int specialOffer(String item, int quantity) {
    	int totalPrice = 0;
    	
    	if(item.equals("A")) {
    		
    		totalPrice = (quantity / 3) * 130 + (quantity % 3) * 50;
    		
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
    	
    	int quantity;
    	String quantityString = proString.substring(0, proString.length() - 1);
    	char item = proString.charAt(proString.length() - 1);
    	if(item  != 'A' || item  != 'B' || item  != 'C' || item  != 'D') {
    		throw new IncorrectFormatException("Format exception");
    	}
    	try {
    		quantity = Integer.parseInt(quantityString);
		} catch (NumberFormatException e) {
			throw new IncorrectFormatException("Format exception");
		}
    	
    	map.put(proString.charAt(proString.length() - 1) + "", quantity);
    	    	
    }
    
    @Test
    public void testCheckout() {
    	
    	CheckoutSolution chSol = new CheckoutSolution();
    	assertEquals((Integer)660, chSol.checkout("6A,10B,5C,5D"));
    	
    }
    
}
