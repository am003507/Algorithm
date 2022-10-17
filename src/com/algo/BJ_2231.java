package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_2231 {

    final static int maxRange = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Integer N = Integer.parseInt(bf.readLine());
        int minValue = N / 2;
        int ret = 0;
        for (int i = minValue; i <= maxRange; i++) {
            int current = i;
            int sum = current;
            while (true) {
                sum += current % 10;
                current /= 10;
                if (current == 0) {
                    break;
                }
            }
            if (sum == N) {
                ret = i;
                break;
            }
        }
        System.out.println(ret);
    }
}
