package interview;

public class Test10 {

	public static void main(String[] args) {
		String s1 = "abc";
		String s2 = new String("abc");
		StringBuffer sb = new StringBuffer("abc");

		 

		System.out.println(s1==s2);  //False
		System.out.println(s1.equals(s2));  //true
		System.out.println(s2.equals(sb));  //true

	}

}
