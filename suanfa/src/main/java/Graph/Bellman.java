package Graph;

import java.util.LinkedList;

public class Bellman {
    static LinkedList<Eage> eageList = new LinkedList<Eage>();
    static LinkedList<Node2> nodeList = new LinkedList<Node2>();
    static LinkedList<LinkedList<Node2>> graphList = new LinkedList<LinkedList<Node2>>();
    public static void main(String[] args) {
        Node2 s = new Node2("s");
        Node2 t = new Node2("t");
        Node2 x = new Node2("x");
        Node2 y = new Node2("y");
        Node2 z = new Node2("z");
        Eage st = new Eage(s,t,6);
        Eage tx = new Eage(t,x,5);
        Eage xt = new Eage(x,t,-2);
        Eage zx = new Eage(z,x,7);
        Eage tz = new Eage(t,z,-4);
        Eage yx = new Eage(y,x,-3);
        Eage ty = new Eage(t,y,8);
        Eage zs = new Eage(z,s,2);
        Eage sy = new Eage(s,y,7);
        Eage yz = new Eage(y,z,9);
        eageList.add(yz);
        eageList.add(tz);
        eageList.add(st);
        eageList.add(tx);
        eageList.add(xt);
        eageList.add(zx);
        eageList.add(yx);
        eageList.add(ty);
        eageList.add(zs);
        eageList.add(sy);
        nodeList.add(s);
        nodeList.add(t);
        nodeList.add(x);
        nodeList.add(y);
        nodeList.add(z);
        LinkedList<Node2> sLink = new LinkedList<Node2>();
        LinkedList<Node2> tLink = new LinkedList<Node2>();
        LinkedList<Node2> xLink = new LinkedList<Node2>();
        LinkedList<Node2> yLink = new LinkedList<Node2>();
        LinkedList<Node2> zLink = new LinkedList<Node2>();
        sLink.add(s);
        sLink.add(t);
        sLink.add(y);
        tLink.add(t);
        tLink.add(x);
        tLink.add(y);
        tLink.add(z);
        xLink.add(x);
        xLink.add(t);
        yLink.add(y);
        yLink.add(x);
        yLink.add(z);
        zLink.add(z);
        zLink.add(x);
        graphList.add(sLink);
        graphList.add(tLink);
        graphList.add(xLink);
        graphList.add(yLink);
        graphList.add(zLink);
        Bellman bm = new Bellman();
        bm.init();
        //for (int i=0;i<4;i++){
            /*for (LinkedList<Node2> link:graphList){
                Node2 u = link.getFirst();
                link.removeFirst();
                for(Node2 v:link){
                    bm.relax(u,v);
                }
            }*/
       // }
        //为什么要进行v-1次循环？，因为最短路径上最多有v-1条边，每次循环相当于找出一条最短边
        for (int i=0;i<4;i++) {
            for (Eage e : eageList) {
                bm.relax(e.start, e.end);
            }
            for (Node2 n:nodeList){
                System.out.println(n.value+"=========="+n.length);
            }
            System.out.println("=============================");
        }
        for (Eage e:eageList){
            if(e.end.length>e.start.length+e.weight){
                System.out.println("false");
            }
        }
        System.out.println("true");

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
