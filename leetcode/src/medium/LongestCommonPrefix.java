package medium;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {

        // find the longest common prefix string from the strs array
        // check each character at the same index across all strings
        // increment count only if all characters at that index are the same

        // nested for loop
        // for - int i = 0 to minLength of any string in strs
        // for - int j = 0 to str.length
        //       check all chracters in strs at index i are the same across all strings.

        int minLength = Integer.MAX_VALUE;

        for(String s : strs) {
            minLength = Math.min(minLength, s.length());
        }
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i< minLength; i++) {
            char c = strs[0].charAt(i);
            for(int j = 1; j <strs.length; j++) {
                if(c != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
