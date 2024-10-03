import java.io.*;
import java.util.*;

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
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: arr) {
            int count = map.getOrDefault(i, 0);
            map.put(i, count + 1);
        }

        int result = 0;
        Arrays.sort(arr);
        for(int i=0; i<n-1; i++) {
            if(arr[i] * 2 == k) {
                result += map.get(arr[i]) - 1;
                map.put(arr[i], map.get(arr[i]) - 1);
                continue;
            }

            int min = i+1;
            int max = n-1;
            while(min <= max) {
                int idx = (min + max) / 2;
                int mid = arr[idx];
                int sum = mid + arr[i];
                if(sum > k) {
                    max = idx - 1;
                } else if(sum < k) {
                    min = idx + 1;
                } else {
                    result += map.get(mid);
                    break;
                }
            }
        }
        System.out.println(result);
    }
}