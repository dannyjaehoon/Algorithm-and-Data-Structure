package graphs.implicit;

import java.util.*;
import java.util.stream.Collectors;

public class OpenTheLock {


    public static Map<Character, Character> nextDigit = Map.of(
            '0','1',
            '1','2',
            '2','3',
            '3','4',
            '4','5',
            '5','6',
            '6','7',
            '7','8',
            '8','9',
            '9','0'
    );

    public static Map<Character, Character> prevDigit = nextDigit.entrySet().stream().collect(Collectors.toMap(Map.Entry::getValue, Map.Entry::getKey));

    public static int numSteps(String targetCombo, List<String> trappedCombos) {
        if (targetCombo.equals("0000")) return 0;

        Set<String> trappedComboSet = new HashSet<>(trappedCombos);
        if (trappedComboSet.contains("0000")) return -1;

        Map<String, Integer> steps = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        steps.put("0000", 0);
        queue.offer("0000");

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            int step = steps.get(curr);

            for (int i = 0; i < 4; i++) {
                char[] chars = curr.toCharArray();

                // Up
                chars[i] = nextDigit.get(curr.charAt(i));
                String up = new String(chars);
                if (!trappedComboSet.contains(up) && !steps.containsKey(up)) {
                    if (up.equals(targetCombo)) return step + 1;
                    steps.put(up, step + 1);
                    queue.offer(up);
                }

                // Down
                chars[i] = prevDigit.get(curr.charAt(i));
                String down = new String(chars);
                if (!trappedComboSet.contains(down) && !steps.containsKey(down)) {
                    if (down.equals(targetCombo)) return step + 1;
                    steps.put(down, step + 1);
                    queue.offer(down);
                }
            }
        }

        return -1;

        // The time complexity of this algorithm is O(N), where N = 10,000, representing all possible 4-digit combinations from "0000" to "9999".
    }
}
