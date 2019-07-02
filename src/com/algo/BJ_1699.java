package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_1699 {

    final static int max = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(bf.readLine());
        int dp[] = new int[max + 1];

        for (int i = 0; i <= N; i++) {
            dp[i] = i;

            for (int j = 0; j * j <= i; j++) {
                if (dp[i - j * j] + 1 < dp[i]) {
                    dp[i] = dp[i - j * j] + 1;
                }
            }
        }
        System.out.println(dp[N]);
    }
}