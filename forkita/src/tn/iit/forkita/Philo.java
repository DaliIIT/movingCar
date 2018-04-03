package tn.iit.forkita;

public class Philo {

	private int id;
	private String state;
	private	Fork fL;
	private Fork fR;
	
	public Philo(int id,Fork[] fk) {
		
		fR=fk[id];
		if(id==4) fL=fk[0];
		else fL=fk[id+1];
		
		this.state="think";
		this.id=id;
	}

	public Fork getfL() {
		return fL;
	}

	public void setfL(Fork fL) {
		this.fL = fL;
	}

	public Fork getfR() {
		return fR;
	}

	public void setfR(Fork fR) {
		this.fR = fR;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}