package string;

public class ReverseStringWithoutAffectingSplChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "vik@s#";
		System.out.println("  rev str ==="+reverseString(str));
		

	}
	
	public static String reverseString(String str)
	{
		char[] charArray = str.toCharArray();
		char temp;
		int start = 0;
		int end = str.length()-1;
		
		while(start < end)
		{
		    if(!Character.isAlphabetic(charArray[start]))  //if special character from start
		    	start++;
		    else if(!Character.isAlphabetic(charArray[end]))  //if special charter from end
		    	end--;
		    else                   //swap when both are charcters
		    {
		    	temp = charArray[start];
		    	charArray[start] = charArray[end];
		    	charArray[end] = temp;
		    	
		    	start++;
		    	end--;
		    	
		    }	
		   
		    //System.out.println(" -----"+start);
		    
		}
		
		return String.valueOf(charArray);
		
	}

}
