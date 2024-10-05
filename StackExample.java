import java.util.Stack;

public class StackExample {

    public static void PushAtBottom(Stack<Integer> s, int data) {  // O(n) and space O(n)

        if(s.isEmpty()) {
            s.push(data);
            return;
        }

        int top = s.pop();
        PushAtBottom(s, data);
        s.push(top);
    }

    public static void Reversestack(Stack<Integer> s) {

        if (s.empty()) {
            return;            
        }

        int top = s.pop();
        Reversestack(s);
        PushAtBottom(s, top);
    }

    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());            
        }
    }


    public static String ReverseString(Stack<Character> S ,String Str) {

        for(int i=0; i<Str.length(); i++){
            S.push(Str.charAt(i));            
        }

        StringBuilder result = new StringBuilder();

        while(!S.isEmpty()) {
            result.append(S.pop());
        }

        return result.toString();

    }

    public static void StackSpan(int Span[], int Stocks[]){
        Stack<Integer> s = new Stack<>();

        Span[0] = 1;
        s.push(0);
        
        for (int i = 1 ; i < Stocks.length; i++) {

            int currPrice = Stocks[i];
            while (!s.isEmpty() && currPrice > Stocks[s.peek()]) {
                s.pop();
            }            

            if (s.isEmpty()) {
                Span[i] = i + 1;
            } else {
                Span[i] = i - s.peek();
            }

            s.push(i);

        }
        
    }

    public static void NextGreater(int arr[], int GreaterArr[]) { // O(n^2)
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < GreaterArr.length; j++) {
                if(arr[i] < arr[j]) {
                    GreaterArr[i] = arr[j];
                } else {
                    GreaterArr[i] = -1;
                }   
                break;
            }   
            if(i == arr.length-1){
                GreaterArr[i] = -1;
            }
        }
    }

    public static void nextGreater(int arr[], int GreaterArr[]) { // time O(n) and space O(n)

        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1; i>=0; i--) {
           
            while(!s.isEmpty() && s.peek() <= arr[i]) {
                s.pop();
            }
          
            if(s.isEmpty()) {
                GreaterArr[i] = -1;
            } else {
                GreaterArr[i] = s.peek();
            }
           
            s.push(arr[i]);
        }
    }

    public static boolean isValid(String str) { // time O(n) and space O(n) 

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(' || ch == '[' || ch == '{'){
                s.push(ch);
            } else {
                if (s.isEmpty()) {
                    return false;                   
                }
                if ( (s.peek() == '(' && ch == ')') || (s.peek() == '[' && ch == ']') || (s.peek() == '{' && ch == '}') ) {
                    s.pop();                 
                } else {
                    return false;
                }
            }
        }

        if (s.isEmpty()) {
            return true;            
        } else {
            return false;
        }
    }

    public static boolean isDuplicate(String str) { // O(n)
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == ')') {
                int count = 0;
                while ((s.peek() != '(')) {
                    s.pop();
                    count++;
                }
                if (count < 1) {
                    return true; // duplicates exit               
                } else {
                    s.pop();
                }  
            } else {
                s.push(ch);
            }
        }
        return false;
    }

    public static void MaxAreaInHistogram(int height[]) {

        int NSL[] = new int[height.length];
        int NSR[] = new int[height.length];

        Stack<Integer> s = new Stack<>();

        // next smaller left
        for (int i = 0; i < height.length; i++) {

            while (!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();                
            }

            if (s.isEmpty()) {
                NSL[i] = -1;                
            } else {
                NSL[i] = s.peek();
            }

            s.push(i);

        }

        // next samller right
        for (int i = height.length-1; i >= 0; i--) {

            while (!s.isEmpty() && height[s.peek()] >= height[i]) {
                s.pop();                
            }

            if (s.isEmpty()) {
                NSR[i] = height.length;                
            } else {
                NSR[i] = s.peek();
            }

            s.push(i);
                        
        }

        int Area[] = new int[height.length];

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < height.length; i++) {

            int width = NSR[i] - NSL[i] - 1;

            int currArea = height[i] * width;

            maxArea = Math.max(maxArea, currArea);
            
        }

        System.out.println(maxArea);

    }

    public static void main(String args[]) {

        StackExample st = new StackExample();

        Stack<Integer> s = new Stack<>();

        //Push at bootom
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // PushAtBottom(s, 4);
        // while (!s.isEmpty()) {
        //     System.out.println(s.peek());
        //     s.pop();       
        // }

        // Reverse Stack
        // s.push(1);
        // s.push(2);
        // s.push(3);
        // // 3 2 1
        // Reversestack(s);
        // printStack(s);
        // // 1 2 3

        // Reverse String
        // Stack<Character> S = new Stack<>();
        // System.out.println(ReverseString(S, "ABC"));

        // Stock Span Problem
        // int Stocks[] = {100, 80, 60, 70, 60, 85, 100};
        // int Span[] = new int[Stocks.length];
        // StackSpan(Span, Stocks);
        // for(int i=0; i<Span.length; i++) {
        //     System.out.println(Span[i]);
        // }

        // Next greater from right side
        // int arr[] = {2,1,5,6,2,3};
        // int length = arr.length;
        // int GreaterArr[] = new int[length];
        // // // NextGreater(arr, GreaterArr);
        // nextGreater(arr, GreaterArr);
        // for (int i = 0; i < GreaterArr.length; i++) {
        //     System.out.print(GreaterArr[i] + " ");
        // }

        // Valid Parenthesis
        // String str = "[[{()}]]";
        // System.out.println(st.isValid(str));

        // Duplicates Parenthesis
        // valid string
        // String str = "(a+b+(c+d))"; // false
        // String str = "((a+b+(c+d)))"; // true
        // System.out.println(isDuplicate(str));

        // Max Area in Histogram  // O(n)
        // int height[] = {2,1,5,6,2,3};
        // MaxAreaInHistogram(height);


    }
}