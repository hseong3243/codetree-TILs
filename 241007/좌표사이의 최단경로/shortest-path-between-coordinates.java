import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int h = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int a = Math.min(h, n);
        int b= Math.max(h, n);
        int[][] dp = new int[b+1][b+1];
        dp[a][a] = 1;
        for(int i=a; i<=b; i++) {
            for(int j=a; j<=b; j++) {
                if(i > j) {
                    continue;
                }
                if(i-1 > 0) {
                    dp[i][j] += dp[i-1][j];
                }
                if(j-1 > 0) {
                    dp[i][j] += dp[i][j-1];
                }
            }
        }
        System.out.println(Math.max(dp[a][a], dp[b][b]));
    }
}