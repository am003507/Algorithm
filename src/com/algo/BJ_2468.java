package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 7..
 */
public class BJ_2468 {
    static int N, table[][];
    static boolean check[][];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        table = new int[N + 1][N + 1];
        check = new boolean[N + 1][N + 1];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;

        for (int k = 0; k <= 100; k++) {
            int cnt = 0;
            check = new boolean[N + 1][N + 1];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (!check[i][j]&&table[i][j] > k) {
                        proc(i, j, k);
                        cnt++;

                    }

                }
            }
            result = Math.max(result,cnt);
        }
        System.out.println(result);

    }

    public static int proc(int x, int y, int height) {

        if (x < 0 || y < 0 || x > N || y > N) return 0;
        if (check[x][y] || table[x][y] <= height) return 0;
        check[x][y] = true;

        int dx[] = new int[]{-1, 1, 0, 0};
        int dy[] = new int[]{0, 0, 1, -1};
        for (int i = 0; i < 4; i++) {
            proc(x + dx[i], y + dy[i], height);
        }


        return 0;


    }
}
