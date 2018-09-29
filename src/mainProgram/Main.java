package mainProgram;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import algoObjects.Node;

public class Main {
	
	private static ReadGraphInput reader;
	
	public Main() {
		try {
			this.reader = new ReadGraphInput("TestData.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Main();
		
		reader.run();
//		ArrayList<ArrayList<Integer>> dBoard = reader.getDijkstraBoard();
//		int endnode = reader.getEndNode();
//		System.out.println(endnode);
//		for(int i=0; i<dBoard.size(); i++) {
//			for(int j=0; j<dBoard.size(); j++) {
//				System.out.print(dBoard.get(i).get(j) + " ");
//			}
//			System.out.println("");
//
//		}
	}
}
