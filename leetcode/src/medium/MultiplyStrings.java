package medium;

public class MultiplyStrings {
    public String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")) return "0";

        int n = num1.length();
        int m = num2.length();
        int[] result = new int[n + m];

        for(int i = n - 1; i>=0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for(int j = m - 1;j>=0; j--) {
                int digit2 = num2.charAt(j) - '0';
                int mul = digit1 * digit2;
                // Multiply the two digits (e.g., 3 * 6 = 18)

                int sum = mul + result[i + j + 1];
                // Add the product to the existing value at this position
                // (in case there's already a carry from a previous step)

                result[i + j + 1] = sum % 10;
                // Keep only the ones place at the current position (e.g., 18 % 10 = 8)

                result[i + j] += sum / 10;
                // Carry over the tens place to the previous index (e.g., 18 / 10 = 1)
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int num : result) {
            if(sb.length() == 0 && num == 0) continue; // 앞자리 0 제거
            sb.append(num);
        }

        return sb.toString();
    }
}
