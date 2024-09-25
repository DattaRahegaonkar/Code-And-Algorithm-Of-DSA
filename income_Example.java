import java.util.*;

public class income_Example {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the income : ");
        int income = scn.nextInt();
        float tax;

        if ( income < 500000 ) {
            System.out.println("you have to pay 0 % tax");
            tax = 0 * income ;
            System.out.println("tax = " + tax);
        } else if ( (income > 500000) && (income < 1000000)) {
            System.out.println("you have to pay 20 % tax");
            tax = 0.20f * income ;
            System.out.println("tax = " + tax);
        } else {
            System.out.println("30 % tax");
            tax = 0.30f * income ;
            System.out.println("tax = " + tax);
        }
    }
}
