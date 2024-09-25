import java.util.*;

public class CalculatorUsingSwitch {
    public static void main(String[] args) {
        Scanner Scn = new Scanner(System.in);

        System.out.print("Enter a = ");
        int a = Scn.nextInt();
        System.out.print("Enter b = ");
        int b = Scn.nextInt();

        char operator = Scn.next().charAt(0);

        switch (operator) {
            case '+':
                int sum = a + b ;
                System.out.println("addition = "+sum);
                break;

            case '*':
                int product = a * b ;
                System.out.println("multiplication = "+product);
                break;

            case '-':
                int subtract = a - b ;
                System.out.println("subtraction = "+subtract);
                break;

            case '/':
                int div = a / b ;
                System.out.println("division = "+div);
                break;
        
            default:
                System.out.println("wrong operator");
                break;
        }   
    }
}