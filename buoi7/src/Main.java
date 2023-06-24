import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
    }

    //        https://leetcode.com/problems/sort-an-array/submissions/978254243/
    public int[] sortArray(int[] nums) {
        int[] result = mergeSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }

        return nums;
    }

    int[] mergeSort(int[] nums, int l, int r) {
        if (l > r) return new int[0];
        if (l == r) return new int[]{nums[l]};

        int mid = (l + r) / 2;
        int[] a1 = mergeSort(nums, l, mid);
        int[] a2 = mergeSort(nums, mid + 1, r);

        return merge(a1, a2);
    }

    int[] merge(int[] a1, int[] a2) {
        int n = a1.length + a2.length;
        int[] result = new int[n];

        int i = 0, i1 = 0, i2 = 0;
        while (i < n) {
            if (i1 < a1.length && i2 < a2.length) {
                if (a1[i1] <= a2[i2]) {
                    result[i++] = a1[i1++];
                } else {
                    result[i++] = a2[i2++];
                }
            } else {
                if (i1 < a1.length) {
                    result[i++] = a1[i1++];
                } else {
                    result[i++] = a2[i2++];
                }
            }
        }
        return result;

    }

    //        https://leetcode.com/problems/neither-minimum-nor-maximum/submissions/977929832/
    public int findNonMinOrMax(int[] nums) {
        int min = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        if (nums.length < 3) {
            return -1;
        } else {
            for (int num : nums) {
                if (num != min && num != max) {
                    return num;
                }
            }
        }
        return -1;
    }

    //    https://leetcode.com/problems/longest-square-streak-in-an-array/submissions/978252875/
    public int longestSquareStreak(int[] nums) {
        Arrays.sort(nums);
        int res = -1;
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);

        for (int n : nums) {
            int count = 1;
            int m = (int) Math.pow(n, 2);
            while (set.contains(m)) {
                count++;
                m = (int) Math.pow(m, 2);
            }
            if (count > 1) res = Math.max(res, count);
        }
        return res;
    }
}
