import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for(int i=0; i<n; i++) {
            arr[i] = br.readLine();
        }
        new Main().solution(n, arr);
    }

    private void solution(int n, String[] arr) {
        Map<String, Integer> map = new HashMap<>();
        for(String s : arr) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String str = String.valueOf(chars);
            int count = map.getOrDefault(str, 0);
            map.put(str, count + 1);
        }
        int result = 0;
        for(int num : map.values()) {
            result = Math.max(result, num);
        }
        System.out.println(result);
    }
}