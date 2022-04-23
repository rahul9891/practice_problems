package Hacker_Rank.Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graph {
	
	Map<Vertex, List<Vertex>> map = new HashMap<>();
	
	
	void addVertex(String name) {
		map.putIfAbsent(new Vertex(name), new ArrayList<>());
	}
	
	void removeVertex(String name) {
		Vertex v = new Vertex(name);
		map.values().stream().forEach(e -> e.remove(v));
		map.remove(new Vertex(name));
	}
	
	void addEdge(String name1, String name2) {
		
		Vertex v1= new Vertex(name1);
		Vertex v2= new Vertex(name2);
		
		map.get(v2).add(v1);
		map.get(v1).add(v2);
	}
	
	void removeEdge(String name1, String name2) {
		Vertex v1= new Vertex(name1);
		Vertex v2= new Vertex(name2);
		
		List<Vertex> lv1 = map.get(v1);
		List<Vertex> lv2 = map.get(v2);
		
		if(lv1 != null) lv1.remove(v2);
		
		if(lv2 != null) lv2.remove(v1);
	}
	
	List<Vertex> getNeighbours(String name) {
		
		return map.get(new Vertex(name));
	}
	
	static Set<String> bfs(String root, Graph g) {
		
		Set<String> visited = new LinkedHashSet<>();
		Queue<String> q = new LinkedList<>();
		
		visited.add(root);
		q.add(root);
		
		while(!q.isEmpty()) {
			String vertex = q.poll();
			for(Vertex v: g.getNeighbours(vertex)) {
				if(!visited.contains(v)) {
					visited.add(v.label);
					q.add(v.label);
				}
			}
		}
		
		return visited;
	}
	
	
	public static void main(String[] args) {
		Graph g = new Graph();
		g.addVertex("Rahul");
		g.addVertex("Suresh");
		g.addVertex("Mahesh");
		g.addVertex("Senthil");
		g.addVertex("Ramu");
		g.addVertex("Jaya");
		g.addVertex("Swati");
		g.addVertex("Anjali");
		g.addVertex("Rima");
		
		g.addEdge("Rahul", "Senthil");
		g.addEdge("Rahul", "Mahesh");
		g.addEdge("Ramu", "Suresh");
		g.addEdge("Ramu", "Senthil");
		g.addEdge("Ramu", "Jaya");
		g.addEdge("Rima", "Anjali");
		g.addEdge("Anjali", "Swati");
		g.addEdge("Swati", "Rahul");
		g.addEdge("Jaya", "Senthil");
		
		
		Set<String> result = bfs("Rahul", g);
		for(String s: result) {
			System.out.println(s);
		}
		
	}
}
