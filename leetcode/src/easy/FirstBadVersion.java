package easy;

public class FirstBadVersion {
    public int firstBadVersion(int n) {
        // case 1
        // n=5 [1,2,3,4,5]
        // left = 1
        // right = 5
        // mid = left + (right - left) /2

        // [1,2,3,4,5]
        // mid = 1 + (5 - 1) /2 = 3
        // isBadVersion(3) = false
        // left = mid + 1 = 4;

        // mid = 4 + (5 - 4) /2 = 4
        // isBadVersion(4) = true;
        // right = mid = 4;

        // case 2
        // 1
        // if(n == 1) return isBadVersion(n) ? n : 0;

        // case 3
        // [1,2,3]
        // mid = 0 + (2 - 0) /2 = 1
        // nums[mid] = 2
        // isBadVersion = true
        // right = mid = 1;

        // mid = 0 + (1 - 0) /2 = 0
        // nums[mid] = 1
        // isBadVersion = false
        // left = mid + 1 = 1

        if(n == 1) return isBadVersion(n) ? n : 0;

        int left = 1;
        int right = n;

        while(left < right) {
            int mid = left + (right - left) / 2;
            if(isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /* Note : Given by LeetCode in the problem */
    private boolean isBadVersion(int version) {
        return true;
    }
}
