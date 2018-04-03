package tn.iit.forkita;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.JFrame;

public class Table {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		
		 Fork[] fk = new Fork[5];
		 EatThread[] t = new EatThread[5];
		 Philo[] ph = new Philo[5];

		for (int i = 0; i < 5; i++) {

			fk[i] = new Fork();
		}

		for (int i = 0; i < 5; i++) {
			ph[i] = new Philo(i, fk);
		}

		t[0] = new EatThread(ph, 0);

		t[1] = new EatThread(ph, 1);
		t[2] = new EatThread(ph, 2);
		t[3] = new EatThread(ph, 3);
		t[4] = new EatThread(ph, 4);
		t[0].setFrame(frame);
		t[1].setFrame(frame);
		t[2].setFrame(frame);
		t[3].setFrame(frame);
		t[4].setFrame(frame);

		t[0].start();
		t[1].start();
		t[2].start();
		t[3].start();
		t[4].start();
		DrawPanel drawPanel = new DrawPanel(ph, fk);
		frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
		frame.setUndecorated(true);
		frame.setResizable(false);
		frame.setSize(700, 700);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);

	}

}
