package string;

public class ReverseString {
	
	
    public void reverseString(char[] s) {
    	int i = 0, j = s.length;
    	char temp;
    	while(i<j) {
    		temp = s[i];
    		s[i++] = s[j];
    		s[j--] = temp;
    	}
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
