package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 1. 29..
 */
public class BJ_9466 {
    static int input[],parent[],cnt;
    static boolean visit[],finish[];


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        while(T-->0) {
            int N = Integer.parseInt(bf.readLine());
            input = new int[N+1];
             visit = new boolean[N+1];
             finish = new boolean[N+1];

            st = new StringTokenizer(bf.readLine());
            for(int i =1;i<=N;i++) {
                input[i]= Integer.parseInt(st.nextToken());
            }
             cnt =0;

            for(int i =1 ;i <=N;i++)
            {
                if(!visit[i]) dfs(i);
            }
            sb.append(N-cnt+"\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int idx)
    {

        if(finish[idx]) return ;
        visit[idx] =true;

        if(!visit[input[idx]])
        {
             dfs(input[idx]);
        }else
        {
           if(! finish[input[idx]])
           {
              for(int i = input[idx]; idx!= i;i=input[i]) cnt++;
              cnt++;
           }

        }


        finish[idx]=true;


        return ;



    }
}
