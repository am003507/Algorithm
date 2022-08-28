package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by ibyeongmu on 2017. 2. 11..
 */
public class BJ_10814 {

    static  person p[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader( new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());

        p= new person[N];
        StringTokenizer st;

        for(int i =0 ; i <N;i++) {
            st= new StringTokenizer(bf.readLine());
            p[i] = new person(Integer.parseInt(st.nextToken()),st.nextToken());
        }
        StringBuilder sb = new StringBuilder();




        Arrays.sort(p, new Comparator<person>() {
            @Override
            public int compare(person o1, person o2) {
                return o1.age-o2.age;
            }
        });
        for(int i =0 ; i <N;i++) {
            sb.append(p[i].age+" "+p[i].name).append("\n");
        }
        System.out.println(sb);

    }
    public static class person
    {
        int age;
        String name;

        public person(int age, String name) {
            this.age = age;
            this.name = name;
        }

    }
}
