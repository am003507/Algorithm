package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 3. 1..
 */
public class BJ_12015_2 {
    static int N, tree[], input[], max, start;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());

        input = new int[N];
        max = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            max = Math.max(max, num);
            input[i] = num;
        }
        for (start = 1; start < max; start *= 2) ;
        tree = new int[start * 2];
        int result = 0;
        for (int i = 0; i < N; i++) {
            int len = find(1, input[i] - 1, 1, 1, start-1) + 1;
            update(input[i], len);
            result = Math.max(result, len);

        }
        System.out.println(result);
    }

    public static int find(int L, int R, int idx, int temp_L, int temp_R) {
        if (temp_R < L || temp_L > R) return 0;
        if (L <= temp_L && temp_R <= R) return tree[idx];
        int mid = (temp_L + temp_R) / 2;
        return Math.max(find(L, R, idx * 2, temp_L, mid), find(L, R, idx * 2 + 1, mid + 1, temp_R));
    }

    public static void update(int idx, int val) {

        int index = idx + start - 1;
        tree[index] = val;
        while (index > 1) {
            index /= 2;
            tree[index] = Math.max(tree[index * 2], tree[index * 2 + 1]);
        }


    }

}
