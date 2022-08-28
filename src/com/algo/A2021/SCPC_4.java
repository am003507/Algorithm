package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 징검다리
 *
 * dp 테이블에     이전에 k번 건너뛰어서 j 번째 돌을 밟을수있는 경우의 수를 저장한다
 */
public class SCPC_4 {

    static int T, N, K, L, mine[];
    static long dp[][],max[];
    static final long mod = 1000000009L;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            dp = new long[100+1][50000+1];
            max = new long[50000+1];
            mine = new int[50000 + 1];
            if (L != 0) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < L; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    mine[num] = 1;
                }
            }
            for(int j = 0 ; j <=K;j++) dp[j][0]=1;
            max[0]=2;
            for (int j = 1; j <= N; j++) {
                if (mine[j] == 1) continue;
                for (int k = 1; k <= K; k++) {
                    int before = j - k;
                    int current = j ;
                   if(j-k>=0) {
                        dp[k][current] = (max[before]+mod-dp[k][before])%mod;
                        max[current] +=dp[k][current];
                        max[current]%=mod;

                    }
                }
            }
            sb.append("Case #" +i).append("\n");
            sb.append(max[N]).append("\n");


        }
        System.out.println(sb);

    }
}
