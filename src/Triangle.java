import java.awt.Graphics;

public class Triangle extends Shape {
	protected int width;
	protected int height;
	protected int[] xPoints = new int[3];
	protected int[] yPoints = new int[3];

	public Triangle(int x, int y, int width, int height) {
		super(x, y);
		
		xPoints[0] = x;
		yPoints[0] = y - height;
		xPoints[1] = x - width;
		yPoints[1] = y + height;
		xPoints[2] = x + width;
		yPoints[2] = y + height;

		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillPolygon(xPoints, yPoints, 3);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
		xPoints[0] = x;
		xPoints[1] = x - width;
		xPoints[2] = x + width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
		yPoints[0] = y - height;
		yPoints[1] = y + height;
		yPoints[2] = y + height;
	}
}
