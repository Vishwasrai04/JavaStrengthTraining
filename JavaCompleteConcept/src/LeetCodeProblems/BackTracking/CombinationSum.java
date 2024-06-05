package LeetCodeProblems.BackTracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String args[]){

        int [] candidates = {2,3,6,5,7};
        int target = 7;
        CombinationSum cSum = new CombinationSum();
        cSum.combinationSum(candidates, target);

    }
    public List<List<Integer>> combinationSum(int [] candidates, int target){

        List<List<Integer>>comb = new ArrayList<>();
        generateCombination(0, candidates, new ArrayList<>(), comb, target);
        System.out.println(comb);
        return comb;

    }

    private void generateCombination(int index, int[] candidates, ArrayList<Integer> list, List<List<Integer>> List, int target) {

         if(target == 0){
             List.add(new ArrayList(list));
         }
         if(target<0){
             return;
         }
         for(int i = index; i<candidates.length; i++){
             list.add(candidates[i]);
             generateCombination(i, candidates, list, List, target-candidates[i]);
             list.remove(list.size() -1);

         }
    }
}
