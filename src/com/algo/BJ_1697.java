package com.algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/**
 * Created by ibyeongmu on 2017. 2. 11..
 */
public class BJ_1697 {
    static int N, M, table[], cnt = 0;
    static boolean check[];
    static Queue<Integer> que;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        check = new boolean[100000+1];
        table = new int[100000+1];
        que = new LinkedList<Integer>();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        que.add(N);
        if(M!=N) System.out.println(BFS());
        else System.out.println(0);
    }
    public static int BFS() {
        while (!que.isEmpty()) {
            cnt++;
            int size = que.size();
            for (int j = 0; j < size; j++) {
                int idx = que.poll();
                int[] vec = new int[]{idx - 1, idx + 1, 2 * idx};
                for (int i = 0; i < 3; i++) {
                    if (vec[i] < 0 || vec[i] > 100000) continue;
                    if (!check[vec[i]]) {
                        que.add(vec[i]);
                        check[vec[i]] = true;
                        if (vec[i] == M) return cnt;
                    }
                }
            }
        }
        return -1;
    }
}
