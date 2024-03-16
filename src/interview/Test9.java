package interview;

public class Test9 {

	public static void main(String[] args) {
		System.out.println(add("99", "34"));

	}
	
	
	//99 + 30   2  11
	static String add(String a, String b) {
		int len1 = a.length(), len2 = b.length();
		int minLen = len1 < len2 ? len1: len2;
		int carryForward = 0;
		String result = "";
		int tempSum = 0;
		for(int i = minLen-1; i >= 0; i--) {
			int num1 = a.charAt(i), num2 = b.charAt(i);
			System.out.println("num1 = "+ num1 + "  num1 = "+ num1);
		    tempSum = num1 + num2 + carryForward;
		    
		    carryForward = tempSum % 10;
		    int toAdd = tempSum /10;
		    result = toAdd + result;			
		}
		return result;
		
	}

}
