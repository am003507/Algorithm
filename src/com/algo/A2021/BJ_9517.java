package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 16..
 */
public class BJ_9517 {
    static int K,N,table[];
    static char answer[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        K = Integer.parseInt(bf.readLine());
        N = Integer.parseInt(bf.readLine());
        table = new int [N+1];
        answer = new char [N+1];

        StringTokenizer st;

        for(int i =0 ; i < K ;i++) {
            st = new StringTokenizer(bf.readLine());
            table[i]=Integer.parseInt(st.nextToken());
            answer[i] = st.nextToken().charAt(0);
        }
        int time =0;
        K=K-1;
        int i =0;
        while(time<100) {

            time+= table[i];




            K = (K+1)%8;
        }


    }

}
