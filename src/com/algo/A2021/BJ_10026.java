package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ibyeongmu on 2017. 2. 7..
 */
public class BJ_10026 {
static int N;
static char table[][];
static boolean check[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        check = new boolean[N+1][N+1];
        for(int i =0 ; i< N;i++) {
            char input [] = bf.readLine().toCharArray();
            for(int j =0;j<N;j++) table[i][j] =input[j];
        }
        int cnt =0;
        for(int i =0 ; i < N ;i++)
        {
            for(int j =0 ; j<N;j++)
            {
                if(!check[i][j])
                {
                    proc(i,j);
                    cnt++;
                }
            }
        }
    }

    public static void proc(int x ,int y)
    {
        if(x<0||y<0||x>N||y>N) return ;
    }
}
