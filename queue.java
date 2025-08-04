import java.util.*;
import java.util.Stack;

public class queue {

    static class QueueUsingArray {

        static int arr[];
        static int size;
        static int rear;
        static int front;

        QueueUsingArray(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        // this is the simple Queue using array

        // check the queue is Empty or not
        public static boolean isempty() {
            return rear == -1;
        }

        // add data into queue
        public void add(int data) { // O(1)
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }

            rear = rear + 1;
            arr[rear] = data;
        }

        // remove data from queue
        public int remove() { // O(n)
            if (rear == -1) {
                System.out.println("Queue is empty");
                return -1;
            }

            int front = arr[0];

            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear = rear - 1;

            return front;
        }

        // peek
        public int peek() { // O(1)
            if (rear == -1) {
                System.out.println("Queue is empty");
                return -1;
            }
            int front = arr[0];
            return front;
        }

        // the Circular Queue

        // Empty or not
        public boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        // full
        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // add element
        public void Add(int data) { // O(1)
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }

            // adding 1st element
            if (front == -1) {
                front = 0;
            }

            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // remove element
        public int Remove() { // O(1)
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int element = arr[front];

            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }

            return element;
        }

        // peek
        public int Peek() { // O(1)
            if (rear == -1) {
                System.out.println("Queue is empty");
                return -1;
            }
            int element = arr[front];
            return element;
        }

        public static void main(String[] args) {

            QueueUsingArray q = new QueueUsingArray(5);

            // Simple Queue
            q.add(1);
            q.add(2);
            q.add(3);
            q.add(4);
            q.remove();
            while (!q.isEmpty()) {
                System.out.println(q.peek());
                q.remove();
            }

            // Circular Queue
            q.Add(1);
            q.Add(2);
            q.Add(3);
            q.Add(4);
            q.Add(5);
            System.out.println(q.Remove());
            q.Add(6);
            System.out.println(q.Remove());
            q.Add(7);
            while (!q.isEmpty()) {
                System.out.println(q.Peek());
                q.Remove();
            }
        }
    }

    static class QueueUsingLinkedList {

        static class node {
            int data;
            node next;

            public node(int data) {
                this.data = data;
                this.next = null;
            }

        }

        public static node head;
        public static node tail;
        public static node size;

        // empty or not
        public boolean isEmpty() {
            return head == null;
        }

        // adding element
        public void add(int data) { // O(1)
            node newnode = new node(data);

            if (isEmpty()) {
                head = tail = newnode;
            }

            tail.next = newnode;
            tail = newnode;
        }

        // remove element
        public int remove() {
            if (isEmpty()) {
                System.out.println("linked list is empty");
                return -1;
            }

            int front = head.data;

            if (tail == head) {
                head = tail = null;
            } else {
                head = head.next;
            }

            return front;
        }

        // peek
        public int peek() {
            if (isEmpty()) {
                System.out.println("linked list is empty");
                return -1;
            }
            return head.data;
        }

        // printing the linked list
        public void print() {
            node temp = head;

            while (temp != null) {
                System.out.print(temp.data + "->");
                temp = temp.next;
            }
            System.out.println("null");

        }

        public static void main(String[] args) {

            QueueUsingLinkedList q = new QueueUsingLinkedList();

            q.add(1);
            q.add(2);
            q.add(3);
            q.add(4);

            q.remove();
            q.remove();

            System.out.println(q.peek());

            q.print();

            System.out.println(q.isEmpty());

        }
    }

    static class QueueUsing2Stack {

        Stack<Integer> s1 = new Stack<Integer>();
        Stack<Integer> s2 = new Stack<Integer>();

        // Method - 1
        // add - O(n) and remove, peek - O(1)

        // empty or not
        public boolean isEmpty() {
            return s1.isEmpty();
        }

        // adding element
        public void add(int data) { // O(n)

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            if (s1.isEmpty()) {
                s1.push(data);
            }

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }

        }

        // remove
        public int remove() { // O(1)
            if (s1.isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return s1.pop();
        }

        // peek
        public int peek() { // O(1)
            if (s1.isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return s1.peek();
        }

        // Method - 2
        // remove, peek - O(n) and add - O(1)

        // adding element
        public void Add(int data) { // O(1)
            s1.push(data);
        }

        // remove
        public int Remove() { // O(n)

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            int top = s2.peek();
            s2.pop();

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return top;

        }

        // peek
        public int Peek() { // O(n)

            while (!s1.isEmpty()) {
                s2.push(s1.pop());
            }

            int top = s2.peek();

            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }

            return top;

        }

        public static void main(String[] args) {

            QueueUsing2Stack q = new QueueUsing2Stack();

            // method 1
            q.add(1);
            q.add(2);
            q.add(3);

            while (!q.isEmpty()) {
                System.out.println(q.remove());
            }

            // method - 2
            q.Add(1);
            q.Add(2);
            q.Remove();
            q.Add(3);
            System.out.println(q.Peek());

            while (!q.isEmpty()) {
                System.out.println(q.Remove());
            }

        }

    }

    static class QueueExamples {

        public static void NonRepeatingLetter(String str) {

            int freq[] = new int[26]; // Frequency array for lowercase letters
            Queue<Character> q = new LinkedList<>();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                q.add(ch);
                freq[ch - 'a']++; // Update frequency count

                // Remove characters from the queue that repeat more than once
                while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                    q.remove();
                }

                // Output the first non-repeating character or -1
                if (q.isEmpty()) {
                    System.out.println("-1" + " ");
                } else {
                    System.out.println(q.peek());
                }
            }
        }

        public static void InterLeave(String str) {
            Queue<Character> Original = new LinkedList<>();
            Queue<Character> FirstHalf = new LinkedList<>();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                Original.add(ch);
            }

            int size = Original.size();

            for (int i = 0; i < size/2; i++) {
                FirstHalf.add(Original.remove());            
            }

            while (!FirstHalf.isEmpty()) {
                Original.add(FirstHalf.remove());
                Original.add(Original.remove());
            }


            while (!Original.isEmpty()) {
                System.out.print(Original.peek() + " ");
                Original.remove();                
            }
        }
        
        
        
        public static void main(String[] args) {

            NonRepeatingLetter("aabccxb");

            InterLeave("12345678");

        }
    }
}
