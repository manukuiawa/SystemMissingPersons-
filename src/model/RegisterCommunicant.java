package model;

public class RegisterCommunicant {

	private int id_register;
	private int i_communicant;

	public RegisterCommunicant() {

	}

	public RegisterCommunicant(int id_register, int i_communicant) {
		super();
		this.id_register = id_register;
		this.i_communicant = i_communicant;
	}

	public int getId_register() {
		return id_register;
	}

	public void setId_register(int id_register) {
		this.id_register = id_register;
	}

	public int getI_communicant() {
		return i_communicant;
	}

	public void setI_communicant(int i_communicant) {
		this.i_communicant = i_communicant;
	}

	@Override
	
	public String toString() {
		return "RegisterCommunicant [id_register=" + id_register + ", i_communicant=" + i_communicant + "]";
	}

}
