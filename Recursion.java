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
        int n = 10;
        // DecreseOrder(n);
        // IncreseOrder(n);

        // int result = Factorial(n);
        // System.err.println(result);

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


        // String str = "abcd";
        // ReverseString(str, str.length()-1);
    }

}
