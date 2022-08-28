package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 22..
 */
public class BJ_1991 {

    static int N,max;
    static char tree[];
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        sb = new StringBuilder();
        max = (int) Math.pow(2,N);
        tree= new char [max];
        Arrays.fill(tree,'-');
        tree[1] = 'A';
        for(int i =0 ; i < N ; i++){
            st = new StringTokenizer(bf.readLine());
            char ch,find;
            find = st.nextToken().charAt(0);
            int j =0;
            for(j=1 ; j<max;j++){
                if(tree[j]==find){
                    break;
                }
            }
            ch = st.nextToken().charAt(0);
            if(!(ch =='.'))tree[j*2] =ch;

            ch = st.nextToken().charAt(0);
            if(!(ch =='.'))tree[(j*2)+1] =ch;
        }
        pre(1);
        sb.append("\n");
        in(1);
        sb.append("\n");
        post(1);
        sb.append("\n");
        System.out.println(sb);
    }
    public static void pre (int idx){
        if(idx>=max) return;
        if(tree[idx]=='-')return;

        sb.append(tree[idx]);
        pre(idx*2);
        pre((idx*2)+1);
    }
    public static void in (int idx){
        if(idx>=max) return;
        if(tree[idx]=='-')return;
        in(idx*2);
        sb.append(tree[idx]);
        in((idx*2)+1);
    }
    public static void post (int idx){
        if(idx>=max) return;
        if(tree[idx]=='-')return;

        post(idx*2);
        post((idx*2)+1);
        sb.append(tree[idx]);

    }
}
