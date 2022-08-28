package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ibyeongmu on 2017. 2. 24..
 */
public class BJ_2014 {
    static int N, K, table[],  max, size = 0;
    static long heap[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        table = new int[K + 1];
        max = 100000;
        heap = new long[max+1];
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < K; i++) {
            int num = Integer.parseInt(st.nextToken());
            table[i] = num;
            enque(num);

        }
        for (int i = 0, before = -1; ; ) {
            long num = deque();
            if (num == before) continue;
            else {
                before = (int) num;
                i++;
                if (i == N) {
                    System.out.println(num);
                    break;
                }
                for (int j = 0; j < K; j++) {
                    long result = num * table[j];
                    enque(result);
                }
            }
        }
    }

    public static void enque(long num) {
        int idx = ++size;
        for (; idx > 1 && num < heap[idx / 2]; idx /= 2) {
            heap[idx] = heap[idx / 2];
        }
        heap[idx] = num;
    }

    public static long deque() {
        long ret = heap[1];
        long temp = heap[size--];
        int parent, child;
        for (parent = 1, child = 2; child <= size && temp > heap[child]; parent = child, child *= 2) {
            if (child<size&&heap[child] > heap[child + 1]) child++;
            heap[parent] = heap[child];
        }
        heap[parent] = temp;
        return ret;


    }

}
