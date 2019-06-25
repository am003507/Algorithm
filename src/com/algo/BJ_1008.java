package com.algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BJ_1008 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        double N = Integer.parseInt(st.nextToken());
        double M = Integer.parseInt(st.nextToken());
        System.out.printf("%.9f", N/M);
    }
}
