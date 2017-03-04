package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 박스 나누기 게임
 */
public class BJ_11867 {
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        dp = new int[100 + 1][100 + 1];
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i <= 100; i++) Arrays.fill(dp[i], -1);
        System.out.println(proc(N,M)==0?"A":"B");
    }
    static public int proc(int N, int M) {
        if (N <= 0 || M <= 0) return -1;
        if (N == 1 && M == 1) return 1;
        if (dp[N][M] != -1) return dp[N][M];
        boolean flag = false;
        for (int i = 1; i <= N&&!flag; i++) {
            if (proc(i, N - i) == 1) flag = true;
            if(proc(N-i,i)==1) flag =true;
            if(flag) break;
        }
        for (int i = 1; i <= M&&!flag; i++) {
            if (proc(i, M - i) == 1) flag = true;
            if(proc(M-i,i)==1) flag =true;
            if(flag) break;
        }
        return dp[N][M]=flag?0:1;



    }
}
