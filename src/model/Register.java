package model;

import java.sql.Date;

public class Register {

	private int idRegister;
	private Date dateReport;
	private StatusRegister statusRegister;
	private int idPeople;
	
	public Register() {
		
	}

	public Register(int idRegister, Date dateReport, StatusRegister statusRegister, int idPeople) {
		super();
		this.idRegister = idRegister;
		this.dateReport = dateReport;
		this.statusRegister = statusRegister;
		this.idPeople = idPeople;
	}

	public int getIdRegister() {
		return idRegister;
	}

	public void setIdRegister(int idRegister) {
		this.idRegister = idRegister;
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
		return "Register [idRegister=" + idRegister + ", dateReport=" + dateReport + ", statusRegister="
				+ statusRegister + ", idPeople=" + idPeople + "]";
	}

}
