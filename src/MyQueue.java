import java.util.ArrayList;

public class MyQueue {
    private ArrayList<Integer> queue = new ArrayList<>();

    public void enqueue(int data) {
        queue.add(data);
    }

    public void dequeue() {
        if (queue.isEmpty()) {
            System.out.println(-1);
        } else {
            queue.remove(queue.size() - 1);
        }
    }

    public void peek() {
        if (queue.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(queue.get(0));
        }
    }

    public void lookup(int data) {
        if (queue.contains(data)) {
            System.out.println(queue.indexOf(data));
        } else {
            System.out.println(-1);
        }
    }
    public void printQueue(){
        for(int i = 0; i<queue.size(); i++){
            System.out.print(queue.get(i)+" ");
        }
        System.out.println();
    }
}


class QueueMain{
    public static void main(String[] args){
        MyQueue queue = new MyQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.printQueue();
        queue.dequeue();
        queue.dequeue();
        queue.peek();
        queue.lookup(3);
        queue.printQueue();

    }
}
