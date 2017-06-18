import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {
	protected int x;
	protected int y;
	
	protected Color color;
	
	public abstract void draw(Graphics g);
}
