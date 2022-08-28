package com.algo.A2021;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class BJ_1068 {
    static int N, table[][], input[], root;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        table = new int[N][N];
        input = new int[N];
        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken());
            if (idx == -1) {
                root = i;
                continue;
            }
            table[idx][i] = 1;
        }
        int delete = Integer.parseInt(bf.readLine());
        for (int i = 0; i < N; i++) table[i][delete] = 0;
        Arrays.fill(table[delete], 0);
        if (root != delete) {
            System.out.println(DFS(root));
        } else {
            System.out.println(0);
        }
    }
    public static int DFS(int idx) {
        int ret = 0;
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            if (table[idx][i] == 1) {
                ret += DFS(i);
                flag = true;
            }
        }
        if (!flag) ret++;
        return ret;
    }
}
