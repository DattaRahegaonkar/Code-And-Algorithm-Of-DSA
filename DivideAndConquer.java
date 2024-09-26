public class DivideAndConquer {

    public static void printarr(int arr[]){
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }

// Merge Sort

    public static void MerageSort(int arr[], int si, int ei){

        if(si >= ei) {
            return;
        }

        //operations
        int mid = si + (ei - si)/2;
        MerageSort(arr, si, mid); // left part
        MerageSort(arr, mid+1, ei); //right part

        merge(arr, si, mid, ei); // merging left and rigth part

    }

    public static void merge(int arr[], int si, int mid, int ei) {

        int temp[] = new int[ei-si+1];
        int i = si; // index for 1st sorted part
        int j = mid+1; // index for 2nd sorted part
        int k = 0; //index for temp

        while (i <= mid && j <= ei) {
            if(arr[i] < arr[j]){
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while ( i <= mid) {   // left side remaining elements
            temp[k++] = arr[i++];  
        }

        while ( j <= ei) {    // right side remaining elements
            temp[k++] = arr[j++];
        }

        // copying temp in orignal
        for( k=0, i=si; k<temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }
    

// Quick sort

    public static void QuickSort(int arr[], int si, int ei){

        if(si >= ei){
            return;
        }

        int pivot = Partion(arr, si, ei);
        QuickSort(arr, si, pivot-1);
        QuickSort(arr, pivot+1, ei);
    }

    public static int Partion(int arr[], int si, int ei) { 

        int j = si-1;
        for(int i=si; i<ei; i++){
            if(arr[ei] >= arr[i]){
                j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        j++;
        int temp = arr[ei];
        arr[ei] = arr[j];
        arr[j] = temp;

        return j;
   }


    public static void main(String[] args) {

        int arr[] = {7,6,10,5,9,2,1,3};
        MerageSort(arr, 0, arr.length-1);
        printarr(arr);

        // int arr[] = {7,6,10,5,9,2,1,15,7};
        // QuickSort(arr, 0, arr.length-1);
        // printarr(arr);
        
    }
}