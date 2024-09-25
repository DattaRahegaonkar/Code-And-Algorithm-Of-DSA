import java.util.*;

public class PatternsPart_I {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // solid four star squareS
        // for(int lines=0; lines<4; lines++) {
        //     for(int star=0; star<4; star++) {
        //         System.err.print("*");
        //     }
        //     System.out.println();
        // }

        // increasing stars
        // for(int i=0; i<4; i++) {
        //     for(int j=0; j<=i; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // decreasing stars logic 1
        // System.out.print("Enter the number : ");
        // int n = scn.nextInt();
        // for(int lines=1; lines<=n; lines++) {
        //     for(int star=n; star>=lines; star--) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }
        
        //logic 2
        // for(int i=1; i<=5; i++) {
        //     for(int j=1; j<=5-i+1; j++) {
        //         System.out.print("*");
        //     }
        //     System.out.println();
        // }

        // half pyramid 
        // System.out.print("Enter the number : ");
        // int n = scn.nextInt();
        // for(int lines=1; lines<=n; lines++) {
        //     for(int num=1; num<=lines; num++) {
        //         System.out.print(num);
        //     }
        //     System.out.println();
        // }

        // ABCD vala half pyaramid
        // System.out.print("Enter the number : ");
        // int n = scn.nextInt();
        // char ch = 'A' ;
        // for(int lines=1; lines<=n; lines++) {
        //     for(int j=1; j<=lines; j++) {
        //         System.out.print(ch);
        //         ch++;
        //     }
        //     System.out.println();
        // }

        System.out.print("Enter the number : ");
        int rows = scn.nextInt();
        int cols = scn.nextInt();

        for(int i=1; i<=rows; i++) {
            for(int j=1; j<=cols; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

    }
    
}
