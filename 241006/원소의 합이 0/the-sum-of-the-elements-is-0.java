import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[4][n];
        for(int i=0; i<4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        new Main().solution(n, arr);
    }

    private void solution(int n, int[][] arr) {
        Map<Integer, Integer> left = new HashMap<>();
        Map<Integer, Integer> right = new HashMap<>();
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                int sum = arr[0][i] + arr[1][j];
                int count = left.getOrDefault(sum, 0);
                left.put(sum, count + 1);

                sum = -1*(arr[2][i] + arr[3][j]);
                count = right.getOrDefault(sum, 0);
                right.put(sum, count + 1);
            }
        }
        
        int result = 0;
        for(int num : left.keySet()) {
            if(!right.containsKey(num)) {
                continue;
            }
            result += left.get(num) * right.get(num);
        }
        System.out.println(result);
    }
}