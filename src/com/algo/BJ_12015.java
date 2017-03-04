package com.algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class BJ_12015 {
    static int N, tree[], start, max[], input[];
    static pp p_input[];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        p_input = new pp[N];
        for (start = 1; start < N; start *= 2) ;
        tree = new int[2 * start];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            p_input[i] = new pp(i, num);
        }
        Arrays.sort(p_input, new Comparator<pp>() {
            @Override
            public int compare(pp o1, pp o2) {
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < N; i++) {
            update(p_input[i].first);
        }
        System.out.println(tree[1]);

    }
    public static int  get_max(int L,int R ,int idx ,int temp_L,int temp_R){
        if(L>temp_R||R<temp_L)return 0;
        if(L<= temp_L&&temp_R<=R) return tree[idx];
        int mid = (temp_L+temp_R)/2;
        return Math.max(get_max(L,R,idx*2,temp_L,mid),get_max(L,R,idx*2+1,mid+1,temp_R));
    }
    public static void update(int idx) {
        int index = start + idx;
        tree[index] = get_max(0,idx-1,1,0,start-1)+1;
        while (index > 1) {
            index /= 2;
            tree[index] = Math.max(tree[index * 2], tree[index * 2 + 1]);
        }
    }

    public static class pp implements Comparable<pp> {
        int first, second;

        public pp(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(pp o2) {
            if (this.second == o2.second)
                return o2.first-this.first;
            else return this.second - o2.second;
        }
    }
}
