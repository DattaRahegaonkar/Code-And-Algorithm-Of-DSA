import java.util.*;

public class Arrays_2D {

    public static void matrix(int matrix[][]) {
        Scanner scn = new Scanner(System.in);
        
        // creating a matrix
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                matrix[i][j] = scn.nextInt();
            }
        }

        // Displaying a matrix
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean searching(int matrix[][], int key){
        matrix(matrix);
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(matrix[i][j] == key) {
                    System.out.println("key found at "+"("+i+","+j+")");
                    return true;
                }
            }
        }
        return false;
    }
    
    public static void largest_samllest_element(int matrix[][]){
        matrix(matrix);
        int largest = Integer.MIN_VALUE;
        int smallest = Integer.MAX_VALUE;

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                if(largest < matrix[i][j]) {
                    largest = matrix[i][j];
                }
                if(smallest >  matrix[i][j]){
                    smallest = matrix[i][j];
                }
            }
        }
        System.out.println("largest element " + largest);
        System.out.println("smallest element " + smallest);
    }
    
    public static void SpiralMatrix(int matrix[][]){
        int startcol = 0;
        int startrow = 0;
        int endcol = matrix[0].length-1;
        int endrow = matrix.length-1;

        while(startcol <= endcol && startrow <= endrow) {

        //top
        for(int i=startcol; i<=endcol; i++){
            System.out.print(matrix[startrow][i] + " ");
        }
        //right
        for(int i=startrow+1; i<=endrow; i++){
            System.out.print(matrix[i][endcol] + " ");
        }
        //bottom
        for(int i=endcol-1; i>=startcol; i--){
            if(startrow == endrow){
                break;
            }
            System.out.print(matrix[endrow][i] + " ");
        }
        //left
        for(int i=endrow-1; i>startrow; i--){
            if(startcol == endcol){
                break;
            }
            System.out.print(matrix[i][startcol] + " ");
        }

        startcol++;
        startrow++;
        endcol--;
        endrow--;
        }
    }
    
    public static void DiagonalSum(int matrix[][]){
        int sum = 0;

        // for(int i=0; i<matrix[0].length; i++){      // O(n^2)
        //     for(int j=0; j<matrix.length; j++){
        //         if( i == j ){
        //             sum += matrix[i][j];
        //         } else if( (i+j) == matrix.length-1) {
        //             sum += matrix[i][j];
        //         }
        //     }
        // }

        for(int i=0; i<matrix.length; i++){    //O(n) optimal solution

            //primary sum
            sum += matrix[i][i];
            // secondary sum
            if(i != matrix.length-i-1)
                sum += matrix[i][matrix.length-i-1];
        }
        System.out.println(sum);
    } 

    public static void searching_in_sorted_matrix(int matrix[][]){

        int key = 5;

        // for(int i=0; i<matrix[0].length; i++){
        //     for(int j=0; j<matrix.length; j++){
        //         if(matrix[i][j] == key){
        //             System.out.println("key found");
        //         }
        //     }
        // }

        for(int i=0; i<matrix[0].length; i++){ // time complexity is O( matrix[0].length * log( matrix.length ) )

            int start = 0;
            int end = matrix.length-1;

            while(start <= end ){
                int mid = (start + end)/2;

                if(matrix[mid][i] == key){
                    System.out.println("key found at "+"("+mid+","+i+")");
                }
                if(matrix[mid][i] < key){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        // int row = 0;
        // int col = matrix[0].length-1;
        // while( row <= matrix.length-1 && col >=0 ){   // time complexity is O( rows + cols)
        //     if(key == matrix[row][col]){
        //         System.out.println("key found at "+"("+row+","+col+")");
        //         break;
        //     } 
        //     if( key > matrix[row][col]){
        //         row++;
        //     } else {
        //         col--;
        //     }
        // }

        // int row = matrix.length-1;
        // int col = 0;

        // while( col <= matrix[0].length && row >= 0){
        //     if(matrix[row][col] == key){
        //         System.out.println("key found at "+"("+row+","+col+")");
        //     }
        //     if( matrix[row][col] < key){
        //         col++;
        //     } else {
        //         row--;
        //     }
        // }
    }


    public static void main(String[] args) {
        // int matrix[][] = new int[3][3];
        // matrix(matrix);
        // searching(matrix,8);
        // largest_samllest_element(matrix);

        int matrix[][] = {  {1,2,3,4},
                            {5,6,7,8},
                            {9,10,11,12},
                            {13,14,15,16}  };
                    
        // SpiralMatrix(matrix);
        // DiagonalSum(matrix);
        // searching_in_sorted_matrix(matrix);
    }
}
