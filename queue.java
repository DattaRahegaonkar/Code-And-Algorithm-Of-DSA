

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
        public int remove() {  // O(n)
            if (rear == -1) {
                System.out.println("Queue is empty");
                return -1;            
            }

            int front = arr[0];

            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i+1];               
            }
            rear = rear-1;

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
            return (rear + 1)%size == front;
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

            rear = (rear + 1) % size ;
            arr[rear] = data;
        }

        // remove element
        public int Remove() {  // O(1)
            if (isEmpty()) {
                System.out.println("Queue is empty");
                return -1;
            }

            int element = arr[front];

            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size ;
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
        public void add(int data) {
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

    
}
