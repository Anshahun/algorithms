package threadTest;

public class Test {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new Counter(10));
        Thread t2 = new Thread(new Counter(100));
        Thread t3 = new Thread(new Counter(1000));
        t1.start();
        t2.start();
        t3.start();
        t1.join();
        System.out.println("done");
    }


}


class Counter implements Runnable{
    int time;

    public Counter(int time){
        this.time = time;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"==="+i);
        }
    }
}