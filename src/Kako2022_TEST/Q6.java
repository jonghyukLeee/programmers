package Kako2022_TEST;

import java.awt.*;
import java.util.LinkedList;

public class Q6 {
    public static void main(String[] args) {
        int [][] board = {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}};
        int [][] skill = {{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
        System.out.print(solution(board,skill));
    }
    static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        String [] map = new String[board[0].length];

        for(int i = 0; i < board.length; ++i)
        {
            for(int j = 0; j < board[0].length; ++j)
            {
                map[i] += board[i][j] + "";
            }
        }

        for(int i = 0; i < skill.length; ++i)
        {
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree = skill[i][5];

            if(type == 1) // 공격
            { // 2 0 2 3
                for(int x = r1; x <= r2; ++x)
                {
                    StringBuilder sb = new StringBuilder(map[x]);
                }
            }
            else
            {

            }
        }

        return answer;
    }
}
