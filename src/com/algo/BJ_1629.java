package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 10..
 */
public class BJ_1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        A %= C;
        long result = 1;
        long dp[] = new long[40];
        dp[0] = A;
        for (int i = 1; i < 40; i++) {
            dp[i] = (dp[i - 1] * dp[i - 1]) % C;
        }
        int i = 32;
        while (i-- > 0) {
            if ((B & (1 << i)) > 0) {
                result = (result * (dp[i] % C)) % C;
            }
        }
        System.out.println(result);
    }

    }
