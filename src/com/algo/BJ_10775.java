package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ibyeongmu on 2017. 2. 26..
 */
public class BJ_10775 {

    static int G,P,parent[],max;
    static boolean  check[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(bf.readLine());
        P = Integer.parseInt(bf.readLine());
        parent = new int [100000+1];
        check = new boolean[100000+1];
        check[0] =true;
        for(int i = 0 ; i <=G;i++)parent[i] = i;
        int  i;
        for(i =1;i<=P;i++){
            int num = Integer.parseInt(bf.readLine());

           int idx = find(num);
           if(check[idx]){
               break;
           } else{
               check[idx]=true;
               int u = find(idx-1);
               merge(u,idx);

           }
        }
        System.out.println(i-1);

    }
    public static int find(int idx){
        if(idx == parent[idx]) return idx;
        else return parent[idx]=find(parent[idx]);
    }
    public static void merge(int u , int v){
        u = find(u);
        v = find(v);
        if(u==v)return;
        if(u>v){
            int temp =v;
            v = u;
            u=temp;
        }
        parent[v]=u;

    }


}
