package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 7..
 */
public class BJ_11403 {

    static int  N , table[][];
    static boolean check[][];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        table  = new int [N+1][N+1];
        check = new boolean[N+1][N+1];
        StringTokenizer st;
        for(int i =0 ; i<N;i++) {
            st= new StringTokenizer(bf.readLine());
            for(int j =0; j<N;j++) {
                table[i][j]= Integer.parseInt(st.nextToken());
            }
        }
        for(int i =0 ; i<N;i++)
        {
            for(int j=0;j<N;j++)
            {
                if(table[i][j]==1&&!check[i][j]) {
                    check [i][j]=true;
                    boolean flag = false;
                    for(int k =0 ;k<N;k++) {
                        if(table[j][k]==1) {
                            table[i][k] = 1;
                            flag = true;
                        }
                    }
                    if(flag) j = -1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i =0 ;i<N;i++) {
            for(int j =0 ;j<N;j++) {
                sb.append(table[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);




    }
}
