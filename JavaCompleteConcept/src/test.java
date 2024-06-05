import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public  class test {


    public static void main(String args[]) {
       String input = "t2e1st This i1s f1irs1t";
       String Output = "This is the first test";

       String str = code(input);
        System.out.println(str);

    }

    private static String code(String input) {
        String[] str = input.split(" ");
        HashMap<Integer, String>map = new HashMap<>();
        List<Integer>list = new ArrayList<>();
        for(int i = 0; i< str.length; i++){

            String temp = str[i].trim();
            int count = 0;
            StringBuilder sb = new StringBuilder("");

            char[] ch = temp.toCharArray();
            for(char c : ch){
                if(Character.isDigit(c)){
                    count = count + c;
                }else{
                    sb.append(c);
                }
            }

            map.put(count, sb.toString());
            list.add(count);

        }

        Collections.sort(list);

        StringBuilder sb = new StringBuilder("");
        String prev = "";
        for(int val : list){
            String curr = map.get(val);
            if(curr != prev){
                sb.append(curr);
                sb.append(" ");
            }
            prev = curr;
        }

        return sb.toString().trim();
    }

}




