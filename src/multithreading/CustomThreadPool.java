package multithreading;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class CustomThreadPool {
	
	private BlockingQueue<Runnable> taskQueue;
	private boolean shutdownThreadPool;
	
	//Creating Worker Thread
	CustomThreadPool(int numOfWorkerThread)
	{
	   taskQueue = new LinkedBlockingQueue<Runnable>(numOfWorkerThread);	
	   for(int i=1; i<= numOfWorkerThread; i++)
	   {
		   Thread worker = new Thread(new WorkerThread(taskQueue, this));
		   worker.setName("WorkerThread"+i);
		   
		   worker.start();
		   System.out.println(" WorkerThread "+i + "  created...... ");
	   }	   
	}
	
	public void submitTask(Runnable task)
	{
	   try {
		taskQueue.put(task);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}	
	}
	
	public void shutDownThreadPool()
	{
		shutdownThreadPool = true;
	}
	
	public boolean isToShutDownTreadPool()
	{
		return shutdownThreadPool;
	}
	
	
	public static void main(String[] args) {
		
		CustomThreadPool ctp = new CustomThreadPool(3);
		ctp.submitTask(new MyTask("TASK1"));
		ctp.submitTask(new MyTask("TASK2"));
		ctp.submitTask(new MyTask("TASK3"));
		ctp.submitTask(new MyTask("TASK4"));
		
		ctp.shutDownThreadPool();
	}


}

class WorkerThread implements Runnable
{
	private BlockingQueue<Runnable> taskQueue;
	private CustomThreadPool customThreadPool;
	
	
	
	public WorkerThread(BlockingQueue<Runnable> taskQueue, CustomThreadPool customTreadPool) {
		super();
		this.taskQueue = taskQueue;
		this.customThreadPool = customTreadPool;
	}



	@Override
	public void run() {
		
		
		try {
			while(true) {
				
				Runnable task = null;
				
				System.out.println(" Worker Thread -"+ Thread.currentThread().getName()+ " is Executing and going to pick a task from Queue .....");
				
				//try {
					task = taskQueue.take();
				//} catch (InterruptedException e) {
					
				//	e.printStackTrace();
				//}
				
				task.run();
				
				if(this.customThreadPool.isToShutDownTreadPool() && this.taskQueue.size() == 0)
					Thread.currentThread().interrupt();
			}
		} catch (Exception e) {
			System.out.println(" thread "+Thread.currentThread().getName()+ "  has stopped successfully ....");
			//e.printStackTrace();
		}
		
	}
  	

}

class MyTask implements Runnable{

	
	String name;
	public MyTask(String string) {
	
		this.name = string;
	}

	@Override
	public void run() {
		
	System.out.println(" This is a task running by thread  -"+Thread.currentThread().getName() +"-----" +name);	
	
	try {
		Thread.sleep(10000);
	} catch (InterruptedException e) {
		
		e.printStackTrace();
	}
	System.out.println(" Still task running is by thread  -"+Thread.currentThread().getName() +"-----" +name);
	}
	
}