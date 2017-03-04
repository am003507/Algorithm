package com.algo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class BJ_1759 {
    static int L, C,top =-1,a_cnt =0, b_cnt=0;
    static char input[];
    static char stack[];
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(bf.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        sb = new StringBuilder();
        input = new char[C];
        stack = new char[C];
        for (int i = 0; i < C; i++) {
            input[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(input);
        proc(0);
        System.out.println(sb);
    }
    public static void push(char cha){
        char ch = cha;
        if(ch =='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            a_cnt++;
        }else{
            b_cnt++;
        }



        stack[++top]=ch;
    }
    public static void pop(){
        char ch =stack[top--];
        if(ch =='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            a_cnt--;
        }else{
            b_cnt--;
        }




    }
    public static StringBuilder retstr(){
        StringBuilder stringb = new StringBuilder();
        for(int i = 0 ; i <=top;i++){
            stringb.append(stack[i]);
        }
        return stringb;
    }
    public static void proc(int idx){
        if((top == L-1)&& a_cnt>0&&b_cnt>1  ) {
            sb.append(retstr()).append("\n");
            return ;
        }
        if(idx >=C)return ;
        for(int i = idx;i<C;i++){
            push(input[i]);
            proc(i+1);
            pop();

        }

    }
}
