package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Link {

    static Map<Node,LinkList> map = new HashMap<Node, LinkList>();
    public static void main(String[] args) {
        Node r = new Node<String>("r");
        Node s = new Node<String>("s");
        Node t = new Node<String>("t");
        Node u = new Node<String>("u");
        Node v = new Node<String>("v");
        Node w = new Node<String>("w");
        Node x = new Node<String>("x");
        Node y = new Node<String>("y");
        LinkList<Node> rLink = new LinkList<Node>()/*.addNode(r)*/.addNode(s).addNode(v);
        LinkList<Node> sLink = new LinkList<Node>()/*.addNode(s)*/.addNode(r).addNode(w);
        LinkList<Node> tLink = new LinkList<Node>()/*.addNode(t)*/.addNode(w).addNode(x).addNode(u);
        LinkList<Node> uLink = new LinkList<Node>()/*.addNode(u)*/.addNode(t).addNode(x).addNode(y);
        LinkList<Node> vLink = new LinkList<Node>()/*.addNode(v)*/.addNode(r);
        LinkList<Node> wLink = new LinkList<Node>()/*.addNode(w)*/.addNode(s).addNode(t).addNode(x);
        LinkList<Node> xLink = new LinkList<Node>()/*.addNode(x)*/.addNode(w).addNode(t).addNode(u).addNode(y);
        LinkList<Node> yLink = new LinkList<Node>()/*.addNode(y)*/.addNode(u).addNode(x);
        map.put(r,rLink);
        map.put(s,sLink);
        map.put(t,tLink);
        map.put(u,uLink);
        map.put(v,vLink);
        map.put(w,wLink);
        map.put(x,xLink);
        map.put(y,yLink);
        bfs();
    }

    public static void bfs(){
        Queue<Node> queue = new Queue<Node>();
        Node s = null;
        for (Node node:map.keySet()){
            node.color = "white";
            if (node.value.equals("s")){
                s = node;
            }
        }
        s.color = "gray";
        s.d = 0;
        queue.enqueue(s);
        Node cur = null;
        while ((cur = queue.dequeue()) != null){
            LinkList<Node<Node>> link = map.get(cur);
            Node point = link.head;
            while (point!=null){
                Node<String> n = (Node<String>) point.value;
                if(n.color.equals("white")){
                    n.prrvious = cur;
                    n.d = cur.d+1;
                    n.color = "gray";
                    queue.enqueue(n);
                }
                point = point.next;
            }
            cur.color = "black";
        }
        for (Node node:map.keySet()){
            System.out.println(node.value);
            LinkList link = map.get(node);
            Node point = link.head;
            while (point!=null){
                Node<String> n = ((Node)point.value);
                System.out.println(n.color+"==="+n.value+"==="+n.d+"==="+(n.prrvious==null?"null":n.prrvious.value));
                point = point.next;
            }

        }

    }

    public void dfs(){

    }

}



class Node<T>{
    T value;
    Node next;
    String color;
    int d;
    int f;
    Node prrvious;
    int def;
    int low;

    public Node(T value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(T value) {
        this.value = value;
    }
}

class LinkList<T>{

    Node<T> head;
    Node<T> tail;
    int size;

    public LinkList addNode(T value){
        Node<T> node = new Node<T>(value);
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
        Node<T> previous = null;
        Node<T> current = head;
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

    public T deleteHead(){
        Node<T> res = head;
        if(head!=null){
            head = head.next;
            size--;
            return res.value;
        }else {
            return null;
        }
    }

    public void display(){
        Node current = head;
        while (current!=null){
            System.out.println(current.value);
            current = current.next;
        }
    }

}

class Queue<T>{

    LinkList<T> link = new LinkList<T>();

    public void enqueue(T value){
        link.addNode(value);
    }

    public T dequeue(){
        return  link.deleteHead();
    }

    //public

}
