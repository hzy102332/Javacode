package leetcode;

import java.util.ArrayList;
import java.util.List;

public class kuohaogenerate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		generateParenthesis(3);
	}
	public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        result.add("(");
        for (int i = 0; i < n*2; i++){
            int s = result.size();
            for (int j = s; j > 0; j--){
                String temp = result.remove(0);
                int right = temp.replace("(","").length();
                int left = temp.replace(")","").length();
                
                if (left == right && left < n){ //如果(数量==)数量
                    result.add(temp+"(");
                }else if (left > right){
                    result.add(temp+")");
                    if (left < n)
                        result.add(temp+"(");
                }else 
                    break;
            }
        }
        return result;
    }
}
