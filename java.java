import java.util.Arrays;

public class java {

    public static void removeElement(int arr[]){

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

            // System.out.println(minaverage);
        }
        System.out.println(minaverage);
    }
    
    public static int maximumLength(int[] nums) {

        int zero_rem = 0;
        int one_rem = 0;

        int max_length = 0;

        for(int i=0; i<nums.length-1; i++){
            if((nums[i] + nums[i+1]) % 2 == 0) {
                zero_rem++;
            } else {
                one_rem++;
            }
        }

        if(zero_rem > one_rem) {
            max_length = zero_rem;
        } else {
            max_length = one_rem;
        }

        return max_length;
        
    }


    public static void main(String[] args) {

    // int arr[] = {2,6,8,4,9,3,5};
    // removeElement(arr);

    int nums[] = {1,2,1,1,2,1,2};
   System.out.println(maximumLength(nums));

    
  }
}
