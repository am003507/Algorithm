package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 3. 1..
 */
public class BJ_1275 {
    static int N, Q, start;
    static long tree[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        for (start = 1; start < N; start *= 2) ;
        tree = new long[2 * start];
        for (int i = 1; i <= N; i++) update(i, Long.parseLong(st.nextToken()));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(x>y){
                int temp = x;
                x= y;
                y = temp;
            }
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(sum(x, y, 1, 1, start) + "\n");
            update(a, b);

        }
        System.out.println(sb);

    }

    public static void update(int idx, long val) {
        int index = start + idx-1;
        tree[index] = val;
        while (index > 1) {
            index /= 2;
            tree[index] = tree[index * 2] + tree[index * 2 + 1];
        }
    }

    public static long sum(int L, int R, int idx, int temp_L, int temp_R) {
        if (temp_R < L || R < temp_L) return 0;
        if (L <= temp_L && temp_R <= R) return tree[idx];
        int mid = (temp_L + temp_R) / 2;
        return sum(L, R, idx * 2, temp_L, mid) + sum(L, R, idx * 2 + 1, mid + 1, temp_R);

    }

}
