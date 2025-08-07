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

    public static void RowWithMaxNoOf1sInSortedArray(int matrix[][]) {   // time complexity is O( rows * cols )
        int count_ones = 0;
        int row_index = 0;
        int max_ones = 0;

        for(int i=0; i<matrix.length; i++) {
            count_ones = 0;
            for(int j=0; j<matrix[0].length; j++) {
                // if(matrix[i][j] == 1) {
                //     count_ones++;
                // }
                count_ones += matrix[i][j];
            }
            if(count_ones > max_ones) {
                max_ones = count_ones;
                row_index = i;
            }
        }

        System.out.println("Row with maximum number of 1s is: " + row_index + " with count: " + max_ones);
    }

    public static int LowerBoundUSingBinarySearch(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;
        int LP = arr.length; // Default answer if target is not found

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(arr[mid] >= target) {
                LP = mid;
                end = mid - 1; // continue searching in the left half
            }  else {
                start = mid + 1;
            }
        }

        // System.out.println("Lower bound index of " + target + " is: " + LP);

        return LP;
    }

    public static void RowWithMaxNoOf1sInSortedArrayOptimized(int matrix[][]) {   // time complexity is O( rows * log(cols) )

        int row_index = 0;
        int max_ones = 0;

        for(int i=0; i<matrix.length; i++) {

            int LP = LowerBoundUSingBinarySearch(matrix[i], 1);
            int count_ones = matrix[i].length - LP;

            if (count_ones > max_ones) {
                max_ones = count_ones;
                row_index = i;                
            }
            
        }

        System.out.println("Row with maximum number of 1s is: " + row_index + " with count: " + max_ones);
    }

    public static void searching_in_sorted_matrix(int matrix[][], int target){  // time complexity is O(rows * cols)

        for(int i=0; i<matrix[0].length; i++){
            for(int j=0; j<matrix.length; j++){
                if(matrix[i][j] == target){
                    System.out.println("key found at (" + i + "," + j + ")");
                }
            }
        }        
    }

    public static void SearchingInSortedMatrix(int matrix[][], int target) {  // time complexity is O(rows * log(cols))
        
        for(int i=0; i<matrix.length; i++){

            if(matrix[i][0] <= target && matrix[i][matrix[i].length - 1] >= target) {
                int index = LowerBoundUSingBinarySearch(matrix[i], target);
                // if (index < matrix[i].length && matrix[i][index] == target) {   // in case of 1st element is of each row is not neccessary greate then the last element of the privous row
                    
                //     System.out.println("Key " + target + " found at (" + i + "," + index + ")");
                // }
                System.out.println("Key " + target + " found at (" + i + "," + index + ")");
            }
        }
    }

    public static void SearchingInSortedMatrixOptimized(int matrix[][], int target) {  // time complexity is O(log(rows * cols))

        int start = 0;
        int end = matrix.length * matrix[0].length - 1;

        while (start <= end) {
            
            int mid = (start + end) / 2;
            int row = mid / matrix[0].length;  // Calculate the row index
            int col = mid % matrix[0].length;   // Calculate the column index

            if(matrix[row][col] == target) {
                System.out.println("Key " + target + " found at (" + row + "," + col + ")");
                return;
            } else if (matrix[row][col] < target) {
                start = mid + 1; // Move to the right half
            } else {
                end = mid - 1; // Move to the left half
            }
        }

    }

    public static void SearchingInSortedMatrixOptimized2(int matrix[][], int target){
        int row = 0;
        int col = matrix[0].length - 1; // Start from the top-right corner

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                System.out.println("Key " + target + " found at (" + row + "," + col + ")");
                return;
            } else if (matrix[row][col] > target) {
                col--; // Move left
            } else {
                row++; // Move down
            }
        }

        System.out.println("Key " + target + " not found in the matrix.");
    }
    public static void main(String[] args) {
        // int matrix[][] = new int[3][3];
        // matrix(matrix);
        // searching(matrix,8);
        // largest_samllest_element(matrix);

        // int matrix[][] = {  {1,2,3,4},
        //                     {5,6,7,8},
        //                     {9,10,11,12},
        //                     {13,14,15,16}  };
                    
        // SpiralMatrix(matrix);
        // DiagonalSum(matrix);
        
        // Row with maximum number of 1s in sorted array
        // int matrix[][] = {  {0,0,1,1},
        //                     {0,1,1,1},
        //                     {1,1,1,1},
        //                     {0,0,0,0}  };
        // RowWithMaxNoOf1sInSortedArray(matrix);
        // RowWithMaxNoOf1sInSortedArrayOptimized(matrix);
        
        // Searching in sorted matrix
        // int matrix[][] = {  {1,2,3,4},             // Increasing order
        //                     {5,6,7,8},
        //                     {9,10,11,12},
        //                     {13,14,15,16}  };
        // int matrix2[][] = { {1,4,7,11,15},        // Increasing but rows and columns wise
        //                    {2,5,8,12,19},
        //                    {3,6,9,16,22},
        //                    {10,13,14,17,24},
        //                    {18,21,23,26,30} };
        // int target = 7;
        // searching_in_sorted_matrix(matrix, target);
        // SearchingInSortedMatrix(matrix, target);
        // SearchingInSortedMatrixOptimized(matrix, target);
        // SearchingInSortedMatrixOptimized2(matrix2, target);
    
        // 
    
    }
}
