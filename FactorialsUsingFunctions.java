import java.util.*;

public class FactorialsUsingFunctions {

    // FACTORIAL OF ANY NUMBER

    // public static int factorial(int n) {
    //     int fact = 1 ;
    //     for(int i=1; i<=n; i++) {
    //         fact *= i ;
    //     }
    //     return fact ;
    // }
    // public static void main(String[] args) {
    //     Scanner scn = new Scanner(System.in);
    //     System.out.print("Enter the number : ");
    //     int n = scn.nextInt();
    //     int fact = factorial(n);
    //     System.out.println("factorial of " + n + " = " + fact);
    // }

    // BINOMIAL COEFFICIENT OF ( n , r )

    public static int factorial(int num) {
        int fact = 1 ;
        for(int i=1; i<=num; i++) {
            fact *= i ;
        }
        return fact ;
    }

    public static int BC(int n, int r) {

        int N = factorial(n);
        int R = factorial(r);
        int I = factorial(n-r);

        int BinomialCoefficient = N / ( R * I) ;

        return BinomialCoefficient ;
    }
  
  
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter n : ");
        int n = scn.nextInt();
        System.out.print("Enter r : ");
        int r = scn.nextInt();

        int BinomialCoefficient = BC(n,r);

        System.out.println("BinomialCoefficient of (n,r) is = " + BinomialCoefficient);
    }


}
