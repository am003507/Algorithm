package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_2250 {
    static int N,  idx[], weight[], max =0,temp =0, cnt = 1;
    static node tree[];
    static Queue<Integer> que;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());

        tree = new node[N+1];
        idx = new int[max];
        weight = new int[max];
        for(int i = 0 ; i<=N;i++)tree[i]=new node();
        for (int i = 1; i <=N; i++) {
            st = new StringTokenizer(bf.readLine());
            int root = Integer.parseInt(st.nextToken());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            tree[root].left=left;
            tree[root].right=right;
            if(left!=-1)tree[left].root=root;
            if(right!=-1)tree[right].root=root;

        }
        int i;
        for( i = 1;i<=N;i++){
            if(tree[i].root==-1)break;
        }


        pre(i);
        que = new LinkedList<Integer>();
        que.add(i);
        BFS();
        System.out.println(temp+" "+max);

    }

    public static void BFS(){
        int k =0;
        while (!que.isEmpty()){
            k++;
            int size = que.size();
            int low= Integer.MAX_VALUE;
            int high = Integer.MIN_VALUE;
            for(int i = 0 ; i < size;i++){
             int num = que.poll();
             low = Math.min(tree[num].cnt,low);
             high = Math.max(tree[num].cnt,high);
             if(tree[num].left!=-1)que.add(tree[num].left);
                if(tree[num].right!=-1)que.add(tree[num].right);
            }
            int result = high-low+1;
            if(max<result){
                max = result;
                temp = k;
            }
        }

    }
    public static void pre(int num){
        if(tree[num].left!= -1) pre(tree[num].left);
        tree[num].cnt= cnt++;
        if(tree[num].right!= -1) pre(tree[num].right);
    }

    public static class node {
        int left,right,cnt,root=-1;


    }
}
