import java.util.ArrayList;

public class Recursion {

    public static void DecreseOrder(int n) {
        if( n == 1 ){
            System.out.print(1);
            return;
        }
        System.out.print(n + " ");
        DecreseOrder(n-1);
    }

    public static void IncreseOrder(int n) {
        if( n == 1 ){
            System.out.print(1 + " ");
            return;
        }
        IncreseOrder(n-1);
        System.out.print(n + " ");
    }

    public static int Factorial(int n) { // time complexity O(n) and Space complexity O(n) because variable creation at every recursion
        int result = 0; 
        if( n == 0){
            return 1;
        }
        int num = Factorial(n-1);
        return result = n * num;
    }

    public static void ReverseAnArray(int i, int arr[]) {

        if (i == (arr.length/2)) {
            return;
        }

        int temp = arr[i];
        arr[i] = arr[arr.length-1-i];
        arr[arr.length-1-i] = temp;

        ReverseAnArray(i+1, arr);
    }

    public static void Palindrome(int i, String str) {

        if (i > (str.length()/2)) {
            System.out.println(true);
            return;
        }

        if (str.charAt(i) == str.charAt(str.length()-1-i)) {
            Palindrome(i+1, str);
        } else {
            System.out.println(false);
            return;
        }

        // in Other Way

        // if (i > (str.length()/2)) {
        //     return true;
        // }

        // if (str.charAt(i) != str.charAt(str.length()-1-i)) {
        //     return false;            
        // }

        // return Palindrome(i+1, str);

    }

    public static int Sum(int n) {  // time complexity O(n) and Space complexity O(n) because variable creation at every recursion
        if( n == 1 ){
            return 1;
        }
        int sumofn1 = Sum(n-1);
        return n + sumofn1;

        // int m = 0;
        // if( n == 1 ){
        //     m = 1;
        //     return m;
        // }
        // int sumofn1 = Sum(n-1);
        // return n + sumofn1 + m;
    }

    public static int Fibonacci(int n) { // time complexity is O(2^n) and space complexity is O(n)
        if(n == 1 || n == 0){
            return n;
        }
        int Fn = Fibonacci(n-1) + Fibonacci(n-2) ;
        return Fn;
    }

    public static boolean isSorted(int arr[], int i) { // time = O(n) and space = O(n)
        if(i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]) {
            return false;
        }
        return isSorted(arr, i+1);
    }

    public static int FirstOccurance(int arr[], int key, int i) { // time = O(n) and space = O(n)
        if(i == arr.length-1){
            return -1;
        }
        if(key == arr[i]){
            return i;
        }

        return FirstOccurance(arr, key, i+1);
    }

    public static int power(int x, int n){   // time complexity is O(n)
        if(n == 0){
            return 1;
        }
        int xnm1 = power(x,(n-1));
        int xn = x * xnm1 ;
        return xn;
    }

    public static int powers(int x, int n){   // optimized solution of above method using time complexity O(log(n))
        if(n == 0){
            return 1;
        }

        int halfpower = powers(x, n/2);
        int halfpowersq = halfpower * halfpower ;

        if(n % 2 != 0){
            halfpowersq = x * halfpowersq;
        }

        return halfpowersq;
    }

    public static int TillingProblem(int n){
        if(n == 1 || n == 0){
            return 1;
        }

        // vertically
        int Fnm1 = TillingProblem(n-1);

        //horizantally
        int Fnm2 = TillingProblem(n-2);

        return Fnm1 + Fnm2 ;

    }

    public static void RemoveDuplicate(String str, int i, StringBuilder newstr, boolean[] map){

        if(i == str.length()){
            System.out.println(newstr);
            return;
        }

        char currchar = str.charAt(i);
        if(map[currchar - 'a'] == true){
            RemoveDuplicate(str, i+1, newstr, map);
        } else {
            map[currchar - 'a'] = true;
            RemoveDuplicate(str, i+1, newstr.append(currchar), map);
        }
    }

    public static int FriendsPairing(int n){
        if(n == 1 || n == 2){
            return n;
        }

        // single
        int fnm1 = FriendsPairing(n-1);

        // paired
        int fnm2 = FriendsPairing(n-2);

        return fnm1 + ((n-1) * fnm2);
    }

    public static void allOccurances(int arr[], int key, int i){
        if(i == arr.length){
            return;
        }

        if(key == arr[i]){
            System.out.print(i + " ");
        }
        allOccurances(arr, key, i+1);
    }

    public static void NumberToString(int num, String array[]){

        if(num == 0){
            return;
        }

        int number = num % 10;
        num = num / 10;

        NumberToString(num, array);

        System.out.print(array[number] + " ");
    }

    public static void SubString(String S, int i, int count){

        if(i == S.length()){
            System.out.println(count);
            return;
        }
        for(int j=i; j<S.length(); j++){  

            if(S.charAt(i) == S.charAt(j) ){
                count++;
            }
        }
        SubString(S, i+1, count);
    }
       
    public static void SubsetsInArray(int ind, ArrayList<Integer> list, int arr[]) {

        if (ind == arr.length) {
            System.out.println(list);
            return;
        }

        list.add(arr[ind]);
        SubsetsInArray(ind+1, list, arr);
        list.remove(list.size()-1);
        SubsetsInArray(ind+1, list, arr);

    }
    
    public static void SubsetOfSumK(int ind, int arr[], ArrayList<Integer> list, int sum, int k) {
        if (ind == arr.length) {
            if (sum == k) {
                System.out.println(list);           
            }
            return;
        }

        list.add(arr[ind]);
        sum += arr[ind];
        SubsetOfSumK(ind+1, arr, list, sum, k);
        list.remove(list.size()-1);
        sum -= arr[ind];
        SubsetOfSumK(ind+1, arr, list, sum, k);
    }

    public static void Shifting(int n, String src, String help, String destination){

        if(n == 0){
            return;
        }

        Shifting(n-1, src, destination, help);
        System.out.println("disk " + n + "transfer from " + src + " to " + destination);
        Shifting(n-1, help, src, destination);

    }

    public static void ReverseString(String str, int i){

        if(i == 0){
            System.out.println(str.charAt(i));
            return;
        }

        System.out.println(str.charAt(i));

        ReverseString(str, i-1);

    }


    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<Integer>();

        int arr[] = {1,2,1};


        SubsetOfSumK(0, arr, list, 0, 2);

        // int n = 10;
        // DecreseOrder(n);
        // IncreseOrder(n);

        // int result = Factorial(n);
        // System.err.println(result);

        // int arr[] = {1,4,3,6,2};
        // ReverseAnArray(0, arr);
        // for (int i = 0; i < arr.length; i++) {
        //     System.out.print(arr[i] + " ");
        // }

        // String str = "madam";
        // Palindrome(0, str);

        // int result = Sum(n);
        // System.out.println(result);

        // int result = Fibonacci(n);
        // System.out.println(result);

        // int arr[] = {1,2,3,4,5};
        // boolean result = isSorted(arr, 0);
        // System.out.println(result);

        // int arr[] = {1,2,8,3,2,9,5,3,4,5};
        // int key = 3;
        // int result = FirstOccurance(arr, key, 0);
        // System.out.println(result);

        // System.out.println(power(2,10));

        // System.out.println(powers(2,10));

        // System.out.println(TillingProblem(10));

        // String str = "dattarahegaonkar";
        // StringBuilder newstr = new StringBuilder("");
        // boolean map[] = new boolean[26];
        // RemoveDuplicate(str, 0, newstr, map);

        // System.out.println(FriendsPairing(5));
        // System.out.println();

        // int arr[] = {3,2,4,5,6,2,7,2,2};
        // int key = 2;
        // allOccurances(arr, key, 0);

        // int num = 1947;
        // String array[] = {"zero","one","two","three","four","five","six","seven","eight","nine"};
        // NumberToString(num, array);

        // String S = "aba";
        // SubString(S, 0, 0);

        // String src = "A";
        // String help = "B";
        // String destination = "C";
        // int n = 3;
        // Shifting(n, src, help, destination);

        // ArrayList<Integer> list = new ArrayList<>();
        // int arr[] = {3,1,2};
        // SubsetsInArray(0, list, arr);

        // String str = "abcd";
        // ReverseString(str, str.length()-1);
    }

}
