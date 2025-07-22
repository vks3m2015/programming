//Rearrange characters in a string such that no two adjacent are same

//https://www.geeksforgeeks.org/rearrange-characters-string-no-two-adjacent/
//https://gist.githubusercontent.com/anil477/98af19dec061657395126cadce7fd5d5/raw/a3c521ab5394294d74cab2da72b82c34142de601/Rearrange.java
//https://www.geeksforgeeks.org/rearrange-a-string-so-that-all-same-characters-become-at-least-d-distance-away/


package string;
import java.util.PriorityQueue ;


public class NoTwoAdjacent {

}



class MyPDPair implements Comparable<MyPDPair>
{
    char ch;
    int count;
    @Override
    
    public int compareTo(MyPDPair o) {
        return this.count<o.count?1:-1;
    }
	@Override
	public String toString() {
		return "MyPDPair [ch=" + ch + ", count=" + count + "]";
	}
    
    
}

class MyRearrangeCharNotAdj 
{
    public static void main(String[] args) 
    {
        String inp="abcdddd";
        int[] chrArr=new int[26];
        for(char c:inp.toCharArray())
        {
            chrArr[c-'a']+=1;
        }
        
        PriorityQueue<MyPDPair> pq=new PriorityQueue<MyPDPair>();
        for(int i=0;i<26;i++)
        {
            if(chrArr[i]!=0)
            {
                MyPDPair pair =new MyPDPair();
                pair.ch     = (char)(i+'a');
                pair.count = chrArr[i];
                pq.add(pair);
            }
        }
        
        System.out.println(" pq =="+pq);
        
        
        MyPDPair prev = null;
        StringBuffer sb=new StringBuffer();
        
        while(!pq.isEmpty())
        {
            MyPDPair tmp=prev;
            
            System.out.println("  before poll pq = "+pq + "\n");
            MyPDPair cur=pq.poll();
            
            System.out.println("  after poll pq = "+pq+ "\n");
            
            if(cur.count==0)
            {
                break;
            }
            cur.count=cur.count-1;
            sb.append(cur.ch);
            
            if(tmp!=null)
            {
                pq.add(tmp);
            }
            prev=cur;
         }
        if(inp.length()==sb.length())
        {
            System.out.println(sb.toString());    
        }
        else
        {
            System.out.println("Not possible>>");    
        }
    }
}