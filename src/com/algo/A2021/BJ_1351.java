package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 2. 23..
 */
public class BJ_1351 {
    static Long N,P,Q;
    static HashMap<Long,Long> map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        map = new HashMap<Long,Long>();
        map.put(0L,1L);
        System.out.println(proc(N));
    }
    public static Long proc(Long num){
        if(map.containsKey(num)) return map.get(num);
        else{


            long result =proc(num/P)+proc(num/Q);
            map.put(num,result);
            return result;
        }


    }

}
