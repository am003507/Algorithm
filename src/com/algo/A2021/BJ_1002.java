package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 1. 26..
 */
public class BJ_1002 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(bf.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(bf.readLine());
            int x_1 = Integer.parseInt(st.nextToken());
            int y_1 = Integer.parseInt(st.nextToken());
            int r_1 = Integer.parseInt(st.nextToken());
            int x_2 = Integer.parseInt(st.nextToken());
            int y_2 = Integer.parseInt(st.nextToken());
            int r_2 = Integer.parseInt(st.nextToken());
            double distance = calc_dix(x_1, y_1, x_2, y_2);
            int min =0;
            int max =0;
            if (x_1 == x_2 && y_1 == y_2) {
                if (r_1 == r_2) sb.append(-1 + "\n");
                else sb.append(0 + "\n");
            } else {
                min = Math.min(r_1,r_2);
                max = Math.max(r_1,r_2);

                if( min+max >distance) {
                    if (min + distance == max) sb.append(1 + "\n");
                    else if ( min+distance<max) sb.append(0+"\n");
                    else sb.append(2 + "\n");
                }else if(min+max<distance)
                {
                    sb.append(0+"\n");
                }else{
                    sb.append(1+"\n");

                }

            }


        }
        System.out.println(sb);

    }

    public static double calc_dix(int x_1, int y_1, int x_2, int y_2) {


        return Math.sqrt(Math.pow(x_2 - x_1, 2) + Math.pow(y_2 - y_1, 2));
    }

}
