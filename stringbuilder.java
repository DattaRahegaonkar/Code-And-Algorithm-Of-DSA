public class stringbuilder {

    public static String ToUpperCase(String str){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i=1; i<str.length();i++){
            if(str.charAt(i) == ' ' && str.length() - 1 > i){
                sb.append(str.charAt(i));
                i++;
                ch = Character.toUpperCase(str.charAt(i));
                sb.append(ch);
            } else {
                sb.append(str.charAt(i));
            }
        }
        // System.out.println(sb.toString());
        return sb.toString();
    }
    
    public static String compresion(String str){   // time complexity is O(n)
        StringBuilder compresed  = new StringBuilder("");
        for(int i=0; i<str.length(); i++){
            int count = 1;
            compresed.append(str.charAt(i));

            while(i < str.length()-1 && str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
            }
            if(count > 1){
                compresed.append(count);
            }
        }
        return compresed.toString();
    }
    
    public static void main(String[] args) {
        // String str = "hello datta";
        // System.out.println(ToUpperCase(str));

        String str = "aaaabbbccdd";
        compresion(str);
        System.out.println(compresion(str));

    }
}
