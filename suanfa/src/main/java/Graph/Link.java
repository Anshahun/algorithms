package Graph;

import java.util.ArrayList;
import java.util.List;

public class Link {

    static List<LinkList> list = new ArrayList<LinkList>();
    public static void main(String[] args) {
        LinkList r = new LinkList().addNode("r").addNode("s").addNode("v");
        LinkList s = new LinkList().addNode("s").addNode("r").addNode("w");
        LinkList t = new LinkList().addNode("t").addNode("w").addNode("x");
        LinkList u = new LinkList().addNode("u").addNode("t").addNode("x").addNode("y");
        LinkList v = new LinkList().addNode("v").addNode("r");
        LinkList w = new LinkList().addNode("w").addNode("s").addNode("t").addNode("x");
        LinkList y = new LinkList().addNode("y").addNode("u").addNode("x");
        LinkList x = new LinkList().addNode("x").addNode("w").addNode("t").addNode("u").addNode("y");
        list.add(r);
        list.add(s);
        list.add(t);
        list.add(u);
        list.add(v);
        list.add(w);
        list.add(y);
        list.add(x);
    }

    public void bfs(){

    }

}

class Node{
    String value;
    Node next;

    public Node(String value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(String value) {
        this.value = value;
    }
}

class LinkList{

    Node head;
    Node tail;
    int size;

    public LinkList addNode(String value){
        Node node = new Node(value);
        if(size==0){
            head = node;
            tail = node;
        }else {
            tail.next = node;
            tail = node;
        }
        size++;
        return this;
    }

    public boolean delete(String value){
        Node previous = null;
        Node current = head;
        while (current!=null){
            if(current.value.equals(value)){
                if(previous!=null){
                    previous.next = current.next;
                }else {
                    head = current.next;
                }
                if(current.next==null){
                    tail = previous;
                }
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    public void deleteHead(){
        head = head.next;
        size--;
    }

    public void display(){
        Node current = head;
        while (current!=null){
            System.out.println(current.value);
            current = current.next;
        }
    }

}

class Queue{

    LinkList link = new LinkList();

    public void enqueue(String value){
        link.addNode(value);
    }

    public void dequeue(){
        link.deleteHead();
    }

    //public

}