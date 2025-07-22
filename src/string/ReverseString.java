package string;

public class ReverseString {

	public static void main(String[] arg)
	{
		String str = "vikas";

		String stringRev = reverseWithoutUsingExtraSpace(str);

		System.out.println("  stringRev == "+stringRev);

		stringRev = reverseRecursively(str);

		System.out.println(" reverseRecursively =  "+ stringRev);

		stringRev = reverseStringByMakingNewStr(str);

		System.out.println(" reverseStringByMakingNewStr  == "+stringRev);


	}

	/*
	 *  Reverse String using Recursion
	 *
	 */

	public static String reverseRecursively(String inputStr)
	{
		if(inputStr.length() == 1)
			return inputStr;

		char charInFun = inputStr.charAt(0);

		System.out.println(" charInFun =="+charInFun );
		return  reverseRecursively(inputStr.substring(1)) + charInFun;

	}

	/*
	 * Reverse String without using any extra space
	 *
	 */
	public static String reverseWithoutUsingExtraSpace(String inputStr)
	{
		char[] charArr = inputStr.toCharArray();
		//char[] charArr = inputStr.split("");

		int start = 0;
		int end = inputStr.length() - 1;

		char temp;

		while(start < end)
		{
			temp = charArr[start];

			charArr[start] = charArr[end];
			charArr[end] = temp;

			start++;
			end--;

		}

		return String.valueOf(charArr);

	}

	public static String reverseStringByMakingNewStr(String inputStr)
	{
		StringBuilder revStr = new StringBuilder();
		for(int i = inputStr.length() - 1; i >= 0;  i-- )
		{
			revStr.append(inputStr.charAt(i));
		}

		return String.valueOf(revStr);

	}
	
	
    public void reverseString(char[] s) {
    	int i = 0, j = s.length;
    	char temp;
    	while(i<j) {
    		temp = s[i];
    		s[i++] = s[j];
    		s[j--] = temp;
    	}
    }
}
