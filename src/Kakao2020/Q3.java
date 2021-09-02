package Kakao2020;

public class Q3 {
    static int n;
    static int [][] map;
    static int maxI = -1, maxJ = -1;
    public static void main(String[] args) {

    }
    static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        n = lock.length;
        int mapLen = (3 * n) - 2;
        map = new int[mapLen][mapLen];


        for(int i = 0; i < n; ++i)
        {
            for(int j = 0; j < n; ++j)
            {
                if(lock[i][j] == 1) map[i+n-1][j+n-1] = 1;
                else
                {
                    if(maxI < i+n-1) maxI = i+n-1;
                    if(maxJ < j+n-1) maxJ = j+n-1;
                }
            }
        }

        for(int t = 0; t < 4; ++t)
        {
            int [][] tmpKey = rotate(key);
            if(unlock(tmpKey))
            {
                answer = true;
                break;
            }
        }
        return answer;
    }
    static boolean unlock(int [][] key)
    {
        for(int i = 0; i < map.length-1; ++i)
        {
            if((i+ key.length) <= maxI) continue;
            for(int j = 0; j < map.length-1; ++j)
            {
                if((j + key.length) <= maxJ) continue;
                for(int k = i; k < i+key.length; ++k)
                {
                    for(int l = j; l < j+key.length; ++l)
                    {
                        if(inArr(k,l))
                        {
                            if(map[k][l] == 0)
                            {
                                if(key[k-i][l-j] == 0) return false;
                            }
                            else
                            {
                                if(key[k-i][l-j] == 1) return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
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
    static boolean inArr(int i, int j)
    {
        return i <= n-1 || i > n+2 || j <= n-1 || j > n+2;
    }
}
