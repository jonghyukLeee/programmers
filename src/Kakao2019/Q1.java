package Kakao2019;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
class Chat
{
    String action,uid;
    public Chat(String action, String uid)
    {
        this.action = action;
        this.uid = uid;
    }
    public String print()
    {
        if(this.action.equals("Enter")) return "들어왔습니다.";
        return "나갔습니다.";
    }
}
public class Q1 {
    public static void main(String[] args) {
        String [] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234",
                "Enter uid1234 Prodo","Change uid4567 Ryan"};
        for(String s : solution(record)) System.out.println(s);
    }
    static String[] solution(String[] record) {
        String[] answer;
        HashMap<String, String> hm = new HashMap<>(); // uid, name정보
        ArrayList<Chat> al = new ArrayList<>();

        StringTokenizer st;
        for(String reco : record)
        {
            st = new StringTokenizer(reco);
            String action = st.nextToken();
            String uid = st.nextToken();
            if(!action.equals("Leave"))
            {
                String name = st.nextToken();
                hm.put(uid,name);
            }
            if(!action.equals("Change"))al.add(new Chat(action,uid));
        }

        answer = new String[al.size()];
        int answerIdx = 0;
        for(Chat c : al)
        {
            StringBuilder sb = new StringBuilder();
            sb.append(hm.get(c.uid)).append("님이 ").append(c.print());
            answer[answerIdx++] = sb.toString();
        }

        return answer;
    }
}
