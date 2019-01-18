package heap;

import java.util.Random;

public class Heap {

    static int heap_size;

    public static void main(String[] args) {
        Random ran = new Random();
        int[] arr = new int[11];
        for (int i = 1; i <11 ; i++) {
            arr[i] = ran.nextInt(100);
        }
        heap_size = arr.length;
        Heap h = new Heap();
        h.build_beap(arr);
        h.heap_sort(arr);
        for (int i: arr) {
            System.out.print(i+",");
        }
        /*int [] arr = {0,60,75,80};
        Heap h = new Heap();
        h.heapfy(arr,1);*/
    }

    public void build_beap(int[] arr){
        for (int i = arr.length/2; i >=1 ; i--) {
            heapfy(arr,i);
        }
    }

    public void heapfy(int[] arr,int i){
        int l = left(i);
        int r = right(i);
        int max = i;
        if(l<heap_size&&arr[l]>arr[max]){
            max = l;
        }
        if(r<heap_size&&arr[r]>arr[max]) {
            max = r;
        }
        if(max!=i){
            exchange(arr,i,max);
            heapfy(arr,max);
        }

    }

    public int left(int i){
        return i*2;
    }

    public int right(int i){
        return i*2+1;
    }

    public void exchange(int[] arr,int i,int j){
         int tmp = arr[i];
         arr[i] = arr[j];
         arr[j] = tmp;
    }

    public void heap_sort(int[] arr){
        for (int i=arr.length-1;i>1;i--){
            exchange(arr,1,i);
            heap_size-=1;
            heapfy(arr,1);
        }
    }

}
