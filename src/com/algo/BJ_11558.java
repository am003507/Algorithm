package com.algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by ibyeongmu on 2017. 2. 13..
 */
public class BJ_11558 {
    static int T,N,table[];
    static boolean check [];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        while(T-->0) {
            N = Integer.parseInt(bf.readLine());
            table = new int[N+1];
            check = new boolean[N+1];
            for(int i =1 ;i <=N;i++) table[i]= Integer.parseInt(bf.readLine());
            int idx=1,cnt =0;
            boolean flag = false;
            while(!check[idx]){
                check[idx]=true;
                if(idx==N) {
                    flag = true;
                    break;
                }
                idx = table[idx];
                cnt++;
            }
            System.out.println(flag?cnt:0);
        }
    }
}
