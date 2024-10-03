import java.util.*;
import java.io.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        new Main().solution(n,k,arr);
    }

    private void solution(int n, int k, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++) {
            int count = map.getOrDefault(arr[i], 0);
            map.put(arr[i], count + 1);
        }
        List<Integer> list = map.entrySet().stream()
        .sorted((a,b) -> {
            int compare = b.getValue() - a.getValue();
            if(compare == 0) {
                return b.getKey() - a.getKey();
            }
            return compare;
        })
        .map(entry -> entry.getKey())
        .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<k; i++) {
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}