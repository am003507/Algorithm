package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 님게임
 */
public class BJ_11694 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int input[] = new int[N + 1];
        for (int i = 0; i < N; i++) input[i] = Integer.parseInt(st.nextToken());
      int result =0;
      boolean flag =false;
        for (int i = 0; i < N; i++) {
            if(input[i] ==1) flag =true;
            result ^= input[i];
        }
        if(flag)result --;
        System.out.println(result==0?"cubelover":"koosaga");
    }
}
