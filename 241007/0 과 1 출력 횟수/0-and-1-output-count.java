import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        codeTree(n);
        System.out.println(one + " " + zero);
    }

    private static int one = 0;
    private static int zero = 0;

    private void codeTree(int n) {
        if (n == 0) {
            zero++;
        } else if(n==1) {  
            one++;
        } else {
            codeTree(n-1);
            codeTree(n-2);
        }
    }
}