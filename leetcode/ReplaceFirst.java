package leetcode;

public class ReplaceFirst {
	public static void main(String []args) {
		String s = "-3.5e7";
		System.out.print(s.indexOf("."));
		System.out.print(check(s));
	}
public static boolean check (String s) {
	int plus = 0, min = 0, dot = 0,se = 0, be = 0;
    if (s.contains("+")){
        plus = s.indexOf("+");
        s = s.replaceFirst("+","");
    }
    if (s.contains("-")){
        min = s.indexOf("-");
        s = s.replaceFirst("-","");
    }
    if (s.contains(".")){
        dot = s.indexOf(".");
        s = s.replaceFirst("\\.","");
    }
    if (s.contains("e")){
        se = s.indexOf("e");
        s = s.replaceFirst("e","");
    }
    if (s.contains("E")){
        be = s.indexOf("E");
        s = s.replaceFirst("E","");
    }
    if (be < plus || be < min || se < plus|| se < min|| be < dot || se < dot)
        return false;
    else{
        for (int i = 0; i < s.length(); i++){
            if(!Character.isDigit(s.charAt(i)))
                return false;
        }
    }      
    return true;
}
}
