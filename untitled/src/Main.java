import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

    }

    //    https://leetcode.com/problems/binary-search/submissions/976067454/
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = (r + l) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }

    //    https://leetcode.com/problems/search-insert-position/submissions/
    public int searchInsert(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        int ans = nums.length;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                start = mid + 1;
            } else {
                ans = mid;
                end = mid - 1;
            }
        }
        return ans;
    }

    //    https://leetcode.com/problems/guess-number-higher-or-lower/submissions/
    public int guessNumber(int n) {
        int start = 1;
        int end = n;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) == 1) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }

    //    https://leetcode.com/problems/missing-number/submissions/976115546/
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] > mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    //    https://leetcode.com/problems/find-the-distance-value-between-two-arrays/submissions/976315205/
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int distance = 0;
        for (int i = 0; i < arr1.length; i++) {
            int from = arr1[i] - d;
            int to = arr1[i] + d;
            boolean flag = false;

            int start = 0;
            int end = arr2.length - 1;

            while (start <= end) {
                int mid = (end + start) / 2;
                if (arr2[mid] >= from && arr2[mid] <= to) {
                    flag = true;
                    break;
                } else if (arr2[mid] < from) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            if (!flag)
                distance++;
        }
        return distance;
    }
}
