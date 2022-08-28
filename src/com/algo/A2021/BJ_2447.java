package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by ibyeongmu on 2017. 2. 12..
 */
public class BJ_2447 {

    static int N;
    static char table[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        table= new char [N+1][N+1];
        StringBuilder sb = new StringBuilder();
        for(int i =1;i<=N;i++) Arrays.fill(table[i],' ');
        proc(1,N,1,N);
        for(int i = 1;i<=N;i++) {
            for(int j = 1 ; j<=N;j++)sb.append(table[i][j]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    public static void proc(int x_start , int x_end,int y_start,int y_end) {
        if(x_start == x_end ) {
            table[x_start][y_start] ='*';
            return ;
        }
            int num =x_end-x_start+1;
        int dx[][] = new int [][]{{1,num/3},{(num/3)+1,(num*2)/3},{((num*2)/3)+1,num}};
        for(int i =0;i<3;i++){
            for(int j =0;j<3;j++){
                if(!(i==1&&j==1)){
                    proc(x_start-1+dx[i][0],x_start-1+dx[i][1],y_start-1+dx[j][0],y_start-1+dx[j][1] );
                }
            }
        }

    }
}
