import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Manager extends JPanel implements MouseListener, MouseMotionListener {
	JFrame window;
	ArrayList<Shape> shapes;
	Shape currentShape;

	JTextField redTF;
	JTextField greenTF;
	JTextField blueTF;
	JTextField numSidesTF;

	ButtonGroup shapeGroup;

	JRadioButton ellipseRB;
	JRadioButton rectangleRB;
	JRadioButton triangleRB;
	JRadioButton polygonRB;

	public static void main(String[] args) {
		new Manager();
	}

	Manager() {
		shapes = new ArrayList<Shape>();
		redTF = new JTextField(3);
		greenTF = new JTextField(3);
		blueTF = new JTextField(3);
		numSidesTF = new JTextField(3);

		shapeGroup = new ButtonGroup();
		ellipseRB = new JRadioButton("ellipse");
		rectangleRB = new JRadioButton("rectangle");
		triangleRB = new JRadioButton("triangle");
		polygonRB = new JRadioButton("polygon");

		shapeGroup.add(ellipseRB);
		shapeGroup.add(rectangleRB);
		shapeGroup.add(triangleRB);
		shapeGroup.add(polygonRB);

		ellipseRB.setSelected(true);
		add(ellipseRB);
		add(rectangleRB);
		add(triangleRB);
		add(polygonRB);

		redTF.setText("0");
		greenTF.setText("0");
		blueTF.setText("0");
		numSidesTF.setText("4");

		add(new JLabel("red:"));
		add(redTF);
		add(new JLabel("green:"));
		add(greenTF);
		add(new JLabel("blue:"));
		add(blueTF);
		add(new JLabel("number of sides:"));
		add(numSidesTF);

		setPreferredSize(new Dimension(500, 500));
		window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.addMouseListener(this);
		window.addMouseMotionListener(this);
		window.add(this);
		window.setVisible(true);
		window.pack();
	}

	@Override
	public void paintComponent(Graphics g) {
		for (Shape s : shapes) {
			s.draw(g);
		}
		if (currentShape != null) {
			currentShape.draw(g);
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (ellipseRB.isSelected()) {
			((Ellipse) currentShape).setWidth(e.getX() - currentShape.getX());
			((Ellipse) currentShape).setHeight(e.getY() - currentShape.getY());
		} else if (rectangleRB.isSelected()) {
			((Rectangle) currentShape).setWidth(e.getX() - currentShape.getX());
			((Rectangle) currentShape).setHeight(e.getY() - currentShape.getY());
		} else if (triangleRB.isSelected()) {
			((Triangle) currentShape).setWidth(e.getX() - currentShape.getX());
			((Triangle) currentShape).setHeight(e.getY() - currentShape.getY());
		} else if (polygonRB.isSelected()) {
			((Polygon) currentShape).setCentDist(e.getX() - currentShape.getX());
		}

		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (ellipseRB.isSelected()) {
			currentShape = new Ellipse(e.getX(), e.getY(), 0, 0);
		} else if (rectangleRB.isSelected()) {
			currentShape = new Rectangle(e.getX(), e.getY(), 0, 0);
		} else if (triangleRB.isSelected() ) {
			currentShape = new Triangle(e.getX(), e.getY(), 0, 0);
		} else if (polygonRB.isSelected()) {
			currentShape = new Polygon(e.getX(), e.getY(), 0, Integer.parseInt(numSidesTF.getText()));
		}

		int r = clamp(Integer.parseInt(redTF.getText()), 0, 255);
		int g = clamp(Integer.parseInt(greenTF.getText()), 0, 255);
		int b = clamp(Integer.parseInt(blueTF.getText()), 0, 255);
		currentShape.setColor(new Color(r, g, b));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		shapes.add(currentShape);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	private int clamp(int val, int min, int max) {
		if (val < min) {
			return min;
		} else if (val > max) {
			return max;
		} else {
			return val;
		}
	}
}
