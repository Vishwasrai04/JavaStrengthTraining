package LeetCodeProblems.BackTracking;

public class NextPermutation {

    public static void main(String args[]){
        int number = 45321;

        /** Here are steps to be followed 3 steps to be followed
         * 1. Identification : From back side start check increasing order like this 4321, but if found 45321  stop at 4
         * 2. Swap : swap the identified number with the next highest number in right of disorder numbers.in our case its 5
         * 3. Sort : sort the remaining number in the right of identified number.
         * */
        char[] ch = String.valueOf(number).toCharArray();
        int len = ch.length;
        int i =len-2;
        while(i>=0 && ch[i] >= ch[i+1]){
           i--;
        }

        if(i>=0){
            int j = ch.length-1;
            while (j>=0 && ch[j]<ch[i]){j--;}
            swap(ch, i, j);
        }

        reverse(ch, i+1);

        for (char c : ch){
            System.out.print(c);
        }

    }
    private static void swap(char[] ch, int i, int j) {
      char temp = ch[i];
      ch[i] = ch[j];
      ch[j] = temp;
    }
    private static void reverse(char[] ch, int i) {

        int start = i;
        int end = ch.length-1;

        while(start<end){
            swap(ch, start, end);
            start++;
            end--;
        }

    }




}
