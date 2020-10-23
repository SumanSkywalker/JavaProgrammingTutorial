import java.util.ArrayList;

public class MyStack {
    ArrayList<Integer> stack = new ArrayList<>();

    public void push(int data) {
        stack.add(data);
    }

    public void pop() {
        stack.remove(stack.size() - 1);
    }

    public void peek() {
        if (stack.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(stack.get(stack.size() - 1));
        }
    }
    public void printStack(){
        if(stack.isEmpty()){
            System.out.println("stack is empty");
        }else{
            for(int i = 0; i<stack.size(); i++){
                System.out.print(stack.get(i)+" ");
            }
        }
        System.out.println();
    }

    public void contains(int data) {
        if (stack.contains(data)) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}

class StackMain {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.printStack();
        stack.peek();
        stack.pop();
        stack.pop();
        stack.peek();
        stack.contains(6);
        stack.printStack();
    }
}
