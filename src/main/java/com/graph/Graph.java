package com.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
	List<Edge> edges =new ArrayList();;
	Map<Integer,Vertex> allVertex = new HashMap<Integer,Vertex>();
	
	public Collection<Vertex> allVertexes(){
		return allVertex.values();
	}
	public List<Edge> getEdges(){
		return this.edges;
	}
	public void addEdge(int a,int b){
		Vertex vertex1 = null;
		if(allVertex.containsKey(a)){
			vertex1 = allVertex.get(a);
		}
		else{
			vertex1 = new Vertex(a);
			allVertex.put(a,vertex1);
		}
		Vertex vertex2=null;
		if(allVertex.containsKey(b)){
			vertex2 = allVertex.get(b);
		}
		else{
			vertex2 = new Vertex(b);
			allVertex.put(b,vertex2);
		}
		Edge edge = new Edge(vertex1,vertex2);
		vertex1.addAdjacentVertex(vertex2, edge);
	}
}
class Edge{
	Vertex start;
	Vertex end;
	public Edge(Vertex start,Vertex end){
		this.start=start;
		this.end=end;
	}
}
class Vertex{
	int a;
	List<Vertex> adjenceyVertices = new ArrayList();
	List<Edge> edges = new ArrayList();
	public Vertex(int a ){
		this.a=a;
	}
	public void addAdjacentVertex(Vertex vertex,Edge edge){
		adjenceyVertices.add(vertex);
		edges.add(edge);
	}
	public List<Vertex> getAllAdjenceyVertex(){
		return this.adjenceyVertices;
	}
	public Integer getVertex(){
		return this.a;
	}
}
