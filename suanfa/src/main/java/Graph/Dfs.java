package Graph;

import java.util.HashMap;
import java.util.Map;

public class Dfs {

    static Map<Node,LinkList> map = new HashMap<Node, LinkList>();
    static int time = 0;

    public static void main(String[] args) {
        Node u = new Node<String>("u");
        Node v = new Node<String>("v");
        Node w = new Node<String>("w");
        Node x = new Node<String>("x");
        Node y = new Node<String>("y");
        Node z = new Node<String>("z");
        LinkList<Node> uLink = new LinkList<Node>().addNode(v).addNode(x);
        LinkList<Node> vLink = new LinkList<Node>().addNode(y);
        LinkList<Node> yLink = new LinkList<Node>().addNode(x);
        LinkList<Node> xLink = new LinkList<Node>().addNode(v);
        LinkList<Node> wLink = new LinkList<Node>().addNode(y).addNode(z);
        LinkList<Node> zLink = new LinkList<Node>().addNode(z);
        map.put(u,uLink);
        map.put(v,vLink);
        map.put(w,wLink);
        map.put(x,xLink);
        map.put(y,yLink);
        map.put(z,zLink);
        Dfs dfs  = new Dfs();
        dfs.dfs();
    }

    public void dfs(){
        for (Node n:map.keySet()) {
            n.color = "white";

        }


        for (Node n:map.keySet()){
            if(n.color.equals("white")){
                dfs_vistor(n);
            }
        }

        for (Node n:map.keySet()){
            System.out.println(n.color+"==="+n.value+"==="+n.d+"/"+n.f+"==="+(n.prrvious==null?"null":n.prrvious.value));
            /*System.out.println(node.value);
            LinkList link = map.get(node);
            Node point = link.head;
            while (point!=null){
                Node<String> n = ((Node)point.value);
                System.out.println(n.color+"==="+n.value+"==="+n.d+"/"+n.f+"==="+(n.prrvious==null?"null":n.prrvious.value));
                point = point.next;
            }*/

        }

    }

    public void dfs_vistor(Node n){
        time = time+1;
        n.color = "gray";
        n.d = time;
        LinkList<Node<Node>> link = map.get(n);
        Node head = link.head.value;
        if (head!=null&&head.color.equals("white")){
            head.prrvious = n;
            dfs_vistor(head);
        }
        n.color = "black";
        time=time+1;
        n.f = time;
    }


}
