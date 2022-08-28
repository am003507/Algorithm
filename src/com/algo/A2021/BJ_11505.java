package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 28..
 */
public class BJ_11505 {
    static int N,M,K,input[],start,mod = 1000000007;
    static long tree[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for(start = 1;start<N;start*=2);
        tree = new long [2*start];
        Arrays.fill(tree,1);

        for(int i =0;i<N;i++) {
            tree[start + i] = Integer.parseInt(bf.readLine());
        }
        make_seg();
        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i <M+K;i++) {
            st = new StringTokenizer(bf.readLine());
            int method = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if(method==1){
                // b번째수를 c로 교체
                update(b,c);
            }else if( method ==2){
                // b~c 곱
                sb.append(sum(b,c,1,1,start-1)).append("\n");
            }

        }
        System.out.println(sb);
    }
    public static long sum(long L,long R ,int idx,int temp_L,int temp_R){
        if(temp_R<L||temp_L>R)return 1;
        if(L <=temp_L&&temp_R<=R)return tree[idx];
        int mid = (temp_R+temp_L)/2;
        return (sum(L,R,idx*2,temp_L,mid)*sum(L,R,idx*2+1,mid+1,temp_R))%mod;
    }
    public static void update(int idx,long val){
        int index = start+idx-1;
        tree[index]=val;
        while(index>1){
            index/=2;
            tree[index]=(tree[index*2]*tree[index*2+1])%mod;
        }
    }
    public static void make_seg(){
        int idx = start-1;
        while(idx>0){
            tree[idx]= (tree[idx*2]*tree[(idx*2)+1])%mod;
            idx--;
        }
    }
}
