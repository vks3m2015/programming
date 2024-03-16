package practice;

public class ExceptionTest {
	
	public static void main(String[] arg )
	{
		try
		{
			
			int a = 10/2;  //exception not occured. Stll finally block will execute 
			// int b = 10/0;
			
			System.out.println("line after exception occured..");
			return;
		}
		
		catch(ArithmeticException e)
		{
			System.out.println("Arithmetic exeption...............");
		}
		catch(RuntimeException e)
		{
			System.out.println(" Runtime Exception class-------------");
		}
		catch(Exception e)
		{
			System.out.println(" Exception class-------------");
			
		}
		finally
		{
			System.out.println("finally block executed......");
		}
		
		
	}
	
	public static final void method1(int a)
	{}
	
	private  static void method1(int a, int b)
	{}
	
	

}
