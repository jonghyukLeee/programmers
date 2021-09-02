package Kakao2020;

public class Q3 {
    static int n,cnt,keyLen;
    static int [][] map;
    public static void main(String[] args) {
        int [][] key = {{0, 0, 0}, {0, 0, 1}, {1, 1, 0}};
        int [][] lock = {{1, 1, 1,1},{0,1, 1, 1},{0,1, 1, 1},{1,0,1,1}};
        System.out.print(solution(key,lock));
    }
    static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        keyLen = key.length;
        n = 2*(key.length-1);
        cnt = 0;
        int mapLen = lock.length + n;
        map = new int[mapLen][mapLen];
        for(int i = 0; i < lock.length; ++i)
        {
            for(int j = 0; j < lock.length; ++j)
            {
                if(lock[i][j] == 1) map[i+key.length-1][j+key.length-1] = 1;
                else cnt++;
            }
        }

        int [][] tmpKey = new int[key.length][key.length];
        for(int i = 0; i < key.length; ++i)
        {
            System.arraycopy(key[i],0,tmpKey[i],0,key[i].length);
        }
        for(int t = 0; t < 4; ++t)
        {
            if(unlock(tmpKey))
            {
                answer = true;
                break;
            }
            tmpKey = rotate(tmpKey);
        }
        return answer;
    }
    static boolean unlock(int [][] key)
    {
        int correct;
        for(int i = 0; i <= map.length-keyLen; ++i)
        {
            for(int j = 0; j <= map.length-keyLen; ++j)
            {
                correct = 0;
                next : for(int k = i; k < i+keyLen; ++k)
                {
                    for(int l = j; l < j+keyLen; ++l)
                    {
                        if(inArr(k,l))
                        {
                            if(map[k][l] == 0)
                            {
                                if(key[k-i][l-j] == 1) correct++;
                            }
                            else
                            {
                                if(key[k-i][l-j] == 1) continue next;
                            }
                        }
                    }
                    if(correct == cnt) return true;
                }
            }
        }
        return false;
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
        return i >= keyLen-1 && i <= map.length-keyLen && j >= keyLen-1 && j <= map.length-keyLen;
    }
}
