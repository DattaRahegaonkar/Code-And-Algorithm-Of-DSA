
public class LinkedListExample {

    public static class node {
        int data;
        node next;

        public node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static node head;
    public static node tail;
    public static int size;

    public void addFirst(int data) {  // O(1)
        // creating new node
        node newnode = new node(data);
        size++;
        if(head == null) {
            head = tail = newnode;
            return;
        }

        // new node next pointing to head - linking
        newnode.next = head;

        // making newnode as head
        head = newnode;
    }

    public void printLinkedList() {  // it traverse the all nodes that why O(n)
        node temp = head;
        if(head == null) {
            System.out.println("null");
            return;
        }
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;            
        }
        System.out.println("null");
    }

    public void SkipMDeleteN(int m, int n) {

        node temp = head;
        
        while (temp != null) {
            int i = 1;
            int j = 0;

            while (i < m && temp != null) {
                temp = temp.next;
                i++;           
            }

            if(temp == null) {
                break;
            }

            node deletenodes = temp;

            while (j <= n && deletenodes != null) {
                deletenodes = deletenodes.next;
                j++;  
            }

            temp.next = deletenodes;
            temp = deletenodes;
        }
    }

    public void SwappingOfNodes(int x, int y){

        if (x == y)
        return;

        node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        if (currX == null || currY == null)
            return;

        if (prevX != null)
            prevX.next = currY;
        else
            head = currY;

        if (prevY != null)
            prevY.next = currX;
        else
            head = currX;

        node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;

    }
    
    public void EvenOddLinkedList() {
        if (head == null) {
            return;
        }
    
        node evenH = null, evenL = null;
        node oddH = null, oddL = null;
        node temp = head;
    
        while (temp != null) {
            if (temp.data % 2 == 0) {
                if (evenH == null) {
                    evenH = evenL = temp;
                } else {
                    evenL.next = temp;
                    evenL = temp;
                }
            } else {
                if (oddH == null) {
                    oddH = oddL = temp;
                } else {
                    oddL.next = temp;
                    oddL = temp;
                }
            }
            temp = temp.next;
        }
    
        if (evenL != null) {
            evenL.next = oddH;
        }
    
        if (oddL != null) {
            oddL.next = null;  
        }

        if(evenH == null) {
            head = oddH;
        } else {
            head = evenH;
        }
    }

    public static void main(String[] args) {

        LinkedListExample exp = new LinkedListExample();
        
        exp.addFirst(6);
        exp.addFirst(5);
        exp.addFirst(4);
        exp.addFirst(3);
        exp.addFirst(2);
        exp.addFirst(1);

        exp.printLinkedList();

        // exp.SkipMDeleteN(2, 2);
        // exp.printLinkedList();

        // exp.SwappingOfNodes(2,4);
        // exp.printLinkedList();

        exp.EvenOddLinkedList();
        exp.printLinkedList();
    }
    
}
