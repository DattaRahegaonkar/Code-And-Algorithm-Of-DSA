import java.util.*;

public class InputExample {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // System.out.print("Enter the string : ");
        // String name = scn.next();
        // System.out.println(name);

        // System.out.print("Enter the line : ");
        // String line = scn.nextLine();
        // System.out.println(line);

        // System.out.print("Enter the number : ");
        // int number = scn.nextInt();
        // System.out.println(number);

        System.out.println("Enter choice of day : ");
        int ch = scn.nextInt();

        // if (marks > 80 & marks < 100) {
        //     System.out.println("A");            
        // } else if (marks > 60 & marks < 79) {
        //     System.out.println("B");            
        // } else if (marks > 50 & marks < 59) {
        //     System.out.println("C");          
        // } else {
        //     System.out.println("fail");
        // }

        switch (ch) {
            case 1:
                System.out.println("monday");                
                break;
            case 2:
                System.out.println("tuseday");                
                break;
            case 3:
                System.out.println("wedensday");                
                break;
            case 4:
                System.out.println("thursday");                
                break;
            case 5:
                System.out.println("friday");                
                break;
            case 6:
                System.out.println("saturday");                
                break;
            case 7:
                System.out.println("sunday");                
                break;
        
            default:
                System.out.println("please, choose a correct choice !");
                break;
        }

    }
}
