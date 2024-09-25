public class BitManipulation {

    public static void EvenOdd(int n){
        int bitmask = 1;
        if((n & bitmask) == 0){
            System.out.println("even number");
        } else {
            System.out.println("odd number");
        }
    }

    public static int Get_ith_Bit(int n,int i){
        int bitmask = 1;
        if(((n >> i) & bitmask) == 0 ){
            // System.out.println("ith bit is 0" );
            return 0;
        } else {
            // System.out.println("ith bit is 1" );
            return 1;
        }
    }

    public static int Set_ith_Bit(int n, int i){
        int bitmask = 1<<i ;
        int result = n | bitmask;
        return result;
    }

    public static int Clear_ith_Bit(int n, int i){
        int bitmask = ~(1<<i) ;
        int result = n & bitmask;
        return result;
    }

    public static int Upadate_ith_Bit(int n, int i, int newBit){
        //logic 1
        // if(newBit == 0){
        //     return Clear_ith_Bit(n, i);
        // } else {
        //     return Set_ith_Bit(n, i);
        // }

        //logic 2
        n = Clear_ith_Bit(n, i);
        int result = n | (newBit<<i);
        return result;

    }

    public static int Clear_Last_ith_Bit(int n, int i){
        // logic 1
        // int num = (n>>i) ;
        // int result = ( num<<i ) ;
        // return result;

        // logic 2
        int result = n & ((-1)<<i);
        return result;

    }

    public static int Clear_Range(int n, int i, int j){

        int a = ((-1) << (j+1));
        int b = (1<<(i)) - 1;

        int result = n & (a | b);
        return result;

    }
    
    public static int isPowerOrNot(int n){

        int count = 0;
        while (n > 0) {
            if( (n & 1) == 1){
                count++;
            }
            n = n>>1;
        }
        return count;
    }
    
    
    
    
    
    public static void main(String[] args) {
        
        // EvenOdd(6);
        // EvenOdd(5);

        // System.out.println(Get_ith_Bit(468, 9));
        // System.out.println(Set_ith_Bit(8, 2));
        // System.out.println(Clear_ith_Bit(8, 3));
        // System.out.println(Upadate_ith_Bit(15, 2, 0));
        // System.out.println(Clear_Last_ith_Bit(15, 2));
        // System.out.println(Clear_Range(1491, 2, 7));
        System.out.println(isPowerOrNot(15));




    }
}
