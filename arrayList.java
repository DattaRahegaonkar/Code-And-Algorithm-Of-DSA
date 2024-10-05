import java.util.*;

public class arrayList {

    public static int storewater(ArrayList<Integer> height) {  // O(n^2)
        int maxwater = Integer.MIN_VALUE;
        for(int i=0; i<height.size(); i++){
            for(int j=i+1; j<height.size(); j++){
                int h = Math.min(height.get(i), height.get(j));
                int w = j - i;
                int water = h * w ;
                maxwater = Math.max(maxwater, water);
            }
        }
        return maxwater;
    }

    public static int Storewater(ArrayList<Integer> height){  // O(n)
        int lp = 0;
        int rp = height.size()-1;
        int maxwater = Integer.MIN_VALUE;
        while (lp < rp) {
            int h = Math.min(height.get(lp), height.get(rp));
            int w = rp - lp ;
            int water = h * w ;
            maxwater = Math.max(maxwater, water);
            if(lp < rp){
                lp++;
            } else {
                rp--;
            }
        }
        return maxwater;
    }

    public static boolean pairsum(ArrayList<Integer> sortedlist) {  // O(n^2) this for any order
        int target = 5;
        for(int i=0; i<sortedlist.size(); i++){
            for(int j=i+1; j<sortedlist.size(); j++){
                if(target == (sortedlist.get(i) + sortedlist.get(j))) {
                    System.out.println("pair sum : " + sortedlist.get(i) + "," + sortedlist.get(j) + " = " + target);
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean Pairsum(ArrayList<Integer> sortedlist) {  //O(n) only for sorted order
        int target = 5;
        int lp = 0;
        int rp = sortedlist.size()-1;
        while (lp < rp) {
            if((sortedlist.get(lp) + sortedlist.get(rp) == target)){
                System.out.println("pair sum : " + sortedlist.get(lp) + "," + sortedlist.get(rp) + " = " + target);
                return true;
            } else if((sortedlist.get(lp) + sortedlist.get(rp) < target)){
                lp++;
            } else {
                rp--;
            }
        }
        return false;
    }

    public static boolean RotatedPairsum(ArrayList<Integer> Rotatedlist) {  // O(n)
        int n = Rotatedlist.size()-1;
        int bp = 0;
        for(int i=0; i<Rotatedlist.size(); i++){
            if(Rotatedlist.get(i) > Rotatedlist.get(i+1)) {
                bp = i;
                break;
            }
        }
        int target = 16;
        int lp = bp + 1; // left pointer
        int rp = bp;  // right pointer
        while (lp != rp) {
            if((Rotatedlist.get(lp) + Rotatedlist.get(rp) == target)){
                System.out.println("pair sum : " + Rotatedlist.get(lp) + "," + Rotatedlist.get(rp) + " = " + target);
                return true;
            } else if((Rotatedlist.get(lp) + Rotatedlist.get(rp) < target)){
                lp = (lp + 1) % n;
            } else {
                rp = (n + rp - 1) % n;
            }
        }
        return false;
    }

    public static void main(String args[]) {

        // Question 1  // Store max water in a container
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(storewater(height));
        System.out.println(Storewater(height));

        // Question 2 // Pair sum 
        ArrayList<Integer> sortedlist = new ArrayList<>();
        sortedlist.add(1);
        sortedlist.add(2);
        sortedlist.add(3);
        sortedlist.add(4);
        sortedlist.add(5);
        sortedlist.add(6);
        System.out.println(pairsum(sortedlist));
        System.out.println(Pairsum(sortedlist));

        // Question 3 // pair sum in rotated and sorted arratlist
        ArrayList<Integer> Rotatedlist = new ArrayList<>();
        Rotatedlist.add(11);
        Rotatedlist.add(15);
        Rotatedlist.add(6);
        Rotatedlist.add(7);
        Rotatedlist.add(8);
        Rotatedlist.add(9);
        Rotatedlist.add(10);
        System.out.println(RotatedPairsum(Rotatedlist));

        // // max element
        // int max = Integer.MIN_VALUE;
        // for(int i=0; i<list.size(); i++){
        //      max = Math.max(max, list.get(i));
        // }
        // System.out.println("max element : " + max);

        // swapping of two numbers
        // int idx1 = 1, idx2 = 3;
        // System.out.println(list);

        // int temp = list.get(idx1);
        // list.set(idx1, list.get(idx2));
        // list.set(idx2, temp);
        
        // System.out.println(list);
        
        // Sorting
        // Collections.sort(list);  // Ascending order
        // System.out.println(list);
        // Collections.sort(list, Collections.reverseOrder());   // Descending order
        // System.out.println(list);

        // multi Demenstional Arraylist

        // ArrayList<ArrayList<Integer>> mainlist = new ArrayList<>();

        // ArrayList<Integer> list1 = new ArrayList<>();
        // list1.add(1);
        // list1.add(2);
        // list1.add(3);
        // list1.add(4);

        // mainlist.add(list1);

        // ArrayList<Integer> list2 = new ArrayList<>();
        // list2.add(6);
        // list2.add(5);
        // list2.add(7);
        // list2.add(9);

        // mainlist.add(list2);

        // printing the multiDemenstional Arraylist 1st way
        // for(int i=0; i<mainlist.size(); i++){
        //     for(int j=0; j<mainlist.get(i).size(); j++){
        //         System.out.print(mainlist.get(i).get(j) + " ");
        //     }
        //     System.out.println();
        // }

        // printing the multiDemenstional Arraylist 2nd way
        // for(int i=0; i<mainlist.size(); i++){
        //     ArrayList<Integer> currlist = new ArrayList<>();
        //     for(int j=0; j<currlist.size(); j++){
        //         System.out.print(currlist.get(j) + " ");
        //     }
        //     System.out.println();
        // }

        // System.out.println(mainlist);

    }
}
