
public class AddBinary {

	public static String addBinary(String s1,String s2){
		
		StringBuilder sb = new StringBuilder();
		int flag=0;
		
		if(s1==null && s2 == null){
			return null;
		}
		
		if(s1==null){
			return s2;
		}
		
		if(s2==null){
			return s1;
		}
		
		int p1 = s1.length()-1;
		int p2 = s2.length()-1;
		int va=0;
		int vb=0;
		int sum;
		
		while(p1>=0 || p2>=0){
			
			va=vb=0;
			if(p1>=0){
				va=s1.charAt(p1)=='0'?0:1;
				p1--;
			}
			if(p2>=0){
				vb=s2.charAt(p2)=='0'?0:1;
				p2--;
			}
			
			sum=va+vb+flag;
			
			if(sum>=2){
				sb.append(sum-2);
				flag=1;
			}else{
				sb.append(sum);
			}
			
		}
		return sb.reverse().toString();
	}
	
	public static void main(String[] args){
		
		String s1="101";
		String s2="1010";
		
		System.out.println(addBinary(s1,s2));
		
	}
	
}
