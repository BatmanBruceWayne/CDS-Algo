package algoObjects;

import java.awt.Color;

public class Node {
	private Color color;
	private double coordinate_x;
	private double coordinate_y;
	private int number;
	public Node(double coordinate_x, double coordinate_y, Color color) {
		this.color = color;
		this.coordinate_x = coordinate_x;
		this.coordinate_y = coordinate_y;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
}
