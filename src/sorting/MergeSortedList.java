package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeSortedList {
	

	//Recursive Approach
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		
		if(list1 == null)
			return list2;
		
		if(list2 == null)
			return list1;
		
		if(list1.val <= list2.val) {
			list1.next  =   mergeTwoLists(list1.next, list2);
			return list1;
		} else {
			 list2.next =  mergeTwoLists(list1, list2.next);
			 return list2;
		}  
	}
	
	//making new list using nodes of list1 & list2
	public ListNode mergeTwoLists_1(ListNode list1, ListNode list2) {
		
		ListNode list3 = new ListNode(-1); //adding dummy node
		ListNode ptr3 = list3;
		
		while(list1 != null && list2 != null ) {
			
			if(list1.val <= list2.val) {
				ptr3.next = list1;
				list1 = list1.next;
			
			}else {
			    ptr3.next = list2;
			    list2 = list2.next;
			}
			ptr3 = ptr3.next;
		}	
		
        if(list1 != null) {
        	ptr3.next = list1;
        }else {
        	ptr3.next = list2;
        }		
		return list3.next;
	}
	
	//Making a 3rd list from these two list. same approch but optimized is _1(above). 
    public ListNode mergeTwoLists_1_1(ListNode list1, ListNode list2) {
    	
    	ListNode ptr1 = list1, ptr2 = list2, list3 = null;
    	
		while (ptr1 != null && ptr2 != null) {
    		
    		if(ptr1.val <= ptr2.val) {
    			ListNode removedNode = ptr1;
    			ptr1 = ptr1.next;
    	    	removedNode.next = null;  //Not needed
    			list3 = addAtEnd(list3, removedNode);
    			
    		}else {
    			
    			ListNode removedNode = ptr2;
    			ptr2 = ptr2.next;
    	    	removedNode.next = null; //Not needed
    	    	list3 = addAtEnd(list3, removedNode);
    		}
    	}
    	
		
		  while(ptr1 != null) {
				ListNode removedNode = ptr1;
    			ptr1 = ptr1.next;
    	    	removedNode.next = null;
    			list3 = addAtEnd(list3, removedNode);
		  }
		  
		  while(ptr2 != null) {
			ListNode removedNode = ptr2;
  			ptr2 = ptr2.next;
  	    	removedNode.next = null;
  	    	list3 = addAtEnd(list3, removedNode);
		  }
		 
		return list3;
    }
    
    ListNode addAtEnd(ListNode list, ListNode node) {
    	
    	if(list == null) {
    		list = node;
    		return list;
    	}
    	
    	ListNode ptr = list;
    	while(ptr.next != null) {
    		ptr = ptr.next;
    		//System.out.println(" 2...in while .....");
    	}
    	ptr.next = node;
    	
    	return list;
    }
    
    
    
	void displayList(ListNode list) {
		
		List<Integer> result = new ArrayList<>();
		ListNode p = list;
		while(p!= null) {
			result.add(p.val);
			p=p.next;
		}
		System.out.println(" List = "+ Arrays.toString(result.toArray()));
	}
	
	public static void main(String[] args) {
		ListNode n = new ListNode(1);
		n.next = new ListNode(2);
		n.next.next = new ListNode(4);
		
		ListNode n2 = new ListNode(2);
		n2.next = new ListNode(3);
		n2.next.next = new ListNode(4);
		
		
		MergeSortedList msl = new MergeSortedList();
		msl.displayList(n);
		msl.displayList(n2);
		ListNode n3 =  msl.mergeTwoLists(n, n2);
		
		System.out.println(" final list =");
		msl.displayList(n3);
		
		/*
		 * ListNode p = n3; while(p!= null) { System.out.println(p.val); p=p.next; }
		 */
		
		
		

	}

}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
