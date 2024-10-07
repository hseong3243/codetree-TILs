import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int h = Integer.parseInt(split[0]);
        int n = Integer.parseInt(split[1]);
        int[][] dp = new int[n+1][n+1];
        dp[h][h] = 1;
        for(int i=h; i<=n; i++) {
            for(int j=h; j<=n; j++) {
                if(i > j) {
                    continue;
                }
                dp[i][j] = dp[i-1][j] + dp[i][j-1] + dp[i][j];
            }
        }
        System.out.println(dp[n][n]);
    }
}