public class Sorting {

    public static void BubbleSort(int arr[]) {  // worst case Wtime complexity is O(n^2)
        for(int i=0; i<=arr.length-1; i++){
            boolean swapped = false;
            for(int j=0; j<arr.length-1-i; j++){
                if(arr[j] > arr[j+1]){
                    //swapping
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(swapped == false){ //    best case time complexity O(n)
                break;
            }
        }
        for(int i=0; i<=arr.length-1; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void BubbleSort_SortedArray(int arr[]) {  // time complexity is O(n)
        int swaps = 0;
        for(int i=0; i<arr.length-1; i++){
                if(arr[i] > arr[i+1]){
                    //swapping
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    swaps++;
            }
        }
        System.out.println("Swaps : "+swaps);

        for(int i=0; i<=arr.length-1; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void SelectionSort(int arr[]) {  // time complexity is O(n^2)

        for(int i=0; i<arr.length; i++){
            int min = i;
            for(int j=i+1; j<arr.length; j++){
                if(arr[min] > arr[j]){
                    min = j;
                }
            }

            //swapping
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }
   
    public static void InsertionSort(int arr[]) {

        for(int i=1; i<arr.length; i++){
            int curr = arr[i];
            int prev = i-1;
            //correct postion
            while(prev >= 0 && arr[prev] > curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            //insertion
            arr[prev+1] = curr;     

        }
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

   }
    
    public static void CountSort(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max,arr[i]);
        }

        //frequency
        int count[] = new int[max+1];
        for(int i=0; i<arr.length; i++){
            count[arr[i]]++;
        }

        //sorting
        int j=0;
        for(int i=0; i<count.length; i++){
            while(count[i] > 0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }

        //printing
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

    }
   
    
    public static void main(String[] args) {
        int arr[] = {5,4,1,3,2};
        // BubbleSort(arr);

        // int arr[] = {1,2,3,4,5};
        // BubbleSort_SortedArray(arr);

        // SelectionSort(arr);
        // InsertionSort(arr);

        // int arr[] = {1,3,1,2,4,2,7};
        // CountSort(arr);

    }
}
