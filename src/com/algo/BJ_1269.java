package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 23..
 */
public class BJ_1269 {

    static int N, M, Ar[], Br[];
    static HashSet<Integer> A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        B = new HashSet<Integer>();
        Ar = new int[N + 1];

        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < N; i++) {
            Ar[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < M; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (B.contains(Ar[i])) cnt++;
        }
//        for (int i = 0; i < M; i++) {
//            if (!A.contains(Br[i])) cnt++;
//        }
        System.out.println(N+M-(cnt*2));


    }
}
