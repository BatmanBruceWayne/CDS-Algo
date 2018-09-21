package mainProgram;

import java.awt.Color;
import java.util.ArrayList;

import algoObjects.IllustraGraph;

public class CDSAlgo {
	private IllustraGraph myGraph;
	
	public CDSAlgo(IllustraGraph myGraph) {
		
		this.myGraph = myGraph;
		
	}
	
	public void run() {
		int root = myGraph.getRoot();
		ArrayList<ArrayList<Integer>> dGraph = myGraph.getDGraph();
		
		boolean[] MIS = new boolean[myGraph.getNumberOfVertex()];
		for(int k=1; k <= myGraph.getDiameter(); k++) {
			for(int y=0; y < myGraph.getNumberOfVertex(); y++) {
				if(dGraph.get(root).get(y) == k) {
					MIS[y] = true;
				}
			}
		}
		for(int i=0; i<myGraph.getNumberOfVertex(); i++) {
			if(MIS[i]) {
				myGraph.getVertices().get(i).setColor(Color.BLACK);
			}
		}
	}
	
	
}
