package LeetCodeProblems;

import java.util.Arrays;
import java.util.List;

public class IsomorphicString {
    public static void main(String args[]) {
        List<String> list = Arrays.asList("rcbyn", "dy", "rcbyndy", "xx", "lorel");
        String words = "rcbyndyxxrcbyndyxx";
        System.out.println(new IsomorphicString().isIsomorphic("aa", "ab"));
    }

    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] cs = s.toCharArray();
        char[] ts = t.toCharArray();

        int[] apl1 = new int[26];
        int [] apl2 = new int[26];


        for(int i = 0; i<s.length(); i++){

            int i1 = cs[i] - 'a';
            int i2 = ts[i] - 'a';
            if(apl1[cs[i]-'a'] != apl2[ts[i]-'a']){
                return false;
            }
            char c1 = cs[i];
            char c2 = ts[i];


            apl1[cs[i]-'a'] = i;
            apl2[ts[i]-'a'] = i;

        }


        return true;
    }
}



