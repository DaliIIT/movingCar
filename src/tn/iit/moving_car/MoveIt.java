package tn.iit.moving_car;

import javax.swing.JFrame;

public class MoveIt extends Thread {
	final int disMax = 50;
	Car car;
	Car[] cv;
	double dbl;
	int num;
	JFrame frame;
	boolean noturn=false;

	public MoveIt(Car[] car, int number, JFrame frame) {
		super();
		this.car = car[number];
		cv = car;
		this.frame = frame;
		num = number;
	}

	public void run() {

		while (true) {

			if (car.isUp() && car.getX() == 325 && car.getY() < 300
					|| car.isDown() && car.getX() == 275 && car.getY() > 300
					|| car.isRight() && car.getY() == 325 && car.getX() > 300
					|| car.isLeft() && car.getY() == 275 && car.getX() < 300) {
				car.setRival(-1);
			}

			// System.out.println(num+" : "+noCollusion());

			if (noCollusion() || car.getRival() > 0) {
				// -------------------------------------------EDGE-CORNERS--------------------------------------------/
				if (car.getX() >= 575 && car.getY() >= 25) // Down Right corner
				{
					car.setUp(true);
					// 2 car.setRight(false);
				} else {

					if (car.getX() <= 25 && car.getY() <= 575) // Up Left corner 7
					{
						car.setDown(true);
						// 2 car.setLeft(false);

					} else {

						if (car.getY() >= 575 && car.getX() <= 575) // Down Left corner
						{
							car.setRight(true);
							// 2 car.setDown(false);

						} else {

							if (car.getY() <= 25 && car.getX() >= 25) // Up right corner
							{
								// 2 car.setUp(false);
								car.setLeft(true);

							} else {
								if (car.getX() == 75 && car.getY() == 75) {
									car.setRight(true);
								} else {
									if (car.getX() == 75 && car.getY() == 525) {
										car.setUp(true);
									} else {
										if (car.getX() == 525 && car.getY() == 75) {
											car.setDown(true);
										} else {
											if (car.getX() == 525 && car.getY() == 525) {
												car.setLeft(true);
											}
										}
									}
								}

							}

						}
					}

				} //////// END CORNERS AND BEGIN INSIDE AND INSIDEOUT/////////////////////

				if (car.getX() == 275 || car.getX() == 325 || car.getY() == 275 || car.getY() == 325) {
					dbl = Math.random();
					if (dbl > 0.5) {

						// ...................OUTSIDE........... //
						if (car.getY() == 325 && car.getX() <= 25) {

							// 2 car.setDown(false);
							car.setRight(true);
							car.setX(car.getX() + 3);

						} else {

							if (car.getY() == 275 && car.getX() >= 580) {
								car.setLeft(true);
								// 2 car.setUp(false);
								car.setX(car.getX() - 3);

							} else {

								if (car.getX() == 275 && car.getY() <= 25) {
									// 2 car.setLeft(false);
									car.setDown(true);

								} else {

									if (car.getX() == 325 && car.getY() >= 580) {
										// 2 car.setRight(false);
										car.setUp(true);

									} else {// --------------------out-in-------------------------/
										if ((car.getY() == 525 || car.getY() == 325)
												&& (car.getX() == 75 || car.getX() == 325)) {
											// 2 car.setLeft(false);
											car.setUp(true);
										} else {
											if ((car.getX() == 275 || car.getX() == 525)
													&& (car.getY() == 525 || car.getY() == 275)) { // Down
												// (Right||Left)
												// corner
												car.setLeft(true);
												// 2 car.setDown(false);
											} else {

												if ((car.getX() == 75 || car.getX() == 325)
														&& (car.getY() == 75 || car.getY() == 325)) { // Up
													// 2 car.setUp(false);
													car.setRight(true);
												} else {
													if ((car.getX() == 275 || car.getX() == 525)
															&& (car.getY() == 75 || car.getY() == 325)) {
														// 2 car.setRight(false);
														car.setDown(true);
													}
												}
											}
										}

									}
								}
							}
						}

					}
				}

				// -----------------______--------------------MIDDLE-EDGE-----------_____-----------------------/

				if (car.isUp()) {
					car.setY(car.getY() - 1);
				} else {
					if (car.isDown()) {
						car.setY(car.getY() + 1);
					} else {
						if (car.isLeft()) {
							car.setX(car.getX() - 1);
						} else {
							if (car.isRight()) {
								car.setX(car.getX() + 1);
							}
						}
					}
				}

			}

			try {
				Thread.sleep((int) (dbl * 10 + 3));
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (cv[0].getX() == car.getX() && cv[0].getY() == car.getY())
				frame.repaint();
		}
	}

	public Boolean noCollusion() {

		for (int i = 0; i < cv.length; i++) {

			if (i != num) {

				////////////////////////////////////// NO BYPASS
				////////////////////////////////////// ///////////////////////////////////////////////////////////////////////
				if (cv[i].getX() < car.getX() + 6 && cv[i].getX() > car.getX() - 6) {
					if (car.getY() < cv[i].getY() && car.getY() + disMax >= cv[i].getY() && car.isDown()
							|| car.getY() > cv[i].getY() && car.getY() - disMax <= cv[i].getY() && car.isUp()) {
						return false;
					}
				}

				if (cv[i].getY() < car.getY() + 6 && cv[i].getY() > car.getY() - 6) {
					if (car.getX() < cv[i].getX() && car.getX() + disMax >= cv[i].getX() && car.isRight()
							|| car.getX() > cv[i].getX() && car.getX() - disMax <= cv[i].getX() && car.isLeft()) {
						return false;
					}
				}
				/////////////////////////////////////// end NO
				/////////////////////////////////////// BYPASS//////////////////////////////////////////////////////////////////////

				////////////////////////////////////// NO HIT CROSSROAD
				////////////////////////////////////// ///////////////////////////////////////////////////////////////////////

				if (car.isRight() && cv[i].isUp() && car.getX() >= 275 && car.getX() <= 290 && car.getY() == 325
						&& cv[i].getY() > 300 && cv[i].getY() < 500 && cv[i].getX() == 325) {

					cv[i].setRival(1);

					return false;
				}

				if (car.isLeft() && cv[i].isDown() && car.getX() >= 300 && car.getX() <= 325 && car.getY() == 275
						&& cv[i].getY() > 100 && cv[i].getY() < 300 && cv[i].getX() == 275) {
					cv[i].setRival(1);
					return false;
				}

				if (car.isDown() && cv[i].isRight() && car.getX() == 275 && car.getY() >= 275 && car.getY() <= 290
						&& cv[i].getY() == 325 && cv[i].getX() < 300 && cv[i].getX() > 100) {
					cv[i].setRival(1);
					return false;
				}

				if (car.isUp() && cv[i].isLeft() && car.getX() == 325 && car.getY() <= 345 && car.getY() >= 325
						&& cv[i].getY() == 275 && cv[i].getX() < 500 && cv[i].getX() > 300) {
					cv[i].setRival(1);
					return false;
				}
				////////////////////////////////////// end NO HIT CROSSROAD
				////////////////////////////////////// ///////////////////////////////////////////////////////////////////////

				if (car.isRight() && cv[i].isUp() && car.getX() == 50 && car.getY() == 325 && cv[i].getX() == 75
						&& cv[i].getY() > 300 && cv[i].getY() < 500
						|| car.isUp() && cv[i].isLeft() && car.getX() == 75 && car.getY() == 300 && cv[i].getY() == 275
								&& cv[i].getX() > 50 && cv[i].getX() < 250) { // left crossRoad
					cv[i].setRival(1);
					return false;
				}

				if (car.isDown() && cv[i].isRight() && car.getX() == 275 && car.getY() == 50 && cv[i].getX() < 250
						&& cv[i].getX() > 100
						|| car.isRight() && cv[i].isUp() && car.getX() == 75 && car.getX() == 300 && cv[i].getX() == 325
								&& cv[i].getY() > 50 && cv[i].getY() < 250) { // up crossRoad
					cv[i].setRival(1);
					return false;
				}

				if (car.isUp() && cv[i].isLeft() && car.getX() == 375 && car.getY() == 550 && cv[i].getY() == 525
						&& cv[i].getX() > 300 && cv[i].getX() < 500
						|| car.isLeft() && cv[i].isDown() && car.getX() == 300 && car.getY() == 525
								&& cv[i].getX() == 275 && cv[i].getY() < 550 && cv[i].getY() > 350) { // down crossRoad
					cv[i].setRival(1);
					return false;
				}

				if (car.isLeft() && cv[i].isDown() && car.getX() == 550 && car.getY() == 275 && cv[i].getX() == 525
						&& cv[i].getY() > 100 && cv[i].getY() < 300 // right crossRoad
						|| car.isDown() && cv[i].isRight() && car.getX() == 525 && car.getY() == 300
								&& cv[i].getX() > 350 && cv[i].getX() < 550) {
					cv[i].setRival(1);
					return false;
				}

			}

		}

		return true;
	}

}
