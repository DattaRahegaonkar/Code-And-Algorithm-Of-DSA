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

    public static void ReverseArray(int arr[]) {
        int left = 0;
        int right = arr.length-1;
        for (int i = 0; i < (arr.length)/2; i++) {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;

            left++;
            right--;   
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
    
    public static void MaxSumOfSubArray1(int arr[]) { // time complexity is O(n^3) -- Bad
        int maxsum = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++) {
            for(int j=i; j<arr.length; j++) {
                int currsum = 0;
                for(int k=i; k<=j; k++) {
                    currsum = currsum + arr[k];
                }
                if(maxsum < currsum) {
                    maxsum = currsum;
                }
            }
        }
        System.out.println();
        System.out.println("max sum of the sub array is = " + maxsum);
    }

    public static void MaxSumOfSubArray2(int arr[]) { // time complexity is O(n^2) -- better than above
        int maxsum = Integer.MIN_VALUE;
        for(int i=1; i<arr.length; i++) {
            int sum = 0;
            for(int j=i; j<arr.length; j++) {
                sum += arr[j];
            }
            if(maxsum < sum) {
                maxsum = sum;
            }
        }
        System.out.println();
        System.out.println("max sum of the sub array is = " + maxsum);
    }

    public static void KadanesAlgorithamForMaxSumOfSubArray(int arr[]) { // time complexity id O(n) -- better the both of above
        int currsum = 0;
        int maxsum = Integer.MIN_VALUE;
        System.out.print("cs = ");
        for(int i=0; i<arr.length; i++) {
            currsum =+ arr[i];
            System.out.print(currsum + " ");
            if(maxsum < currsum) {
                maxsum = currsum;
            }
            if(currsum < 0) {
                currsum = 0;
            }
        }
        System.out.println();
        System.out.println("max sum of sub array = " + maxsum);
    }

    public static void KadanesAlgorithamForMaxSumOfSubArrayWithSubArray(int arr[]) { // time complexity id O(n) --- better than PrintSubArray
        int currsum = 0;
        int maxsum = Integer.MIN_VALUE;
        int arrstart = -1;
        int arrend = -1;
        int start = 0;
        for(int i=0; i<arr.length; i++) {
            if (currsum == 0) {
                start = i;
            }
            currsum =+ arr[i];

            if(maxsum < currsum) {
                maxsum = currsum;
                arrstart = start;
                arrend = i;
            }
            if(currsum < 0) {
                currsum = 0;
            }
        }

        for (int i = arrstart; i <= arrend; i++) {
            System.out.print(arr[i] + " ");       
        }
        System.out.println();
        System.out.println("max sum of sub array = " + maxsum);
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
        // int arr[] = {1,-2,6,-1,3};
        // int key = 12;
        // int element = BinarySearch(arr,key);
        // if(arr[element] == key) {
        // System.out.println("index is : " + element);
        // } else {
        // System.out.println("index is not found ");
        // }
        
        // reverse of array
        // int arr[] = {1,-2,6,-1,3};
        // ReverseArray(arr);
        // for(int i=0; i<arr.length; i++){
        //     System.out.print(arr[i] + " ");
        // }

        //Pair Of Array
        // int arr[] = {1,-2,6,-1,3};
        // PairOfArray(arr);

        //Print SubArray
        // int arr[] = {1,-2,6,-1,3};
        // PrintSubArray(arr);

        //Max Sum Of SubArray 1
        // int arr[] = {1,-2,6,-1,3};
        // MaxSumOfSubArray1(arr);

        //Max Sum Of SubArray 2
        // int arr[] = {1,-2,6,-1,3};
        // MaxSumOfSubArray2(arr);

        //Kadanes Algoritham
        // int arr[] = {2,-2,-1,4,1,6,-2};
        // KadanesAlgorithamForMaxSumOfSubArray(arr);
        // KadanesAlgorithamForMaxSumOfSubArrayWithSubArray(arr);
    
        //remove element in array
        // int arr[] = {7,8,3,4,15,13,4,1};
        // removeElementInArray(arr);
    

        
        // Google Question
        // Scanner sc = new Scanner(System.in);
        // System.out.print("Enter time : ");
        // String time = sc.nextLine();
        // StringBuilder maxtime = new StringBuilder("");
        // char time1 =  time.charAt(0);
        // if(time.charAt(0) == '?') {
        //     if(time.charAt(1) == '0' | time.charAt(1) == '1' | time.charAt(1) == '2' | time.charAt(1) == '3') {
        //         time1 = '2';
        //     } else {
        //         time1 = '1';
        //     }
        // }
        // char time2 =  time.charAt(1);
        // if(time.charAt(1) == '?') {
        //     if(time.charAt(0) == '0' | time.charAt(0) == '1') {
        //         time2 = '9';
        //     } else {
        //         time2 = '3';
        //     }
        // }
        // char time3 =  ':';
        // char time4 =  time.charAt(3) == '?' ? '5' : time.charAt(3);
        // char time5 =  time.charAt(4) == '?' ? '9' : time.charAt(4);
        // maxtime.append(time1);
        // maxtime.append(time2);
        // maxtime.append(time3);
        // maxtime.append(time4);
        // maxtime.append(time5);
        // System.out.println(maxtime);
    
        
    }
}
