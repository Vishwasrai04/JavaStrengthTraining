package LeetCodeProblems.BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * This problem of subset is base of some many problems related to back tracking
 * Their are two approaches for solving this problem
 * 1.By iterative process(Just because it is much faster)
 * 2.By Recursive process - Using LeetCodeProblems.BackTracking
 */
public class Subsets {

    public static void main(String args[]){
        Subsets subsets = new Subsets();
        int[] nums = {1,2,3,4,5};
//        subsets.getSubSetIterative(nums);/** Iterative Process*/

        List<List<Integer>>res = new ArrayList<>();
        subsets.getSubSetRecursive(0, nums, new ArrayList<>(), res);/** Recursive process*/
        System.out.println(res);

    }
//
///** Iterative Process*/
//    public List<List<Integer>> getSubSetIterative(int[] nums){
//        List<List<Integer>>List = new ArrayList<>();
//        List.add(new ArrayList<>());
//
//        for(int i =0; i< nums.length; i++){
//            List<Integer>list = new ArrayList<>();
//            for(List<Integer> li:List){
//                li.add(nums[i]);
//            }
//            List.add(list);
//        }
//        return List;
//    }


/** Recursive Process*/
   public void getSubSetRecursive(int index, int[] nums, List<Integer>curr, List<List<Integer>> res){

     res.add(new ArrayList<>(curr));
     for(int i =index; i< nums.length; i++){
         curr.add(nums[i]);
         getSubSetRecursive(i+1, nums, curr, res);
         curr.remove(curr.size() -1);
     }
  }

}

