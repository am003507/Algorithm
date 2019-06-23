package com.algo;

import java.io.*;
import java.util.StringTokenizer;

public class BJ_1912 {
    public static void main(String[] args) {

        Integer N = null;
        int input[]= null;

        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(bf.readLine());
            input = new int[N];
            String line = bf.readLine();
            StringTokenizer st = new StringTokenizer(line);
            for (int i =0 ; i <N ;i++){
                input[i]=Integer.parseInt(st.nextToken());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int ret =-3000;
        for (int i = 1;i<N ;i++){
            int sum = input[i]+input[i-1];
            ret = sum >ret ? sum:ret;
        }
        System.out.println(ret);
    }
}
