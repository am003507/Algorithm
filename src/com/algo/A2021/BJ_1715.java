package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Created by ibyeongmu on 2017. 2. 24..
 */
public class BJ_1715 {
    static int N;
    static PriorityQueue<Integer> que;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        que = new PriorityQueue<Integer>();
        for(int i =0;i<N;i++)que.add(Integer.parseInt(bf.readLine()));

        int sum =0;
        while(que.size()!=1){
            int a = que.poll();
            int b = que.poll();
            sum+= a+b;
            que.offer(a+b);
        }
        System.out.println(sum);


    }
}
