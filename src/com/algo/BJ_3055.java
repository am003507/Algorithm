package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 11..
 */
public class BJ_3055 {

    static int R,C;
    static char table[][];
    static boolean check[][];
    static Queue<coordi> que,water_q;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        water_q = new LinkedList<coordi>();
        que = new LinkedList<coordi>();
        check = new boolean[C+1][R+1];
        table = new char[C+1][R+1];
        for(int i =0;i<R;i++) {
            char input[] = bf.readLine().toCharArray();
            for(int j =0;j<C;j++) {
                table[j][i] = input[j];
                if(table[j][i]=='S'){
                    que.add(new coordi(j,i));
                    check[j][i] =true;
                }else if(table[j][i]=='*') {
                    water_q.add(new coordi(j,i));
                }
            }
        }
        int value = BFS();
        System.out.println(value==-1?"KAKTUS":value);


    }
    public static int BFS()
    {
        int dx[] = new int [] {-1,1,0,0};
        int dy [] = new int [] {0,0,1,-1};
        int size =0;
        int cnt=0;
        while(!que.isEmpty()){
            cnt++;
            size = water_q.size();
            for(int i =0;i<size;i++)
            {
                coordi item = water_q.poll();

                for(int j =0;j<4;j++)
                {
                    int next_x = item.x+dx[j];
                    int next_y = item.y+dy[j];
                    if(next_x<0||next_y<0||next_x>=C||next_y>=R){
                        continue;
                    }
                    if(table[next_x][next_y]=='.') {
                        table[next_x][next_y]='*';
                        water_q.add(new coordi(next_x,next_y));
                    }
                }
            }

            size = que.size();
            for(int i =0;i<size;i++)
            {
                coordi item = que.poll();

                for(int j =0;j<4;j++)
                {
                    int next_x = item.x+dx[j];
                    int next_y = item.y+dy[j];
                    if(next_x<0||next_y<0||next_x>=C||next_y>=R)continue;

                    if(!check[next_x][next_y]&& table[next_x][next_y]!='*'&&table[next_x][next_y]!='X')
                    {
                        que.add(new coordi(next_x,next_y));

                        check[next_x][next_y]=true;
                        if(table[next_x][next_y]=='D') return cnt;
                    }




                }


            }
        }
        return -1;


    }
    public static class coordi{
        int x,y;

        public coordi(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
