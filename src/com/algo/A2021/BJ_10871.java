package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 10..
 */
public class BJ_10871 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());

        int N  = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<N;i++)
        {
            int num =  Integer.parseInt(st.nextToken());
            if(num<X) sb.append(num+" ");
        }
        System.out.println(sb);




    }
}
