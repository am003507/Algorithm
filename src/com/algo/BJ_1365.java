package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 3. 2..
 * 꼬인 전깃줄
 * 전체 전봇대의 수 N -  LIS
 */
public class BJ_1365 {
    static int N,tree[],start,input[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        input = new int [ N+1];
        StringTokenizer st= new StringTokenizer(bf.readLine());
        int max =0;
        for(int i = 1 ;i<=N;i++){
            int num =Integer.parseInt(st.nextToken());
            input[i] = num;
            max = Math.max(max,num);
        }
        for(start =1 ; start<max;start*=2);
        tree = new int [2*start];
        for(int i = 1; i <=N;i++){
            int num = input[i];
            int len = getMax(1,num-1,1,1,start)+1;
            update (num,len);
        }
        System.out.println(N - getMax(1,N,1,1,start));
    }
    public static void update (int idx ,int val){
        int index = start+idx-1;
        tree[index]=val;
        while (index>1){
            index/=2;
            tree[index] = Math.max(tree[index*2],tree[index*2+1]);
        }
    }
    public static int getMax(int L,int R,int idx,int temp_L,int temp_R){
        if(temp_L>R||temp_R<L)return 0;
        if(L<=temp_L&& temp_R<=R)return tree[idx];
        int mid = (temp_L+temp_R)/2;

        return Math.max(getMax(L,R,idx*2,temp_L,mid),getMax(L,R,idx*2+1,mid+1,temp_R));



    }
}
