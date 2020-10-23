public class MyLinkedList {
    private SLLNode sllHead = null;
    private DLLNode dllHead = null;
    private int length = 0;

    public void prepend(int data) {
        if (this.sllHead == null) {
            sllHead = new SLLNode(data);
            //dllHead = new DLLNode(data);
            length++;
        } else {
            SLLNode node = new SLLNode(data);
            node.next = this.sllHead;
            this.sllHead = node;

            //DLLNode node = new DLLNode(data);
            //node.next = this.dllHead;
            //node.previous = this.dllHead.previous;
            //this.dllHead = node;
            length++;
        }
    }

    public void append(int data) {
        if (this.sllHead == null) {
            sllHead = new SLLNode(data);
            //dllHead = new DLLNode(data);
            length++;
        } else {
            SLLNode current = sllHead;
            //DLLNode current = dllHead;
            while (current != null) {
                if (current.next == null) {
                    current.next = new SLLNode(data);
                    //node = new SLLNode(data);
                    //node.previous = current;
                    //current.next = node;
                    length++;
                    break;
                }
                current = current.next;
            }
        }
    }

    public void contains(int data) {
        if (sllHead == null) {
            System.out.println(false);
        } else {
            boolean contains = false;
            while (sllHead != null) {
                if (sllHead.data == data) {
                    contains = true;
                    break;
                }
            }
//            while (dllHead != null) {
//                if (dllHead.data == data) {
//                    contains = true;
//                    break;
//                }
//            }
            System.out.println(contains);
        }
    }

    public void insert(int index, int data) {
        if (index > length) {
            System.out.println("IndexOutOfBoundsException...");
        } else {
            int i = 1;
            SLLNode current = sllHead;
            SLLNode previous = current;
            //DLLNode current = dllHead;
            //DLLNode previous = current;
            while (current != null) {

                if (i == index) {
                    SLLNode node = new SLLNode(data);
                    node.next = current;
                    current = node;
                    previous.next = current;
                    length++;
                    break;
                    //DLLNode node = new DLLNode(data);
                    //node.next = current;
                    //node.previous = previous;
                    //current = node;
                    //previous.next = current;
                    //length++;
                    //break;
                }
                previous = current;
                current = current.next;
                i++;
            }
        }
    }

    public void delete() {
        if (sllHead == null) {
            System.out.println(-1);
        } else {
            if (sllHead.next == null) {
                sllHead = null;
                //dllHead = null;
                length--;
            }
            SLLNode current = sllHead;
            //DLLNode current = dllHead;
            while (current != null) {
                if (current.next.next == null) {
                    current.next = null;
                    //current.next = null;
                    length--;
                    break;
                }
                current = current.next;
            }
        }
    }

    public void printList() {
        if (sllHead == null) {
            System.out.println("The List is empty...");
        } else {
            SLLNode current = sllHead;
            //DLLNode current = dllHead;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}

class SLLNode {
    int data;
    SLLNode next;

    public SLLNode(int data) {
        this.data = data;
        this.next = null;
    }
}

class DLLNode {
    int data;
    DLLNode previous;
    DLLNode next;

    public DLLNode(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }
}

class LinkedListMain {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);
        linkedList.printList();
        linkedList.prepend(0);
        linkedList.printList();
        linkedList.delete();
        linkedList.printList();
        linkedList.insert(5, 6);
        linkedList.printList();
    }
}
