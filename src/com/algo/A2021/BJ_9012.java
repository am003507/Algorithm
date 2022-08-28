package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 10..
 */
public class BJ_9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(T-->0) {
        boolean flag =false;
            Stack<Integer> stack = new Stack<Integer>();
            char input[]= bf.readLine().toCharArray();
            for(int i=0;i<input.length;i++) {
                if(input[i]=='(') stack.push(i);
                else if( input[i]==')') {
                    if(stack.isEmpty()) {
                        flag=true;
                        break;
                    }else
                    {
                        int num = stack.pop();
                        if(input[num]!='('){
                            flag=true;

                            break;
                        }

                    }
                }
            }
            if(!stack.isEmpty())flag=true;

            sb.append(flag?"NO":"YES").append("\n");


        }
        System.out.println(sb);
    }
}
