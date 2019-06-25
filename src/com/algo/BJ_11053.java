package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 28..
 */
public class BJ_11053 {
    static int N,input[],dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        dp = new int [ N];
        input = new int [N];
        for(int i =0 ; i <N ;i++ ){
            input[i] = Integer.parseInt(st.nextToken());
        }

//        Arrays.fill(dp,1);
        for(int i =1 ;i<N;i++){

            for(int j=0;j<i;j++){
                if(input[j] <input[i])
                    dp[i] = Math.max(dp[i],dp[j]+1);
            }
        }
        int result =0 ;
        for(int i =0 ; i< N;i++){
            result =Math.max(dp[i],result);
        }

        System.out.println(result+1);





    }
}
