package GraphsAndTrees.BFS_and_DFS;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class My_practiseDFS {
    public LinkedList<Integer>[] adj;

    public  void create_nodes(int nodes){
        adj = new LinkedList[nodes];
        for (int i =0; i<nodes; i++){
            adj[i] = new LinkedList<>();
        }
    }

    public void create_edges(int start, int end){
        adj[start].add(end);
        adj[end].add(start);
    }

    public void leaf(int node, Stack <Integer> st, boolean visited[]){
        for(int leafs: adj[node]){

            if(visited[leafs]){
                return;
            }else{
                visited[leafs] = true;
            }
            leaf(leafs,st,visited);
        }

    }
    public void DFS(int origin, int destination){
        boolean[] visited = new boolean[adj.length];
        Stack<Integer>st = new Stack<>();
        st.push(origin);

        visited[origin] = true;

        while(!st.isEmpty()){
            int var = st.peek();
            leaf(var,st, visited);
        }

//        while(!st.isEmpty()){
//            if(st.peek() == destination){
//                break;
//            }
//        for(int nodes : adj[st.peek()]){
//            if(!visited[nodes]){
//                visited[nodes] = true;
//            }
//        }
//
//        }


    }


    public static void main(String args[]){
        My_practiseDFS myPractise = new My_practiseDFS();
        System.out.println("***DFS***");
        System.out.println("How many nodes you want to create");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        myPractise.create_nodes(n);

        System.out.println("How many edges you want to create");
        int no_edges = sc.nextInt();

        System.out.println("Create edges and connect nodes");
        for(int i = 0; i<no_edges; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            myPractise.create_edges(start, end);
        }
        System.out.println("Enter vertices or nodes between which you want to find distance");
        System.out.println("Start = ");
        int origin =  sc.nextInt();
        System.out.println("End = ");
        int destination = sc.nextInt();
        myPractise.DFS(origin, destination);

    }

}
