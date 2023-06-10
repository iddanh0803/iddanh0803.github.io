import java.util.*;

public class Main {
    public static void main(String[] args) {

    }
//    https://leetcode.com/problems/third-maximum-number/submissions/967739021/
    public static int thirdMax(int[] nums) {
        long m1=Long.MIN_VALUE;
        long m2=Long.MIN_VALUE;
        long m3=Long.MIN_VALUE;
        Arrays.sort(nums);
        for(int i=nums.length-1;i>=0;i--)
        {
            if(nums[i]>m1)
                m1=nums[i];
            else if(m1>nums[i] && nums[i]>m2)
                m2=nums[i];
            else if(m2>nums[i] && nums[i]>m3)
                m3=nums[i];
        }
        return (m3==Long.MIN_VALUE ? (int)m1 :(int) m3);
    }
//    https://leetcode.com/problems/height-checker/submissions/967737840/
    public static int heightChecker(int[] heights) {
        int newHeights[] = new int[heights.length];
        for(int i=0; i<heights.length; i++) {
            newHeights[i]=heights[i];
        }
        Arrays.sort(heights);
        int ans=0;

        for(int i=0; i<heights.length; i++) {
            if(heights[i]!=newHeights[i]) {
                ans++;
            }
        }

        return ans;
    }
//    https://leetcode.com/problems/sort-the-people/submissions/967737731/
    public String[] sortPeople(String[] names, int[] heights) {
        HashMap<Integer, String> map= new HashMap<>();
        int k=0;
        for(int height: heights){
            map.put(height, names[k]);
            k++;
        }
        Arrays.sort(heights);
        String[] res=new String[names.length];
        int j=0;
        for(int i=heights.length-1;i>=0;i--){
            res[j]= map.get(heights[i]);
            j++;
        }
        return res;
    }
//    https://leetcode.com/problems/sort-array-by-increasing-frequency/submissions/967738213/
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();
        for (int n : nums) {
            ans.add(n);
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        Collections.sort(ans, (a, b) ->
                (map.get(a) == map.get(b))? b - a : map.get(a) - map.get(b)
        );

        return ans.stream().mapToInt(i -> i).toArray();
    }
}