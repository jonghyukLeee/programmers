package Kakao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Loc
{
    int x,y;
    public Loc(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}
public class KeyPress {
    static int [] numbers;
    static Loc [] keypad = {new Loc(3,1),new Loc(0,0),new Loc(0,1),
            new Loc(0,2),new Loc(1,0),new Loc(1,1),new Loc(1,2),
            new Loc(2,0),new Loc(2,1),new Loc(2,2)};
    static Loc left;
    static Loc right;
    static String hand;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        numbers = new int[n];
        left = new Loc(3,0);
        right = new Loc(3,2);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; ++i)
        {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        hand = br.readLine();

        System.out.print(solution(numbers,hand));
    }
    static String solution(int[] numbers, String hand) {
        sb = new StringBuilder();
        for(int i : numbers)
        {
            switch(i)
            {
                case 1:
                case 4:
                case 7:
                {
                    click(i,"left");
                    break;
                }
                case 3:
                case 6:
                case 9:
                {
                    click(i,"right");
                    break;
                }
                default :
                {
                    int endX = keypad[i].x;
                    int endY = keypad[i].y;

                    double fromLeft = Math.pow(Math.abs(endX - left.x),2) + Math.pow(Math.abs(endY - left.y),2);
                    double fromRight = Math.pow(Math.abs(endX - right.x),2) + Math.pow(Math.abs(endY - right.y),2);

                    if(fromRight == fromLeft)
                    {
                        click(i,hand);
                    }
                    else if(fromRight > fromLeft)
                    {
                        click(i,"left");
                    }
                    else click(i,"right");
                }
            }

        }
        return sb.toString();
    }
   static void click(int i, String lr)
   {
       if(lr.equals("left"))
       {
           sb.append("L");
           left = keypad[i];
       }
       else
       {
           sb.append("R");
           right = keypad[i];
       }
   }
}
