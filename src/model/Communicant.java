package model;

public class Communicant {

	private int idCommunicant;
	private String cellphone;
	private String kinship;

	public Communicant() {

	}

	public Communicant(int idCommunicant, String cellphone, String kinship) {
		super();
		this.idCommunicant = idCommunicant;
		this.cellphone = cellphone;
		this.kinship = kinship;
	}

	public int getIdCommunicant() {
		return idCommunicant;
	}

	public void setIdCommunicant(int idCommunicant) {
		this.idCommunicant = idCommunicant;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getKinship() {
		return kinship;
	}

	public void setKinship(String kinship) {
		this.kinship = kinship;
	}

	@Override
	public String toString() {
		return "Communicant [idCommunicant=" + idCommunicant + ", cellphone=" + cellphone + ", kinship=" + kinship
				+ "]";
	}

}
