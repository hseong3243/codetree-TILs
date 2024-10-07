import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            String[] split = br.readLine().split(" ");
            arr[i][0] = Integer.parseInt(split[0]);
            arr[i][1] = Integer.parseInt(split[1]);
        }

        Map<Integer, Integer> map = new HashMap<>();
        for(int[] point : arr) {
            if(map.containsKey(point[0])) {
                int y = map.get(point[0]);
                map.put(point[0], Math.min(y, point[1]));
            } else {
                map.put(point[0], point[1]);
            }
        }
        long result = 0;
        for(int y : map.values()) {
            result += y;
        }
        System.out.println(result);
    }
}