import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.regex.Matcher;;

public class DebugProgram {

	
	static String[] taskMaker(String[] source, int challengeId) {
	    
	    String prevString = null;
	    int index = 0;
	    
	    String[] output = new String[source.length];
	    int k=0;
	    
	    for(int i=0;i<source.length;i++){
	        
	        if(!source[i].contains("DB")){
	            output[k++] = source[i];
	        }else{
	            
	            String comment = source[i];
	            int commentLen = comment.length();
	            
	            //Removing the leading spaces
	            comment = comment.replaceAll("^\\s+","");
	            
	            int newCommentLength = comment.length();
	            
	            int leadingZeros = commentLen-newCommentLength;   
	            
	            String splitComment = comment.substring(comment.indexOf(" ")+1);
	            
	            if(splitComment.startsWith(String.valueOf(challengeId))){
	                
	                index = splitComment.lastIndexOf('/');
	                String replacement = splitComment.substring(index+1);

	            	StringBuilder sb = new StringBuilder();
	                
	                for(int j=0;j<leadingZeros;j++){
	                    sb.append(" ");
	                }
	                sb.append(replacement);
	                
	                output[k-1] = sb.toString();
	                
	            }
	            
	        }
	        
	    }
	    
	    return Arrays.copyOfRange(output,0,k);    
	    
	}

	
	public static void main(String[] args){
		
		String[] src = {"ans = 0;",
				"for (var i = 0; i < n; i++) {",
				"    for (var j = 0; j < n; j++) {",
				"    //DB 3//for (var j = 1; j < n; j++) {",
				"    //DB 2//for (var j = 0; j < n + 1; j++) {",
				"        ans++;",
				"    }",
				"}",
				"return ans;"};
		
		
		
		String[] src2 = {"ans = 0", 
		 "for i in range(n):", 
		 "    for j in range(n):", 
		 "    //DB 3//for j in range(1, n):", 
		 "    //DB 2//for j in range(n + 1):", 
		 "        ans += 1", 
		 "return ans"};
		
		//String[] output = taskMaker(src,2);
		
		String[] output = taskMaker(src2,3);
		
		for(String s:output){
			System.out.println(s);
		}
		
	}
}
