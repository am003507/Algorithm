package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 4..
 */
public class BJ_1012 {
    static int M,N,K,table[][];
    static boolean check[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(T-->0)
        {
            st = new StringTokenizer(bf.readLine());
             M = Integer.parseInt(st.nextToken());
             N = Integer.parseInt(st.nextToken());
             K = Integer.parseInt(st.nextToken());
             table = new int[M+1][N+1];
             check  = new boolean[M+1][N+1];
            int cnt =0;
            for(int i =0;i<K;i++)
            {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                table[x][y]=1;
            }


            for(int i =0;i<M;i++) {
                for(int j =0 ; j<N;j++) {
                    if(proc(i,j)) cnt++;
                }
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }

    public static boolean proc(int x,int y)
    {
        if(x<0||y<0 ||x>=M||y>=N) return false;
        if(check[x][y])return false;

        int dx[] = new int[]{-1,1,0,0};
        int dy[] = new int[]{0,0,-1,1};

        if(table[x][y] ==1&&!check[x][y])
        {
            check[x][y]=true;
            for(int i =0;i<4;i++) {
                proc(x+dx[i],y+dy[i]);
            }
            return true;

        }



        return false;



    }
}
