package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_5427 {
    static int T, N, M, result[][];
    static char table[][];
    static boolean check[][], fire[][];
    static Queue<coordi> que, fire_que;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            st = new StringTokenizer(bf.readLine());
            que = new LinkedList<coordi>();
            fire_que = new LinkedList<coordi>();
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            table = new char[N + 1][M + 1];
            check = new boolean[N + 1][M + 1];
            fire = new boolean[N + 1][M + 1];
            result = new int[N + 1][M + 1];
            for (int i = 0; i < M; i++) {
                char input[] = bf.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    table[j][i] = input[j];
                    if (input[j] == '@') {
                        que.add(new coordi(j, i));
                        check[j][i] = true;
                    } else if (input[j] == '*') {
                        fire_que.add(new coordi(j, i));
                    }
                }
            }
            int value = BFS();
            sb.append(value == -1 ? "IMPOSSIBLE" : value).append("\n");
        }
        System.out.println(sb);
    }

    public static int BFS() {
        int dx[] = new int[]{-1, 1, 0, 0};
        int dy[] = new int[]{0, 0, 1, -1};
        int size =0;
        while (!que.isEmpty()) {

            size = fire_que.size();

            for (int j = 0; j < size; j++) {
                coordi item = fire_que.poll();
                for (int i = 0; i < 4; i++) {
                    int x = item.x + dx[i];
                    int y = item.y + dy[i];
                    if (x < 0 || y < 0 || x >= N || y >= M) {
                        continue;
                    }

                    if (table[x][y] == '.') {
                        table[x][y] = '*';
                        fire_que.add(new coordi(x, y));
                    }
                }
            }
             size = que.size();
            for (int j = 0; j < size; j++) {
                coordi item = que.poll();

                for (int i = 0; i < 4; i++) {
                    int x = item.x + dx[i];
                    int y = item.y + dy[i];
                    if (x < 0 || y < 0 || x >= N || y >= M) {
                        return result[item.x][item.y] + 1;
                    }
                    if (table[x][y] == '.' && !check[x][y]) {
                        que.add(new coordi(x, y));
                        check[x][y] = true;
                        result[x][y] = result[item.x][item.y] + 1;
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
