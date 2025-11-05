package tree;

import java.util.Map;

public class Practice {

    public static void main(String[] args) {

        TreeNode node = null;
        int[] arr = {20,16,30, 14, 17, 25,32,15};
        for (int i  = 0; i  < arr.length; i ++) {
            System.out.println(" elemet = "+ arr[i]);
            node = insertIntoBinaryTree(node, arr[i]);
        }

        traverseTree(node);
        System.out.println(" height == "+ height(node));

    }


    static TreeNode insertIntoBinaryTree(TreeNode node, int key){

        System.out.println("insert "+ (node != null ? node.val : null));
        if(node == null){
            return  new TreeNode(key);
        }

        if(key < node.val)
           node.left =  insertIntoBinaryTree( node.left, key);
        else
           node.right = insertIntoBinaryTree( node.right, key);

        return node;
    }

    static void traverseTree(TreeNode node){
        if(node == null){
            return;
        }
        traverseTree(node.left);
        System.out.println(" node - > " + node.val);
        traverseTree(node.right);
    }

    static int height(TreeNode node){

        if(node == null) return  0;

        return Math.max(height(node.left), height(node.right)) + 1;
    }


    boolean isBinaryTree(TreeNode node){

        if(node == null )
            return true;

        boolean left = isBinaryTree(node.left);
        boolean right = isBinaryTree(node.right);

        return  node.val > node.left.val && node.val < node.right.val;
    }
}
