package model;

import java.sql.Date;

public class Register {

	private int id_register;
	private Date dateReport;
	private StatusRegister statusRegister;
	private int idPeople;

	public Register() {

	}

	public Register(int idRegister, Date dateReport, StatusRegister statusRegister, int idPeople) {
		super();
		this.id_register = idRegister;
		this.dateReport = dateReport;
		this.statusRegister = statusRegister;
		this.idPeople = idPeople;
	}

	public int getIdRegister() {
		return id_register;
	}

	public void setIdRegister(int idRegister) {
		this.id_register = idRegister;
	}

	public Date getDateReport() {
		return dateReport;
	}

	public void setDateReport(Date dateReport) {
		this.dateReport = dateReport;
	}

	public StatusRegister getStatusRegister() {
		return statusRegister;
	}

	public void setStatusRegister(StatusRegister statusRegister) {
		this.statusRegister = statusRegister;
	}

	public int getIdPeople() {
		return idPeople;
	}

	public void setIdPeople(int idPeople) {
		this.idPeople = idPeople;
	}

	@Override
	public String toString() {
		return "Register [idRegister=" + id_register + ", dateReport=" + dateReport + ", statusRegister="
				+ statusRegister + ", idPeople=" + idPeople + "]";
	}

}
