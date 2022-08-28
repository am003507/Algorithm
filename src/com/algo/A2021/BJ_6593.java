package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_6593 {
    static int L, R, C, result[][][];
    static char table[][][];
    static boolean check[][][];
    static Queue<coordi> que;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = "";


        while ((str = bf.readLine()) != null && str.length() != 0) {
            que = new LinkedList<coordi>();
            StringTokenizer st;
            st = new StringTokenizer(str);
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if(L==0&&R==0&&C==0) return;
            table = new char[L + 1][R + 1][C + 1];
            check = new boolean[L + 1][R + 1][C + 1];
            result = new int[L + 1][R + 1][C + 1];
            for (int k = 0; k < L; k++) {
                for (int i = 0; i < R; i++) {
                    char input[] = bf.readLine().toCharArray();
                    for (int j = 0; j < C; j++) {
                        table[k][i][j] = input[j];
                        if (input[j] == 'S') {
                            que.add(new coordi(k, i, j));
                            check[k][i][j] = true;
                        }
                    }
                }
                bf.readLine();
            }
            int value = BFS();
            if (value == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + value + " minute(s).");

            }
        }
    }

    public static int BFS() {
        while (!que.isEmpty()) {
            coordi item = que.poll();
            int dx[] = new int[]{-1, 1, 0, 0, 0, 0};
            int dy[] = new int[]{0, 0, 1, -1, 0, 0};
            int dz[] = new int[]{0, 0, 0, 0, 1, -1};
            for (int i = 0; i < 6; i++) {
                int next_x = item.x + dx[i];
                int next_y = item.y + dy[i];
                int next_z = item.z + dz[i];
                if (next_x < 0 || next_y < 0 || next_z < 0 || next_x > L || next_y > R || next_z > C) continue;
                if (!check[next_x][next_y][next_z]) {
                    if (table[next_x][next_y][next_z] == '.') {
                        que.add(new coordi(next_x, next_y, next_z));
                        check[next_x][next_y][next_z] = true;
                        result[next_x][next_y][next_z] = result[item.x][item.y][item.z] + 1;
                    } else if (table[next_x][next_y][next_z] == 'E') {
                        que.add(new coordi(next_x, next_y, next_z));
                        check[next_x][next_y][next_z] = true;
                        result[next_x][next_y][next_z] = result[item.x][item.y][item.z] + 1;
                        que.clear();
                        return result[next_x][next_y][next_z];
                    }
                }
            }
        }
        return -1;

    }

    public static class coordi {
        int x, y, z;

        public coordi(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
