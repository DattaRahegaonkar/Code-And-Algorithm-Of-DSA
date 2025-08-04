import java.util.*;

public class BinaryToDecimal {

    public static void BinToDec(int BinNum) {

        int power = 0;
        int dec = 0;

        while( BinNum > 0 ) {
            int LastDigit = BinNum % 10;
            BinNum = BinNum / 10;
            dec = dec + ( LastDigit * (int)Math.pow(2, power));
            power++;
        }

        System.out.println("Decimal of " + BinNum + " = " + dec);

    }
    
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int n = scn.nextInt();
        
        BinToDec(n);
    }

}





