package model;

public class Communicant {

	private int id_Communicant;
	private String cellphone;
	private String kinship;

	public Communicant() {

	}

	public Communicant(int idCommunicant, String cellphone, String kinship) {
		super();
		this.id_Communicant = idCommunicant;
		this.cellphone = cellphone;
		this.kinship = kinship; 
	}

	public int getIdCommunicant() {
		return id_Communicant;
	}

	public void setIdCommunicant(int idCommunicant) {
		this.id_Communicant = idCommunicant;
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
		return "Communicant [idCommunicant=" + id_Communicant + ", cellphone=" + cellphone + ", kinship=" + kinship
				+ "]";
	}

}
