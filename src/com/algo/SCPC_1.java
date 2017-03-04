package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 숫자 골라 내기
 */
public class SCPC_1 {
    static int N, T, input[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= T; i++) {
            N = Integer.parseInt(bf.readLine());
            st = new StringTokenizer(bf.readLine());
            input = new int[N];
            for (int k = 0; k < N; k++) {
                input[k] = Integer.parseInt(st.nextToken());

            }
            int result = 0;
            for (int k = 0; k < N; k++) {

                result ^= input[k];

            }
            sb.append("Case #" + i + "\n").append(result + "\n");


        }
        System.out.println(sb);


    }
}
