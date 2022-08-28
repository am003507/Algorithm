package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 21..
 */
public class BJ_1987 {
    static int R,C,cnt=0,max=0;
    static char table[][];
    static boolean check[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        check = new boolean[30];
        table = new char[C+1][R+1];
        for(int i = 0 ; i <R;i++){
            char input[] = bf.readLine().toCharArray();
            for(int j=0;j<C;j++){
                table[j][i]=input[j];
            }
        }
        proc(0,0);
        System.out.println(max);
    }
    public static void proc(int x , int y){
        if(x<0||y<0||x>=C||y>=R) return;
        if(check[table[x][y]-'A']) {
            return;
        }else{
            check[table[x][y]-'A']=true;
            cnt++;
            max=Math.max(max,cnt);
        }
        int dx[] = new int[]{-1,1,0,0};
        int dy[] = new int[]{0,0,-1,1};
        for(int i =0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            proc(nx,ny);
        }
        check[table[x][y]-'A']=false;
        cnt--;



    }

}
