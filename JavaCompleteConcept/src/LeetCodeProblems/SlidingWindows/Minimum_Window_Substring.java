package LeetCodeProblems.SlidingWindows;

public class Minimum_Window_Substring {
    public static void main(String args[]){

        Minimum_Window_Substring minimumWindowSubstring = new Minimum_Window_Substring();
        System.out.println(minimumWindowSubstring.MWSS("ADOBECODEBANC", "ABC"));

    }

    public  int MWSS(String s, String t){
      if(t.length() ==0 || s.length() == 0 || t.length()>s.length()){
          return 0;
      }
      int[] arr = new int[26];
      for(int i =0; i<t.length();i++){
          arr[t.charAt(i)-'A']++;
      }
      // I need to fetch substring string from the given string, so need an start index and end index
      int start = 0;
      int end = 0;


      // to traverse string s i need window i,j;
      int i = 0;
      int j = 0;

      // I need a count variable to check whether i have covered all the elements of t string
      int count = t.length();

      int minlen = Integer.MAX_VALUE;

      char[] ch = s.toCharArray(); // This will boost performance
      while(j<s.length()){
          if(arr[ch[j]-'A']-- >0){
              count--;
          }
          while(count == 0){
              if(j-i+1<minlen){
                  minlen = j-i+1;
                  start = i;
                  end = j;
              }
              if(arr[ch[i++]-'A']++ >=0){
                  count++;
              }
          }

          j++;
      }

      System.out.println(s.substring(start, end+1));
     return minlen;
    }
}
