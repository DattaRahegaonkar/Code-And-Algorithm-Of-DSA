import java.util.*;

public class LeapYearConcept {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int year = scn.nextInt();

        if( year % 4 == 0) {
            if( year % 100 == 0){
                if( year % 400 == 0){
                    System.out.println("it is a leap year");
                } else {
                    System.out.println("it is not a leap year");
                }
            } else {
                System.out.println("it is not a leap year");
            }
        } else {
            System.out.println("it is not a leap year");
        }
    }
}
