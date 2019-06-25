package com.algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BJ_2309 {
    public static void main(String[] args) {
        final int inputCnt = 9;
        int input[] = new int[inputCnt];
        int total = 0;
        try (BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))) {
            for (int i = 0; i < inputCnt; i++) {
                input[i] = Integer.parseInt(bf.readLine());
                total += input[i];
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        Arrays.sort(input);
        for (int i = 0; i < inputCnt; i++) {
            for (int j = i + 1; j < inputCnt; j++) {
                int ret = total - input[i] - input[j];
                if (ret == 100) {
                    for (int w = 0; w < inputCnt; w++) {
                        if (w != i && w != j) {
                            System.out.println(input[w]);
                        }
                    }
                    return;
                }
            }
        }
    }
}

