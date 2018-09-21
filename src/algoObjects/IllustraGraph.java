package algoObjects;

import java.awt.Color;
import java.util.ArrayList;


public class IllustraGraph {
	private ArrayList<ArrayList<Boolean>> iGraph = new ArrayList<>(); //illustrate graph with true and false board
	private ArrayList<ArrayList<Integer>> dGraph = new ArrayList<>(); //Describe distances between some two nodes at every point of the arrayList
	private int numberOfVertex = 5;
	private int diameter;
	private int root;
	private ArrayList<Node> vertices;
	
	public IllustraGraph() {
		this.initD();
		this.initI();
		this.root = 0;
		for(int i=0; i<numberOfVertex; i++) {
			vertices.add(new Node(0, 0, Color.WHITE));
		}

	}
	
	private void initI() {
		ArrayList<Boolean> tmp = new ArrayList<>();
		tmp.add(false); tmp.add(false); tmp.add(false); tmp.add(true); tmp.add(true);
		iGraph.add(tmp);
		tmp.add(false); tmp.add(false); tmp.add(true); tmp.add(true); tmp.add(true);
		iGraph.add(tmp);
		tmp.add(false); tmp.add(true); tmp.add(false); tmp.add(false); tmp.add(false);
		iGraph.add(tmp);
		tmp.add(true); tmp.add(true); tmp.add(false); tmp.add(false); tmp.add(false);
		iGraph.add(tmp);
		tmp.add(true); tmp.add(true); tmp.add(false); tmp.add(false); tmp.add(false);
		iGraph.add(tmp);
	}
	
	private void initD(){
		ArrayList<Integer> tmp = new ArrayList<>();
		tmp.add(0); tmp.add(2); tmp.add(3); tmp.add(1); tmp.add(1);
		dGraph.add(tmp);
		tmp.add(2); tmp.add(0); tmp.add(1); tmp.add(1); tmp.add(1);
		dGraph.add(tmp);
		tmp.add(3); tmp.add(1); tmp.add(0); tmp.add(2); tmp.add(2);
		dGraph.add(tmp);
		tmp.add(1); tmp.add(1); tmp.add(2); tmp.add(0); tmp.add(2);
		dGraph.add(tmp);
		tmp.add(1); tmp.add(1); tmp.add(2); tmp.add(2); tmp.add(0);
		dGraph.add(tmp);
	}
	
	public int getNumberOfVertex() {
		return this.numberOfVertex;
	}
	
	public int getRoot() {
		return this.root;
	}
	
	public int getDiameter() {
		return this.diameter;
	}
	
	public ArrayList<ArrayList<Integer>> getDGraph(){
		return this.dGraph;
	}
	
	public ArrayList<Node> getVertices(){
		return this.vertices;
	}
	
}
