import java.util.HashMap;
import java.util.*;
import java.util.HashSet;
import java.util.Set;

// import hm.keySet;

public class Hashing {

    public static void NumberHashingArray() {

        int arr[] = { 1, 3, 4, 1, 3 };
        int hash[] = new int[6];

        for (int i = 0; i < arr.length; i++) {
            hash[arr[i]] += 1;
        }

        int k = 0;

        while (k < arr.length) {
            System.out.print(hash[k++] + " ");
        }
    }

    public static void CharacterHashingArray() {

        String str = "dattasureshrahegaonkar";

        int hash[] = new int[26];

        for (int i = 0; i < str.length(); i++) {

            hash[str.charAt(i) - 'a'] += 1;

        }

        int k = 0;
        while (k < hash.length) {

            System.out.print(hash[k++] + " ");

        }
    }

    public static void HashMapping() {

        int arr[] = { 2, 4, 1, 2, 4, 12 };
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            int key = arr[i];

            if (hm.containsKey(key)) {
                hm.put(key, hm.get(key) + 1);
            } else {
                hm.put(key, 1);
            }
        }

        System.out.println(hm);
    }

    public static void LowestAndHighestFrequencyElement() {
        int arr[] = { 3, 4, 2, 3, 4, 3, 4, 5};
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int key = arr[i];

            if (hm.containsKey(key)) {
                hm.put(key, hm.get(key) + 1);
            } else {
                hm.put(key, 1);
            }
        }

        System.out.println(hm);

        Set<Integer> keys = hm.keySet();

        int largest = 0;
        int smallest = Integer.MAX_VALUE;

        for (Integer k : keys) {

            if (hm.get(k) > largest) {
                largest = hm.get(k);
            }

            if (hm.get(k) < smallest) {
                smallest = hm.get(k);
            }

        }
    
        for (Integer k : keys) {
            if (hm.get(k) == largest) {
                System.out.println("Largest Frequency key value --> (key: "+k+", repeated: "+largest+")");
            }
            if (hm.get(k) == smallest) {
                System.out.println("smallest Frequency key value --> (key: "+k+", repeated: "+smallest+")");

            }
        }

    }

    
    public static void main(String[] args) {

        NumberHashingArray();
        // CharacterHashingArray();
        // HashMapping();
        // LowestAndHighestFrequencyElement();

    }

}
