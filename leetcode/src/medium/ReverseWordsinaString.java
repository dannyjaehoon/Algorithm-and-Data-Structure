package medium;

import java.util.ArrayList;
import java.util.List;

public class ReverseWordsinaString {

    public String reverseWords(String s) {
        // 1. remove the leading and trailing spaces first by trim()
        // 2. for loop through each character of s, use StringBuilder to make each word
        // 3. when we meet ' ', check the length of the StringBuilder to build a word and store it in the list, and then reset the length to 0
        // 4. for loop the word list from the end and make the sentence
        // 5. return the reversed string

        s = s.trim();
        List<String> wordList = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()) {
            if(sb.length() > 0 && c == ' ') {
                wordList.add(sb.toString());
                sb.setLength(0);
            } else if(c != ' ') {
                sb.append(c);
            }
        }
        if(sb.length() > 0) {
            wordList.add(sb.toString());
            sb.setLength(0);
        }
        for(int i = wordList.size() - 1; i >= 0;i--) {
            if(i != 0) sb.append(wordList.get(i)).append(" ");
            else sb.append(wordList.get(i));
        }
        return sb.toString();
    }
}
