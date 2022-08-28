package com.algo.A2021;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BJ_9663 {
    static int N, cnt = 0, max = 0;
    static boolean check[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        check = new boolean[N + 1][N + 1];
        proc(0, 0);
        System.out.println(max);
    }
    public static boolean chec(int x, int y) {
        for (int i = 1; i < N; i++) {
            if (y - i >= 0) {
                if (x - i >= 0) {
                    if (check[x - i][y - i]) return false;
                }
                if (x + i < N) {
                    if (check[x + i][y - i]) return false;
                }
                if (check[x][y - i]) return false;
            }
        }
        return true;
    }
    public static void proc(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= N) return;
        for (int i = 0; i < N; i++) {
            if (chec(i, y)) {
                if (y + 1 == N) {
                    max++;
                    return;
                }
                check[i][y] = true;
                proc(i, y + 1);
                check[i][y] = false;
            }
        }
    }


}
