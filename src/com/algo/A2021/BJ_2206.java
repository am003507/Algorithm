package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 11..
 */
public class BJ_2206 {

    static int N,M, table[][],result[][][];
    static boolean check [][][];
    static Queue<coordi> que;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        table = new int [M+1][N+1];
        result = new int [M+1][N+1][2];
        check = new boolean [M+1][N+1][2];
//        for(int i = 0;i<2;i++){
//            for(int j=0;j<M;j++) Arrays.fill(result[i][j],1000001);
//        }
        for(int i = 0 ; i < N;i++) {
            char input[]= bf.readLine().toCharArray();
            for(int j=0;j<M;j++) {
                table[j][i]= input[j]-48;
            }
        }
        que = new LinkedList<coordi>();

        que.add(new coordi(0,0,0));
        check[0][0][0]=true;
        check[0][0][1]=true;
        BFS();
        int value =10000001;

        for(int i = 0 ; i < 2;i++)
        {
            result[M-1][N-1][i] =result[M-1][N-1][i]==0?10000001:result[M-1][N-1][i];
            value =Math.min(value,result[M-1][N-1][i]);
        }

        System.out.println(value==10000001?"-1":(value+1));








    }

    public static void BFS()
    {
        int dy[] = new int []{-1,1,0,0};
        int dx[] = new int []{0,0,-1,1};
        while(!que.isEmpty()){
            coordi item = que.poll();
            for(int i =0;i<4;i++){
                int x = item.x+dx[i];
                int y = item.y+dy[i];
                if(x<0||y<0||x>=M||y>=N) continue;
               if(table[x][y]==0 && item.z==0){
                   if(!check[x][y][0])
                   {
                       que.add(new coordi(x,y,0));
                       check[x][y][0]=true;
                       result[x][y][0]=result[item.x][item.y][0]+1;
                   }
               }else if( table[x][y]==0&&item.z==1)
               {
                   if(!check[x][y][1])
                   {
                       que.add(new coordi(x,y,1));
                       check[x][y][1]=true;
                       result[x][y][1]=result[item.x][item.y][1]+1;
                   }

               }else if( table[x][y]==1&&item.z==0)
               {
                   if(!check[x][y][1])
                   {
                       que.add(new coordi(x,y,1));
                       check[x][y][1]=true;
                       result[x][y][1]=result[item.x][item.y][0]+1;
                   }
               }
            }
        }

    }

    public static class coordi {
        int x,y,z;

        public coordi(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
}
