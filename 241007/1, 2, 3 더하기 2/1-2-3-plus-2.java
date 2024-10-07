import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n+1][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;
        for(int i=4; i<=n; i++) {
            dp[i][1] = (dp[i-1][2] + dp[i-1][3]) % 1_000_000_007;
            dp[i][2] = (dp[i-2][1] + dp[i-2][3]) % 1_000_000_007;
            dp[i][3] = (dp[i-3][1] + dp[i-3][2]) % 1_000_000_007;
        }
        int result = 0;
        for(int i=1; i<=3; i++) {
            result = (result + dp[n][i]) % 1_000_000_007;
        }
        System.out.println(result);
    }
}