package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 24..
 */
public class BJ_2075 {

    static int N,table[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        table= new int [N*N];
        StringTokenizer st;

        for(int i =0,k=0 ; i <N;i++){
            st = new StringTokenizer(bf.readLine());
            for(int j =0;j<N;j++,k++){
                table[k]= Integer.parseInt(st.nextToken());
            }
        }
        Arrays.sort(table);
        System.out.println(table[(N*N)-N ]);
    }
}
