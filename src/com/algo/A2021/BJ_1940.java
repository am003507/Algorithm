package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 11..
 */
public class BJ_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int M  = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int table[] = new int [N];
        for(int i =0 ; i < N;i++) {
            table[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(table);
        int start = 0;
        int end = N-1;
        int cnt =0;
        while(start <end) {
            if(table[start]+table[end]<M) {
                start++;
            }else if (table[start]+table[end]>M) {
                end--;
            }
            else {
                start++;
                end--;
                cnt ++;
            }
        }

        System.out.println(cnt);






    }



}
