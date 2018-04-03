package tn.iit.moving_car;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import javax.swing.JPanel;
/////////

final public class Pan extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Car cars[];
	// Car c1,c2,c3,c4;
	// Thread t1, t2, t3, t4, t5;
	Thread thread[];
	JFrame frame;
	DrawPanel drawPanel;
	int numberOfCars;

	public Pan(int numberOfCars) {
		this.numberOfCars = numberOfCars;
		System.out.println(numberOfCars);
		cars = new Car[numberOfCars];
		thread = new Thread[numberOfCars];
	}

	public Pan(String s) {
		this(Integer.valueOf(s));
		go();
	}

	private void go() {

		for (int i = 0; i < numberOfCars; i++) {
			cars[i] = new Car();
		}

		frame = new JFrame("Pan");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		drawPanel = new DrawPanel(cars);

		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);

		frame.setResizable(false);

		frame.setSize(600, 630);
		frame.setLocationByPlatform(true); // open windows at random location
		frame.setVisible(true);

		// new MoveIt(c,frame).moveIt();
		for (int i = 0; i < numberOfCars; i++) {
			thread[i] = new Thread(new MoveIt(cars, i, frame));
			thread[i].start();
		}

	}
}