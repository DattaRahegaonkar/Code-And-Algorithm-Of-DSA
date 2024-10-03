import java.util.ArrayList;

public class Stack {
    
    static class StackUsingArrayList {

        static ArrayList<Integer> list = new ArrayList<>();
        
        // empty
        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // push
        public static void push(int data) {
            list.add(data);
        }

        // pop
        public static int pop() {
            if(isEmpty()) {
                return -1;
            }
            int top = list.get(list.size()-1);
            list.remove(list.size()-1);
            return top;
        }

        // peek
        public static int peek(){
            if(isEmpty()) {
                return -1;
            }
            return list.get(list.size()-1);
        }
    
    }


    static class  node {
        int data;
        node next;

        public node(int data) {
            this.data = data;
            this.next = null;
        }        
    }

    static class StackUsingLinkedList {

        static node head = null;

        // empty
        public static boolean isEmpty() {
            return head == null;
        }

        //push
        public static void push(int data) {
            node newnode = new node(data);

            if (isEmpty()) {
                head = newnode;
                return;
            }

            newnode.next = head;
            head = newnode;
        }

        // pop
        public static int pop() {
            if(isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }

        // peek
        public static int peek(){
            if(isEmpty()) {
                return -1;
            }
            return head.data;
        }
        
    }
    
    
    public static void main(String[] args) {

        // StackUsingArrayList sa = new StackUsingArrayList();
        // sa.push(1);
        // sa.push(2);
        // sa.push(3);
        // while (!sa.isEmpty()) {
        //     System.out.println(sa.peek());
        //     sa.pop();            
        // }

        // StackUsingLinkedList sl = new StackUsingLinkedList();
        // sl.push(1);
        // sl.push(2);
        // sl.push(3);
        // while (!sl.isEmpty()) {
        //     System.out.println(sl.peek());
        //     sl.pop();            
        // }

        
    }
}