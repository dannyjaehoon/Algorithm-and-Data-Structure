package easy;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if((c >= 'a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9')){
                sb.append(c);
            }
        }

        String filtered = sb.toString().toLowerCase();
        String reversed = sb.reverse().toString().toLowerCase();

        return filtered.equals(reversed);
    }
}
