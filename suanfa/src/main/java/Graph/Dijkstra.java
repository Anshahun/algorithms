package Graph;

import java.util.LinkedList;
import java.util.TreeSet;

public class Dijkstra {

    static LinkedList<Eage> eageList = new LinkedList<Eage>();
    static LinkedList<Node2> nodeList = new LinkedList<Node2>();
    static TreeSet<Node2> nodeSet = new TreeSet<Node2>();
    public static void main(String[] args) {
        Node2 s = new Node2("s");
        Node2 t = new Node2("t");
        Node2 x = new Node2("x");
        Node2 y = new Node2("y");
        Node2 z = new Node2("z");
        Eage st = new Eage(s,t,10);
        Eage sy = new Eage(s,y,5);
        Eage ty = new Eage(t,y,2);
        Eage tx = new Eage(t,x,1);
        Eage yt = new Eage(y,t,2);
        Eage yx = new Eage(y,x,9);
        Eage yz = new Eage(y,z,2);
        Eage xz = new Eage(x,z,4);
        Eage zs = new Eage(z,s,7);
        Eage zx = new Eage(z,x,6);
        eageList.add(st);
        eageList.add(sy);
        eageList.add(ty);
        eageList.add(tx);
        eageList.add(yt);
        eageList.add(yx);
        eageList.add(yz);
        eageList.add(xz);
        eageList.add(zs);
        eageList.add(zx);
    }

    public void init(){
        for (Node2 n:nodeList){
            if (n.value.equals("s")){
                n.length = 0;
            }
            else{
                n.length = 999;
                n.prev = null;
            }
        }
    }

    public void relax(Node2 u,Node2 v){
        Eage e = findEage(u,v);
        if(v.length>u.length+e.weight){
            v.length = u.length+e.weight;
            v.prev = u;
        }
    }

    public Eage findEage(Node2 u,Node2 v){
        for (Eage e:eageList){
            if(e.start==u&&e.end==v){
                return e;
            }
        }
        return null;
    }
}
