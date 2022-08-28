package com.algo.A2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by ibyeongmu on 2017. 3. 3..
 *  삼성 SCPC 바이러스
 *  각 정점의  차수를  최소 K 이면서 |V'|-L-1 로 유지 하는 문제이다
 *  차수가 K보다 작거나 |V'|-L-1인 정점을 삭제하는데
 *  삭제 한 후에는 |V'|이 변호가 생기기 때문에 첫 정점 부터 다시 검사하여 삭제 한다
 */
public class SCPC_6 {
    static int T,K,L,N,M,gre[][],max[];
    static boolean visit[];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(bf.readLine());
        StringTokenizer st;
        for(int t =1 ; t <=T ;t++){
            st = new StringTokenizer(bf.readLine());
            K = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(bf.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            gre = new int [N+1][N+1];
            max = new int [N+1];
            visit = new boolean[N+1];
            for(int k =0 ; k< M;k++){
                st = new StringTokenizer(bf.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                gre[y][x] = gre[x][y] = 1;
                max[y]++;
                max[x]++;
            }
            int sum =0;
            int total = N;
            for(int i = 1; i<=N ;i++){
                if(!visit[i]&&(max[i]<K || max[i]> total-L-1)){
                    for(int j = 1; j <=N; j++){
                        max[j]-=gre[j][i];
                        gre[j][i]=0;
                    }
                    visit[i]=true;
                    total--;
                    sum +=i;
                    i=0;
                }
            }
            sb.append("Case #" + t).append("\n");
            sb.append(sum).append("\n");
        }
        System.out.println(sb);

    }
}
