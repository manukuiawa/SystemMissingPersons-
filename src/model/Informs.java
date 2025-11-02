package model;

public class Informs {

	private int id_communicant;
	private int id_disappearence;

	public Informs() {

	}

	public int getId_communicant() {
		return id_communicant;
	}

	public void setId_communicant(int id_communicant) {
		this.id_communicant = id_communicant;
	}

	public int getId_disappearence() {
		return id_disappearence;
	}

	public void setId_disappearence(int id_disappearence) {
		this.id_disappearence = id_disappearence;
	}

	@Override
	public String toString() {
		return "Informs [id_communicant=" + id_communicant + ", id_disappearence=" + id_disappearence + "]";
	}

}
