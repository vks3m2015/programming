package practice;
import java.util.*;

public class MyCollection2 {
	
	public static void main( String[] arg)
	  {
	     ArrayList<String[]> al = new ArrayList<String[]> ();
	     
	     String[] arrStr1 = {"str1", "str2", "str3"};
	     String[] arrStr2 = {"str1", "str2", "str3"};
	      al.add(arrStr1);
	      al.add(arrStr2);
	    // al.add("vikas");
	    // al.add("singh");
	    // al.add("utkarsh");
	     
	   
	     System.out.println(al);
	     
	     System.out.println(Arrays.toString(al.get(0)));
	     
	     HashMap<Integer,String> hm = new HashMap<Integer, String> ();
	     HashMap<Integer,String> hm2 = new HashMap<Integer, String> ();
	     
	     hm.put(1, "vikas");
	     hm.put(2, "utkarsh");
	     hm2.put(3, "chaudhary");
	     hm2.put(4, "singh");
	     
	   //  al.addAll(hm);
	    // System.out.println(al);
	   //  System.out.println(hm);
	     
	  
	  }

}
