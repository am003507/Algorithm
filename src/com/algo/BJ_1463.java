package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_1463 {
    final static int max = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(bf.readLine());
        int dp[] = new int[max + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 1; i <= max; i++) {
            if (i + 1 <= max) {
                dp[i + 1] = dp[i + 1] > dp[i] + 1 ? dp[i] + 1 : dp[i + 1];
            }

            if (i * 2 <= max) {
                dp[i * 2] = dp[i * 2] > dp[i] + 1 ? dp[i] + 1 : dp[i * 2];
            }

            if (i * 3 <= max) {
                dp[i * 3] = dp[i * 3] > dp[i] + 1 ? dp[i] + 1 : dp[i * 3];
            }
        }
        System.out.println(dp[N]);
    }
}