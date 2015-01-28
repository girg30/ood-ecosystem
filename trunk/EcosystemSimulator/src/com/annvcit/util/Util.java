package com.annvcit.util;

import java.awt.Point;
import java.awt.Rectangle;

public class Util {
	
	public static final double distance(Rectangle r1, Rectangle r2) {
		Point p1 = new Point(r1.x + r1.width / 2, r1.y + r1.height / 2);
		Point p2 = new Point(r2.x + r2.width / 2, r2.y + r2.height / 2);

		return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2)
				+ Math.pow(p2.getY() - p1.getY(), 2));
	}
}
