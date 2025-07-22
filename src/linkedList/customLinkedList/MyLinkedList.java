package linkedList.customLinkedList;

public class MyLinkedList<T> {

    Node<T> head;
    Node<T> tail;
    int size;

    public Node<T> add(T data){
        Node<T> newNode = new Node<>(data);
        size++;

        if(tail == null){
            head = newNode;
            tail = newNode;
            return head;
        }

        tail.link = newNode;
        tail = newNode;
        return head;
    }

    public void display(){
        Node<T> tmp = head;

        String displayStr = "";
        while (tmp != null){
            displayStr = displayStr + " -> " +tmp.data;
            tmp = tmp.link;
        }
        System.out.println(displayStr);
    }

    public int size(){
        return size;
    }


    public static void main(String[] str){
        MyLinkedList<String> mll = new MyLinkedList<>();
        mll.add("v");
        mll.add("i");
        mll.add("k");
        mll.add("a");
        mll.add("s");
        mll.display();
        System.out.println("size of linked list = "+mll.size());
    }
}


class Node<T> {

    T data;
    Node<T> link;

    Node(T data){
        this.data = data;
    }
}
