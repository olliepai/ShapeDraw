import java.awt.Graphics;

public class Ellipse extends Shape {
	protected int width;
	protected int height;

	public Ellipse(int x, int y, int width, int height) {
		super(x, y);

		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, width, height);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

}
