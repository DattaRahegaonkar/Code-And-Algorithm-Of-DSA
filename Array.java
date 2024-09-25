import java.util.*;

public class Array {

    public static int LinearSearch(int arr[], int key) {
        System.out.println("Length of array : " + arr.length);
        for(int i=0; i<arr.length; i++ ) {
            if( arr[i] == key) {
                return i ;
            }
        }
        return -1;
    }

    public static void DisplayKey(int index) {
        if(index == -1) {
            System.out.println("index of key is not found");
        } else { 
            System.out.println("index of key is : " + index);
        }
    }

    public static int LinearSearch(String menu[], String key) {

        System.out.println("Length of array : " + menu.length);
        for(int i=0; i<menu.length; i++ ) {
            if( menu[i] == key) {
                return i ;
            }
        }
        return -1;
    }

    public static void DisplayIndexOfLinearSearch(int index) {
        if(index == -1) {
            System.out.println("index of key is not found");
        } else { 
            System.out.println("index of key is : " + index);
        }
    }

    public static void LargestNumber(int arr[]) {

        int LargestNumber = Integer.MIN_VALUE;
        int SmallestNumber = Integer.MAX_VALUE;
        for(int i=0; i<arr.length; i++) {
            if(LargestNumber < arr[i]) {
                LargestNumber = arr[i];
             }
             if(SmallestNumber > arr[i]) {
                SmallestNumber = arr[i];
             }
        }

        System.out.println("Largest number : "+ LargestNumber);
        System.out.println("Smallest number : "+ SmallestNumber);
    }
    
    public static int BinarySearch(int arr[], int key) {
        
        int start = 0;
        int end = arr.length - 1;
        while(start <= end) {
            int mid = (start + end) / 2;

            if(arr[mid] == key){
                return mid;
            }
            if(arr[mid] > key){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    //logic 1
    public static void ReverseOfArray(int arr[]) {
        for(int i=0; i<arr.length/2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp ;
        }
    }
    //logic 2
    public static void ReverseArray(int arr[]) {
        int first = 0;
        int last = arr.length - 1;
        while(first < last) {
            int temp = arr[first];
            arr[first] = arr[last];
            arr[last] = temp;

            first++;
            last--;
        }
    }
    
    public static void PairOfArray(int arr[]) {
        int totalpairs = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=i+1; j<arr.length; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ")" + " ");

                totalpairs++;
            }
            System.out.println(); 
        }
        System.err.println("Total pairs : " + totalpairs);
    }

    public static void PrintSubArray(int arr[]) {
        int totalsubarray = 0;
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                for(int k=i; k<=j; k++) {
                    System.out.print(arr[k] + " ");
                }
                totalsubarray++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("totalsubarray : " + totalsubarray);
    }
    
    public static void MaxSumOfSubArray(int arr[]) { // time complexity is O(n^3) -- Bad
        int maxsum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                int currsum = 0;
                for(int k=i; k<=j; k++) {
                    currsum = currsum + arr[k];
                }
                System.out.print(currsum + " ");
                if(maxsum < currsum) {
                    maxsum = currsum;
                }
            }
        }
        System.out.println();
        System.out.println("max sum of the sub array is = " + maxsum);
    }

    public static void PrefixArrayForMaxSumOfSubArray(int arr[]) { // time complexity is O(n^2) -- better than above
        int maxsum = Integer.MIN_VALUE;
        int PrefixArray[] = new int[arr.length];
        PrefixArray[0] = arr[0];
        for(int i=1; i<arr.length; i++) {
            PrefixArray[i] = PrefixArray[i-1] + arr[i];
        }
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                
                int currsum = i==0 ? PrefixArray[j] : PrefixArray[j] - PrefixArray[i-1];
                System.out.print(currsum + " ");
                if(maxsum < currsum) {
                    maxsum = currsum;
                }
            }
        }
        System.out.println();
        System.out.println("max sum of the sub array is = " + maxsum);
    }

    public static void KadanesAlgoritham(int arr[]) { // time complexity id O(n) -- better the both of above
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        System.out.print("cs = ");
        for(int i=0; i<arr.length; i++) {
            cs = cs + arr[i];
            if(cs < 0) {
                cs = 0;
            }
            System.out.print(cs + " ");
            if(ms < cs) {
                ms = cs;
            }
        }
        System.out.println();
        System.out.println("max sum of sub array = " + ms);
    }
    
    public static int SortedRotedArray(int arr[], int target, int start, int end){

        while (start <= end) {

            int mid = start + (end - start)/2 ;

            if(arr[mid] == target){
                return mid;
            }

            if(arr[start] <= arr[mid]){
                if(arr[start] <= target && target <= arr[mid]){
                    end = mid - 1;                   
                } else {
                    start = mid + 1;
                }
            } else {
                if(arr[mid] <= target && target <= arr[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;

    }
    
    public static void removeElementInArray(int arr[]){

        Arrays.sort(arr);
        int n = arr.length;
        float minaverage = Float.MAX_VALUE;

        int maxE = 0;
        int minE = 0;
        int j = 0;

        for(int i=0; i<n/2; i++){
            minE = arr[i];
            maxE = arr[n-i-1];

            float average = (maxE + minE)/2.0f;

            if(average < minaverage){
                minaverage = average;
            }

            System.out.println(minaverage);
        }
    }

    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);

        // sorted roted array
        // int arr[] = {4,5,6,7,0,1,2};
        // System.out.println(SortedRotedArray(arr, 0, 0, arr.length-1));
        
        //linear search
        // int arr[] = {2,4,6,8,10,12,14,16};
        // String menu[] = {"samosa","dosa","jamun","vadapav"};
        // String key = "jamun" ;
        // int index = LinearSearch(menu,key);
        // DisplayIndexOfLinearSearch(index);

        //largest number
        // int arr[] = {1,2,6,3,5};
        // LargestNumber(arr);

        //binary search
        // int arr[] = {2,4,6,8,10,12,14,16};
        // int key = 12;
        // int element = BinarySearch(arr,key);
        // if(arr[element] == key) {
        // System.out.println("index is : " + element);
        // } else {
        // System.out.println("index is not found ");
        // }
        
        //reverse of array
        // int arr[] = {2,4,6,8,10};
        // ReverseOfArray(arr);
        // ReverseArray(arr);
        // for(int i=0; i<arr.length; i++){
        //     System.out.print(arr[i] + " ");
        // }

        //Pair Of Array
        // int arr[] = {2,4,6,8,10};
        // PairOfArray(arr);

        //Print SubArray
        // int arr[] = {2,4,6,8,10};
        // PrintSubArray(arr);

        //Max Sum Of SubArray
        // int arr[] = {2,4,6,8,10};
        // int arr[] = {1,-2,6,-1,3};
        // MaxSumOfSubArray(arr);

        //prefix array
        // int arr[] = {1,-2,6,-1,3};
        // PrefixArrayForMaxSumOfSubArray(arr);

        //Kadanes Algoritham
        // int arr[] = {1,-2,6,-1,3};
        // KadanesAlgoritham(arr);
    
        //remove element in array
        // int arr[] = {7,8,3,4,15,13,4,1};
        // removeElementInArray(arr);
    
        
    
    }
}
