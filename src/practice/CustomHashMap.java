package practice;

public class CustomHashMap<K, V> {
	
	private Entry<K,V>[] table;
	private int capacity = 4;
	
	
	class Entry<K,V>
	{
		K key;
		V value;
		Entry<K,V> link;
		
		Entry(K key, V value, Entry<K,V> link)
		{
			this.key = key;
			this.value = value;
			this.link = link;
			
		}
		
	}
	
	public CustomHashMap(){
	       table = new Entry[capacity];
	    }
	
	public void put(K newKey, V value)
	{
		if(newKey == null)
		  return;
		
		int hash = hash(newKey);
		
		System.out.println(" hash === "+hash + "  table length == "+table.length);
		Entry<K,V> curr = table[hash], previous= null;
		
		System.out.println(" hash table === "+table[hash]);
		
		while(curr != null)
		{
		    if(curr.key.equals(newKey))
			{
					curr.value = value;
					return;
		    }
		    
		    previous = curr;
			curr = curr.link;
		}
			
			Entry<K,V> entry = new Entry<K,V>(newKey, value, null);
			
			if(previous == null)
				table[hash] = entry;
			else
			    previous.link = entry;
			
		}	
		
      		
	
	/*public V get(K key)
	{
		
		
	}*/
    
	
	public int hash(K key)
	{
	  return Math.abs(key.hashCode()) % capacity;
	}
	
	
	public void display()
	{
	       
	       for(int i=0;i<capacity;i++)
	       {
	           if(table[i]!=null)
	           {
	                  Entry<K, V> entry=table[i];
	                  while(entry!=null)
	                  {
	                        System.out.print("{"+entry.key+"="+entry.value+"}" +" ");
	                        entry=entry.link;
	                  }
	           }
	       }             
	    
	  }
	
	
	public static void main(String[] arg)
	{
		
		 CustomHashMap<Integer, Integer> hashMapCustom = new CustomHashMap<Integer, Integer>();
		 
		 hashMapCustom.put(12, 100);
		 hashMapCustom.put(13, 101);
		 hashMapCustom.put(14, 102);
		 hashMapCustom.put(15, 103);
		 hashMapCustom.put(16, 104);
		 
		 hashMapCustom.display();
		 
		 
	}
}



























