package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int i =1;
        while (true){
            st = new StringTokenizer(bf.readLine());
            int L = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            if( L == 0 && P==0 && V ==0){
                break;
            }
            int ret  = (V/P)*L +((V%P) > L ? L :(V%P));
            System.out.println("Case "+ i++ +": "+ret);
        }
    }
}