import java.util.Arrays;


public class CopyAndPaste {

	static boolean plagiarismCheck(String[] code1, String[] code2) {

	    boolean returnVal = false;
	    
	    if(code1.length!=code2.length)
	        return returnVal;
	        
	    for(int i=0;i<code1.length;i++){
	        if(!code1[i].equals(code2[i])){
	            //String within paranthesis
	            
	            if(code1[i].endsWith(":") || code1[i].endsWith(";")){
	            	code1[i] = code1[i].substring(0, code1[i].length()-1);
	            }
	            
	            if(code2[i].endsWith(":") || code2[i].endsWith(";")){
	            	code2[i] = code2[i].substring(0, code2[i].length()-1);
	            }
	        	
	            String[] vars1;
	            String[] vars2;
	            
	            vars1 = code1[i].split(" ");
	            vars2 = code2[i].split(" ");
	            
	            Arrays.sort(vars1);
	            Arrays.sort(vars2);
	            
	            for(int j=0;j<vars1.length;j++){
	                if(!vars1[j].equals(vars2[j])){
	                    returnVal = true;
	                    break;
	                }
	            }
	        }    
	    }
	    
	    return returnVal;
	    
	}






	
	public static void main(String[] args){
		
		String[] code1 = {
				"function is_even_sum(a, b) {", 
				 "  return (a + b) % 2 === 0;", 
				 "}"
		};
		
		String[] code2 = {
				"function is_even_sum(a, b) {", 
				        "  return (a + b) % 2 !== 1;", 
				        "}"
		};
		
		System.out.println(plagiarismCheck(code1,code2));
	}

}
