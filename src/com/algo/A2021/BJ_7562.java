package com.algo.A2021;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class BJ_7562 {
    static int T, N, table[][];
    static boolean check[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(bf.readLine());
            int dx[] = new int[]{-1, -2, 1, 2, -1, -2, 1, 2};
            int dy[] = new int[]{2, 1, 2, 1, -2, -1, -2, -1};
            table = new int[N + 1][N + 1];
            check = new boolean[N + 1][N + 1];
            Queue<coordi> que = new LinkedList<coordi>();
            StringTokenizer st;
            st = new StringTokenizer(bf.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            que.add(new coordi(x, y));
            check[x][y] = true;
            st = new StringTokenizer(bf.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            while (!que.isEmpty()) {
                coordi item = que.poll();
                for (int i = 0; i < 8; i++) {
                    int next_x = item.x + dx[i];
                    int next_y = item.y + dy[i];
                    if (next_x < 0 || next_y < 0 || next_x >= N || next_y >= N) continue;
                    if (!check[next_x][next_y]) {
                        check[next_x][next_y] = true;
                        que.add(new coordi(next_x, next_y));
                        table[next_x][next_y] = table[item.x][item.y] + 1;
                        if (next_x == x && next_y == y) {
                            que.clear();
                            break;
                        }


                    }
                }


            }
            sb.append(table[x][y] + "\n");


        }
        System.out.println(sb);
    }

    static public class coordi {
        int x, y;

        public coordi(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
