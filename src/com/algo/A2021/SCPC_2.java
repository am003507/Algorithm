package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 3. 2..
 */
public class SCPC_2 {
    static int T,N,input[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(bf.readLine());
        for(int i =1; i <=T;i++){
            StringTokenizer st  = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            input = new int[N];
            for(int j = 0; j<N;j++){
                input[j]= Integer.parseInt(bf.readLine());
            }
            Arrays.sort(input);
            int max =0,cnt =0;
            for(int k= 0;k<N;k++){
                max = Math.max(input[k]+N-k,max);
            }
            for(int k = 0 ; k<N;k++){
                if (input[k]+N >=max)cnt++;
            }
            sb.append("Case #" +i).append("\n");
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
