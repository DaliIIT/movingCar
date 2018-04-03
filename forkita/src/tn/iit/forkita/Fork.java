package tn.iit.forkita;

public class Fork {

	private int idOwner;

	public Fork() {
		idOwner = -1;
	}

	synchronized public void takeFrk(int idPhilo) {

		if (idOwner == -1)
			idOwner = idPhilo;

	}

	synchronized public void releasefrk() {
		idOwner = -1;
	}

	////// getters and setters
	public int getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(int idPhilo) {
		this.idOwner = idPhilo;
	}

}
