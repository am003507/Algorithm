package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 23..
 */
public class BJ_1967 {
    static int N, total = 0;
    static ArrayList<node> tree[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        tree = new ArrayList[N + 1];
        for (int i = 0; i <=N; i++) {
            tree[i] = new ArrayList<node>();

        }
        StringTokenizer st;

        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(bf.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            tree[parent].add(new node(child, weight));
        }
        DFS(1);
        System.out.println(total);

    }

    public static int DFS(int idx) {
        int size, max = 0, sub_1=0,sub_2=0;
        size = tree[idx].size();
        for (int i = 0; i < size; i++) {
            node item = tree[idx].get(i);
            int result = DFS(item.idx)+item.weight;
            if(result > sub_1){
                sub_2=sub_1;
                sub_1=result;
            }else if( result>sub_2){
                sub_2 =result;
            }

        }
        total = Math.max((sub_1+sub_2), total);
        return sub_1;

    }

    public static class node {
        int idx, weight;

        public node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }
}
