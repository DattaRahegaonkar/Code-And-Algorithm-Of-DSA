import java.util.*;

public class Reverse_of_number {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the number : ");
        int n = scn.nextInt();
         do {
            int rem = n % 10 ;
            n = n / 10 ;
            System.out.print(rem);
         } while(n > 0);
    }
}


