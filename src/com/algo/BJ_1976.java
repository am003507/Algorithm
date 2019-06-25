package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 25..
 */
public class BJ_1976 {
    static int N,M,map[][],root[];
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        M = Integer.parseInt(bf.readLine());
        visit = new boolean[N+1];
        map = new int [N+1][N+1];
        root = new int[M+1];
        StringTokenizer st;
        for(int i =1;i<=N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j =1;j<=N;j++){
                map[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(bf.readLine());
        for(int i = 0 ; i<M;i++) root[i]=Integer.parseInt(st.nextToken());
        DFS(root[0]);
        boolean ok = true;
        for(int i = 0;i<M;i++){
            if(!visit[root[i]]){
                ok = false;break;
            }
        }
        System.out.println(ok?"YES":"NO");
    }
    public static void DFS(int index){
        visit[index]=true;
        for(int i = 1;i<=N;i++){
            if(map[index][i]==1&&!visit[i]){
                DFS(i);
            }
        }
        return;
    }

}
