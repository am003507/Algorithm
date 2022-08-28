package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by ibyeongmu on 2017. 2. 10..
 */
public class BJ_3015 {
    public static void main(String[] args) throws NumberFormatException, IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        int[] h = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        Stack<Integer> st_num = new Stack<Integer>();
        long count = 0;
        for(int i=0;i<n;i++){
            h[i] = Integer.parseInt(in.readLine());
            int temp = 1;
            while(!st.isEmpty()){
                if(st.peek() <= h[i]){
                    count += (long)st_num.peek();
                    if(st.peek() == h[i]){
                        temp += st_num.peek();
                    }
                    st.pop();
                    st_num.pop();
                }else{
                    break;
                }
            }
            if(!st.isEmpty())
                count+= 1L;
            st.push(h[i]);
            st_num.push(temp);
        }
        System.out.println(count);
    }

}
