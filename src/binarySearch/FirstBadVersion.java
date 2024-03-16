package binarySearch;

//https://leetcode.com/problems/first-bad-version/
//Sol- https://www.youtube.com/watch?v=SNDE-C86n88&list=PLi9RQVmJD2fZGdIX-y3-X37YUAWxh6GqH&index=17

/* The isBadVersion API is defined in the parent class VersionControl.
boolean isBadVersion(int version); */
public class FirstBadVersion {

    public int firstBadVersion(int n) {
        int left = 0, right = n;
        while(left < right) {
        	int mid = left + (right - left)/2;
        	if(isBadVersion(mid)) {
        		right = mid;
        	}else {
        		left = mid + 1;
        	}
        }
    	return left; //or right (both same)
    }
	
    //it returns if a version is bad or not
	private boolean isBadVersion(int mid) {
		// TODO Auto-generated method stub
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
