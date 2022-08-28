package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 11..
 */
public class BJ_7576 {
    static int N, M, table[][], non_cnt = 0, day_cnt = 0,cnt=0;
    static boolean check[][];
    static Queue<coordi> que;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        table = new int[N + 1][M + 1];
        check = new boolean[N + 1][M + 1];
        que = new LinkedList<coordi>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                table[j][i] = Integer.parseInt(st.nextToken());
                if (table[j][i] == 0) {
                    non_cnt++;
                } else if (table[j][i] == 1) {
                    que.add(new coordi(j, i));
                    check[j][i] = true;
                }
            }
        }
        int value = 0;
        if (non_cnt > 0) value = BFS();
        System.out.println(value);
    }
    public static int BFS() {
        int dy[] = new int[]{-1, 1, 0, 0};
        int dx[] = new int[]{0, 0, -1, 1};
        while (!que.isEmpty()) {
            day_cnt++;
            int size = que.size();
            for (int k = 0; k < size; k++) {
                coordi item = que.poll();

                for (int i = 0; i < 4; i++) {
                    int x = item.x + dx[i];
                    int y = item.y + dy[i];
                    if (x < 0 || y < 0 || x >= N || y >= M) continue;
                    if (!check[x][y] && table[x][y] == 0) {

                        cnt++;
                        que.add(new coordi(x, y));
                        check[x][y] = true;
                        if( cnt== non_cnt) return day_cnt;
                    }
                }
            }
        }
        return -1;
    }
    public static class coordi {
        int x, y;
        public coordi(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
