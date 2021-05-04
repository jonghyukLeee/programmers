package Hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Song{
    int id;
    String gen;

    public Song(int id, String gen)
    {
        this.id = id;
        this.gen = gen;
    }
    public int getId()
    {
        return this.id;
    }
}
public class Q4 {
    static String [] genres;
    static int [] plays;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        genres = new String[t];
        plays = new int[t];

        for(int i = 0; i < t; ++i)
        {
            st = new StringTokenizer(br.readLine());
            genres[i] = st.nextToken();
            plays[i] = Integer.parseInt(st.nextToken());
        }
        for(int i : solution(genres,plays))
        {
            sb.append(i).append(" ");
        }
        System.out.print(sb.toString());
    }
    static int[] solution(String[] genres, int[] plays)
    {
        int[] answer = new int[4];
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<String,Integer> hm = new HashMap<>();
        HashMap<Song,Integer> songHm = new HashMap<>();

        for(int i = 0; i < genres.length; ++i)
        {
            songHm.put(new Song(i,genres[i]),plays[i]);
            hm.put(genres[i],hm.getOrDefault(genres[i],0)+plays[i]);
        }
        int cnt = 2;
        while(cnt-- > 0)
        {
            int maxVal = Collections.max(hm.values());
            Iterator<String> it = hm.keySet().iterator();
            String maxKey = "";
            while(it.hasNext())
            {
                String tmp = it.next();
                if(hm.get(tmp) == maxVal)
                {
                    maxKey = tmp;
                    break;
                }
            }
            ArrayList<Integer> tmpAl = new ArrayList<>();
            for(int i = 0; i < genres.length; ++i)
            {
                if(genres[i].equals(maxKey))
                {
                    tmpAl.add(plays[i]);
                }
            }
            Collections.sort(tmpAl,Collections.reverseOrder());
            for(int i = 0; i < 2; ++i)
            {
                Iterator<Song> songIt = songHm.keySet().iterator();
                int max = tmpAl.get(i);
                while(songIt.hasNext())
                {
                    Song tmp = songIt.next();
                    if(songHm.get(tmp) == max)
                    {
                        ans.add(tmp.getId());
                    }
                }
            }
            hm.remove(maxKey);
        }
        for(int i = 0; i < 4; ++i)
        {
            answer[i] = ans.get(i);
        }
        return answer;
    }
}
