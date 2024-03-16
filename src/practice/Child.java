package practice;

public class Child extends Parent {
	
	public static void printMsg()
	 {
		 System.out.println(" Hi. Child ........");
	 }

	  public static void main( String[] args)
	  {
		Child objChild = new Child();
		objChild.printMsg();
	  }

}
