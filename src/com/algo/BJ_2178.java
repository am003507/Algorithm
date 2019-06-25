package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 8..
 */
public class BJ_2178 {
    static int N,M,table[][],dp[][];
    static boolean check [][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N+1][M+1];
        dp = new int [N+1][M+1];
        table = new int[N+1][M+1];
        for(int i =1;i<=N;i++) {
            char input[] = bf.readLine().toCharArray();
            for(int j =1;j<=M;j++) {
                table[i][j]= input[j-1]-48;
            }
        }
        BFS();
        System.out.println(dp[N][M]);
    }
    public static void BFS()
    {
        int dx [] = new int [] {-1,1,0,0};
        int dy [] = new int [] { 0,0,1,-1};
        Queue<coordi> que = new LinkedList<coordi>();
        que.add(new coordi(1,1));
        check[1][1]=true;
        dp[1][1]=1;


        while(!que.isEmpty())
        {
            coordi temp = que.poll();

            for(int i=0;i<4;i++)
            {

                int next_x = temp.x+dx[i];
                int next_y = temp.y+dy[i];
                if( next_x<0 ||next_x>N||next_y<0||next_y>M) continue;
                if(table[next_x][next_y]==1 && !check[next_x][next_y])
                {
                    check[next_x][next_y]=true;
                    dp[next_x][next_y] =dp[temp.x][temp.y]+1;
                    que.add(new coordi(next_x,next_y));
                }
            }
        }



    }
    static public class coordi
    {
        int x,y;

        public coordi(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
