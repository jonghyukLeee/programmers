package Kakao;

import java.awt.geom.Line2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Loc
{
    int x,y,dist;
    char key;

    public Loc(){};
    public Loc(int x, int y,int dist,char key)
    {
        this.x = x;
        this.y = y;
        this.dist = dist;
        this.key = key;
    }
}
public class KeyPress {
    static int [] numbers;
    static char [][] keypad = {{'1','2','3'},{'4','5','6'},{'7','8','9'},{'*','0','#'}};
    static boolean [][] isVis;
    static int [] dx = {0,0,-1,1};
    static int [] dy = {-1,1,0,0};
    static Loc left;
    static Loc right;
    static String hand;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        numbers = new int[n];
        left = new Loc(3,0,0,'*');
        right = new Loc(3,2,0,'#');

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i)
        {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        hand = br.readLine();

        System.out.print(solution(numbers,hand));
    }
    static String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        for(int i : numbers)
        {
            char end = Character.forDigit(i,10);

            switch(end)
            {
                case '1' :
                {
                    sb.append("L");
                    left = new Loc(0,0,0,'1');
                    break;
                }
                case '4' :
                {
                    sb.append("L");
                    left = new Loc(1,0,0,'4');
                    break;
                }
                case '7' :
                {
                    sb.append("L");
                    left = new Loc(2,0,0,'7');
                    break;
                }
                case '3' :
                {
                    sb.append("R");
                    right = new Loc(0,2,0,'3');
                    break;
                }
                case '6' :
                {
                    sb.append("R");
                    right = new Loc(1,2,0,'6');
                    break;
                }
                case '9' :
                {
                    sb.append("R");
                    right = new Loc(2,2,0,'9');
                    break;
                }
                default :
                {
                    Loc tmpLeft = click(left,end);
                    Loc tmpRight = click(right,end);

                    if(tmpLeft.dist == tmpRight.dist)
                    {
                        if(hand.equals("left"))
                        {
                            sb.append("L");
                            left = new Loc(tmpLeft.x,tmpLeft.y,0,keypad[tmpLeft.x][tmpLeft.y]);
                        }
                        else
                        {
                            sb.append("R");
                            right = new Loc(tmpRight.x,tmpRight.y,0,keypad[tmpRight.x][tmpRight.y]);
                        }
                    }
                    else if(tmpLeft.dist < tmpRight.dist)
                    {
                        sb.append("L");
                        left = new Loc(tmpLeft.x,tmpLeft.y,0,keypad[tmpLeft.x][tmpLeft.y]);
                    }
                    else
                    {
                        sb.append("R");
                        right = new Loc(tmpRight.x,tmpRight.y,0,keypad[tmpRight.x][tmpRight.y]);
                    }
                }
            }

        }
        return sb.toString();
    }
    static Loc click(Loc start, char end)
    {
        Queue<Loc> q = new LinkedList<>();
        q.add(start);
        isVis = new boolean[4][3];
        while(!q.isEmpty())
        {
            Loc tmp = q.poll();
            int curX = tmp.x,curY = tmp.y;
            if(tmp.key == end)
            {
                return tmp;
            }

            for(int idx = 0; idx < 4; ++idx)
            {
                int x = curX + dx[idx];
                int y = curY + dy[idx];

                if(!isValid(x,y) || isVis[x][y]) continue;
                q.add(new Loc(x,y,tmp.dist+1,keypad[x][y]));
            }
        }
        return new Loc();
    }

    static boolean isValid(int x, int y)
    {
        return x >= 0 && y >= 0 && x < keypad.length && y < keypad[0].length;
    }
}
