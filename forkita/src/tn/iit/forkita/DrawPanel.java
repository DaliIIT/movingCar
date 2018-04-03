package tn.iit.forkita;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

import javafx.scene.shape.Line;

public class DrawPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Philo[] ph;
	Fork[] fork;
	Color stateColor;

	DrawPanel(Philo[] ph, Fork[] fork) {
		super();
		this.stateColor = Color.white;
		this.ph = ph;
		this.fork = fork;
	}

	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		Rectangle rect0 = new Rectangle(300, 90, 5, 100);
		Rectangle rect1 = new Rectangle(450, -300, 5, 100);
		Rectangle rect2 = new Rectangle(150, -600, 5, 100);
		Rectangle rect3 = new Rectangle(-450, -305, 5, 100);
		Rectangle rect4 = new Rectangle(120, 300, 100, 5);
		Rectangle[] rect = new Rectangle[5];
		rect[0] = rect0;
		rect[1] = rect1;
		rect[2] = rect2;
		rect[3] = rect3;
		rect[4] = rect4;

		int x = 0;
		int y = 0;
		g.setColor(Color.gray);
		g.fillOval(80, 80, 460, 460);
		g.setColor(Color.white);
		g.fillOval(150, 150, 85, 85);
		g.fillOval(350, 150, 85, 85);
		g.fillOval(400, 300, 85, 85);
		g.fillOval(300, 430, 85, 85);
		g.fillOval(130, 350, 85, 85);
		
		for (int i = 0; i < ph.length; i++) {
			if (fork[i].getIdOwner()!=-1) {
				rect[i].height = 0;
				rect[i].width = 0;
			}
			switch (ph[i].getState()) {
			case "think":
				this.stateColor = Color.yellow;
				if(fork[i].getIdOwner()!=-1) {
					rect[i].height = 0;
					rect[i].width = 0;
				}
				if(fork[(i + 5 - 1) % 5].getIdOwner()!=-1) {
					rect[(i + 5 - 1) % 5].height = 0;
					rect[(i + 5 - 1) % 5].width = 0;
				}
				break;
			case "eating":
				this.stateColor = Color.green;
				rect[i].height = 0;
				rect[i].width = 0;
				rect[(i + 5 - 1) % 5].height = 0;
				rect[(i + 5 - 1) % 5].width = 0;
				break;
			case "waiting":
				this.stateColor = Color.red;
				if(fork[i].getIdOwner()!=-1) {
					rect[i].height = 0;
					rect[i].width = 0;
				}else {
					rect[(i + 5 - 1) % 5].height = 0;
					rect[(i + 5 - 1) % 5].width = 0;
				}
				
				break;
			
			}
			switch (i) {
			case 0:
				x = 50;
				y = 50;
				break;
			case 1:
				x = 450;
				y = 50;
				break;
			case 2:
				x = 550;
				y = 350;
				break;
			case 3:
				x = 300;
				y = 550;
				break;
			case 4:
				x = 20;
				y = 400;
				break;

			}
			/*if(fork[i].getIdOwner()!=-1) {
				rect[i].height = 0;
				rect[i].width = 0;
			}*/
			g.setColor(stateColor);
			g.fillOval(x, y, 100, 100);

		}
		
		g2d.setColor(Color.black);

		g2d.draw(rect0);
		g2d.fill(rect0);
		g2d.rotate(Math.toRadians(60));
		g2d.draw(rect1);
		g2d.fill(rect1);
		g2d.rotate(Math.toRadians(60));
		g2d.draw(rect2);
		g2d.fill(rect2);

		g2d.rotate(Math.toRadians(90));
		g2d.draw(rect3);
		g2d.fill(rect3);
		g2d.rotate(Math.toRadians(150));

		g2d.draw(rect4);
		g2d.fill(rect4);

	}

}
