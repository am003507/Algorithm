package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  누울 자리를 찾아라
 */
public class BJ_1652 {

    static int N,height[][],input[][],width[][];
    static boolean check[][];
    static int width_cnt=0,height_cnt=0;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        height = new int [N+1][N+1];
        width = new int [N+1][N+1];
        input = new int[N+1][N+1];
        for(int j =1;j<=N;j++) {
            char str[] = bf.readLine().toCharArray();
            for(int i =1;i<=N;i++) input[j][i] = str[i-1]=='X'?2:1;
        }
        for(int j=1;j<=N;j++) {
            for(int i =1;i<=N;i++) {
                if(input[j][i]==1) {
                    height[j][i]=width[j][i] =1;
                    if(width[j][i-1]==1){
                        width[j][i]=2;
                        width_cnt++;
                    }else if(width[j][i-1]==2){
                        width[j][i]=2;
                    }
                    if(height[j-1][i]==1) {
                        height[j][i]=2;
                        height_cnt++;
                    }else if(height[j-1][i]==2) {
                        height[j][i]=2;
                    }
                }
            }
        }
        System.out.println(width_cnt+" "+ height_cnt);



    }
}
