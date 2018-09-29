package algoObjects;

import java.awt.Color;

public class Node {
	private Color color;
	private int coordinate_x;
	private int coordinate_y;
	private int radius;
	
	public static int numberOfNodes = 0;
	public Node(int coordinate_x, int coordinate_y, Color color, int radius) {
		this.color = color;
		this.coordinate_x = coordinate_x;
		this.coordinate_y = coordinate_y;
		this.radius = radius;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public int getX() {
		return this.coordinate_x;
	}
	
	public int getY() {
		return this.coordinate_y;
	}
	
	public int getRadius() {
		return this.radius;
	}
	
}
