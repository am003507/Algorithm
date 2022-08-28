package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 12..
 */
public class BJ_10158 {

    static int W,H,x,y,T,dx,dy;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(bf.readLine());
        dx=1;dy=1;
        while(T>0){
            int limit_x =0;
            int limit_y=0;

            if(dx >0) limit_x=W;
            else limit_x=0;
            if(dy>0) limit_y =H;
            else limit_y=0;

            int lx =Math.abs(limit_x-x);
            int ly =Math.abs(limit_y-y);

            int min = Math.min(lx,ly);
            if(T >min){
                x+=dx*min;
                y+=dy*min;
                T-=min;
            }else
            {
                x+=dx*T;
                y+=dy*T;
                T=0;
            }
            if(lx >ly){
                dy*=-1;
            }else if(lx <ly){
                dx*=-1;
            }else{
                dy*=-1;
                dx*=-1;
            }

        }
        System.out.println(x+" "+y);



    }
}
