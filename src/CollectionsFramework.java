import java.util.*;

public class CollectionsFramework {
    public static void main(String[] args) {
        //List
        List<String> al = new ArrayList<>();
        al.add("grapes");
        al.add("apple");
        al.add("orange");
        System.out.println("ArrayList: " + al);
        al.remove("apple");
        System.out.println(al + "\n");

        List<String> ll = new LinkedList<>();
        ll.add("grapes");
        ll.add("apple");
        ll.add("orange");
        System.out.println("LinkedList: " + ll);
        ll.remove("apple");
        System.out.println(ll + "\n");

        List<String> v = new Vector<>();
        v.add("grapes");
        v.add("apple");
        v.add("orange");
        System.out.println("Vector: " + v);
        v.remove("apple");
        System.out.println(v + "\n");

        //Queue
        int[] a = new int[]{3, 2, 1};
        Queue<Integer> pq = new PriorityQueue<>(new Comparison());
        pq.add(1);
        pq.add(2);
        pq.add(3);
        System.out.println("Priority Queue: " + pq);
        System.out.println(pq.peek());
        pq.poll();
        System.out.println(pq.peek());
        System.out.println();


        Queue<String> arrayDeque = new ArrayDeque<>();

        Stack<String> stack = new Stack<>();
        stack.add("grapes");
        stack.add("apple");
        stack.add("orange");
        System.out.println("Stack: " + stack);
        stack.remove("grapes");
        System.out.println(stack + "\n");


//        Iterator<String> it = al.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
//        System.out.println();

        Hashtable<String, String> table = new Hashtable<>();
        table.put("grapes", "grapes");
        table.put("apple", "apple");
        table.put("orange", "orange");
        System.out.println("HashTable: " + table);
        table.remove("apple");
        System.out.println(table);
    }
}

//Comparator class for priority queue
class Comparison implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return b - a;
    }
}
