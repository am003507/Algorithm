package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 21..
 */
public class BJ_1327 {

    static int N,K;
    static long num=0,des=0;
    static Queue<Long> que;
    static HashSet<Long> visit;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        K =Integer.parseInt(st.nextToken());
        st= new StringTokenizer(bf.readLine());
        visit = new HashSet<Long>();
        que = new LinkedList<Long>();
        for(int i =0;i<N;i++){
            num<<=4;
            num +=Long.parseLong(st.nextToken());
        }
        for(int i = 1 ;i<=N;i++){
            des<<=4;
            des+=i;
        }
        que.add(num);
        visit.add(num);
        if(num == des)System.out.println(0);
        else System.out.println(BFS());

    }
    public static int BFS(){
        int cnt =0;
        while(!que.isEmpty()){
            cnt++;
            int size =que.size();
            for(int i =0; i<size;i++){
                long cur = que.poll();
                for(int j=0;j<=N-K;j++){
                    long value = cur;
                    long result =0,temp=0;
                    for(int t=0;t<K;t++){
                        temp = value &(15L<<(4*(t+j)));
                        value-=temp;
                        temp>>=(4*t);
                        result<<=4;
                        result +=temp;
                    }
                    value+=result;
                    if(value == des)return cnt;
                    if(!visit.contains(value)){
                        visit.add(value);
                        que.add(value);
                    }
                }

            }
        }
        return -1;


    }
}
