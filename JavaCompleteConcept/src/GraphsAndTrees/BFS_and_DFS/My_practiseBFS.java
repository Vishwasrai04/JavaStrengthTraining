package GraphsAndTrees.BFS_and_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class My_practiseBFS {

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

    public void BFS(int origin, int destination){

        int[] parent = new int[adj.length];
        boolean[] visited = new boolean[adj.length];
        Queue<Integer>Qu = new LinkedList<>();

        parent[origin] = -1;
        Qu.offer(origin);
        visited[origin] = true;

        while (!Qu.isEmpty()) {
            int cur = Qu.poll();
            if(cur == destination){
                break;
            }

            if (!adj[cur].isEmpty()) {
                for (int neighbour : adj[cur]) {
                    if (!visited[neighbour]) {
                        visited[neighbour] = true;
                    }
                    parent[neighbour] = cur;
                    Qu.offer(neighbour);
                }
            }

        }

        int var = destination;
        int cout = 0;
        while(var != -1){
            cout++;
            int cur = parent[var];
            var = cur;
        }
        System.out.println("The shortest Distance between origin and destination node is = " + cout);

    }

    public static void main(String args[]){
        My_practiseBFS myPractise = new My_practiseBFS();
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
        myPractise.BFS(origin, destination);

    }

}



    