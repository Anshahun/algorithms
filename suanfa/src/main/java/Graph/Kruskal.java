package Graph;

import rbTree.Node;

import java.util.ArrayList;
import java.util.LinkedList;

public class Kruskal {

    static Grap grap = new Grap();
    public static void main(String[] args) {
        Node2 a = new Node2("a");
        Node2 b = new Node2("b");
        Node2 c = new Node2("c");
        Node2 d = new Node2("d");
        Node2 e = new Node2("e");
        Node2 f = new Node2("f");
        Node2 g = new Node2("g");
        Eage fe = new Eage(f,e,2);
        Eage cd = new Eage(c,d,3);
        Eage de = new Eage(d,e,4);
        Eage ce = new Eage(c,e,5);
        Eage fc = new Eage(f,c,6);
        Eage bf = new Eage(b,f,7);
        Eage eg = new Eage(e,g,8);
        Eage gf = new Eage(g,f,9);
        Eage bc = new Eage(b,c,10);
        Eage ab = new Eage(a,b,12);
        Eage ga = new Eage(g,a,14);
        Eage af = new Eage(a,f,16);
        LinkedList<Eage> eageList = new LinkedList<Eage>();
        eageList.add(fe);
        eageList.add(cd);
        eageList.add(de);
        eageList.add(ce);
        eageList.add(fc);
        eageList.add(bf);
        eageList.add(eg);
        eageList.add(gf);
        eageList.add(bc);
        eageList.add(ab);
        eageList.add(ga);
        eageList.add(af);
        LinkedList<Node2> aLink = new LinkedList<Node2>();
        LinkedList<Node2> bLink = new LinkedList<Node2>();
        LinkedList<Node2> cLink = new LinkedList<Node2>();
        LinkedList<Node2> dLink = new LinkedList<Node2>();
        LinkedList<Node2> eLink = new LinkedList<Node2>();
        LinkedList<Node2> fLink = new LinkedList<Node2>();
        LinkedList<Node2> gLink = new LinkedList<Node2>();
        aLink.add(b);
        aLink.add(f);
        aLink.add(c);
        bLink.add(a);
        bLink.add(f);
        bLink.add(c);
        cLink.add(b);
        cLink.add(f);
        cLink.add(e);
        cLink.add(d);
        dLink.add(c);
        dLink.add(e);
        eLink.add(g);
        eLink.add(f);
        eLink.add(c);
        eLink.add(d);
        fLink.add(g);
        fLink.add(a);
        fLink.add(b);
        fLink.add(c);
        fLink.add(e);
        gLink.add(a);
        gLink.add(f);
        gLink.add(e);

        ArrayList<Eage> res = new ArrayList<Eage>();
        for (Eage eage:eageList){
            Trees t1 = findTree(eage.start);
            Trees t2 = findTree(eage.end);
            if(t1!=t2){
                System.out.println(eage.start.value+"=>"+eage.end.value);
                if(t1!=null&&t2!=null){
                    combine(t1,t2);
                }else if(t1!=null){
                    t1.nodes.add(eage.end);
                }else {
                    t2.nodes.add(eage.start);
                }
            }else if(t1==null&&t2==null){
                System.out.println(eage.start.value+"=>"+eage.end.value);
                Trees t = new Trees();
                t.nodes.add(eage.start);
                t.nodes.add(eage.end);
                grap.trees.add(t);
            }
        }

    }

    private static void combine(Trees t1, Trees t2) {
        t1.nodes.addAll(t2.nodes);
        grap.trees.remove(t2);
    }

    public static Trees findTree(Node2 node){
        for (Trees t:grap.trees) {
            if(t.nodes.contains(node))
                return t;
        }
        return null;
    }

}


class Node2{
    String value;

    public Node2(String value) {
        this.value = value;
    }
}

class Eage{
    Node2 start;
    Node2 end;
    int weight;

    public Eage(Node2 start, Node2 end,int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

class Grap{
    ArrayList<Node2> start = new ArrayList<Node2>();
    ArrayList<Node2> end = new ArrayList<Node2>();
    ArrayList<Trees> trees = new ArrayList<Trees>();
}

class Trees{
    ArrayList<Node2> nodes = new ArrayList<Node2>();
}