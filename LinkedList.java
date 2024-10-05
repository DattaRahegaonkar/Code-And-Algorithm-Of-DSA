
public class linkedList {

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

    public int size() {
        int sz = 0;
        node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;            
        }
        return sz;
    }

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

    public void addLast(int data) {  // O(1)
        // creating new node
        node newnode = new node(data);
        size++;
        if(head == null) {
            head = tail = newnode;
            return;
        }

        // next of the tail pointing to newnode - linking
        tail.next = newnode;

        // making newnode as tail
        tail = newnode;
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

    public void add(int idx, int data) {  // O(n)
        if(idx == 0) {
            addFirst(data);
            return;
        }

        node newnode = new node(data);
        size++;
        node temp = head;
        int i = 0;

        while (i < idx-1) {
            temp = temp.next;
            i++;            
        }

        newnode.next = temp.next;

        temp.next = newnode;
    }

    public int removeFirst() { // O(1)
        node temp = head;

        if(size == 0) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = temp.data;
            head = tail = null;
            size = 0;
            return val;
        }
        
        int val = temp.data;
        head = temp.next;
        size--;
        return val;
    }

    public int removeLast() { // O(n)
        node pre = head;

        if(size == 0) {
            System.out.println("ll is empty");
            return Integer.MIN_VALUE;
        } else if(size == 1) {
            int val = pre.data;
            head = tail = null;
            size = 0;
            return val;
        }
        
        int i = 0;
        while (i < size - 2) {
            pre = pre.next;
            i++;            
        }

        int val = pre.data;        
        pre.next = null;
        tail = pre;
        size--;
        return val;
    }

    public int itrSearch(int key) {  // O(n)
        node temp = head;
        int i = 0;

        while (temp != null) {
            if(temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;           
        }

        return -1;
    }

    public int search(node head, int key) {
        if(head == null){
            return -1;
        }

        if(head.data == key) {
            return 0;
        }

        int idx = search(head.next, key);
        if(idx == -1) {
            return -1;
        }

        return idx + 1;
    }

    public int RecSearch(int key) {
        return search(head, key);
    }
    
    public void reverse() {
        node prev = null;
        node curr = head;
        node next;

        tail = head;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head = prev;
    }
    
    public void deleteNthNodeFromEnd(int n) {
        int size = size();

        if(n == size){
            head = head.next;
            return;
        }

        int i = 1;
        int idxtoFind = size - n;
        node prev = head;
        while (i < idxtoFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
    }

    public node findMid(node head) {
        node slow = head;
        node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;  //+1
            fast = fast.next.next; // +2          
        }

        return slow;
    }

    public boolean CheackPalindrome() {
        if(head == null && head.next == null) {
            return true;
        }

        // find midle node
        node midnode = findMid(head);

        // reverse 2nd half
        node prev = null;
        node curr = midnode; // current node means staring vala node means head
        node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;            
        }

        node left = head;
        node right = prev;
    
        // cheak left == right
        while (right.next != null) {
            if (left.data != right.data) {
                return false;               
            }
            left = left.next;
            right = right.next;            
        }

        return true;

    }

    public static boolean isCycle() {  // Floyd's cycle finding algorithm
        node slow = head;
        node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;            
            if(slow == fast ){
                return true; // cycle exit
            }
        }

        return false;
    }

    public static void RemoveCycle() {
        // detect cycle
        node slow = head;
        node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                cycle = true;
                break;
            }         
        }
        if (cycle == false) {
            return;
        }

        // remove cycle
        slow = head;
        node prev = null;
        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }

        fast.next = null; // removing the cycle

    }

    private node getnode(node head) {
        node slow = head;
        node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    private node Merge(node h1, node h2) {
        node MergeLL = new node(-1);
        node temp = MergeLL;

        while (h1 != null && h2!= null) {
            if(h1.data <= h2.data) {
                temp.next = h1;
                h1 = h1.next;
                temp = temp.next;
            } else {
                temp.next = h1;
                h2 = h2.next;
                temp = temp.next;
            }           
        }

        while (h1 != null) {
            temp.next = h1;
            h1 = h1.next;
            temp = temp.next;            
        }

        while (h2 != null) {
            temp.next = h2;
            h2 = h2.next;
            temp = temp.next;
        }

        return MergeLL.next;
    }

    public node MergeSort(node head) {

        if(head != null || head == null) {
            return head;
        }

        // find midnode
        node midnode = getnode(head);

        // break in two parts
        node rightnode = midnode.next;
        midnode.next = null;

        node newleft = MergeSort(head);
        node newright = MergeSort(rightnode);

        return Merge(newleft, newright);

    }

    public void zigzag() {

        // find mid
        node slow = head;
        node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        node midnode = slow;

        // reverse the 2nd half
        node prev = null;
        node curr = midnode.next;
        midnode.next = null;
        node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;                        
        }
        
        // alternate merging
        node left = head;
        node right = prev;

        node nextleft, nextright;
        
        while (left != null && right != null) {
            nextleft = left.next;
            left.next = right;
            nextright = right.next;
            right.next = nextleft;

            left = nextleft;
            right = nextright;
        }

    }

    public static void main(String[] args) {

        linkedList ll = new linkedList();
        
        // ascending order linked list
        System.out.print("Linked List : ");
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(5);
        ll.addLast(4);
        ll.add(2, 3);
        ll.printLinkedList();

        //MergeSort
        ll.head = ll.MergeSort(ll.head);
        ll.printLinkedList();

        //Zig zag
        ll.zigzag();
        ll.printLinkedList();

        // palindrome linked list
        System.out.print("Linked List : ");
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(2);
        ll.addLast(1);
        System.out.println(ll.CheackPalindrome());
        ll.printLinkedList();

        // cycle linked list
        System.out.print("Linked List : ");
        head = new node(1);
        node temp = new node(2);
        head.next = temp;
        head.next.next = new node(3);
        head.next.next.next = head;
        System.out.println(isCycle());
        RemoveCycle();
        System.out.println(isCycle());

        ll.removeFirst();
        ll.printLinkedList();

        ll.removeLast();
        ll.printLinkedList();

        // Search iterative
        System.out.println(ll.itrSearch(2));
        System.out.println(ll.itrSearch(6 ));

        // Search Recursive
        System.out.println(ll.RecSearch(2));
        System.out.println(ll.RecSearch(6 ));

        ll.deleteNthNodeFromEnd(3);
        ll.printLinkedList();

        ll.reverse();
        ll.printLinkedList();

        System.out.println(ll.CheackPalindrome());

        
    }
}
