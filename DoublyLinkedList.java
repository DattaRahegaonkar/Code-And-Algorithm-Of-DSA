public class DoublyLinkedList {

    public static class node {
        int data;
        node next;
        node prev;

        public node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static node head;
    public static node tail;    
    public static int size;    

    public void addFirst(int data) {
        node newnode = new node(data);
        size++;
        if(head == null) {
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head.prev = newnode;
        head = newnode;
    }

    public void addLast(int data) {
        node newnode = new node(data);
        size++;
        if(head == null) {
            head = tail = newnode;
            return;
        }
        newnode.prev = tail;
        tail.next = newnode;
        tail = newnode;
    }

    public void print() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;        
        }
        System.err.println("null");
    }

    public void removeFirst(){
        node temp = head;

        if(head == null) {
            System.out.println("Doubly linked list is empty");
            return;
        }

        if(head == tail) {
            head = tail = null;
        } else {
            node nextOfhead = head.next;
            head.next = null;
            nextOfhead.prev = null;
            head = nextOfhead;           
        }

        size--;

    }

    public void removeLast() {
        node temp = tail;
        
        if(head == null) {
            System.out.println("Doubly linked list is empty");
            return;
        } 
        
        if(head == tail) {
            head = tail = null;
        } else {
            node prevOftail = tail.prev;
            temp.prev = null;
            prevOftail.next = null;
            tail = prevOftail;
        }

        size--;
    }

    public void reverse() {
        node prev = null;
        node curr = head;
        node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;            
        }
        head = prev;
    }

    public static void main(String[] args) {

        DoublyLinkedList dll = new DoublyLinkedList();

        // addFirst and addLast
        dll.addFirst(4);
        dll.addLast(5);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.print();
        System.out.println(dll.size);
        
        // removeFirst
        // dll.removeFirst();
        // dll.removeFirst();
        // dll.removeFirst();
        // dll.removeFirst();
        // dll.removeFirst();
        // dll.print();
        // System.out.println(dll.size);
        
        // removeLast
        // dll.removeLast();
        // dll.removeLast();
        // dll.removeLast();
        // dll.removeLast();
        // dll.removeLast(); 
        // dll.print();
        // System.out.println(dll.size);
        
        // reverse
        // dll.reverse();
        // dll.print();
        // System.out.println(dll.size);
        
        
        
    }
}
