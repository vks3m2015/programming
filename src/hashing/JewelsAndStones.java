package hashing;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/jewels-and-stones/
public class JewelsAndStones {

    public int numJewelsInStones(String jewels, String stones) {
    	int count = 0;
    	Set<Character> jewelsMemory = new HashSet<>();
    	
    	for(char ch : jewels.toCharArray())
    		jewelsMemory.add(ch);
    	
    	for(int i = 0; i< stones.length(); i++) {
    		if(jewelsMemory.contains(stones.charAt(i)))
    			count++;
    	}
    	return count;
    }
    
	public static void main(String[] args) {

	}

}
