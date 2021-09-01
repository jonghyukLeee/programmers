package Kakao2020;

public class Q3 {
    static int n;
    public static void main(String[] args) {

    }
    static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        n = lock.length;
        int mapLen = (3 * n) - 2;
        int [][] map = new int[mapLen][mapLen];

        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                if(lock[i][j] == 1) map[i+n-1][j+n-1] = 1;
            }
        }

        for(int i = 0; i < map.length-n; ++i)
        {
            int [][] tmp = rotate(key);
            for(int j = 0; j < map.length-n; ++j)
            {

            }
        }
        return answer;
    }
    static boolean unlock(int [][] key,int idx)
    {

    }
    static int [][] rotate(int [][] key)
    {
        int len = key.length;
        int [][] arr = new int[len][len];

        for(int i = 0; i < len; ++i)
        {
            for(int j = 0; j < len; ++j)
            {
                arr[i][j] = key[len-j-1][i];
            }
        }
        return arr;
    }
}
