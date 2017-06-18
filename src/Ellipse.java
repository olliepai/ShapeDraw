import java.awt.Graphics;

public class Ellipse extends Shape{
	protected int width;
	protected int height;
	
	@Override
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillRect(x, y, width, height);
	}

}
