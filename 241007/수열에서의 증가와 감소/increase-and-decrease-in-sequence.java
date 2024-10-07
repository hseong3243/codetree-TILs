import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        boolean order = true;
        int len = 0;
        int prev = 0;
        for(int num : arr) {
            if(num > prev) {
                if(!order) {
                    len = 0;
                    order = true;
                }
            } else if(num < prev) {
                if(order) {
                    len = 0;
                    order = false;
                }
            }
            len++;
            prev = num;
            result = Math.max(result, len);
        }
        System.out.println(result);
    }
}