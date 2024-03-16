package arrays;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

//https://leetcode.com/problems/minimum-deletions-to-make-character-frequencies-unique/description/
//sol - https://www.youtube.com/watch?v=xzsAFSFiVF8
public class MinDeletionsToMakeCharFreqUnique {

    public static int minDeletions(String s) {
		
    	Map<Integer, Long> countMap = s.chars().boxed()
    			.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    	
    	List<Long> countCollection = countMap.values().stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
    	
    	Long deletions = 0L;
    	Long maxAllowedFreq = countCollection.get(0)+1;
    	
    	for(Long freq : countCollection) {
    	
    		if(maxAllowedFreq <= 0) {
    			deletions += freq; 
    		}
    		
    		else if(freq <= maxAllowedFreq) {
    			maxAllowedFreq = freq -1L;
    		}else {
    			deletions += (freq - maxAllowedFreq);
    			maxAllowedFreq = maxAllowedFreq - 1L;
    		}
    	}
    	
    	return deletions.intValue();
        
    }
    
    public int minDeletions2(String s) {
        int cnt[] = new int[26], res = 0;
        Set<Integer> used = new HashSet<>();
        for (int i = 0; i < s.length(); ++i)
            ++cnt[s.charAt(i) - 'a'];
        for (int i = 0; i < 26; ++i) {
            while (cnt[i] > 0 && !used.add(cnt[i])) {
                --cnt[i];
                ++res;
            }
        }        
        return res;
    }

	public static void main(String[] args) {
		String s = "vvikasssa";
		System.out.println(minDeletions(s));
	}

}
