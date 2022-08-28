package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 25..
 */
public class BJ_1717 {
    static int N,M,parent [];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i =0;i<=N;i++)parent[i]=i;
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<M;i++){
            st = new StringTokenizer(bf.readLine());
            int method = Integer.parseInt(st.nextToken());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            if(method ==0){
                merge(first,second);
            }else {
                sb.append(find(first)==find(second)?"YES":"NO").append("\n");
            }

        }
        System.out.println(sb);



    }

    public static int find(int vertex){
        if(parent[vertex]==vertex)return vertex;
        else return parent[vertex]= find(parent[vertex]);
    }
    public static void merge(int f,int s){

        int u = find(f);
        int v = find(s);
        if(u>v){
            int temp = v;
            v = u;
            u =temp;
        }
        parent[v]=u;



    }



}
