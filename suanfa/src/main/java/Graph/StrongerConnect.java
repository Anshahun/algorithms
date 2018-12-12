package Graph;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StrongerConnect {

    static Map<Node,LinkList> map = new LinkedHashMap<Node, LinkList>();
    static int time = 0;

    public static void main(String[] args) {
        Node a = new Node<String>("a");
        Node b = new Node<String>("b");
        Node c = new Node<String>("c");
        Node d = new Node<String>("d");
        Node e = new Node<String>("e");
        Node f = new Node<String>("f");

        LinkList<Node> aLink = new LinkList<Node>().addNode(b).addNode(d);
        LinkList<Node> bLink = new LinkList<Node>().addNode(c).addNode(e);
        LinkList<Node> cLink = new LinkList<Node>().addNode(f);
        LinkList<Node> dLink = new LinkList<Node>().addNode(e);
        LinkList<Node> eLink = new LinkList<Node>().addNode(f);
        LinkList<Node> fLink = new LinkList<Node>();
        map.put(a,aLink);
        map.put(b,bLink);
        map.put(c,cLink);
        map.put(d,dLink);
        map.put(e,eLink);
        map.put(f,fLink);
        StrongerConnect sc = new StrongerConnect();
        sc.dfs();
    }

    public void dfs(){
        for (Node n:map.keySet()) {
            n.color = "white";

        }


        for (Node n:map.keySet()){
            if(n.color.equals("white")){
                List<Node> list = new ArrayList();
                dfs_vistor(n,list);
                for (Node no:list){
                    System.out.print(no.value);
                }
                System.out.println();
                list.clear();
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

    public void dfs_vistor(Node n,List list){
        time = time+1;
        n.color = "gray";
        n.d = time;
        list.add(n);
        LinkList<Node<String>> link = map.get(n);
        if(link.size>0){
            Node<Node<String>> head = link.head;
            Node hv = head.value;
            while (head!=null){
                if(head.value.color.equals("white")){
                    head.value.prrvious = n;
                    dfs_vistor(head.value,list);
                }
                head = head.next;
            }
        }
        n.color = "black";
        time=time+1;
        n.f = time;
    }
}
