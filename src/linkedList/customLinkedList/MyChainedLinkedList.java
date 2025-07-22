package linkedList.customLinkedList;

public class MyChainedLinkedList<T> {

    Node<T> head;
    Node<T> tail;
    int size;

    public MyChainedLinkedList<T> add(T data){
        Node<T> newNode = new Node<>(data);
        size++;

        if(tail == null){
            head = newNode;
            tail = newNode;
            return this;
        }

        tail.link = newNode;
        tail = newNode;
        return this;
    }

    public void display(){
        Node<T> tmp = head;

        StringBuilder displayStr = new StringBuilder();
        while (tmp != null){
            displayStr.append(" -> ").append(tmp.data);
            tmp = tmp.link;
        }
        System.out.println(displayStr);
    }

    public int size(){
        return size;
    }


    public static void main(String[] str){
        MyChainedLinkedList<String> mll = new MyChainedLinkedList<>();
        mll.add("v").add("i").add("k").add("a").add("s");
        mll.display();
        System.out.println("size of linked list = "+mll.size());

        MyChainedLinkedList<String> mll2 = new MyChainedLinkedList<>();
        mll2.add("1").add("2").add("3");

        MyChainedLinkedList<String> mll3 = new MyChainedLinkedList<>();
        mll3.add("s").add("i").add("n").add("g");

        mll2.tail.link = mll3.head;
        mll.tail.link = mll3.head;

       // System.out.println("mll3.head --"+mll3.head.data);

        mll2.display();
        mll.display();
    }
}
