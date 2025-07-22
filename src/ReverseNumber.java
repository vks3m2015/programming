public class ReverseNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("  reverse Number == "+reverseNumber(12345));

	}
	
	public static int reverseNumber(int num)
	{
		int reverseNum = 0;
		
		while( num != 0)
		{
			int lastDigit = num%10;
			
			reverseNum = reverseNum * 10 + lastDigit;
			
			num = num / 10;
			
		}
		
		return reverseNum;
	}

}
