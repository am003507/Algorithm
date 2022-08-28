package com.algo.A2021;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1912 {
    public static void main(String[] args) {
        Integer N = null;
        int input[] = null;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(bf.readLine());
            input = new int[N + 1];
            String line = bf.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for (int i = 1; i <= N; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int dp[] = new int[N + 1];
        int ret = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (dp[i - 1] < 0) {
                dp[i] =input[i];
            } else {
                dp[i]= dp[i-1]+input[i];
            }
            ret = ret > dp[i] ? ret : dp[i];
        }
        System.out.println(ret);
    }
}
