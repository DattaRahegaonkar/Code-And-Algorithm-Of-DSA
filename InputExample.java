import java.util.*;

public class InputExample {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Enter the string : ");
        String name = scn.next();
        System.out.println(name);

        // System.out.print("Enter the line : ");
        // String line = scn.nextLine();
        // System.out.println(line);

        System.out.print("Enter the number : ");
        int number = scn.nextInt();
        System.out.println(number);
    }
}
