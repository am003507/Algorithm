package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 25..
 */
public class BJ_2696 {

    static int T,N,table[],mid;
    static PriorityQueue<Integer> lower,higher;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while(T-->0){
            N = Integer.parseInt(bf.readLine());
            table = new int[N+1];

            for(int i = 0,j=1 ; i <=N/10;i++){
                st = new StringTokenizer(bf.readLine());
                while (st.hasMoreTokens()){
                    table[j++]=Integer.parseInt(st.nextToken());
                }
            }
            lower = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2-o1;
                }
            });
            higher = new PriorityQueue<Integer>();
            sb.append( N%2==1?(N/2)+1:(N/2)).append("\n");
            for(int i =1,mid = table[1];i<=N;i++){
                if( mid >table[i]) lower.add(table[i]);
                else higher.add(table[i]);

                 if( i%2 ==1){
                     while(lower.size()!= higher.size()){
                         if(lower.size() >higher.size()){
                             if(i!=1)higher.add(mid);

                             mid = lower.poll();
                         }else{
                             if(i!=1)lower.add(mid);
                             mid = higher.poll();
                         }
                     }
                     sb.append(mid).append(" ");

                 }


            }
            sb.append("\n");



        }
        System.out.println(sb);



    }
}
