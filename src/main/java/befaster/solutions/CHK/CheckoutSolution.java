package befaster.solutions.CHK;

import java.util.HashMap;

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
    
    
    private void processProductString(HashMap<String, Integer> map, String proString) {
    	
    	String quantityString = proString.substring(0, proString.length() - 2);
    	int quantity = Integer.parseInt(quantityString);
    	map.put(proString.charAt(proString.length() - 1) + "", quantity);
    	    	
    }
}
