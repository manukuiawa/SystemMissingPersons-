package model;

public class RegisterCommunicant {

	private int idRegister;
	private int idCommunicant;

	public RegisterCommunicant() {

	}

	public RegisterCommunicant(int idRegister, int idCommunicant) {
		super();
		this.idRegister = idRegister;
		this.idCommunicant = idCommunicant;
	}

	public int getIdRegister() {
		return idRegister;
	}

	public void setIdRegister(int idRegister) {
		this.idRegister = idRegister;
	}

	public int getIdCommunicant() {
		return idCommunicant;
	}

	public void setIdCommunicant(int idCommunicant) {
		this.idCommunicant = idCommunicant;
	}

	@Override
	public String toString() {
		return "RegisterCommunicant [idRegister=" + idRegister + ", idCommunicant=" + idCommunicant + "]";
	}

}
