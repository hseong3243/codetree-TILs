import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        for(char c : arr) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }

        for(char c : arr) {
            if(map.get(c) == 1) {
                System.out.println(c);
                return;
            }
        }
        System.out.println("None");
    }
}