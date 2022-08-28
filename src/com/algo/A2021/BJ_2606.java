package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 바이러스
 */
public class BJ_2606 {
    static int N,M,cnt,parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st ;
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        parent = new int [N+1];
        for(int i =1;i<=N;i++) parent[i]=i;

        for(int i=0;i<M;i++) {
            st = new StringTokenizer(bf.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            merge(N,M);
        }
        for(int i=2;i<=N;i++) if(find(i)==1)cnt++;
        System.out.println(cnt);
    }
    public static int find(int vertex) {
        if(vertex==parent[vertex]) return vertex;
        else return parent[vertex] = find(parent[vertex]);
    }
    public static void merge(int a,int b) {
        a = find(a);
        b = find(b);
        if(a==b)return ;
        else {
            if(b>a) {
                int temp =a;
                a=b;
                b=temp;
            }
            parent[a]=b;
        }
    }
}
