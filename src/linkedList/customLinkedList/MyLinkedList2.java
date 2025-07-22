package linkedList.customLinkedList;


public class MyLinkedList2<T>{

    public static void main(String[] str){
        MyLinkedList2<String> mll = new MyLinkedList2<>();
        mll.addNode("v");
        mll.addNode("i");
        mll.addNode("k");
        mll.addNode("a");
        mll.addNode("s");
        mll.addNode("s");
        mll.addNode("i");
        mll.addNode("n");
        mll.addNode("g");
        mll.addNode("h");

        String[] arr = {"u", "t", "k"};
        mll.addNodes(arr);

        mll.displayList();
    }

    Node2<T> head;

    public Node2<T> addNode(T data){
        System.out.println(" add data -- " + data);
        Node2<T> node = new Node2<>(data);

        if(head == null){
            head = node;
            return head;
        }
        Node2<T> temp = head;

        while (temp.link != null){
            System.out.println(" add in while -- " + data);
            temp = temp.link;
        }
        temp.link = node;
        return head;

    }

    public Node2<T> addNodes(T[] data){
        Node2<T> tmpHead = null;
        Node2<T> tmpTail = null;
        for(T d : data){
            Node2<T> newNode = new Node2<>(d);

            if(tmpHead == null){
                tmpHead =  newNode;
                tmpTail = newNode;
                continue;
            }
            tmpTail.link = newNode;
            tmpTail = newNode;
        }

        if(head == null){
            head = tmpHead;
            return head;
        }

        Node2<T> tmp = head;
        while (tmp.link != null){
            tmp = tmp.link;
        }
        tmp.link = tmpHead;
        return head;
    }

    String displayList(){
        String str = "";
        Node2<T> tmp = head;

        while (tmp != null) {
            System.out.println(" display in while");
            str = str + " -> "+ tmp.data;
            tmp = tmp.link;
        }
        System.out.println(str);
        return str;
    }

}

class Node2<T>{
    T data;
    Node2<T> link;

    public Node2(T data) {
        this.data = data;
    }
}

