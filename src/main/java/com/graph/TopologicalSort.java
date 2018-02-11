package com.graph;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.graph.Graph;

public class TopologicalSort {

	public static void main(String[] args) {
		Graph graph =new Graph();
		graph.addEdge(1, 3);
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);
		graph.addEdge(5, 6);
		graph.addEdge(6, 3);
		graph.addEdge(3, 8);
		graph.addEdge(8, 11);
		Stack<Vertex> stack = new Stack<Vertex>();
		Set <Vertex> visitedVertices = new HashSet<Vertex>();
		for(Vertex vertex:graph.allVertexes()){
			if(visitedVertices.contains(vertex)){
				continue;
			}
			sortUtils(vertex,stack,visitedVertices);
		}
		 while(!stack.isEmpty()){
	            System.out.println(stack.pop().getVertex());
	        }
	}

	private static void sortUtils(Vertex vertex, Stack<Vertex> stack, Set<Vertex> visitedVertices) {
		visitedVertices.add(vertex);
		for(Vertex vert:vertex.getAllAdjenceyVertex()){
			if(visitedVertices.contains(vert))
				continue;
			sortUtils(vert, stack, visitedVertices);
		}
		stack.add(vertex);
		
	}

}
