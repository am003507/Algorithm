package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1004 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        int T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        while(T-->0) {
            st = new StringTokenizer(bf.readLine());
            int x_1 = Integer.parseInt(st.nextToken());
            int y_1 = Integer.parseInt(st.nextToken());
            int x_2 = Integer.parseInt(st.nextToken());
            int y_2 = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(bf.readLine());
            int cnt =0;
            while(N-->0)
            {
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                boolean start = IsInside(x_1,y_1,x,y,r);
                boolean end = IsInside(x_2,y_2,x,y,r);
                if(start && end ) continue;
                if(start) cnt++;
                if(end)cnt++;
            }
            sb.append(cnt+"\n");
        }
        System.out.println(sb);
    }
    public static boolean IsInside(int x,int y ,int x_1,int y_1,int r) {
        double dis= Math.sqrt(Math.pow(x-x_1,2)+Math.pow(y-y_1,2));
        return (dis<r);
    }
}
