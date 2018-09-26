package mainProgram;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import algoObjects.Node;

public class ReadGraphInput {
	
	private String path;
	private ArrayList<ArrayList<Boolean>> aMatrix = new ArrayList<>(); //illustrate graph with true and false board
	private ArrayList<ArrayList<Integer>> dijkstraBoard = new ArrayList<>(); // create a Dijkstra board 
	private ArrayList<Node> myNodeList;
	
	public ReadGraphInput(String path) throws FileNotFoundException {
		this.path = path;
		Scanner sc = new Scanner(new File(path));
		while (sc.hasNextLine()) {
		    double x = sc.nextDouble();
		    double y = sc.nextDouble();
		    double k = sc.nextDouble();
		    myNodeList.add(new Node(x, y, Color.WHITE, k));
		    Node.numberOfNodes++;
		}
	}
	
	public float getDistance(Node a, Node b) {
		return (float) Math.sqrt((a.getX()-b.getX())*(a.getX()-b.getX()) + (a.getY()-b.getY())*(a.getY()-b.getY()));
	}
	

	
	public ArrayList<ArrayList<Boolean>> getAMatrix(){
		for(int i=0; i<Node.numberOfNodes; i++) {
			ArrayList<Boolean> tmp = null;
			for(int j=0; j<Node.numberOfNodes; j++) {
				Node x = this.myNodeList.get(i);
				Node y = this.myNodeList.get(j);
				if((double) this.getDistance(x, y) <= x.getRadius() + y.getRadius()) tmp.add(true);
				else tmp.add(false);
			}
			this.aMatrix.add(tmp);
		}
		return this.aMatrix;
	}
	
	public ArrayList<ArrayList<Integer>> getDijkstraBoard(){
		
		return this.dijkstraBoard;
	}
}
