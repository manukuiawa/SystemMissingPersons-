package model;

public class Informs {

	private int idDisappearence;
	private int idCommunicant;

	public Informs() {

	}

	public Informs(int idDisappearence, int idCommunicant) {
		super();
		this.idDisappearence = idDisappearence;
		this.idCommunicant = idCommunicant;
	}

	public int getIdDisappearence() {
		return idDisappearence;
	}

	public void setIdDisappearence(int idDisappearence) {
		this.idDisappearence = idDisappearence;
	}

	public int getIdCommunicant() {
		return idCommunicant;
	}

	public void setIdCommunicant(int idCommunicant) {
		this.idCommunicant = idCommunicant;
	}

	@Override
	public String toString() {
		return "Informs [idDisappearence=" + idDisappearence + ", idCommunicant=" + idCommunicant + "]";
	}

}
