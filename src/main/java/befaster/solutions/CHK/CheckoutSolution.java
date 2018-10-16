package befaster.solutions.CHK;



import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import org.junit.Test;




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
    		
   
    	
    	
    	/*for(String key : hmap.keySet()) {
    		totalPrice+= specialOffer(key, hmap.get(key));
    	}
    	
    	*/
    	
    	ArrayList<String> prioritizedStrings = 	processPrirityOneFirst(hmap.keySet(), skus);
    	
    	for(String key : prioritizedStrings) {
    		totalPrice+= specialOffer(hmap, key, hmap.get(key));
    	}
    			
    	return totalPrice;
    	
    }
    
    private int specialOffer(HashMap<String, Integer> map, String item, int quantity) {
    	int totalPrice = 0;
    	int remainings = 0;
    	
    	if(item.equals("A")) {
    		
    		
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
    	else if(item.equals("E")) {
    		
    		if((quantity / 2) > 0) {
    			int amount = quantity / 2;
    			
    			if(map.get("B") != null) {
					if (map.get("B") >= amount) {
						map.put("B", map.get("B") - amount);
					} else {
						map.put("B", 0);
					}
    			}
    		}
    		totalPrice = quantity * 40;
    	}
    	
    	return totalPrice;
    	
    }
    
    private ArrayList<String> processPrirityOneFirst(Set<String> keySet, String inputString) {
    	
    	ArrayList<String> stringArrays = new ArrayList<String>();

    	if(inputString.contains("E")) {
    		stringArrays.add("E");
    	}
    	
    	for(String key : keySet) {
    		
    		if(!key.equals("E")) {
    			stringArrays.add(key);
    		}
    		
    		//totalPrice+= specialOffer(key, hmap.get(key));
    		
    	}
    	
    	return stringArrays;
    	
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
    
    
    @Test
	public void computeCase1(){
    	
    	CheckoutSolution checkSol = new CheckoutSolution();
		assertEquals((Integer)115, checkSol.checkout("ABCD"));
	}
   
  
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
