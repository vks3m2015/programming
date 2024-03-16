package practice;

public class DataTypes {
	
	public static void main( String[] args)
	{
		int a =12346;
		float b = 123.9225f;
		a = (int)b;
		//int 
		byte byt1 = (byte)1245657;
		//byte byt2 = 128;  //error because byte has range -128 to 127
		byte byt2 = 127;
		
		byte byt3 =(byte) (byt1 + byt2);
		
		System.out.println("byt 1 ========"+byt1);
		System.out.println("a== "+a);
		System.out.println(" b == "+b);
	}

}
