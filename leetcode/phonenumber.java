package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class phonenumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(letterCombinations("23"));
	}
	public static List<String> letterCombinations(String digits) {
        int len = digits.length();
        List<String> result = new ArrayList<>();
        Map<String, String> map = new HashMap<String, String>() {{
            put("2", "abc");
            put("3", "def");
            put("4", "ghi");
            put("5", "jkl");
            put("6", "mno");
            put("7", "pqrs");
            put("8", "tuv");
            put("9", "wxyz");
        }};
        String [] arr = digits.split("");
        if (len == 0)
            return result;
        if (len == 1){
            String t = map.get(digits);
            List<String> re = Arrays.asList(t.split(""));
            return re;
        }
        else {
            result.add("");
            for (int i = 0; i < len-1; i ++){
            	char c = digits.charAt(i);
                String r = map.get(c);
                String [] t = r.split("");  
                int len_re = result.size();
                for(int j = 0; j < len_re; j++){
                    String temp = result.remove(0);
                    for(String e: t){
                        result.add(temp+e);
                    }
                }                
            }
        }
        return result;
    }
}
