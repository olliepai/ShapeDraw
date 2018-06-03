import java.awt.Graphics;

public class Polygon extends Shape {
	protected int centDist;
	protected int numSides;
	protected int[] xPoints;
	protected int[] yPoints;
	protected double theta;
	protected double offset;

	public Polygon(int x, int y, int centDist, int numSides) {
		super(x, y);
		
		this.centDist = centDist;
		this.numSides = numSides;
		
		xPoints = new int[numSides];
		yPoints = new int[numSides];
		
		if (numSides % 2 != 0) {
			theta = 0;
		} else {
			theta = 180.0 / numSides;
		}
		
		for (int i = 0; i < numSides; i++) {
			xPoints[i] = (int) (x + (centDist * Math.cos(theta)));
			yPoints[i] = (int) (y - (centDist * Math.sin(theta)));
			theta += 360.0 / numSides;
		}
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillPolygon(xPoints, yPoints, numSides);
	}

	public int getCentDist() {
		return centDist;
	}

	public void setCentDist(int centDist) {
		this.centDist = centDist;
		for (int i = 0; i < numSides; i++) {
			xPoints[i] = (int) (x + (centDist * Math.cos(theta)));
			yPoints[i] = (int) (y - (centDist * Math.sin(theta)));
			theta += 360.0 / numSides;
		}
	}
}

