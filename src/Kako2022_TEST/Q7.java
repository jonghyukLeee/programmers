package Kako2022_TEST;


public class Q7 {
    static int maxVal = Integer.MIN_VALUE;
    static int [] dx = {0,0,1,-1};
    static int [] dy = {1,-1,0,0};
    static int n,m;
    public static void main(String[] args) {

    }
    static int solution(int[][] board, int[] aloc, int[] bloc) {
        n = board.length;
        m = board[0].length;
        dfs(board,aloc[0],aloc[1],bloc[0],bloc[1],0);
        return maxVal;
    }
    static void dfs(int [][] board,int a_curx,int a_cury,int b_curx,int b_cury,int cnt)
    {
        if(board[a_curx][a_cury] == 0 || board[b_curx][b_cury] == 0)
        {
            maxVal = Math.max(maxVal,cnt);
            return;
        }

        boolean a = false;
        boolean b = false;
        int tmpCnt = 0;
        for(int i = 0; i < 4; ++i)
        {
            a = false;
            tmpCnt = 0;
            int ax = a_curx + dx[i];
            int ay = a_cury + dy[i];
            if(!isValid(ax,ay) || board[ax][ay] == 0) continue;
            a = true;
            tmpCnt++;
            for(int j = 0; j < 4; ++j)
            {
                b = false;
                int bx = b_curx + dx[j];
                int by = b_cury + dy[j];

                if(!isValid(bx,by) || board[bx][by] == 0) continue;
                b = true;
                tmpCnt++;
                board[a_curx][a_cury] = 0;
                board[b_curx][b_cury] = 0;
                dfs(board,ax,ay,bx,by,cnt+tmpCnt);
                board[a_curx][a_cury] = 1;
                board[b_curx][b_cury] = 1;
            }
        }
        if(!a)
        {
            for(int i = 0; i < 4; ++i)
            {
                int bx = b_curx + dx[i];
                int by = b_cury + dy[i];
                if(!isValid(bx,by) || board[bx][by] == 0) continue;
                b = true;
            }
            if(b)
            {
                maxVal = Math.max(maxVal,cnt+1);
            }
        }
        else
        {
            if(!b)
            {
                maxVal = Math.max(maxVal,cnt+1);
            }
        }
    }
    static boolean isValid(int x, int y)
    {
        return x >=0 && y >= 0 && x < n && y < m;
    }
}
