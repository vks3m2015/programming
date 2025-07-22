package arrays;

public class Cipher {

	public static void main(String[] args) {
		
		String str = "vikaszyw";
		StringBuilder result =  new StringBuilder();

		
		for(int i=0; i< str.length(); i++)
		{
			int temp = str.charAt(i)  + 2;
			
			if(temp > 'z')
			{	
			   int temp2 = temp % 'z';
			   int temp3 = temp2 + 'a';
			   temp = temp3 - 1;
			}   
			char temp4 = (char)temp;
			
			//System.out.println(" temp = "+temp+ "  temp2 = "+temp2 + "  temp3 = "+temp3+ " temp4 = "+temp4);
			result = result.append( String.valueOf(temp4));
		}	
		
		System.out.println(result);
		
		 // + 'a' + 2 ;
		//System.out.println(('y' + 2) % 'z' + 'a');
			
	}

}
