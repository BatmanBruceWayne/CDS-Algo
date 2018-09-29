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
	private ArrayList<Node> myNodeList = new ArrayList<>();
	private int diameter;
	private int endNode = -1;
	private Scanner sc;
	
	public ReadGraphInput(String path) throws FileNotFoundException {
		this.path = path;
		this.diameter = 1;
		sc = new Scanner(new File(this.path));

		for (int i=0; i<7; i++) {
		    int x = sc.nextInt();
		    int y = sc.nextInt();
		    int k = sc.nextInt();
		    myNodeList.add(new Node(x, y, Color.WHITE, k));
		    Node.numberOfNodes++;
		}
	}
	
	public void run() {
		dijkstraBoard();
		diameter();
		this.handleEndNode();
	}
	
	public float getDistance(Node a, Node b) {
		return (float) Math.sqrt((a.getX()-b.getX())*(a.getX()-b.getX()) + (a.getY()-b.getY())*(a.getY()-b.getY()));
	}
	

	
	private void aMatrix(){
		for(int i=0; i<Node.numberOfNodes; i++) {
			ArrayList<Boolean> tmp = new ArrayList<>();
			Node x = this.myNodeList.get(i);

			for(int j=0; j<Node.numberOfNodes; j++) {
				Node y = this.myNodeList.get(j);
				if(i == j) tmp.add(false);
				else if((int) this.getDistance(x, y) <= x.getRadius() + y.getRadius()) tmp.add(true);
				else tmp.add(false);
			}
			this.aMatrix.add(tmp);
		}
	}
	
//	public void print() {
//		for(int i=0; i<Node.numberOfNodes; i++) {
//			for(int j=0; j<Node.numberOfNodes; j++) {
//				System.out.
//			}
//			this.aMatrix.add(tmp);
//		}
//	}
	

	public ArrayList<ArrayList<Integer>> getDijkstraBoard() {
		return dijkstraBoard;
	}

	private void dijkstraBoard() {
		aMatrix();
		for(int i=0; i<Node.numberOfNodes; i++) {
			ArrayList<Integer> tmp = new ArrayList<>();
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
			for(int j=0; j<Node.numberOfNodes; j++) {
				if(this.aMatrix.get(i).get(j)) {
					DoneNode[j] = true;
					T.add(j);
				}
				
			}

			while(T.size() != 0) {
				int min = Integer.MAX_VALUE;
				for(int n=0; n<Node.numberOfNodes; n++) {
					if(!DoneNode[n]) {
						for(Integer node: T) {

							if(this.aMatrix.get(node).get(n)) {
								int distance = this.dijkstraBoard.get(i).get(node) + 1;

								if(distance < min) {
									min = distance;
								}
								this.dijkstraBoard.get(i).set(n, distance);
								break;
							}
						}
					}
					
				}
				T.clear();
				for(int n=0; n<Node.numberOfNodes ; n++) {
					
					if(this.dijkstraBoard.get(i).get(n) == min && !DoneNode[n]) {
						DoneNode[n] = true;
						T.add(n);
					}
				}
			}
		}
	}

	public int getDiameter() {
		return diameter;
	}

	private void diameter() {
		int max = 0;
		for(int i=0; i<Node.numberOfNodes; i++) {
			for(int j=0; j<Node.numberOfNodes; j++) {
				if(this.dijkstraBoard.get(i).get(j) > max) max = this.dijkstraBoard.get(i).get(j);
			}
		}
		this.diameter = max;
	}

	public int getEndNode() {
		return endNode;
	}
	
	private void handleEndNode() {
		for(int i=0; i<Node.numberOfNodes; i++) {
			if(endNode != -1) break;
			for(int j=0; j<Node.numberOfNodes; j++) {
				if(dijkstraBoard.get(i).get(j) == diameter) {
					endNode = i;
					break;
				}
			}
		}
	}
	
}
