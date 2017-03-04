package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 20..
 */
public class BJ_1039 {
    static int K, len;
    static long N,value=-1;
    static Queue<Long> que;

    static HashSet<Long> visit;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        String str = st.nextToken();
        len = str.length();
        char input_num[] = str.toCharArray();
        N=0;
        for(int i = 0 ; i <len;i++){
            N <<=4;
            N+= input_num[i]-48;
        }

        K = Integer.parseInt(st.nextToken());
        que = new LinkedList<Long>();
        que.offer(N);
        BFS();

        if(value ==-1) {
            System.out.println(value);
        }else
        {
            StringBuilder sb = new StringBuilder();
            for(int i = len-1;i>=0;i--){
                 Long num = value &(15L<<(4*i));
                 num>>=(4*i);
                 sb.append(num);
            }
            System.out.println(sb);
        }
    }

    public static void BFS() {
        int cnt =0;
        while (!que.isEmpty()&&cnt<K) {
            visit=new HashSet<Long>();
            cnt++;
            int size = que.size();
            for (int i = 0; i < size; i++) {
                long input = que.poll();
                long first_idx, second_idx, first_num, second_num;
                for (int j = len - 1; j >= 1; j--) {
                    for (int k = j - 1; k >= 0; k--) {
                        long num = input;
                        first_num = num & (15L<<(4*j));
                        second_num = num & (15L<<(4*k));
                        num -= first_num;
                        num -= second_num;
                        first_num >>= (4*j);
                        second_num >>=(4*k);
                        num += first_num<<(4*k);
                        num += second_num << (4*j);
                        if ((num & (15L<<((len-1)*4)))==0) continue;
                        if(cnt==K) value = Math.max(value,num);
                        if(!visit.contains(num)) {
                            visit.add(num);
                            que.add(num);
                        }
                    }

                }


            }
        }


    }


}
