import java.util.ArrayList;
import java.util.*;

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

    static class node {
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
    
    static class StackUsing2Queues {
    
        static Queue<Integer> q1 = new LinkedList();
        static Queue<Integer> q2 = new LinkedList();

        // method - 1
        // peek, pop - O(n) and push - O(1)

        // isEmpty
        public boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        // push
        public void push(int data) {  // O(1)
            if (!q1.isEmpty()) {
                q1.add(data);                
            } else {
                q1.add(data);
            }
        }

        // pop
        public int pop() { // O(n)
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            int top = -1;
            
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);         
                }                
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);         
                } 
            }

            return top;
        }

        // peek
        public int peek() { // O(n)
            if (isEmpty()) {
                System.out.println("Stack is empty");
                return -1;
            }

            int top = -1;
            
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    q2.add(top);         
                }                
            } else {
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);         
                } 
            }

            return top;

        }


        // method - 2 
        // push - O(n) and peek, pop - O(1)

        // push 
        public void Push(int data) { // O(n)
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }

            q1.add(data);

            while (!q2.isEmpty()) {
                q1.add(q2.remove());
            }

        }

        // pop
        public int Pop() {  // O(1)
            if (q1.isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }

            return q1.remove();
        }

        // peek
        public int Peek() { // O(1)
            if (q1.isEmpty()) {
                System.out.println("Stack is Empty");
                return -1;
            }

            return q1.peek();
        }

        public static void main(String[] args) {
            
            StackUsing2Queues s = new StackUsing2Queues();

            // method - 1

            s.push(1);
            s.push(2);
            s.push(3);
            s.push(4);

            System.out.println(s.pop());

            while (!s.isEmpty()) {
                System.out.println(s.peek());
                s.pop();
            }


            // method - 2

            s.Push(1);
            s.Push(2);
            s.Push(3);
            s.Push(4);

            s.Pop();

            System.out.println(s.Peek());

            while (!s.isEmpty()) {
                System.out.println(s.Peek());
                s.Pop();
            }
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