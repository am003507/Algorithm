package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by ibyeongmu on 2017. 2. 24..
 */

public class BJ_11286 {
    static int N;
    static PriorityQueue<Integer> que;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        que = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Math.abs(o1) - Math.abs(o2);
            }
        });
        int num;
        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(bf.readLine());
            if (num == 0) {
                sb.append((que.size() == 0 ? 0 : que.poll()) + "\n");
            } else {
                que.offer(num);
            }
        }
        System.out.println(sb);
    }
}


