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
    			totalPrice+= (remainings / 3) * 130;
    		}
    		
    		totalPrice+= (remainings % 3) * 50;
    		
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
    	else if(item.equals("F")) {
    		
    		if((quantity / 3) > 0) {
    			quantity = quantity - (quantity / 3);
    		}
    		
    		totalPrice = quantity * 10;
    	}
    	
    	else if(item.equals("G")) {
    		
    		totalPrice = quantity * 20;
    	}
    	
    	else if(item.equals("H")) {
    		
    		if((quantity / 10) > 0) {
    			totalPrice+= (quantity / 10) * 80;
    			
    		}
    		
    		remainings = quantity % 10;
    		
    		if((remainings / 5) > 0) {
    			totalPrice+= (remainings / 5) * 45;
    		}
    		
    		totalPrice+= (remainings % 5) * 10;
    		
    	}
    	else if(item.equals("I")) {
    		
    		totalPrice = quantity * 35;
    	}
    	else if(item.equals("J")) {
    		
    		totalPrice = quantity * 60;
    	}
    	
    	else if(item.equals("K")) {
    		totalPrice = (quantity / 2) * 120 + (quantity % 2) * 70;
    	}
    	else if(item.equals("L")) {
    		
    		totalPrice = quantity * 90;
    	}
    	else if(item.equals("M")) {
    		
    		totalPrice = quantity * 15;
    	}
    	
    	else if(item.equals("N")) {
    		
    		if((quantity / 3) > 0) {
    			int amount = quantity / 3;
    			
    			if(map.get("M") != null) {
					if (map.get("M") >= amount) {
						map.put("M", map.get("M") - amount);
					} else {
						map.put("M", 0);
					}
    			}
    		}
    		totalPrice = quantity * 40;
    	}
    	
    	else if(item.equals("O")) {
    		
    		totalPrice = quantity * 10;
    	}
    	
    	else if(item.equals("P")) {
    		totalPrice = (quantity / 5) * 200 + (quantity % 5) * 50;
    	}
    	
    	else if(item.equals("Q")) {
    		totalPrice = (quantity / 3) * 80 + (quantity % 3) * 30;
    	}
    	
    	else if(item.equals("R")) {
    		
    		if((quantity / 3) > 0) {
    			int amount = quantity / 3;
    			
    			if(map.get("Q") != null) {
					if (map.get("Q") >= amount) {
						map.put("Q", map.get("Q") - amount);
					} else {
						map.put("Q", 0);
					}
    			}
    		}
    		totalPrice = quantity * 50;
    	}
    	
    	else if(item.equals("S")) {
    		
    		totalPrice = quantity * 20;
    	}
    	
    	else if(item.equals("T")) {
    		
    		totalPrice = quantity * 20;
    	}
    	
    	else if(item.equals("U")) {
    		
    		if((quantity / 4) > 0) {
    			quantity = quantity - (quantity / 4);
    		}
    		
    		totalPrice = quantity * 40;
    	}
    	
    	else if(item.equals("V")) {
    		
    		
    		if((quantity / 3) > 0) {
    			totalPrice+= (quantity / 3) * 130;
    			
    		}
    		
    		remainings = quantity % 3;
    		
    		if((remainings / 2) > 0) {
    			totalPrice+= (remainings / 2) * 90;
    		}
    		
    		totalPrice+= (remainings % 2) * 50;
    		
    	}
    	else if(item.equals("W")) {
    		
    		totalPrice = quantity * 20;
    	}
    	else if(item.equals("X")) {
    		
    		totalPrice = quantity * 90;
    	}
    	else if(item.equals("Y")) {
    		
    		totalPrice = quantity * 10;
    	}
    	else if(item.equals("Z")) {
	
    		totalPrice = quantity * 50;
    	}
    	
    	return totalPrice;
    	
    }
    
    private ArrayList<String> processPrirityOneFirst(Set<String> keySet, String inputString) {
    	
    	ArrayList<String> stringArrays = new ArrayList<String>();

    	if(inputString.contains("E")) {
    		stringArrays.add("E");
    	}
    	if(inputString.contains("N")) {
    		stringArrays.add("N");
    	}
    	if(inputString.contains("R")) {
    		stringArrays.add("R");
    	}
    	
    	for(String key : keySet) {
    		
    		if(!("ENR").contains(key)) {
    			stringArrays.add(key);
    		}
    		
    		//totalPrice+= specialOffer(key, hmap.get(key));
    		
    	}
    	
    	return stringArrays;
    	
    }
    
  
    private int processGroupOffer(HashMap<String, Integer> map, ArrayList<String> groups, int groupSize, int spPrice) {
    	
    	int totalItems = 0;
    	int totalCost = 0;
    	int leftItems = 0;
    	int quantity = 0;
    	
    	for(int index =0; index < groups.size(); index++) {

    		if(map.get(groups.get(index)) != null) {
    			
    			totalItems += map.get(groups.get(index));
    		}
    	}
    	
    	totalCost = ( totalItems / groupSize ) * spPrice;
    	
    	leftItems = totalItems % groupSize;
    	
    	for(int index =0; index < groups.size(); index++) {
    		
    		if(map.get(groups.get(index)) != null) {
    			
    			quantity = map.get(groups.get(index));
    			
    			if(leftItems > 0) {
  				
    				if(quantity >= leftItems) {
    					map.put(groups.get(index), leftItems);
    					leftItems = 0;
    				}
    				else {
    					leftItems = leftItems - quantity;
    				}
    			}
    			else {
    				
    				map.put(groups.get(index), 0);
    			}
    		}
    	}
    	
    	return totalCost;
    }
    
    private void processProductString(HashMap<String, Integer> map, String proString) throws IncorrectFormatException {
    	
    	int proStringLength = proString.length();
    	char item;
    	
    	for(int i=0; i< proStringLength; i++) {
    		item = proString.charAt(i);
    		if(!"ABCDEFGHIJKLMNOPQRSTUVWXYZ".contains(item+"")) {
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
		assertEquals((Integer)220, checkSol.checkout("AAAAAFFF"));
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
