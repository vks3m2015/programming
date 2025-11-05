package a_practice.linkedList;

import linkedList.concepts.ListNode;

public class LinkedListPrac {

    public static void main(String[] args) {



        Node head = new Node(4);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);





    }

    static void reverseLinkedList(Node node){

    }

    static void traverseLinkedList(Node node){

    }

    static void midElement(Node node){

    }

    static void isLoopPresent(Node node){

    }

    public Node removeElements(Node head, int val) {
        return null;
    }

    //https://leetcode.com/problems/odd-even-linked-list/
    public Node oddEvenList(Node head) {

    }




    private static class Node{
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
}
