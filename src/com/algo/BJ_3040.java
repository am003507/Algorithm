package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ibyeongmu on 2017. 2. 10..
 */
public class BJ_3040 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        int N = 9;
        int table[]=new int[N+1];
        for(int i =0;i<N;i++) {
            table[i]=Integer.parseInt(bf.readLine());
        }
        int bit = (1<<7)-1;
        StringBuilder sb;

        for(int i =bit;i<1<<9;i++)
        {
            if(Integer.bitCount(i)==7)
            {
                int result =0;
                sb = new StringBuilder();
                for(int j =0;j<9;j++)
                {
                    if((i&(1<<j))>0)
                    {
                        result+=table[j];
                        sb.append(table[j]+"\n");

                    }
                }
                if(result ==100)
                {
                    System.out.println(sb);
                    return;

                }
            }
        }

    }
}
