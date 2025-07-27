package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<String>();
        List<String> res = new ArrayList<>();
        Map<Character, List<Character>> map = new HashMap<>();
        char num = '2';
        char c = 'a';

        while(num <= '9' && c <= 'z') {
            int letters = (num == '7' || num == '9') ? 4 : 3;

            List<Character> list = new ArrayList<>();
            for(int i = 0; i<letters; i++) {
                list.add(c++);
            }

            map.put(num, list);
            num++;
        }
        StringBuilder ans = new StringBuilder();

        dfs(digits, 0, res, ans, map);


        return res;
    }

    private void dfs(String digits, int idx, List<String> res, StringBuilder ans, Map<Character, List<Character>> map) {
        if (idx == digits.length()) {
            res.add(ans.toString());
            return;
        }

        char digit = digits.charAt(idx);

        for(char ch : map.get(digit)) {
            ans.append(ch );
            dfs(digits, idx + 1,res, ans, map);
            ans.deleteCharAt(ans.length() -1);
        }
    }
}
