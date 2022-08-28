package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by ibyeongmu on 2017. 2. 7..
 */
public class BJ_2667 {

    static int N,table[][];
    static boolean check [][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        table= new int [N+1][N+1];
        check = new boolean[N+1][N+1];
        StringBuilder sb = new StringBuilder();

        for(int i =0 ; i < N;i++) {
            char input[] = bf.readLine().toCharArray();
            for(int j =0;j<N;j++) table[i][j] = input[j]-48;
        }
        ArrayList<Integer> list  = new ArrayList<Integer>();
        for(int i =0 ; i<N;i++)
        {
            for(int j =0 ; j<N;j++)
            {
                if(!check[i][j]&& table[i][j]==1)  list.add(proc(i,j));
            }
        }
        sb.append(list.size()+"\n");

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for(int i =0 ; i<list.size();i++) sb.append(list.get(i)+"\n");

        System.out.println(sb);



    }
    public static int proc(int x ,int y )
    {
        if(x<0||y<0||x>N||y>N) return 0;
        if(table[x][y]!=1 || check[x][y]) return 0;
        check[x][y]= true;
        int dx [] = new int[]{-1,1,0,0};
        int dy [] = new int [] {0,0,-1,1};
        int result = 1;
        for(int i =0;i<4;i++) {
            result+= proc(x+dx[i],y+dy[i]);
        }

        return result;


    }
}
