package com.algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
/**
 * Created by ibyeongmu on 2017. 1. 26..
 */
public class BJ_1003 {
    static int dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        dp = new int[2][40+1];
        Arrays.fill(dp[0],-1);
        Arrays.fill(dp[1],-1);
        dp[0][0]=1;dp[1][0]=0;
        dp[0][1]=0;dp[1][1]=1;
        StringBuilder sb = new StringBuilder();
        while(T-->0) {
            int N = Integer.parseInt(bf.readLine());
            sb.append(proc(0,N)+" ").append(proc(1,N)+"\n");
        }
        System.out.println(sb);
    }
    public static int proc(int flag,int index)
    {
        if(index<0)return 0;
        if(dp[flag][index]!=-1)return dp[flag][index];
        dp[flag][index] =0;
        dp[flag][index]+=proc(flag,index-1);
        dp[flag][index]+=proc(flag,index-2);
        return dp[flag][index];
    }
}
