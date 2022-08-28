package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 28..
 */
public class BJ_2357 {
    static int N, M, max_tree[], start, min_tree[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        for (start = 1; start < N; start *= 2) ;

        max_tree = new int[2 * start];
        min_tree = new int[2 * start];

        Arrays.fill(min_tree, Integer.MAX_VALUE);
        Arrays.fill(max_tree, Integer.MIN_VALUE);
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(bf.readLine());
            max_tree[start + i] = num;
            min_tree[start + i] = num;
        }
        make_max();
        make_min();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(get_min(a, b, 1, 1, start - 1)).append(" ");
            sb.append(get_max(a, b, 1, 1, start - 1)).append("\n");
        }
        System.out.println(sb);
    }

    public static int get_max(int L, int R, int idx, int temp_L, int temp_R) {
        if (temp_L > R || temp_R < L) return Integer.MIN_VALUE;
        if (L <= temp_L && temp_R <= R) return max_tree[idx];
        int mid = (temp_L + temp_R) / 2;

        return Math.max(get_max(L, R, idx * 2, temp_L, mid), get_max(L, R, idx * 2 + 1, mid + 1, temp_R));
    }

    public static int get_min(int L, int R, int idx, int temp_L, int temp_R) {
        if (temp_L > R || temp_R < L) return Integer.MAX_VALUE;
        if (L <= temp_L && temp_R <= R) return min_tree[idx];
        int mid = (temp_L + temp_R) / 2;

        return Math.min(get_min(L, R, idx * 2, temp_L, mid), get_min(L, R, idx * 2 + 1, mid + 1, temp_R));
    }


    public static void make_min() {

        int idx = start  - 1;
        while (idx > 0) {
            min_tree[idx] = Math.min(min_tree[idx * 2], min_tree[idx * 2 + 1]);
            idx--;
        }
    }

    public static void make_max() {

        int idx = start - 1;
        while (idx > 0) {
            max_tree[idx] = Math.max(max_tree[idx * 2], max_tree[idx * 2 + 1]);
            idx--;
        }
    }
}
