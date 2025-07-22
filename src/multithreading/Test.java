
package multithreading;

public class Test {

	  boolean isOddTurn = true;
	  
	  public void printOdd()
	  {
		// synchronized(this)
		// {
			 for(int i=1; i<10; i=i+2)
		     {
//			    try{
//			    	 while(!isOddTurn)
//			    	 {
//			    		 System.out.println(" ODD WAITING...");
//			    		// wait();
//			    		 System.out.println(" ODD NOTIFIED...");
//			    	 }    
//			    }
//			    catch(InterruptedException e)
//			    {
//			    	e.printStackTrace();
//			    }
			    
			    System.out.println(i);
			   // isOddTurn = false;
			   // notify();   //what if we don't use notify 
		     }	 
	      //}
	    }
	
	
	public void printEven() 
	{
		synchronized (this) 
		{

			for (int i = 2; i <= 10; i = i + 2) 
			{
//				try 
//				{
//					while (isOddTurn)
//					{
//						System.out.println(" EVEN WAITING...");
//						wait();
//						System.out.println(" EVEN NOTIFIED...");
//					}	
//						
//				} 
//				catch (InterruptedException e) 
//				{
//					e.printStackTrace();
//				}

				System.out.println(i);
				//isOddTurn = true;
				//notify();
			}
		}
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		OddEvenThread oddEvenThread = new OddEvenThread();
		
		/* if we do like this -
		 *    new OddEvenThread().printOdd();
		 *    new OddEvenThread().printEven();
		 * 
		 * It is creating DeadLock because these methods are called on two different object. Thread1 and Thread2 are working on two different objects
		 */
		
		
		Runnable r1 = () -> {
			 
			oddEvenThread.printOdd();
		};

		Runnable r2 = () -> {
			 
			oddEvenThread.printEven();
		};
		
	
		Thread thread1 = new Thread(r1);
		Thread thread2 = new Thread(r2);
		
		thread1.start();
		thread2.start();
		
	}

}
