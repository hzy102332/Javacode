package leetcode;

public class decode {
	public static void main(String[]args) {
		numDecodings("22222");
	}
	public static int numDecodings(String s) {
        int len = s.length();
        int dp [] = new int [len];
        dp[0] = 1;
        for (int i = 1; i < len; i++){
            if (s.charAt(i-1) != '*'){
                if (s.charAt(i-1) > '2') {
                    if (s.charAt(i) == 0) 
                        dp[i] = dp[i-1];
                    else {
                        dp[i] = dp[i-1] + 1;
                    }
                // else if (s.charAt(i-1) == 2)
                }
                else {// i-1 == 1,2
                    if (s.charAt(i) > '6')
                        dp[i] = dp[i-1];
                    else 
                        dp[i] = dp[i-1] + 1;
                    
                    int temp = i-2;
                    while(s.charAt(temp) <= '2' && temp > 0){
                        dp[i] = dp[i] + 1;
                        temp --;
                    }
                }
            }
            else{ //i-1 == *
                
            }
        }
        return dp[len -1];
    }
}
