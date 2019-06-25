package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 20..
 */
public class BJ_1182 {

    static int N,S,table[],cnt,total=0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st ;
        st= new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st= new StringTokenizer(bf.readLine());
        table= new int [N];
        for(int i =0;i<N;i++){
            table[i] =Integer.parseInt(st.nextToken());
        }
        cnt = (int) (Math.pow(2,N)-1);
        for(int i =1;i<=cnt;i++){
            int result =0;
            for(int j=0;j<N;j++){
                if((i&(1<<j)) !=0){
                    result +=table[j];
                }
            }
            if(result==S)total++;
        }

        System.out.println(total);

    }

}
