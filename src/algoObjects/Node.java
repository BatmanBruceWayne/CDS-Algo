package algoObjects;

import java.awt.Color;

public class Node {
	private Color color;
	private double coordinate_x;
	private double coordinate_y;
	private double radius;
	
	public static int numberOfNodes = 0;
	public Node(double coordinate_x, double coordinate_y, Color color, double radius) {
		this.color = color;
		this.coordinate_x = coordinate_x;
		this.coordinate_y = coordinate_y;
		this.radius = radius;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
	
	public double getX() {
		return this.coordinate_x;
	}
	
	public double getY() {
		return this.coordinate_y;
	}
	
	public double getRadius() {
		return this.radius;
	}
	
}
