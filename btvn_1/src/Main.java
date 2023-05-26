import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int nums[] = {2, 7, 11, 15};
        int target = 9;
        int[] out = twoSum(nums, target);
    }

    //    https://leetcode.com/problems/two-sum/submissions/957785536/
    public static int[] twoSum(int[] nums, int target) {
        int[] out = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    out[0] = i;
                    out[1] = j;
                    return out;
                }
            }
        }
        return out;
    }

    //    https://leetcode.com/problems/single-number/submissions/957785646/
    public static int singleNumber(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            boolean trung = false;
            result = nums[i];
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                else if (nums[i] == nums[j]) {
                    trung = true;
                }
            }
            if (trung) continue;
            else break;
        }
        return result;
    }

    //    https://leetcode.com/problems/running-sum-of-1d-array/submissions/957785759/
    public static int[] runningSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
            runningSum[i] = total;
        }
        return runningSum;
    }

    //    https://leetcode.com/problems/max-consecutive-ones/submissions/957785876/
    public static int findMaxConsecutiveOnes(int[] nums) {
        int maxLen = 0;
        int curLen = 0;
        for (int num : nums) {
            if (num == 1) {
                curLen++;
                maxLen = Math.max(maxLen, curLen);
            } else {
                curLen = 0;
            }
        }
        return maxLen;
    }

    //    https://leetcode.com/problems/jump-game/submissions/957785964/
    public static boolean canJump(int[] nums) {
        int n = nums.length;
        int farthest = 0;
        for (int i = 0; i < n; i++) {
            if (i > farthest) {
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]);
            if (farthest >= n - 1) {
                return true;
            }
        }
        return true;
    }

    //    https://leetcode.com/problems/majority-element/submissions/957786018/
    public static int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            }
        }
        return candidate;
    }

    //    https://leetcode.com/problems/shuffle-the-array/submissions/957786074/
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n];
        int i = 0;
        int j = n;
        int k = 0;
        while (i < n && j < 2 * n) {
            result[k++] = nums[i++];
            result[k++] = nums[j++];
        }
        return result;
    }
}