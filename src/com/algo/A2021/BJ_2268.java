package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 3. 1..
 */
public class BJ_2268 {
    static int N, M, start;
    static long tree[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (start = 1; start < N; start *= 2) ;

        tree = new long[2 * start];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int method = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());


            if (method == 0) {

                if (x > y) {
                    int temp = x;
                    x = y;
                    y = temp;
                }
                sb.append(sum(x, y, 1, 1, start)).append("\n");
            } else if (method == 1) {
                update(x, y);
            }
        }
        System.out.println(sb);
    }

    public static void update(int idx, int val) {
        int index = start + idx - 1;
        tree[index] = val;
        while (index > 1) {
            index /= 2;
            tree[index] = tree[index * 2] + tree[index * 2 + 1];
        }
    }

    public static long sum(int L, int R, int idx, int temp_L, int temp_R) {
        if (temp_R < L || temp_L > R) return 0;
        if (L <= temp_L && temp_R <= R) return tree[idx];
        int mid = (temp_L + temp_R) / 2;
        return sum(L, R, idx * 2, temp_L, mid) + sum(L, R, idx * 2 + 1, mid + 1, temp_R);
    }


}
