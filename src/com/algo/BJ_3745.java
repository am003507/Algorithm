package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 3. 2..
 */
public class BJ_3745 {
    static int N, tree[], start, table[], max;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input ;

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
//        Scanner sc = new Scanner(System.in);

//        while (sc.hasNext()) {

        while ((input = bf.readLine()) != null) {
            N = Integer.parseInt(input);
//            N = sc.nextInt();
            table = new int[N];
            max = 0;
            int i = 0, result = 0;
//            String str = sc.nextLine();
            st = new StringTokenizer(bf.readLine());
            while (st.hasMoreTokens()) {
                table[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, table[i++]);
            }
//            for (int k = 0; k < N; k++) {
//                table[k] = sc.nextInt();
//                max = Math.max(max, table[k]);
//            }

            for (start = 1; start < max; start *= 2) ;
            tree = new int[2 * start];
            for (int j = 0; j < N; j++) {
                int num = table[j];
                int len = get_max(1, num - 1, 1, 1, start) + 1;
                update(num, len);
                result = Math.max(result, len);
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);

    }

    public static int get_max(int L, int R, int idx, int temp_L, int temp_R) {
        if (temp_L > R || temp_R < L) return 0;
        if (L <= temp_L && temp_R <= R) return tree[idx];
        int mid = (temp_L + temp_R) / 2;
        return Math.max(get_max(L, R, idx * 2, temp_L, mid), get_max(L, R, idx * 2 + 1, mid + 1, temp_R));


    }

    public static void update(int idx, int val) {
        int index = start + idx - 1;
        tree[index] = val;
        while (index > 1) {
            index /= 2;
            tree[index] = Math.max(tree[index * 2], tree[index * 2 + 1]);
        }
    }
}
