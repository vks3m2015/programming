package string;

public class RotationOfOther {

	public static void main(String[] args) {
	
		
		System.out.println(isRotationStr("abcdef", "cdefab"));

	}
	
	//return true if str2 is a rotation of str1 else return false
	public static boolean isRotationStr(String str1, String str2)
	{
		if(str1.length() != str2.length())
		 return false;
		
		String str3 = str2 + str2;
		
		if(str3.contains(str1)) 
			return true;
		else
			return false;
				
	}

}
