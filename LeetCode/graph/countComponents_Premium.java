package leetcode.graph;

import java.util.*;

/*
 * 
 *323. Number of Connected Components in an Undirected Graph
Medium


Add to List

Share
You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

Return the number of connected components in the graph.
 
 *
 */
public class countComponents_Premium {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/*
		 * 5 [[0,1],[1,2],[3,4]] 5 [[0,1],[1,2],[2,3],[3,4]] 2 [[1,0]] 4
		 * [[2,3],[1,2],[1,3]] 3 [[1,0],[2,0]]
		 */

		System.out.println(countComponentsDFS(5, new int[][] { { 0, 1 }, { 1, 2 }, { 3, 4 } }));// 2

		System.out.println(countComponentsDFS(2, new int[][] { { 1, 0 } })); // 1

		System.out.println(countComponentsDFS(4, new int[][] { { 2, 3 }, { 1, 2 }, { 1, 3 } }));// 2

		System.out.println(countComponentsDFS(3, new int[][] { { 1, 0 }, { 2, 0 } }));// 1

	}

	private static void dfs(List<Integer>[] adjList, int[] visited, int startNode) {
		visited[startNode] = 1;

		for (int i = 0; i < adjList[startNode].size(); i++) {
			if (visited[adjList[startNode].get(i)] == 0) {
				dfs(adjList, visited, adjList[startNode].get(i));
			}
		}
	}

	public static int countComponentsDFS(int n, int[][] edges) {
		int components = 0;
		int[] visited = new int[n];

		List<Integer>[] adjList = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adjList[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < edges.length; i++) {
			adjList[edges[i][0]].add(edges[i][1]);
			adjList[edges[i][1]].add(edges[i][0]);
		}

		for (int i = 0; i < n; i++) {
			if (visited[i] == 0) {
				components++;
				dfs(adjList, visited, i);
			}
		}
		return components;
	}

	public static int countComponents(int n, int[][] edges) {

		// build a graph

		// traverse it bfs or dfs? [[0,1],[1,2],[4,3],[3,4]] bfs once queue is empty
		// count++

		if (n == 0) {
			return 0;
		}

		Map<Integer, List<Integer>> graph = new HashMap<>();

		for (int[] edge : edges) {

			List<Integer> l;

			if (graph.containsKey(edge[0])) {
				l = graph.get(edge[0]);
			} else {
				l = new ArrayList<>();
			}

			l.add(edge[1]);
			graph.put(edge[0], l);

			if (graph.containsKey(edge[1])) {
				l = graph.get(edge[1]);
			} else {
				l = new ArrayList<>();
			}

			l.add(edge[0]);
			graph.put(edge[1], l);
		}

		boolean visited[] = new boolean[n];

		Queue<Integer> q = new LinkedList<>();

		int comCnt = 0;

		for (int node : graph.keySet()) {// [[1,0],[2,0]] 1-0, 2-0

			if (!visited[node]) {

				q.add(node);

				while (!q.isEmpty()) {

					int visitingNode = q.poll();

					visited[visitingNode] = true;

					if (graph.containsKey(visitingNode)) {
						for (int adj : graph.get(visitingNode)) {

							if (!visited[adj]) {
								q.add(adj);
							}
						}
					}

				}

				// System.out.println(Arrays.toString(visited));

				comCnt++;
			}
		}

		for (boolean v : visited) {// count disconnected individual nodes
			if (!v) {
				comCnt++;
			}
		}

		return comCnt;
	}

}
