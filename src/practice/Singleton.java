package practice;

import java.util.stream.Collectors;

public class Singleton {
	
	private static volatile Singleton singleton = null;
	
	private Singleton() {}
	
	public Singleton getInstance() {
		
		
		if(singleton == null) {
			
			synchronized(this){
				if(singleton == null)
				    singleton = new Singleton();
			}
		}
		return singleton;
	}
	
	public static void main(String[] args) {
		
	  // emp -> fn, ln, dep, un
	   
	 //  Map<String, Integer> map = list.stream().grouping(emp -> emp.fn + "_"+ emp.ln , Collectors.collect(Collectors.toList()).count() )
	   
	
	
	
	
	
	}
	
	
	
	
	
	
	
	@Test
	m(){
		
	}
	
	
	@Test
	
	

	
}



null null -> 
alter table tb add constraint unique(,, )