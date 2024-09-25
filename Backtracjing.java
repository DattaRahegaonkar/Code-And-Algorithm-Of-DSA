public class Backtracjing {

    public static void changeArr(int arr[], int i, int val){      // O(n)

        if(i == arr.length){
            printArr(arr);
            return;
        }

        arr[i] = val;
        changeArr(arr, i+1, val+1);
        arr[i] = arr[i] - 2;
        
    }

    public static void printArr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void Findsubdet(String str, int i, String ans){  // O( n * 2^n )

        if(i == str.length()){
                System.out.println(ans);
            return;
        }

        Findsubdet(str, i+1, ans + str.charAt(i)); // yes
        Findsubdet(str, i+1, ans);  // no

    }

    public static void FindPermutation(String str, String ans){    // O( n * n! )

        if(str.length() == 0){
            System.out.println(ans);
            return;
        }

        for(int i=0; i<str.length(); i++){
            char curr = str.charAt(i);
            String Newstr = str.substring(0, i) + str.substring(i+1);
            FindPermutation(Newstr, ans+curr);
        }

    }


    public static boolean issafe(char board[][], int row, int col){
        // vertical
        for(int i=row; i>=0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        
        //diagonal left up
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        
        //diagonal right up
        for(int i=row-1, j=col+1; i>=0 && j<board.length; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }

        return true;

    }

    // public static void nqueens(char board[][], int row){ // all solution
    //     if(row == board.length){
    //         printBoard(board);
    //         count++;
    //         return;
    //     }
    //     for(int j=0; j<board.length; j++){
    //        if(issafe(board,row,j)) {
    //         board[row][j] = 'Q';
    //         nqueens(board, row+1);
    //         board[row][j] = 'x';
    //        }
    //     }
    // }

    public static boolean nqueens(char board[][], int row){   // 1 solution

        if(row == board.length){
            count++;
            return true;
        }
          
        for(int j=0; j<board.length; j++){
           if(issafe(board,row,j)) {
            board[row][j] = 'Q';
            if(nqueens(board, row+1)) {
                return true;
            }
            board[row][j] = 'x';
           }
        }

        return false;
    }

    public static void printBoard(char board[][]){
        System.out.println("---------------");
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static int count = 0;

    public static int gridways(int i, int j, int n, int m){

        // base case
        if( i == n-1 && j == m-1){
            return 1;
        } else if ( i == n || j == n){
            return 0;
        }


        int w1 = gridways(i+1, j, n, m); // down
        int w2 = gridways(i, j+1, n, m); // right
        return w1 + w2 ;

    }

    public static int gridwaysUsingPandC(int n, int m){

        int t = n-1 + m-1 ;

        int fact = 1;
        for(int i=1; i<t; i++){
            fact = fact + fact * i;
        }

        int factn = 1;
        for(int i=1; i<n-1; i++){
            factn = factn + factn * i;
        }
        int factm = 1;
        for(int i=1; i<m-1; i++){
            factm = factm + factm * i;
        }

        int totaways =  fact / (factn * factm);

        return totaways;
    }



    
    public static void main(String[] args) {

        // int arr[] = new int[5];
        // changeArr(arr, 0, 1);
        // printArr(arr);

        // String str = "abc";
        // String ans = "";
        // Findsubdet(str, 0, ans);
        // FindPermutation(str, ans);

        // all solutions
        // int n = 5;
        // char board[][] = new char[n][n];
        // for(int i=0; i<board.length; i++){
        //     for(int j=0; j<board.length; j++){
        //         board[i][j] = 'x';
        //     }
        //     System.out.println();
        // }
        // nqueens(board, 0);
        // System.out.println(count);

        // for print only 1 solution
        // if(nqueens(board, 0)) {
        //     System.out.println("solution is possible");
        //     printBoard(board);
        // } else {
        //     System.out.println("solution is not possible");
        // }


        // int n=3;
        // int m=3;
        // System.out.println(gridways(0, 0, n, m));
    //    System.out.println( gridwaysUsingPandC(n, m));







        
    }
}
