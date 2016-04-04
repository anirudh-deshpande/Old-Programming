

public class LongestCommonSubSeq {
	
	public static String LCSRecursion(String s1,String s2){
		
		if(s1.length()==0 || s2.length()==0)
			return "";
		
		int s1Last = s1.length()-1;
		int s2Last = s2.length()-1;
		
		if(s1.charAt(s1Last) == s2.charAt(s2Last)){
			return s1.charAt(s1Last)+LCSRecursion(s1.substring(0, s1Last),s2.substring(0, s2Last));
		}else{
			String s1Ret = LCSRecursion(s1,s2.substring(0, s2Last));
			String s2Ret = LCSRecursion(s1.substring(0, s1Last),s2);
			String both = LCSRecursion(s1.substring(0, s1Last),s2.substring(0, s2Last));
			
			int max = Math.max(s1Ret.length(), Math.max(s2Ret.length(), both.length()));
			
			if(max == s1Ret.length()){
				return s1Ret;
			}else if(max == s2Ret.length()){
				return s2Ret;
			}else{
				return both;
			}
		}
		
	}
	
	public static int[][] computeLCS(String s1,String s2){
		int s1Len = s1.length();
		int s2Len = s2.length();
		
		final int pick_s1_or_s2 = 0;
		final int pick_s1 = 1;
		final int pick_s2 = 2;
		
		int[][] match = new int[s1Len][s2Len];
		int[][] pointer = new int[s1Len][s2Len];
		
		for(int i=0;i<s1Len;i++){
			for(int j=0;j<s2Len;j++){
				
				if(s1.charAt(i) == s2.charAt(j)){ //Characters match
					if(i==0 || j==0){
						match[i][j] = 1;
					}else{
						match[i][j] = match[i-1][j-1]; 
					}
					pointer[i][j] = pick_s1_or_s2;
				}else{ //Characters dont match
					
					if(i==0 && j>0){ // first row, 
						match[i][j] = match[i][j-1];
						pointer[i][j] = pick_s1;
					}else if(i>0 && j==0){ // first column
						match[i][j] = match[i-1][j];
						pointer[i][j] = pick_s2;
					}else if(i>0 && j>0){
						
						if(match[i-1][j] >= match[i][j-1]){
							match[i][j]=match[i-1][j];
							pointer[i][j] = pick_s2;
						}else{
							match[i][j]=match[i-1][j];
							pointer[i][j] = pick_s1;
						}
					}
				}
			}
		}
		
		return pointer;
	}
	
	
	public static String LCSDynamicProgramming(String s1,String s2){
		
		int[][] pointer = computeLCS(s1,s2);
		
		int i = s1.length()-1;
		int j = s2.length()-1;
		
		final int pick_s1_or_s2 = 0;
		final int pick_s1 = 1;
		final int pick_s2 = 2;
		
		StringBuilder solution = new StringBuilder();
		
		while(i>=0 && j>=0){	
				switch(pointer[i][j]){
				
				case pick_s1_or_s2:
					solution.append(s1.charAt(i));
					i--;j--;
					break;
					
				case pick_s1:
					j--;
					break;
					
				case pick_s2:
					i--;
					break;
				
				}
			}
		
		return solution.reverse().toString();
	}
	
	
	
	public static void main(String[] args){
		String s1 = "abcfgijklabcdefglabcfgijkl";
		String s2 = "abcfgijklabcfgijkl";
		
		System.out.println(new StringBuilder(LCSRecursion(s1,s2)).reverse());
		System.out.println(LCSDynamicProgramming(s1,s2));
		
	}

}
