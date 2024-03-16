package practice;

import java.util.Scanner;

public class Fabonacci {
	
	static int fab( int n)
	{
		int n1 = 0, n2=1, n3=1;
		
		if(n==1)
			return n1;
		
		for(int i =3; i<= n; i++) 
		{
			n3 = n1+n2;
			n1= n2;
			n2 = n3;
			
		}	
		
		return n3;
	}
	
	
	static int fabRec(int n)
	{
		
		if(n == 1)
			return 0;
		else if(n == 2)
			return 1;
		
		return fabRec(n-1) + fabRec( n-2); 
	}
	
	
	
	public static void main(String[] arg)
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println(" Enter n th position in fab series");
		int n = sc.nextInt();
		System.out.println(" using simple approch  num == "+fab(n));
		System.out.println(" using recursion num == "+fab(n));
		
		System.out.println();
		
		sc.close();
	}

}
