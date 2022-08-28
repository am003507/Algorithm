package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

/**
 *  바이러스 대책
 *
 */
public class SCPC_5 {
    static int T, N,  min, dp[];
    static long max;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        dp = new int[100001];
        Arrays.fill(dp, -1);
        for (int k = 1; k <= T; k++) {
            N = Integer.parseInt(bf.readLine());

//            m = m.pow(N);
            BigInteger m = new BigInteger("1");

            for(int i = 0 ; i < N;i++){
                m = m.multiply(BigInteger.valueOf(2));
            }
//            max = (long) Math.pow(2, N);

            for (int i = 1; i <= 10000; i++) {
                int num = proc(i);
                if (num == N) {
                    sb.append("Case #" + k).append("\n");
                    sb.append(i + " " + m + "\n");
                    break;
                }
            }
        }
        System.out.println(sb);
    }
    public static int proc(int idx) {
        if (idx > 10000) return -1;
        if (idx == 1) return 0;
        if (dp[idx] != -1) return dp[idx];

        int result = 0;
        if (idx % 2 == 0) {
            result = proc(idx / 2);
        } else {
            result = proc(3 * idx + 1);
        }
        if(result!=-1)dp[idx] = result + 1;
        return dp[idx];
    }
}
