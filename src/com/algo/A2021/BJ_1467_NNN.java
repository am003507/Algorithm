package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * 수 지우기
 */
public class BJ_1467_NNN {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        String N = new BigInteger(bf.readLine()).toString();
        String K = new BigInteger(bf.readLine()).toString();
        int first_idx =-1,last_idx=-1,N_length,K_length;
        N_length = N.length();
        K_length=K.length();
        char Arr_N[]  = N.toCharArray();
        char Arr_K[] = K.toCharArray();
        boolean flag =false;
        StringBuilder sb = new StringBuilder("0");
        for(int i =0;i<=N_length-K_length;i++) {
            for(int j=i,temp=0;j<i+K_length;j++) {
                if(Arr_N[j] == Arr_K[j-i]){
                    if(j-i==0) temp = j;
                    if(j-i== K_length-1){
                        first_idx = temp;
                        last_idx = j;
                        if(last_idx!=N_length-1) {
                            if(Arr_N[last_idx] <Arr_N[last_idx+1]) flag = true;
                        }
                    }
                }else {
                    break;
                }
            }
            if(flag) break;
        }
        if(first_idx!=-1&&last_idx !=-1) {
            for (int i = 0; i < first_idx; i++)
                sb.append(Arr_N[i]);
            for (int i = last_idx + 1;i<N_length;i++ )
                sb.append(Arr_N[i]);
            System.out.println(new BigInteger(sb.toString()));
        }else {
            System.out.println(N);
        }
    }
}
