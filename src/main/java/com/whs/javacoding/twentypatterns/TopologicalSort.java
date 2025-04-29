package com.whs.javacoding.twentypatterns;

import java.util.*;

public class TopologicalSort {
    public static List<Integer> sort(int vertices, int[][] edges) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[vertices];

        for (int i = 0; i < vertices; i++) graph.put(i, new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < vertices; i++)
            if (inDegree[i] == 0)
                queue.offer(i);

        List<Integer> sortedOrder = new ArrayList<>();
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            sortedOrder.add(vertex);
            for (int neighbor : graph.get(vertex)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }

        return sortedOrder.size() == vertices ? sortedOrder : new ArrayList<>();
    }

    public static void main(String[] args) {
        int[][] edges = {{3,2},{3,1},{2,0},{1,0}};
        System.out.println(sort(4, edges)); // Output: [3, 2, 1, 0]
    }
}
