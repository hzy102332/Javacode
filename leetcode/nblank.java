package leetcode;

import java.util.ArrayList;
import java.util.List;

public class nblank {
	private String str = "你好 ";
	
	public nblank() {
		addBlank(2);
		System.out.println(str);
		System.out.printf("新字符串长度：%d\n", str.length());
	}
	public void addBlank(int n){
		String a = str.substring(0, 1);
		String b = str.substring(1);
		str = String.format("%s%" + (n) + "s", a,"");
	}
	
public static void main(String[] args) {
//		new nblank();
	int max = 16;
	String s = "sd";
	String [] words = {"This", "is", "an", "example", "of", "text", "justification."};
	System.out.print(fullJustify(words,max));
//	s = String.format("%" + (4) + "s%s", s,"");
//	System.out.print(s);
	}
	
public static List<String> fullJustify(String[] words, int maxWidth) {
	        int temp = 0;
	        String line = "";
	        List<String> t = new ArrayList<>();
	        List<String> result = new ArrayList<>();
	        
	        for (String word : words){
	            
	            temp += word.length()+1;
	            
	            if (word == words[words.length-1] && temp <= maxWidth+1){
	             //剩余
	            	t.add(word);
	                for (int i = 0; i < t.size(); i ++){
	                    line = line + t.get(i) + " ";
	                    // line = String.format("%s%" + (1) + "s", line, " ");
	                }
	                // line = String.format("%s%" + (maxWidth-line.length()) + "s", line, "");
	                result.add(line);
	            } 
	            else if(temp <= maxWidth+1)
	                t.add(word);
	            else{//如果超过长度,进行排序
	                temp -= word.length()+1;
	                int re = maxWidth - temp; 
	                int blank = (maxWidth-temp)/(t.size()-1);
	                //从右往左加,空格数不断减
	                for (int i = t.size()-1; i >= 0; i--){
	                    if (i == 0)
	                        // line = t.get(i) + " " * re % blank + line;
	                        line = String.format("%s%" + (re%blank) + "s", t.get(i), line);
	                    else
	                        // line = " " * blank + t.get(i) + line;
	                        line = String.format("%" + (blank) + "s%s", t.get(i),line);
	                }
	                result.add(line);
	                t.clear();
	                t.add(word);
	                line = "";
	                temp = word.length()+1;
	            }
	        }
	        return result;
	    }
}
