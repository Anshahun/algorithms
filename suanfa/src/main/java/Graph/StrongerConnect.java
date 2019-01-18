package Graph;

import java.util.*;

public class StrongerConnect {

    static Map<Node,LinkList> map = new LinkedHashMap<Node, LinkList>();
    static Stack<Node> stack = new Stack<Node>();
    static int time = 0;
    static int count = 0;
    //tarjan 算法计算强联通分量
    public static void main(String[] args) {
        Node a = new Node<String>("a");
        Node b = new Node<String>("b");
        Node c = new Node<String>("c");
        Node d = new Node<String>("d");
        Node e = new Node<String>("e");
        Node f = new Node<String>("f");

        LinkList<Node> aLink = new LinkList<Node>().addNode(b)/*.addNode(d)*/;
        LinkList<Node> bLink = new LinkList<Node>().addNode(c).addNode(e);
        LinkList<Node> cLink = new LinkList<Node>().addNode(f);
        LinkList<Node> dLink = new LinkList<Node>().addNode(b)/*.addNode(e)*/;
        LinkList<Node> eLink = new LinkList<Node>().addNode(f).addNode(a);
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

    public void tarjan(Node n){

    }

    public void dfs(){
        for (Node n:map.keySet()) {
            n.color = "white";
        }

        for (Node n:map.keySet()){
            if(n.color.equals("white")){
                count+=1;
                n.low =count;
                n.def = count;
                dfs_vistor(n);
            }
        }

        for (Node n:map.keySet()){
            System.out.println(n.color+"==="+n.value+"==="+n.d+"/"+n.f+"========="+n.def+"/"+n.low+"==="+(n.prrvious==null?"null":n.prrvious.value));
        }

    }

    public void dfs_vistor(Node n){
        stack.push(n);
        time = time+1;
        n.color = "gray";
        n.d = time;
        LinkList<Node<String>> link = map.get(n);
        if(link.size>0){
            Node<Node<String>> head = link.head;
            while (head!=null){
                if(head.value.color.equals("white")){
                    head.value.prrvious = n;
                    count+=1;
                    head.value.def = count;
                    head.value.low = count;
                    dfs_vistor(head.value);
                    n.low = head.value.low>n.low?n.low:head.value.low;
                }else {
                    n.low = head.value.def>n.low?n.low:head.value.def;
                }
                head = head.next;
            }
        }
        n.color = "black";
        time=time+1;
        n.f = time;
        if(n.low==n.def){
            Node tmp = stack.pop();
            System.out.println(tmp.value);
            while (tmp!=n&&!stack.empty()){
                tmp = stack.pop();
                System.out.println(tmp.value);
            }
            System.out.println("==================");
        }

    }
}
