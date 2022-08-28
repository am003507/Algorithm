package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 8..
 */
public class BJ_2644 {

    static int N, first, second, M, table[][], cnt = 0,chon[];
    static boolean check[];
    static Queue<Integer> que;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        first = Integer.parseInt(st.nextToken());
        second = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(bf.readLine());
        table = new int[N + 1][N + 1];
        check = new boolean[N + 1];
        chon = new int [N+1];
        que = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            table[x][y] = 1;
            table[y][x] = 1;
        }


        System.out.println(bfs());

    }

    public static int bfs() {
        que.add(first);
        check[first] = true;
        while (!que.isEmpty()) {
            int index = que.poll();
            cnt++;

            for (int i = 1; i <= N; i++) {
                if (table[index][i] == 1 && !check[i]) {
                    que.add(i);
                    check[i] = true;
                    chon[i]=chon[index]+1;

                    if (i == second) {
                        return chon[i];
                    }

                }

            }
        }
        return -1;

    }
}
