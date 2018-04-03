package tn.iit.moving_car;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

class DrawPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	int numberOfCars;
	Car[] cars;

	public void paintComponent(Graphics g) {

		g.setColor(Color.white);
		g.fillRect(0, 0, 600, 600);

		g.setColor(Color.blue);

		for (int i = 0; i < cars.length; i++) {
			g.fillRect(cars[i].getX(), cars[i].getY(), 6, 6);
		}

		g.setColor(Color.GREEN);
		g.fillRect(100, 100, 150, 150);
		g.fillRect(500 - 150, 100, 150, 150);
		g.fillRect(100, 600 - 250, 150, 150);
		g.fillRect(500 - 150, 600 - 250, 150, 150);

		g.setColor(Color.gray);
		g.fillRect(500 - 150, 600 - 50, 150, 3);
		g.fillRect(100, 600 - 50, 150, 3);
		g.fillRect(600 - 250, 50, 150, 3);
		g.fillRect(100, 50, 150, 3);
		g.fillRect(50, 100, 3, 150);
		g.fillRect(50, 600 - 250, 3, 150);
		g.fillRect(600 - 300, 100, 3, 150);
		g.fillRect(600 - 50, 100, 3, 150);
		g.fillRect(600 - 50, 600 - 250, 3, 150);
		g.fillRect(100, 300, 150, 3);
		g.fillRect(600 - 250, 300, 150, 3);
		g.fillRect(600 - 300, 350, 3, 150);

	}

	public DrawPanel(int numberOfCars) {
		super();
		this.numberOfCars = numberOfCars;
	}

	public DrawPanel(Car[] a) {
		super();
		cars = a;
	}

}