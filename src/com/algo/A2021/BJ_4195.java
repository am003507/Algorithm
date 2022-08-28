package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 25..
 */
public class BJ_4195 {
    static int N, com[], parent[], T, cnt;
    static HashMap<String, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            N = Integer.parseInt(bf.readLine());
            int max = (N*2)+1;
            parent = new int[max];
            com = new int[max];
            Arrays.fill(com, 1);
            for (int i = 0; i < max; i++) parent[i] = i;
            map = new HashMap<String, Integer>();
            cnt=0;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(bf.readLine());
                String name_1 = st.nextToken();
                String name_2 = st.nextToken();
                int idx_1, idx_2;

                if (!map.containsKey(name_1)) {
                    idx_1 = ++cnt;
                    map.put(name_1, idx_1);
                } else {
                    idx_1 = map.get(name_1);
                }
                if (!map.containsKey(name_2)) {
                    idx_2 = ++cnt;
                    map.put(name_2, idx_2);
                } else {
                    idx_2 = map.get(name_2);
                }
                idx_1 = find(idx_1);
                idx_2 = find(idx_2);
                if(idx_1 == idx_2){
                    sb.append(com[idx_1]).append("\n");
                }else{
                    sb.append(com[idx_1] + com[idx_2]).append("\n");
                }


                merge(idx_1, idx_2);

            }
        }
        System.out.println(sb);

    }

    public static int find(int idx) {
        if (idx == parent[idx]) return idx;
        else return parent[idx] = find(parent[idx]);
    }

    public static void merge(int f, int s) {
        int u = find(f);
        int v = find(s);
        if (u == v) return;
        else if (u > v) {
            int temp = u;
            u = v;
            v = temp;
        }
        parent[v] = u;
        com[u] += com[v];

    }


}
