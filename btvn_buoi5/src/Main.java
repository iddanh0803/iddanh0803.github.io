public class Main {
    public static void main(String[] args) {

//        https://leetcode.com/problems/fibonacci-number/submissions/973055995/
        class Solution1 {
            public int fib(int n) {
                int f0 = 0, f1 = 1, fn = 1;
                if(n==0 || n==1){
                    return n;
                }

                return fib(n-1)+fib(n-2);
            }
        }
//        https://leetcode.com/problems/reverse-string/submissions/973056140/
        class Solution2 {
            public void reverseString(char[] s) {
                int r = s.length - 1;
                int l = 0;
                while (l<r){
                    char c = s[l];
                    s[l] = s[r];
                    s[r] = c;
                    l++;
                    r--;
                }
            }
        }
//        https://leetcode.com/problems/power-of-three/submissions/973038877/
        class Solution3 {
            public boolean isPowerOfThree(int n) {
                if(n<=0) return false;
                while(n%3==0){
                    n/=3;
                }
                return n==1;
            }
        }
//        https://leetcode.com/problems/power-of-four/submissions/973039379/
        class Solution4 {
            public boolean isPowerOfFour(int n) {
                if(n==0) return false;
                if(n==1) return true;
                while(n%4==0)
                {
                    n/=4;
                }
                return n==1;
            }
        }
//        https://leetcode.com/problems/decode-string/submissions/973054405/
        class Solution5 {
            int pos=0;
            public String decodeString(String s) {
                StringBuilder str = new StringBuilder();
                int num=0;
                while(pos<s.length()){
                    char c = s.charAt(pos);
                    if(c>='0'  && c<='9'){
                        num=num*10+(c-'0');
                    }else if(c>='a' && c<='z'){
                        str.append(c);
                    }else if(c=='['){
                        pos++;
                        String temp = decodeString(s);
                        for(int i=0; i<num; i++)str.append(temp);
                        num=0;
                    }else if(c==']'){
                        break;
                    }
                    pos++;
                }
                return str.toString();
            }
        }
//        https://leetcode.com/problems/find-the-winner-of-the-circular-game/submissions/973054984/
        class Solution6 {
            public int rec(int n, int k){
                if(n==1){
                    return 0;
                }
                return (rec(n-1, k)+k)%n;
            }

            public int findTheWinner(int n, int k) {
                int ans = rec(n,k)+1;
                return ans;
            }
        }
    }
}