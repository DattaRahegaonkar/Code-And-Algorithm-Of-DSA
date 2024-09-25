import java.util.*;

public class PrimeNumbers {

    public static boolean prime(int n) {
        for(int i=2; i<=Math.sqrt(n); i++) {
            if( n % i == 0) {
                return false;
            }
        }
        // System.out.println(n);
        return true;
    }

    public static void RangeOfPrime(int n) {
        for(int i=2; i<=n; i++) {
            if(prime(i)) {
                System.out.print( i + " ");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = scn.nextInt();

        RangeOfPrime(n);
    }
    
}
