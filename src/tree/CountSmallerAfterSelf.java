package tree;
//https://kennyzhuang.gitbooks.io/algorithms-collection/content/count_of_smaller_numbers_after_self.html
public class CountSmallerAfterSelf {

	public static void main(String[] args) {
		

	}
	
	int countSmaller(Node node, int val) {
		int finalCount =0;
		
		while(true) {
			
			if(val < node.key) {
				node.count++;
				
				if(node.left == null) {
					node.left = new Node(val);
					break;
				}else
				    node = node.left;
				
			}else if(val > node.key) {
				finalCount += node.count;
				
				if(node.right == null) {
					node.right = new Node(val);
					break;
				}else
				   node = node.right;
			}
		
		}
		return finalCount;
	}
	
	
	static class Node{
		int key, count = 0;
		Node left, right;
		
		Node(int key){
			this.key =key;
		}
	}

}
