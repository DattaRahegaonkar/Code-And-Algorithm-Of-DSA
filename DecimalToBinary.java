import java.util.*;

public class DecimalToBinary {

    public static void DecToBin(int Decimal) {
        int num = Decimal ;
        int remainder = 0 ;
        int power = 0 ;
        int bin = 0 ;
        
        while( Decimal > 0 ) {
            remainder = Decimal % 2 ;
            Decimal = Decimal / 2 ;
            bin = bin + remainder * (int)Math.pow(10, power);
            power++;
        }
        System.out.println("decimal of " + num + " = " + bin );
    }
    
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the number : ");
        int n = scn.nextInt();

        DecToBin(n);
        
    }
    
}
