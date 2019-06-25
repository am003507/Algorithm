package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 11..
 */
public class BJ_9019 {

    static int N, first, second, table[], where[];
    static Queue<Integer> que;
    static Stack<Integer> stack;
    static boolean check[];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        sb = new StringBuilder();
        while (N-- > 0) {
            st = new StringTokenizer(bf.readLine());
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());
            que = new LinkedList<Integer>();
            table = new int[10000 + 1];
            where = new int[10000 + 1];
            check = new boolean[10000 + 1];
            stack = new Stack<Integer>();
            que.add(first);
//            check[first] = true;
            BFS();

        }
        System.out.println(sb);

    }

    public static void BFS() {
        while (!que.isEmpty()) {
            int idx = que.poll();
            int dx[] = new int[]{D(idx), S(idx), L(idx), R(idx)};
            for (int i = 0; i < 4; i++) {
                if (dx[i] < 0 || dx[i] > 9999) continue;
                if (!check[dx[i]]) {
                    table[dx[i]] = i;
                    where[dx[i]] = idx;
                    check[dx[i]] = true;
                    que.add(dx[i]);
                    if (dx[i] == second) {
                        int num = dx[i];
                        while (num != first) {
                            stack.add(table[num]);
                            num = where[num];
                        }
                        if(stack.isEmpty()) sb.append("L");

                        while (!stack.isEmpty()) {
                            int ch = stack.pop();
                            if (ch == 0) sb.append("D");
                            else if (ch == 1) sb.append("S");
                            else if (ch == 2) sb.append("L");
                            else if (ch == 3) sb.append("R");
                        }
                        sb.append("\n");
                        return;


                    }
                }
            }
        }

        return;
    }

    public static int D(int num) {
        int ret = num * 2;
        if (ret > 9999) ret %= 10000;
        return ret;
    }

    public static int S(int num) {
        if (num - 1 < 0) return 9999;
        else return num - 1;
    }

    public static int L(int num) {
        int mod = 1000;
        int remainder = num%mod;
        int quotient = num/mod;
        return (remainder*10)+quotient;
    }

    public static int R(int num) {
        int mod = 10;
        int remainder = num%mod;
        int quotient = num/mod;
        return remainder*1000+quotient;
    }
}
