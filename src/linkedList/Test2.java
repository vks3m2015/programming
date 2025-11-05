package linkedList;

import java.util.HashSet;
import java.util.Set;

public class Test2 {

    public static void main(String[] args) {

       LL ll = new LL();
       ll.add(12);
       ll.add(13);
       ll.add(14);
       ll.add(15);
       ll.add(14);

      // ll.add(new Node1(16, ll.head.link));

       ll.printLL();

     //  ll.detectLoop();
        ll.midNode();

    }


}

class LL{

    Node1 head;
    Node1 tail;

    void add(Integer data) {
        Node1 node = new Node1(data, null);
        if (head == null) {
            head = node;
            tail = node;
        }
        tail.link = node;
        tail = node;
    }

    void add(Node1 node) {
       // Node1 node = new Node1(data, null);
        if (head == null) {
            head = node;
            tail = node;
        }
        tail.link = node;
    }

    void printLL(){
        Node1 tmp = head;
        StringBuilder llStr = new StringBuilder();

        int i = 1;
        while(tmp != null && i<12){
           llStr.append(" -> ").append(tmp.data);
           tmp = tmp.link;
           i++;
        }
        System.out.println("Linked List " + llStr);
    }

    boolean detectLoop(){
        Set<Node1> set = new HashSet<>();
        Node1 tmp = head;

        while(tmp != null){

            if(set.contains(tmp)){
                System.out.println("Loop exists..."+ tmp.data);
                return true;
            }
            set.add(tmp);

            tmp = tmp.link;
        }
        System.out.println("Loop doesn't exists");
       return false;
    }

    boolean detectLoop2(){
        Node1 slow = head;
        Node1 fast = head.link;

        while(fast != null){

            if(fast == slow ){
                System.out.println("loop present ");
                return true;
            }

            slow = slow.link;
            fast = fast.link.link;
        }
        System.out.println("Loop not found");
        return false;
    }

    Node1 midNode(){
        Node1 slow = head;
        Node1 fast = head;

        while(fast != null && fast.link != null ){
            slow = slow.link;
            fast = fast.link.link;
        }
        System.out.println(" mid node = "+ slow.data);
        return slow;
    }

}


class Node1{
    Integer data;
    Node1 link;

    public Node1(Integer data, Node1 link) {
        this.link = link;
        this.data = data;
    }
}
