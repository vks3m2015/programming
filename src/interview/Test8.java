package interview;

import java.util.HashMap;

public class Test8<K, V> {
	
	Object[] buckets = new Object[16];
	
	HashMap<String, Integer> map = new HashMap<>();
	public void put(K key, V value) {
	  	int hashCode = key.hashCode();
	  	int bucketIndex = mapBucketIndex(hashCode);
	  	
	  	Entry entry = new Entry(key, value);
	  	if(buckets[bucketIndex] == null) {
	  		buckets[bucketIndex] = entry;
	  	}else {
	  		//traverse entry list
	         		
	  		
	  	}
	  	
		
		
	}
	
	private int mapBucketIndex(int hashCode) {
		return 0;
	}

	public V get(K key) {
		int hashCode = key.hashCode();
	  	int bucketIndex = mapBucketIndex(hashCode);
	  	
	  	Entry entryBucket = (Entry) buckets[bucketIndex];
	  	
	  	Entry ptr = entryBucket; 
	  	while(ptr != null) {
	  		
	  		if(ptr.key.equals(key)) {
	  			return (V) ptr.value;
	  		}
	  		
	  		ptr = ptr.next;
	  	}
		return null;
	}
	
	
	static class Entry<K, V>{
		K key;
		V value;
		Entry next;
		
		Entry(K key, V value){
		   this.key = key;
		   this.value = value;
		}
		
		
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Te

	}

}
