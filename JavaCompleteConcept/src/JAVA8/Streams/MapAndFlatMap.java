package JAVA8.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapAndFlatMap {

    public static void main(String args[]){


        List<List<Integer>>List = new ArrayList<>();
        System.out.println(Stream.iterate(1,x->x+1).limit(4).collect(Collectors.toList()));
        for(int i = 0; i< 5; i++){
            List<Integer>list = new ArrayList<>();
            list.add(i+2);
            list.add(i*2);
            List.add(list);
        }
       /** Here as we used simple map so variable in left hand side is List<List<Integer>> */
        List<List<Integer>> CollectList = List.stream().map(val -> {
            System.out.println(val);
            return val;
        }).collect(Collectors.toList());


        /** Here as we used simple map so variable in left hand side is List<Integer> */
        List<Integer> collectlist = List.stream().flatMap(val -> val.stream()).map(val->{
            System.out.println(val);return val;}).collect(Collectors.toList());

        /** NOTE:- flatMap(val -> val.stream())  we ave first convert val into stream*/

        System.out.println(CollectList);
        System.out.println(collectlist);
        /** CollectList = [[2, 0], [3, 2], [4, 4], [5, 6], [6, 8]]*/
        /** collectlist =  [2, 0, 3, 2, 4, 4, 5, 6, 6, 8]*/
    }
}
