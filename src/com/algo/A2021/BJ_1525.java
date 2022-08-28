package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ_1525 {
    static int N, table[];
    static HashSet<Long> visit;
    static Queue<Long> que;
    static long desc = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        visit = new HashSet<Long>();
        StringTokenizer st;
        long num = 0;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 3; j++) {
                num = num << 4;
                num += Long.parseLong(st.nextToken());
            }
        }


        for (int i = 1; i < 9; i++) {
            desc += i;
            desc <<= 4;
        }

        visit.add(num);
        que = new LinkedList<Long>();
        que.add(num);
        System.out.println(BFS());
    }

    public static int BFS() {
        int cnt = -1;
        while (!que.isEmpty()) {
            cnt++;
            int size = que.size();
            for (int k = 0; k < size; k++) {
                Long idx = que.poll();

                int i = 0;
                int shift[] = new int[]{4, -4, 12, -12};
                int dx[] = new int[]{-1, 1, 0, 0};
                int dy[] = new int[]{0, 0, -1, 1};
                for (; (idx & (15L << (i * 4))) != 0; i++);

                int x = i % 3;
                int y = i / 3;
                if (idx == desc) {
                    return cnt;
                }
                for (int j = 0; j < 4; j++) {
                    int nx = x + dx[j];
                    int ny = y + dy[j];
                    if (nx < 0 || ny < 0 || nx >= 3 || ny >= 3) continue;
                    long temp = idx & (15L << ((ny * 3 + nx) * 4));
                    long next = idx - temp;
                    if (shift[j] > 0) temp <<= shift[j];
                    else temp >>= -shift[j];
                    long result = temp + next;
                    if (!visit.contains(result)) {
                        visit.add(result);
                        que.add(result);
                    }
                }
            }
        }
        return -1;
    }

}
