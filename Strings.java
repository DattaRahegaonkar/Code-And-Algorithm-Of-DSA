public class Strings {

    public static boolean isPalindrome(String str){ // O(n)
        for(int i=0; i<str.length()/2; i++){
            int n = str.length()-1;
            if(str.charAt(i) != str.charAt(n-i)){
                return false;
            }
        }
        return true;
    }
    
    public static void ShortestPath(String path){
        // int E,N,W,S;
        int x = 0;
        int y = 0;
        for(int i=0; i<path.length(); i++){
            int letter = path.charAt(i);
            if( letter == 'E' ){
                x++;
            } else if( letter == 'W' ){
                x--;
            } else if( letter == 'S' ){
                y--;
            } else {
                y++;
            }
        }

        System.out.println("destination point : " + "(" + x + "," + y + ")");
        int shortestPath = (int)Math.sqrt((x-0)^2 + (y-0)^2);

        System.out.println("shortestPath : " + shortestPath);

    }
    
    public static void LargestString(String str[]) {
        String largest = str[0];
        for(int i=1; i<str.length; i++){
            if(largest.compareTo(str[i]) < 0) {
                largest = str[i];
            }
        }
        System.out.println(largest);
    }
   
    
    public static void main(String[] args) {

        // String str = "racecar";
        // System.out.println(isPalindrome(str));

        // String path = "WNEENESENNN";
        // ShortestPath(path);

        String str[] = {"apple","mango","banana","kivi","grepes","papaya"};
        LargestString(str);


        
    }
}
