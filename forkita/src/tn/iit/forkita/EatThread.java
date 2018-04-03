package tn.iit.forkita;

import javax.swing.JFrame;

public class EatThread extends Thread {
	private JFrame frame;
	private Philo[] ph;
	private int id;

	public EatThread(Philo[] ph, int id) {
		this.ph = ph;
		this.id = id;
	}

	public void run() {

		while (true) {

			System.out.println(id + " R=  " + (id + 1 + 5) % 5 + "   L=  " + (id - 1 + 5) % 5 + ph[(id)].getState()
					+ "  " + ph[(id + 1 + 5) % 5].getState() + "  " + ph[(id - 1 + 5) % 5].getState());
			// System.out.println(id+ " "+ ph[id].getState() );

			// if (ph[id].getfR().getFrk() != id && ph[id].getfL().getFrk() != id) {

			// thinking
			// System.out.println(id + " is thinking");

			// wait
			if (ph[id].getfR().getIdOwner() != id && ph[id].getfL().getIdOwner() != id) {

				ph[id].setState("think");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				} finally {
					ph[id].getfR().takeFrk(id);
					// wait
					ph[id].getfL().takeFrk(id);
					if (ph[id].getfR().getIdOwner() != id && ph[id].getfR().getIdOwner() != id) {
						ph[id].setState("think");
					}
					if (ph[id].getfR().getIdOwner() != id && ph[id].getfR().getIdOwner() == id
							|| ph[id].getfR().getIdOwner() == id && ph[id].getfR().getIdOwner() != id) {
						ph[id].setState("waiting");
					}
					if (ph[id].getfR().getIdOwner() == id && ph[id].getfR().getIdOwner() == id) {
						ph[id].setState("eating");
					}
				}
			}
			// }

			while (ph[id].getfR().getIdOwner() != -1 && ph[id].getfR().getIdOwner() != id
					&& ph[id].getfL().getIdOwner() == id
					|| ph[id].getfR().getIdOwner() == id && ph[id].getfL().getIdOwner() != id
							&& ph[id].getfL().getIdOwner() != -1) {

				try {

					// System.out.println(id + " yestana");
					ph[id].setState("waiting");
					// System.out.println(id+" R= "+(id + 1 + 5) % 5+" L= "+(id - 1 + 5) % 5+
					// ph[(id)].getState() +" "+ ph[(id + 1 + 5) % 5].getState() +" "+ph[(id - 1 +
					// 5) % 5].getState());
					// System.out.println(id+ " "+ ph[id].getState() );
					Thread.sleep(500);

				} catch (InterruptedException e) {

					e.printStackTrace();
				} finally {
					ph[id].getfL().takeFrk(id);
					ph[id].getfR().takeFrk(id);
					if (ph[id].getfR().getIdOwner() != id && ph[id].getfL().getIdOwner() != id) {
						ph[id].setState("think");
					}
					if (ph[id].getfR().getIdOwner() != id && ph[id].getfL().getIdOwner() == id) {
						ph[id].setState("waiting");
					}
					if (ph[id].getfR().getIdOwner() == id && ph[id].getfL().getIdOwner() == id) {
						ph[id].setState("eating");
					}
				}

			}

			if (ph[id].getfR().getIdOwner() == id && ph[id].getfL().getIdOwner() == id
					&& !ph[(id + 1 + 5)%5].getState().equals("eating") && !ph[(id - 1 + 5)%5].getState().equals("eating")) {

				try {
					ph[id].setState("eating");
					Thread.sleep(1000);
					// eat
					// System.out.println(id + " yekel");
				} catch (InterruptedException e) {

					e.printStackTrace();
				} finally {
					ph[id].getfR().releasefrk();
					ph[id].getfL().releasefrk();
					if (ph[id].getfR().getIdOwner() != id && ph[id].getfL().getIdOwner() != id)
						ph[id].setState("think");
					if (ph[id].getfR().getIdOwner() != id && ph[id].getfL().getIdOwner() == id) {
						ph[id].setState("waiting");
					}
				}

				/////////////////////////////////////
				/*
				 * boolean b1 = true, b2 = true;
				 * 
				 * System.out.println(id + " R=  " + (id + 1 + 5) % 5 + "   L=  " + (id - 1 + 5)
				 * % 5 + ph[(id)].getState() + "  " + ph[(id + 1 + 5) % 5].getState() + "  " +
				 * ph[(id - 1 + 5) % 5].getState());
				 * 
				 * if (ph[(id + 1 + 5) % 5].getState().equals("waiting")) { ph[(id + 1 + 5) %
				 * 5].getfR().setIdOwner((id + 1 + 5) % 5); b1 = false; }
				 * 
				 * if (ph[(id - 1 + 5) % 5].getState().equals("waiting")) { ph[(id - 1 + 5) %
				 * 5].getfL().setIdOwner((id - 1 + 5) % 5); b2 = false; }
				 * 
				 * /////////////////////////////////////
				 * 
				 * if (b1) ph[id].getfR().releasefrk(); if (b2)
				 */

			}
			frame.repaint();

		}

	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
