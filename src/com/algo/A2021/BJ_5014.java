package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 9..
 */
public class BJ_5014 {

    static int F, S, G, U, D, table[];
    static boolean check[];


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        table = new int[F + 1];
        check = new boolean[F + 1];


        if(S==G) {
        System.out.println(0);
        }
        else {
            int result = BFS(S, G);
            System.out.println(result == -1 ? "use the stairs" : result);
        }
    }

    public static int BFS(int S, int G) {
        Queue<Integer> que = new LinkedList<Integer>();
        que.add(S);
        check[S] = true;
        int del[] = new int[]{U, -D};


        while (!que.isEmpty()) {
            int idx = que.poll();

            for (int i = 0; i < 2; i++) {
                int next = idx + del[i];
                if(next<=0||next>F) continue;

                if (!check[next]) {
                    check[next] = true;
                    table[next] = table[idx] + 1;
                    que.add(next);
                    if (next == G) {
                        que.clear();
                        return table[next];
                    }
                }
            }
        }
        return -1;


    }


}
