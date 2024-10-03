import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        new Main().solution(n,k,arr);
    }

    private void solution(int n, int k, int[] arr) {
        int result = 0;
        for(int i=2; i<n; i++) {
            int sum = k-arr[i];
            Map<Integer, Integer> innerMap = new HashMap<>();
            for(int j=0; j<i; j++) {
                int target = sum - arr[j];
                if(innerMap.containsKey(target)) {
                    result += innerMap.get(target);
                }
                int count = innerMap.getOrDefault(arr[j], 0);
                innerMap.put(arr[j], count + 1);
            }
        }
        System.out.println(result);
    }
}