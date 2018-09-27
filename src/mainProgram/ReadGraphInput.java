package mainProgram;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import algoObjects.Node;

public class ReadGraphInput {
	
	private String path;
	private ArrayList<ArrayList<Boolean>> aMatrix = new ArrayList<>(); //illustrate graph with true and false board
	private ArrayList<ArrayList<Integer>> dijkstraBoard = new ArrayList<>(); // create a Dijkstra board 
	private ArrayList<Node> myNodeList;
	private int diameter;
	
	public ReadGraphInput(String path) throws FileNotFoundException {
		this.path = path;
		this.diameter = 1;
		Scanner sc = new Scanner(new File(this.path));
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
		
		for(int i=0; i<Node.numberOfNodes; i++) {
			ArrayList<Integer> tmp = null;
			for(int j=0; j<Node.numberOfNodes; j++) {
				
				if(i == j) tmp.add(0);
				else if(this.aMatrix.get(i).get(j)) tmp.add(1);
				else tmp.add(Integer.MAX_VALUE);
			}
			this.dijkstraBoard.add(tmp);
		}
		
		for(int i=0; i<Node.numberOfNodes; i++) {
			Set<Integer> T = new HashSet<>();
			boolean[] DoneNode = new boolean[Node.numberOfNodes];
			DoneNode[i] = true;
			for(int j=1; j<Node.numberOfNodes && this.aMatrix.get(i).get(j); j++) {
				DoneNode[j] = true;
				T.add(j);
			}
			
			while(T.size() != 0) {
				int min = Integer.MAX_VALUE;
				for(int n=0; n<Node.numberOfNodes && !DoneNode[n]; n++) {
					for(Integer node: T) {
						if(this.aMatrix.get(node).get(n)) {
							int distance = this.dijkstraBoard.get(i).get(node) + 1;
							if(distance < min) min = distance;
							this.dijkstraBoard.get(i).set(n, distance);
							break;
						}
					}
				}
				T.clear();
				for(int n=0; n<Node.numberOfNodes && !DoneNode[n]; n++) {
					if(this.dijkstraBoard.get(i).get(n) == min) {
						DoneNode[n] = true;
						T.add(n);
					}
				}
			}
		}
		
		return this.dijkstraBoard;
	}
	
	
	
}
