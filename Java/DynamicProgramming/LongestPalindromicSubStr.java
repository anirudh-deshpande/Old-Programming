package Programming.Java.DynamicProgramming;

public class LongestPalindromicSubStr {

	/*
	 * 1. Declare a table of size = length * length of string
	 * 2. Palindrome computed as follows
	 * 		a. Characters with length 1 is a palindrome
	 * 		b. If consecutive characters are of same length, they are palindromes
	 * 		c. Form a window of size 3 onwards and slide the window
	 * 			- If 1st and last characters of window are same, Inner string is a palindrome, it implies that outer string is also palindrome
	 * 			- Do this only if the length is greater, Else it is not a palindrome.
	 * 
	 */
	
	
	public static String longestPalindromicSubStr(String s){
		String palSubStr = null;
		int palSubStrLen = 0;
		
		//1. Declare a table of size = length * length of string, by default, the entries are 0.
		int[][] table = new int[s.length()][s.length()];
		
		//2.a Characters with length 1 is a palindrome
		for(int i=0;i<s.length();i++){
			table[i][i]=1;
			palSubStrLen = 1;
			palSubStr = String.valueOf(s.charAt(i));
		}
		
		/*2.b If consecutive characters are of same length, they are palindromes
		 * 		s.length()-1 because s[i] and s[i+1] are being compared  
		 */
		for(int i=0;i<s.length()-1;i++){
			if(s.charAt(i)==s.charAt(i+1)){
				table[i][i+1]=1;
				palSubStrLen = 2;
				palSubStr = s.substring(i, i+2);
			}
		}
		
		//2.c Form a window of size 3 onwards and slide the window
		for(int l=2;l<s.length();l++){
			for(int i=0;i<s.length()-l;i++){
				int j=i+l;
				
				// If 1st and last characters of window are same, 
				if(s.charAt(i)==s.charAt(j)){
					table[i][j] = table[i+1][j-1];
					
					// Inner string is a palindrome, length greater than previously found palindrome
					if(table[i][j] == 1 && j-i > palSubStrLen){
						
						//It implies that outer string is also palindrome
						palSubStrLen = j-i;
						palSubStr = s.substring(i, j+1);
					}
				}
			}
		}
		
		return palSubStr;
	}
	
	public static void main(String[] args) {
		
		String s = "abbaabbacdcdcdcd";
		System.out.println(longestPalindromicSubStr(s));
	}

}
