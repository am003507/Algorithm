package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 22..
 */
public class BJ_4803 {

    static int N, M, parent[], compo[], edge[];
    static boolean check[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int test=0;
        while (true) {
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;
            parent = new int[N + 1];
            compo = new int[N + 1];
            edge = new int[N + 1];
            check = new boolean[N + 1];
            for (int i = 1; i < N + 1; i++) parent[i] = i;
            Arrays.fill(compo, 1);
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(bf.readLine());
                merge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            int tree=0;
            for (int i = 1; i < N + 1; i++) {
                int idx = find(i);
                if (!check[idx]) {
                    if (compo[idx] - 1 == edge[idx]) {
                        tree++;
                    }
                    check[idx]=true;
                }
            }
            sb.append("Case "+ ++test+": ");
            if(tree ==0){
                sb.append("No trees.\n");
            }else if( tree ==1){
                sb.append("There is one tree.\n");
            }else {
                sb.append("A forest of "+tree+" trees.\n");
            }
        }
        System.out.println(sb);
    }
    public static int find(int idx) {
        if (idx == parent[idx]) return idx;
        else return parent[idx] = find(parent[idx]);
    }
    public static void merge(int a, int b) {
        int u = find(a);
        int v = find(b);
        if(u==v){
            edge[u]+=1;
            return;
        }
        if (u > v) {
            int temp = u;
            u = v;
            v = temp;
        }
        parent[v] = u;
        compo[u] += compo[v];
        edge[u] += (edge[v] + 1);
    }
}
