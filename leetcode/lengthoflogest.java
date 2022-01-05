package leetcode;

public class lengthoflogest {
	public static void main(String[]args) {
		String s = "pwwkew";
		System.out.print(lengthOfLongestSubstring(s));
	}
	public static int lengthOfLongestSubstring(String s) {
		   // ��¼�ַ���һ�γ��ֵ�λ��
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // ���ڿ�ʼλ��
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }

        return res;
	}
	
}
